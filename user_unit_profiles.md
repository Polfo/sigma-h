# Table user\_unit\_profiles #
## Remarks ##
This table associates an user\_unit to a profile.
The primary key of the table is formed by id\_user\_unit and id\_profile.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_user\_unit | integer  | X            |                 | [user\_unit](user_unit.md)(id\_user\_unit) | This is a foreign key to the table user\_unit. |
| id\_profile | integer  | X            |                 |                 | This is a foreign key to the table profile. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/user_unit_profiles.svg' />
