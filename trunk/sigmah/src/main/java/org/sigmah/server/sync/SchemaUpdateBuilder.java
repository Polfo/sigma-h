/*
 * All Sigmah code is released under the GNU General Public License v3
 * See COPYRIGHT.txt and LICENSE.txt.
 */

package org.sigmah.server.sync;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONException;
import org.sigmah.shared.command.GetSyncRegionUpdates;
import org.sigmah.shared.command.result.SyncRegionUpdate;
import org.sigmah.shared.dao.UserDatabaseDAO;
import org.sigmah.shared.domain.Activity;
import org.sigmah.shared.domain.AdminLevel;
import org.sigmah.shared.domain.Attribute;
import org.sigmah.shared.domain.AttributeGroup;
import org.sigmah.shared.domain.Country;
import org.sigmah.shared.domain.Indicator;
import org.sigmah.shared.domain.LocationType;
import org.sigmah.shared.domain.OrgUnit;
import org.sigmah.shared.domain.Site;
import org.sigmah.shared.domain.User;
import org.sigmah.shared.domain.UserDatabase;
import org.sigmah.shared.domain.UserPermission;

import com.bedatadriven.rebar.sync.server.JpaUpdateBuilder;
import com.google.inject.Inject;

public class SchemaUpdateBuilder implements UpdateBuilder {

    private final UserDatabaseDAO userDatabaseDAO;

    private Set<Integer> countryIds = new HashSet<Integer>();
    private List<Country> countries = new ArrayList<Country>();
    private List<AdminLevel> adminLevels = new ArrayList<AdminLevel>();

    private List<UserDatabase> databases = new ArrayList<UserDatabase>();

    private Set<Integer> partnerIds = new HashSet<Integer>();
    private List<OrgUnit> partners = new ArrayList<OrgUnit>();

    private List<Activity> activities = new ArrayList<Activity>();
    private List<Indicator> indicators = new ArrayList<Indicator>();
    
    private Set<Integer> attributeGroupIds = new HashSet<Integer>();
    private List<AttributeGroup> attributeGroups = new ArrayList<AttributeGroup> ();
    private List<Attribute> attributes = new ArrayList<Attribute>();
    
    private Set<Integer> userIds = new HashSet<Integer>();
    private List<User> users = new ArrayList<User>();
    private List<LocationType> locationTypes  = new ArrayList<LocationType>();
    
    private Set<Integer> siteIds = new HashSet<Integer>();
    private List<Site> sites = new ArrayList<Site>();
    
    private Class[] schemaClasses = new Class[] {
            Country.class,
            AdminLevel.class,
            LocationType.class,
            UserDatabase.class,
            OrgUnit.class,
            Activity.class,
            Indicator.class,
            AttributeGroup.class,
            Attribute.class,
            Site.class,
            User.class
    };
    private static final String REGION_ID = "schema";

    @Inject
    public SchemaUpdateBuilder(UserDatabaseDAO userDatabaseDAO) {
        this.userDatabaseDAO = userDatabaseDAO;
    }

    public SyncRegionUpdate build(User user, GetSyncRegionUpdates request) throws JSONException {
        databases = userDatabaseDAO.queryAllUserDatabasesAlphabetically();

        long localVersion = request.getLocalVersion() == null ? 0 : Long.parseLong(request.getLocalVersion());
        long serverVersion = getCurrentSchemaVersion(user);

        SyncRegionUpdate update = new SyncRegionUpdate();
        update.setVersion(Long.toString(serverVersion));
        update.setComplete(true);

        if(localVersion == serverVersion) {
            update.setComplete(true);
        } else {
            makeEntityLists();
            update.setSql(buildSql());
        }
        return update;
    }

    private String buildSql() throws JSONException {
        JpaUpdateBuilder builder = new JpaUpdateBuilder();
        for(Class schemaClass : schemaClasses) {
            builder.createTableIfNotExists(schemaClass);
            builder.deleteAll(schemaClass);
        }

        builder.insert(Country.class, countries);
        builder.insert(AdminLevel.class, adminLevels);
        builder.insert(UserDatabase.class, databases);
        builder.insert(OrgUnit.class, partners);
        builder.insert(Activity.class, activities);
        builder.insert(Indicator.class, indicators);
        builder.insert(AttributeGroup.class, attributeGroups);
        builder.insert(Attribute.class, attributes);
        builder.insert(LocationType.class, locationTypes);
        builder.insert(User.class, users);
        builder.insert(Site.class, sites);

        return builder.asJson();
    }

    private void makeEntityLists() {
        for(UserDatabase database : databases) {
        	if(!userIds.contains(database.getOwner().getId())) {
        		User u = database.getOwner();
        		// don't send hashed password to client
        		u.setHashedPassword("");
        		users.add(u);
        		userIds.add(u.getId());
        	}
            if(!countryIds.contains(database.getCountry().getId())) {
                countries.add(database.getCountry());
                adminLevels.addAll(database.getCountry().getAdminLevels());
                countryIds.add(database.getCountry().getId());
                for (org.sigmah.shared.domain.LocationType l: database.getCountry().getLocationTypes()) {
                	locationTypes.add(l);
                }
            }
            for(OrgUnit partner : database.getPartners()) {
                if(!partnerIds.contains(partner.getId())) {
                    partners.add(partner);
                    partnerIds.add(partner.getId());
                }
            }
            for(Activity activity : database.getActivities()) {
                activities.add(activity);
                for(Indicator indicator : activity.getIndicators()) {
                    indicators.add(indicator);
                }
                for(AttributeGroup g: activity.getAttributeGroups()) {
                	if (!attributeGroupIds.contains(g.getId())) {
                		attributeGroups.add(g);
                		for (Attribute a: g.getAttributes()) {
                			attributes.add(a);
                		}
                	}
                }
                for (Site s : activity.getSites()) {
                	if (!siteIds.contains(s)) {
                		sites.add(s);
                	}
                }
            }
        }
    }

    public long getCurrentSchemaVersion(User user) {
        long currentVersion = 1;
        for(UserDatabase db : databases) {
            if(db.getLastSchemaUpdate().getTime() > currentVersion) {
                currentVersion = db.getLastSchemaUpdate().getTime();
            }

            if(db.getOwner().getId() != user.getId()) {
                UserPermission permission = db.getPermissionByUser(user);
                if(permission.getLastSchemaUpdate().getTime() > permission.getId()) {
                    currentVersion = permission.getLastSchemaUpdate().getTime();
                }
            }
        }
        return currentVersion;
    }
}