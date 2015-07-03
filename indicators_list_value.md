# Table indicators\_list\_value #
## Remarks ##
This table associates an indicator with an indicator list.
But it is not used on the software and will be removed on a future revision. So it can be considered as **obsolete**.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_indicators\_list | bigint   | X            | X               |                 |             |
| id\_indicator | integer  | X            | X               | [indicator](indicator.md)(indicatorid) |             |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/indicators_list_value.svg' />

