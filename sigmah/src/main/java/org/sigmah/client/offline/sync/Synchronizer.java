/*
 * All Sigmah code is released under the GNU General Public License v3
 * See COPYRIGHT.txt and LICENSE.txt.
 */

package org.sigmah.client.offline.sync;

import com.allen_sauer.gwt.log.client.Log;
import com.bedatadriven.rebar.sql.client.DatabaseLockedException;
//import com.bedatadriven.rebar.sync.client.BulkUpdaterAsync;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.sigmah.client.EventBus;
import org.sigmah.client.dispatch.Dispatcher;
import org.sigmah.client.dispatch.remote.Authentication;
import org.sigmah.client.dispatch.remote.Direct;
import org.sigmah.shared.command.GetSyncRegionUpdates;
import org.sigmah.shared.command.GetSyncRegions;
import org.sigmah.shared.command.result.SyncRegion;
import org.sigmah.shared.command.result.SyncRegionUpdate;
import org.sigmah.shared.command.result.SyncRegions;
import org.sigmah.shared.dao.SqlQueryBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static org.sigmah.shared.dao.SqlQueryBuilder.select;

@Singleton
public class Synchronizer {

    private final Dispatcher dispatch;
    private final EventBus eventBus;
    private final Connection conn;
    //private final BulkUpdaterAsync updater;
    private final Authentication auth;

    private ProgressTrackingIterator<SyncRegion> regionIt;

    private int rowsUpdated;

    private AsyncCallback<Void> callback;

    private boolean running = false;

    @Inject
    public Synchronizer(EventBus eventBus,
                        @Direct Dispatcher dispatch,
                        Connection conn,
                        //BulkUpdaterAsync updater,
                        Authentication auth) {
        this.eventBus = eventBus;
        this.conn = conn;
        this.dispatch = dispatch;
    //    this.updater = updater;
        this.auth = auth;
        createSyncMetaTables();
   }

    private void createSyncMetaTables() {
        execute("create table if not exists sync_regions (id TEXT, localVersion TEXT)",
                "create table if not exists sync_history (lastUpdate INTEGER) ");
    }

    public void clearDatabase() {
        dropAllTables();
        createSyncMetaTables();
    }

    private void dropAllTables() {
        final List<String> tableNames = new ArrayList<String>();
        select("name").from("sqlite_master where type = 'table'")
                .forEachResult(conn, new SqlQueryBuilder.ResultHandler() {
                    @Override
                    public void handle(ResultSet rs) throws SQLException {
                        tableNames.add(rs.getString(1));
                    }
                });

        for(String tableName : tableNames) {
            execute("drop table " + tableName);
        }
    }

    public void start(AsyncCallback<Void> callback) {
        this.callback = callback;
        start();
    }

    public void start() {
        fireStatusEvent("Requesting sync regions...", 0);
        running = true;
        rowsUpdated = 0;
        dispatch.execute(new GetSyncRegions(), null, new AsyncCallback<SyncRegions>() {
            @Override
            public void onFailure(Throwable throwable) {
                handleException("Error getting sync regions", throwable);
            }

            @Override
            public void onSuccess(SyncRegions syncRegions) {
                Synchronizer.this.regionIt = new ProgressTrackingIterator(syncRegions.getList());
                fireStatusEvent("Received sync regions...", 0);
                doNextUpdate();
            }
        });
    }

    private void fireStatusEvent(String task, double percentComplete) {
        Log.info("Synchronizer: " + task + " (" + percentComplete + "%)");
        eventBus.fireEvent(SyncStatusEvent.TYPE, new SyncStatusEvent(task, percentComplete));
    }

    private void doNextUpdate() {
        if(!running) {
            return;
        }
        if(regionIt.hasNext()) {
            final SyncRegion region = regionIt.next();
            String localVersion = queryLocalVersion(region.getId());

            doUpdate(region, localVersion);
        } else {
            onSynchronizationComplete();
        }
    }

    private void onSynchronizationComplete() {
        setLastUpdateTime();
        fireStatusEvent("Synchronization Complete", 100);
        if(callback != null) {
            callback.onSuccess(null);
        }
    }

