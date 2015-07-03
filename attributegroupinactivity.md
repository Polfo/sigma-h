# Table attributegroupinactivity #
## Remarks ##
This table associates an attribute group with an activity. It means that the group belongs to this activity.

The primary key is formed by both columns of the table.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| activityid | integer  | X            | X               | [activity](activity.md)(activityid) | This is a foreign key to the table activity. |
| attributegroupid | integer  | X            | X               | [attributegroup](attributegroup.md)(attributegroupid) | This is a foreign key to the table attributegroup. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/attributegroupinactivity.svg' />
