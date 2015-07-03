# Table org\_unit\_banner #
## Remarks ##
The table org\_unit\_banner is an association table between the table org\_unit\_model and the table layout. It defines the layout which is associated with a project model on the banner.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| banner\_id | integer  | X            | X               |                 | This is the primary key of the table. |
| id\_layout | bigint   | X            |                 | [layout](layout.md)(id\_layout) | This is a foreign key to the table layout. |
| id\_org\_unit\_model | integer  | X            |                 | [org\_unit\_model](org_unit_model.md)(org\_unit\_model\_id) | This is a foreign key to the table org\_unit\_model. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/org_unit_banner.svg' />
