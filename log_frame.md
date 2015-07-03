# Table log\_frame #
## Remarks ##
A log\_frame corresponds to a logical framework related to a model of logical framework. It belongs to a project.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_log\_frame | integer  | X            | X               |                 | This is the primary key of the table. |
| main\_objective | text     |              |                 |                 | This is a sentence that describes the main objective of the project |
| id\_log\_frame\_model | integer  | X            |                 | [log\_frame\_model](log_frame_model.md)(id\_log\_frame) | This is a foreign key to the table log\_frame\_model. The log\_frame\_model related corresponds to the model of this logical framework. |
| id\_project | integer  | X            |                 | [project](project.md)(databaseid) | This is a foreign key to the table project. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/log_frame.svg' />
