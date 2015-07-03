# Table layout\_group #
## Remarks ##
A layout\_group is a group of elements. It was created to gather some flexible elements with a same idea or concept.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_layout\_group | bigint   | X            | X               |                 | This is the primary key of the table. |
| column\_index | integer  | X            |                 |                 | It corresponds to the column where the group will be displayed. Actually in Sigmah, this column is always set to 1. |
| row\_index | integer  | X            |                 |                 | It corresponds to the row where the group will be displayed. |
| title    | character varying(8192) |              |                 |                 | This is the title of the group. |
| id\_layout | bigint   | X            |                 | [layout](layout.md)(id\_layout) | This is a foreign key to the table layout. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/layout_group.svg' />
