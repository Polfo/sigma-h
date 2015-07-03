# Table budget\_parts\_list\_value #
## Remarks ##
This table is not used on the software and will be removed on a future revision. So it can be considered as **obsolete**.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_budget\_parts\_list | bigint   | X            | X               |                 |             |
| id\_budget | bigint   | X            |                 | [budget](budget.md)(id\_budget) |             |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/budget_parts_list_value.svg' />

