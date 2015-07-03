# Table global\_permission #
## Remarks ##
This table defines the global permissions of a profile.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_global\_permission | integer  | X            | X               |                 | This is the primary key of the table. |
| permission | character varying(255) | X            |                 |                 | It corresponds to a java enumeration (VIEW\_PROJECT, EDIT\_PROJECT, CREATE\_PROJECT, CHANGE\_PHASE, VIEW\_ADMIN, MANAGE\_USER, MANAGE\_UNIT, REMOVE\_FILE, VIEW\_ACTIVITYINFO or VALID\_AMENDEMENT). It indicates that the the profile related has this permission. |
| id\_profile | integer  | X            |                 | [profile](profile.md)(id\_profile) | This is a foreign key to the table profile. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/global_permission.svg' />
