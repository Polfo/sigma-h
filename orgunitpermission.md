# Table orgunitpermission #
## Remarks ##
This table was used for giving permissions on a organizational unit for a user. But this table is now **obsolete**.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id       | integer  | X            | X               |                 | This is the primary key of the table. |
| editall  | bool     | X            |                 |                 | It indicates if the user can edit all informations in the organizational unit. |
| viewall  | bool     | X            |                 |                 | It indicates if the user can view all informations in the organizational unit. |
| unit\_id | integer  | X            |                 | [partner](partner.md)(partnerid) | This is a foreign key to the table partner. |
| user\_userid | integer  | X            |                 | [userlogin](userlogin.md)(userid) | This is a foreign key to the table userlogin. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/orgunitpermission.svg' />
