# Table attributegroup #
## Remarks ##
An attributegroup is a group of attributes.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| attributegroupid | integer  | X            | X               |                 | This is the primary key of the table. |
| category | character varying(50) |              |                 |                 | it represents the category of the group. |
| datedeleted | timestamp(0) |              |                 |                 | This is the date the attribute group was deleted. |
| multipleallowed | bool     | X            |                 |                 | It indicates if a group can contains several attributes. |
| name     | character varying(255) |              |                 |                 | This is an human readable name for the attribute group. |
| sortorder | integer  | X            |                 |                 | It corresponds to the order it will be displayed. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/attributegroup.svg' />

