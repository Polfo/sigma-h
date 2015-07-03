# Table project\_model #
## Remarks ##
The table project\_model is the table which defines how a project is formed, which elements composed this project.
But this table is not reserved for only one project. A project\_model can be used by several projects.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_project\_model | bigint   | X            | X               |                 | This is the primary key of the table. |
| name     | character varying(8192) | X            |                 |                 | This column corresponds to the label that identify the project model |
| status   | character varying(255) | X            |                 |                 | This column specify the production state of the project model. It can have these values : DRAFT when the model is under construction, AVAILABLE if the model is in production and UNAVAILABLE if it is disabled.  |
| id\_root\_phase\_model | bigint   | X            |                 | [phase\_model](phase_model.md)(id\_phase\_model) | This column specify the first type of phase of the project model |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/project_model.svg' />
