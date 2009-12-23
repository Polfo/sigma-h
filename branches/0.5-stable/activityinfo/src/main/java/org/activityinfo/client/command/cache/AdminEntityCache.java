package org.activityinfo.client.command.cache;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.activityinfo.client.command.CommandEventSource;
import org.activityinfo.shared.command.GetAdminEntities;
import org.activityinfo.shared.command.result.AdminEntityResult;
import org.activityinfo.shared.command.result.CommandResult;

/**
 * Caches the results of
 *
 *
 * @author Alex Bertram
 */
@Singleton
public class AdminEntityCache extends AbstractCache implements CommandProxy<GetAdminEntities>, CommandListener<GetAdminEntities> {

    @Inject
    public AdminEntityCache(CommandEventSource connection) {
        connection.registerProxy(GetAdminEntities.class, this);
        connection.registerListener(GetAdminEntities.class, this);
    }

    @Override
    public CommandProxyResult<AdminEntityResult> execute(GetAdminEntities command) {

        if(command.getActivityId() != null)
            return CommandProxyResult.couldNotExecute();

        AdminEntityResult result = (AdminEntityResult) fetch(command);
        if(result == null) {
            return CommandProxyResult.couldNotExecute();
        } else {
            return new CommandProxyResult<AdminEntityResult>(new AdminEntityResult(result));
        }
    }

    @Override
    public void beforeCalled(GetAdminEntities command) {

    }

    @Override
    public void onFailure(GetAdminEntities command, Throwable caught) {

    }

    @Override
    public void onSuccess(GetAdminEntities command, CommandResult result) {

        if(command.getActivityId() == null)
            cache(command, new AdminEntityResult((AdminEntityResult) result));
    }
}
