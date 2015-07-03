# Table project\_banner #
## Remarks ##
The table project\_banner is an association table between the table project\_model and the table layout. It defines the layout which is associated with a project model on the banner.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id       | integer  | X            | X               |                 | This is the primary key of the table. |
| id\_layout | bigint   | X            |                 |                 | This is a foreign key to the table Layout |
| id\_project\_model | bigint   |              |                 | [project\_model](project_model.md)(id\_project\_model) | This is a foreign key to the table project\_model |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/project_banner.svg' />
