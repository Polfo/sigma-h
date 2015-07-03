# Table log\_frame\_prerequisite #
## Remarks ##
A log\_frame\_prerequisite indicates what are the prerequisites of a logical framework.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_prerequisite | integer  | X            | X               |                 | This is the primary key of the table. |
| code     | integer  | X            |                 |                 | The code is the identifier of the element in the group. This code will be formatted in the view according to the type of the element. Do not confuse with the column position : an element will not change its code when its position is updated |
| content  | text     |              |                 |                 | The content corresponds to a text that will be written in a textual field in the logical framework view. |
| position | integer  |              |                 |                 | This column contains the position of the element in the group. All elements of a group will be ordered according to this column. |
| id\_group | integer  |              |                 | [log\_frame\_group](log_frame_group.md)(id\_group) | This is a foreign key to the table log\_frame\_group. It corresponds to the group in which the log\_frame\_prerequisite is related. |
| id\_log\_frame | integer  | X            |                 | [log\_frame](log_frame.md)(id\_log\_frame) | This is a foreign key to the table log\_frame. The log\_frame\_prerequisite belongs to the log\_frame related. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/log_frame_prerequisite.svg' />
