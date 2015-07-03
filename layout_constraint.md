# Table layout\_constraint #
## Remarks ##
A layout constraint associates a flexible element to a layout group.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_layout\_constraint | bigint   | X            | X               |                 | This is the primary key of the table. |
| sort\_order | integer  |              |                 |                 | It corresponds to the order the flexible element will be displayed. |
| id\_flexible\_element | bigint   | X            |                 | [flexible\_element](flexible_element.md)(id\_flexible\_element) | This is a foreign key to the table flexible\_element |
| id\_layout\_group | bigint   | X            |                 | [layout\_group](layout_group.md)(id\_layout\_group) | This is a foreign key to the table layout\_group. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/layout_constraint.svg' />
