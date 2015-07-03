# Table attribute #
## Remarks ##
An attribute is like a boolean parameter or a caracterisation of an activity followed in Activity Info. Indeed, this notion does not exist in Sigmah, only in Activity Info.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| attributeid | integer  | X            | X               |                 | This is the primary key of the table. |
| datedeleted | timestamp(0) |              |                 |                 | This is the date the attribute was deleted. |
| name     | character varying(50) | X            |                 |                 | This is an human readable name for the attribute. |
| sortorder | integer  | X            |                 |                 | It corresponds to the order it will be displayed. |
| attributegroupid | integer  | X            |                 | [attributegroup](attributegroup.md)(attributegroupid) | This is a foreign key to the table attributegroup, that corresponds to the group in which the attribute belongs. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/attribute.svg' />

