# Introduction #

Synchronization is the process whereby the user's local sqlite database is brought up to date with the master database on the server.

Only data which the user has permission to view is replicated to the local database.


# Process #

The process varies slightly depending on the type of versioning used for each sync region, but in the simplest case (where the region is a single table versioned by a timestamp) it works like this:

**Step 1**: client requests list of sync regions from server. (cf GetSyncRegions, GetSyncRegionHandler)

Response is list of opaque string ids

**Step 2**. _for each_ sync region:

a. The client checks the local `sync_regions` table for the local version (timestamp) of this sync region. If not found, local version = null.

b. The client sends GetSyncRegionUpdates(regionId, localVersion) to server.

c. The server (GetSyncRegionUpdatesHandler) queries the database for all rows that have been after the timestamp sent by the client.

d. The server generates and sends the client a set of SQL(ite) statements that will bring the local database up to date in JSON format.

e. The client receives the updates in JSON/SQL format and sends to a web worker for execution against the local database.

f. Upon success, the client stores the local version in the `sync_regions` table.


# Rationale for Sync Regions #

The overall database is divided into sync regions that each maintain their own version sequence. This is required because :

a. Different parts of the data change at different rates, for example, the AdminLevel and AdminEntity tables are versioned at the table level rather than the row level

b. Users have varying and changing permissions to view different parts of the database.

To understand the second point, consider the following scenario in which the whole database is versioned together:

|Day|Action|
|:--|:-----|
|Monday | User 1 at UNICEF creates two databases D1 and D2, and grants user at NRC access only to D1, enters 100 sites for D1, 50 sites for D2 |
|Tuesday| User 2 at NRC connects, synchronizes database, now has complete replica of D1 with version "Tuesday"|
|Wednesday| User 1 UNICEF grants access to D2 to User 2 NRC|
|Thursday| User 2 connects and attempts to synchronize, asking server for all changes since last sync at "Tuesday". Receives update to permission on D1, but not sites in D2 since their version is "Monday". FAIL.|

For this reason, we maintain separate sync regions for each database / partner combination so that the client can ask separately for updates for each of these regions.

When a new region becomes visible, the client appropriately sends a local version of "null" even if the client has later version numbers for other regions in the database.

# Sync Regions Implemented #

|Region id|Tables|Versioning/Update Strategy|
|:--------|:-----|:-------------------------|
|admin/{levelId}|AdminLevel,AdminEntity|An AdminLevel and its AdminEntities have a single version number. Only AdminLevels relevant to the user are provide by GetSyncRegions|
|schema   |UserDatabase,Country,UserPermission,OrgUnit,Activity,Indicator,Attribute|Single timestamp per UserDatabase that is updated whenever an Indicator or Attribute is changed|
|location |Location, LocationAdminLink|Timestamp                 |
|site/{dbId}/{orgUnitId}|Site,ReportingPeriod,IndicatorValue,AttributeValue|Timestamp per Site. Any change to IndicatorValue, AttributeValue, etc updates timestamp|