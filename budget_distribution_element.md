# Table budget\_distribution\_element #
## Remarks ##
This table corresponds to a number field on the software and is intended for save the budget for a project. But it is not used on the software and will be removed on a future revision. So this table can be considered as **obsolete**.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_flexible\_element | bigint   | X            | X               | [flexible\_element](flexible_element.md)(id\_flexible\_element) | This is the primary key of the table and also a foreign key on the table flexible\_element which is its parent table. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/budget_distribution_element.svg' />
