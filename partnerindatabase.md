# Table partnerindatabase #
## Remarks ##
This table associates an organizational unit with a project (an userdatabase is a project). The primary key is formed by both columns of the table.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| databaseid | integer  | X            | X               | [userdatabase](userdatabase.md)(databaseid) | This is a foreign key to the table userdatabase. |
| partnerid | integer  | X            | X               | [partner](partner.md)(partnerid) | This is a foreign key to the table partner. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/partnerindatabase.svg' />
