# Table budget\_part #
## Remarks ##
This table is not used on the software and will be removed on a future revision. So it can be considered as **obsolete**.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_budget\_part | bigint   | X            | X               |                 |             |
| amount   | real     | X            |                 |                 |             |
| label    | character varying(2048) | X            |                 |                 |             |
| id\_budget\_parts\_list | bigint   | X            |                 | [budget\_parts\_list\_value](budget_parts_list_value.md)(id\_budget\_parts\_list) |             |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/budget_part.svg' />
