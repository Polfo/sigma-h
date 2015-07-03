# Table userpermission #
## Remarks ##
This table contains all data relative to the permission of one user. These permissions are defined with the organizational unit which the user belongs and also some booleans that indicates if an user can read or edit a project.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| userpermissionid | integer  | X            | X               |                 | This is the primary key of the table. |
| allowdesign | bool     | X            |                 |                 | It indicates if the user has the permission to modify the design of the project related, i.e. create or change indicators, etc.  |
| allowedit | bool     | X            |                 |                 | It indicates if the user has the permission to create or edit data in the project that belongs to its own organizational unit. |
| alloweditall | bool     | X            |                 |                 | It indicates if the user has the permission to create or edit data in the project that belongs to other organizational units. |
| allowmanageallusers | bool     | X            |                 |                 | It indicates if the user can add, remove or modify other users, no matter if they belongs to another organizational unit. |
| allowmanageusers | bool     | X            |                 |                 | It indicates if the user can add, remove or modify other users if their belongs to the same organizational unit. |
| allowview | bool     | X            |                 |                 | It indicates if the user can see its own data in the project related and in the same organizational unit. |
| allowviewall | bool     | X            |                 |                 | It indicates if the user can see others organizational unit's data |
| lastschemaupdate | timestamp(0) |              |                 |                 | This is the date this permission was the last updated |
| databaseid | integer  | X            |                 | [userdatabase](userdatabase.md)(databaseid) | This is a foreign key to the table userdatabase, that corresponds to the project related. |
| partnerid | integer  | X            |                 | [partner](partner.md)(partnerid) | This is a foreign key to the table partner, which corresponds to the organizational unit of the user. |
| userid   | integer  | X            |                 | [userlogin](userlogin.md)(userid) | This is a foreign key to the table userlogin. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/userpermission.svg' />