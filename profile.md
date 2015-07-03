# Table profile #
## Remarks ##
A profile corresponds to a profile in the user view in the admin tab. It defines a global profile that will get several permissions.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_profile | integer  | X            | X               |                 | This is the primary key of the table. |
| name     | character varying(8196) | X            |                 |                 | This is a human readable name for the profile. |
| id\_organization | integer  |              |                 | [organization](organization.md)(id\_organization) | This is a foreign key to the table organization. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/profile.svg' />
