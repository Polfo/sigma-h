=Table log\_frame\_element=
## Remarks ##
This table corresponds to an element of the logical framework view. In Java, the class related is abstract. Each concrete element inherits of the class LogFrameElement. As inheritance doesn’t exist in the SQL format, Hibernate transforms this inheritance into joint (with the strategy InheritanceType.JOINED). So each element has a foreign-key (called id\_element) to its parent table so the table log\_frame\_element. You can notice that these foreign-keys are also primary-keys for these elements.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_element | integer  | X            | X               |                 | This is the primary key of the table. |
| assumptions | text     |              |                 |                 | This column corresponds to an assumption |
| code     | integer  | X            |                 |                 | The code is the identifier of the element in the group. This code will be formatted in the view according to the type of the element. Do not confuse with the column position : an element will not change its code when its position is updated |
| position | integer  |              |                 |                 | This column contains the position of the element in the group. All elements of a group will be ordered according to this column. |
| risks    | text     |              |                 |                 | All risks of a logical framework are written in this textual field. |
| id\_group | integer  | X            |                 | [log\_frame\_group](log_frame_group.md)(id\_group) | This is a foreign key to the table log\_frame\_group. It corresponds to the group in which the log\_frame\_element is related. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/log_frame_element.svg' />
