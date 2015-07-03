# Table locationadminlink #
## Remarks ##
This is an association table between the table AdminEntity and the table Location.
A location can belong to several administraive entities and an administrative entity can have several locations.

The primary key of the table is formed by both columns of the table.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| locationid | integer  | X            | X               | [location](location.md)(locationid) | This is a foreign key to the table Location. |
| adminentityid | integer  | X            | X               | [adminentity](adminentity.md)(adminentityid) | This is a foreign key to the table adminentity. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/locationadminlink.svg' />
