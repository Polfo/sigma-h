# Table phase #
## Remarks ##
A project is formed by several phases. A phase is created with a model which defines how the configuration of the phase.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_phase | bigint   | X            | X               |                 | This is the primary key of the table. |
| end\_date | timestamp(0) |              |                 |                 | This is the date the phase should be ended. |
| start\_date | timestamp(0) |              |                 |                 | This is the date the phase should be started. |
| id\_phase\_model | bigint   | X            |                 | [phase\_model](phase_model.md)(id\_phase\_model) | This is a foreign key to the table phase\_model. |
| id\_project | integer  | X            |                 | [project](project.md)(databaseid) | This is a foreign key to the table project. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/phase.svg' />