    private void doUpdate(final SyncRegion region, String localVersion) {
        fireStatusEvent("Synchronizing '" + region.getId() + "' [" + rowsUpdated + " rows updated so far]",
                regionIt.percentComplete());
        Log.info("Synchronizer: Region " + region.getId() + ": localVersion=" + localVersion);

        dispatch.execute(new GetSyncRegionUpdates(region.getId(), localVersion), null, new AsyncCallback<SyncRegionUpdate>() {
            @Override
            public void onFailure(Throwable throwable) {
                handleException("GetSyncRegionUpdates for region id " + region.getId() + " failed.", throwable);
            }

            @Override
            public void onSuccess(SyncRegionUpdate update) {
                persistUpdates(region, update);
            }
        });
    }

    private void persistUpdates(final SyncRegion region, final SyncRegionUpdate update) {
        if(update.getSql() == null) {
            Log.debug("Synchronizer: Region " + region.getId() + " is up to date");
            afterUpdatesArePersisted(region, update);
            return;
        }

        Log.debug("Synchronizer: persisting updates for region " + region.getId());
        /*updater.executeUpdates(auth.getLocalDbName(), update.getSql(), new AsyncCallback<Integer>() {
            @Override
            public void onFailure(Throwable throwable) {
                handleException("Synchronizer: Async execution of region updates failed. \nSQL=" + update.getSql() +
                        "\nMessage: " + throwable.getMessage(), throwable);
            }

            @Override
            public void onSuccess(Integer rows) {
                Log.debug("Synchronizer: updates succeeded, " + rows + " row(s) affected");
                rowsUpdated += rows;
                afterUpdatesArePersisted(region, update);
            }
        }); */
    }

    private void afterUpdatesArePersisted(final SyncRegion region, final SyncRegionUpdate update) {
        try {
            updateLocalVersion(region.getId(), update.getVersion());
            if(!update.isComplete()) {
                doUpdate(region, update.getVersion());
            } else {
                doNextUpdate();
            }
        } catch (DatabaseLockedException e) {
            Log.debug("Synchronizer: Database locked, will try again in 500 ms");
            Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
                @Override
                public boolean execute() {
                    afterUpdatesArePersisted(region, update);
                    return false;
                }
            }, 500);
        } catch (SQLException e) {
            handleException("SQL exception thrown while updating local version number", e);
        }
    }

    private String queryLocalVersion(String id) {
        try {
            PreparedStatement stmt = conn.prepareStatement("select localVersion from sync_regions where id = ?");
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return rs.getString(1);
            } else {
                return null;
            }
        } catch (SQLException e) {
            handleException("Exception thrown while querying local version", e);
            throw new RuntimeException(e);
        }
    }

    private void updateLocalVersion(String id, String version) throws SQLException {
        PreparedStatement update = conn.prepareStatement(
                "update sync_regions set localVersion = ? where id = ?");
        update.setString(1, version);
        update.setString(2, id);
        if(update.executeUpdate() == 0) {
            PreparedStatement insert = conn.prepareStatement(
                    "insert into sync_regions (id, localVersion) values (?, ?)");
            insert.setString(1, id);
            insert.setString(2, version);
            insert.executeUpdate();
        }
    }

    private void handleException(String message, Throwable throwable) {
        Log.error("Synchronizer: " + message, throwable);
        if(callback != null) {
            callback.onFailure(throwable);
        }
    }

    private void setLastUpdateTime() {
        Date now = new Date(new java.util.Date().getTime());
        try {
            PreparedStatement stmt = conn.prepareStatement("update sync_history set lastUpdate = ?");
            stmt.setDate(1, now);
            if(stmt.executeUpdate() == 0) {
                stmt = conn.prepareStatement("insert into sync_history (lastUpdate) values (?)");
                stmt.setDate(1, now);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't set last update time", e);
        }
    }

    public Date getLastUpdateTime() {
        return select("lastUpdate").from("sync_history")
                 .singleDateResultOrNull(conn);

    }

    private static class ProgressTrackingIterator<T> implements Iterator<T> {
        private double total;
        private double completed;
        private Iterator<T> inner;

        private ProgressTrackingIterator(Collection<T> collection) {
            total = collection.size();
            completed = 0;
            inner = collection.iterator();
        }

        @Override
        public boolean hasNext() {
            completed++;
            return inner.hasNext();
        }

        @Override
        public T next() {
            return inner.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public double percentComplete() {
            return completed / total * 100d;
        }
    }


    private void execute(String... sql) {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            for(String statement : sql) {
                stmt.executeUpdate(statement);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(stmt != null) { try { stmt.close(); } catch( SQLException ignored) {} }
        }
    }
}
