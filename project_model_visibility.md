# Table project\_model\_visibility #
## Remarks ##
This table defines in which type of project this project model should be displayed.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_visibility | integer  | X            | X               |                 | This is the primary key of the table. |
| type     | character varying(255) |              |                 |                 | It corresponds to an java enumeration that defines the type of the project model (NGO, FUNDING or LOCAL\_PARTNER) |
| id\_project\_model | bigint   | X            |                 | [project\_model](project_model.md)(id\_project\_model) | This is a foreign key to the table project\_model. |
| id\_organization | integer  | X            |                 |                 | This is a foreign key to the table organization. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/project_model_visibility.svg' />
