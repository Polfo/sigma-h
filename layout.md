# Table layout #
## Remarks ##
A layout is the place where all elements are put. A layout is formed by several layout groups formed themself by several layout constraints formed finally by several flexible elements.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_layout | bigint   | X            | X               |                 | This is the primary key of the table. |
| columns\_count | integer  | X            |                 |                 | This is the number of columns of the layout. Actually in Sigmah, there are always one column displayed. Others are not visibles. |
| rows\_count | integer  | X            |                 |                 | It corresponds to the number of rows of the layout. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/layout.svg' />
