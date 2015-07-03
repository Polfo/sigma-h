# Introduction #

The Schema Domain defines the structure of UserDatabases, including Activities, Indicators, Attributes,
and user access rights to the UserDatabase's data.


## The Schema Objects ##
![http://activity-info.googlecode.com/svn/wiki/diagrams/schema.png](http://activity-info.googlecode.com/svn/wiki/diagrams/schema.png)


The root of the schema object model is the UserDatabase. Each UserDatabase is owned by one User, and this User has full control over the definition of the database and user access to the database. UserDatabases may eventually be linked to each other, but the goal is to assure that changes to other UserDatabases will not affect a given UserDatabase.

# Partners and UserPermissions #

Each UserDatabase must have at least one Partner organisation. Partners represent an additional level of granularity when it comes to defining access rights. Each [Site](SiteDomainObjects.md) is owned by one Partner, and users my be restricted
to viewing and/or modifying only data belonging to their partner.

The UserDatabase's owner can grant access to additional users to add/modify the database. These permissions are modeled by the UserPermission object, which links a User object to the database, and to a Partner within the database.

|**Property**|**Description**|
|:-----------|:--------------|
|View        |Permits the user to view (but not change) Sites belonging to **their** partner|
|Edit        |Permits the user to add, edit, and delete Sites belonging to **their** partner|
|ViewAll     |Permits the user to view Sites belonging to **all** partners in the UserDatabase|
|EditAll     |Permits the user to add, edit, and delete Sites belonging to **any** partner in the UserDatabase|
|ManageUsers |Permits the user to add additional users for their partner to the database, and to delete existing users belonging to their partner, and to change **only** the View and Edit permissions|
|Manage All Users|Permits the user to add/remove additional users for **any** partner, and to change their permissions|
|Design      |Permits the user to change the structure of the UserDatabase, adding, modifying, or deleting Activities, Indicators, Attributes, and Partners|

Note that Owner does not have a corresponding UserPermission entity, their permissions are derived from their status as the UserDatabase owner.

Below is an example of the partner configuration of a UserDatabase for monitoring the Program of Expanded Assistance to Returns (PEAR), one of the first programs to use ActivityInfo.

![http://activity-info.googlecode.com/svn/wiki/diagrams/schema-partners.png](http://activity-info.googlecode.com/svn/wiki/diagrams/schema-partners.png)

The (simplified) UserDatabase includes three Partner organisations: Unicef, Solidarites, and NRC.

In this case, the Users belonging to the two operational partners, Solidarites and NRC, have not been given the View All permission, so when they connect, they will see only data belonging to their own organisation. In this specific example, this was preferable because the partners worked in different geographic areas and were not necessarily concerned by the specifics of what other partners were doing. In the case of a cluster database, however, it is useful to grant ViewAll permission to all users so that UserDatabase can
be a tool in coordination as well.

Note that:

  * The UNICEF education specialist has the Design permission, which would allow him/her to modify or correct indicators for the program. This allows specialists to work directly with the structure of the indicators.
  * The two program managers (3) and (5) have the permission to Manage Users, so they are able to add new user accounts when new staff arrive, or remove accounts if staff leave. They do not have the right, however, to assign the View All, Edit All, Manage All Users, or Design permissions.

While this security model will meet most needs, there are limits:

  * You cannot define permissions by geography, so if a partner has offices in two provinces, users from one office will be able to see/edit data for the other office. If this is really a problem, you can create two Partner entities, for example, IRC-NK and IRC-SK for IRC's offices in North Kivu and South Kivu respectively.
  * You cannot restrict permissions to a specific activities or indicators. If there are really elements of the schema that cannot be visible by certain users, you would need to create two UserDatabases


# Activities, Attributes, and Indicators #

The Activity, AttributeGroup Attribute, and Indicator entities correspond to the logical framework model of the UserDatabase. The diagram in the beginning of this document also includes ActivityCategories and IndicatorCategories, but these are modeled as simple string properties rather than separate entities. (Mostly becuase they were an afterthought in the design)

**TODO**: Entity documentation

Here is an example of how a logframe could be modeled in ActivityInfo:


![http://activity-info.googlecode.com/svn/wiki/diagrams/schema-pear.png](http://activity-info.googlecode.com/svn/wiki/diagrams/schema-pear.png)

# Future Directions #

  * The Edit/EditAll, View/ViewAll pairs should be changed to a single property with a level (0=None, 1=Partner,2=All Partners). This will make maintaining consistency easier (ViewAll without View shouldn't be possible) and make the model cleaner.