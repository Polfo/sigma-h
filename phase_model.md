# Table phase\_model #
## Remarks ##
A phase\_model corresponds to a model of phase that can be modified while the model of project is in draft mode.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_phase\_model | bigint   | X            | X               |                 | This is the primary key of the table. |
| display\_order | integer  |              |                 |                 | It corresponds to the order it will be displayed. |
| guide    | text     |              |                 |                 |             |
| name     | character varying(8192) | X            |                 |                 |             |
| definition\_id | integer  | X            |                 | [phase\_model\_definition](phase_model_definition.md)(id\_phase\_model\_definition) |             |
| id\_layout | bigint   |              |                 | [layout](layout.md)(id\_layout) |             |
| id\_project\_model | bigint   | X            |                 | [project\_model](project_model.md)(id\_project\_model) |             |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/phase_model.svg' />
