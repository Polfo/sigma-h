# Table user\_unit #
## Remarks ##
This table associates an user to an organizational unit.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_user\_unit | integer  | X            | X               |                 | This is the primary key of the table. |
| id\_org\_unit | integer  | X            |                 | [partner](partner.md)(partnerid) | This is a foreign key to the table partner. |
| id\_user | integer  | X            |                 | [userlogin](userlogin.md)(userid) | This is a foreign key to the table userlogin. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/user_unit.svg' />
