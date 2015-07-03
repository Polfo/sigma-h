# Table privacy\_group\_permission #
## Remarks ##
This table corresponds associates a privacy group to a profile.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_permission | integer  | X            | X               |                 | This is the primary key of the table. |
| permission | character varying(255) | X            |                 |                 | It corresponds to a java enumeration (NONE, READ or WRITE) and defines the access right to the resource related in the privacy group. |
| id\_privacy\_group | integer  | X            |                 | [privacy\_group](privacy_group.md)(id\_privacy\_group) | This is a foreign key to the table privacy\_group. |
| id\_profile | integer  | X            |                 | [profile](profile.md)(id\_profile) | This is a foreign key to the table profile. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/privacy_group_permission.svg' />
