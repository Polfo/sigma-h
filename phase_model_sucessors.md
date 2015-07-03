# Table phase\_model\_sucessors #
## Remarks ##
This table defines which are the models of phase that will succeed to another one.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_phase\_model | bigint   | X            |                 | [phase\_model](phase_model.md)(id\_phase\_model) | This is a foreign key to the table phase\_model. |
| id\_phase\_model\_successor | bigint   | X            |                 | [phase\_model](phase_model.md)(id\_phase\_model) | This is a foreign key to the table phase\_model. It corresponds to the table that will succeed to the first one. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/phase_model_successors.svg' />
