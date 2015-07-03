# Table log\_frame\_group #
## Remarks ##
A log\_frame\_group is used in order to organize all logical framework elements in the view. Each group can have several elements according to the configuration written in the table log\_frame (table that is related with a foreign key).

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_group | integer  | X            | X               |                 | This is the primary key of the table. |
| label    | text     |              |                 |                 | This is an human-readable name for the group. |
| type     | character varying(255) |              |                 |                 | This column corresponds to an enumeration of values in Java (SPECIFIC\_OBJECTIVE, EXPECTED\_RESULT, ACTIVITY, PREREQUISITE). It indicates the type which can be contained in the group. |
| id\_log\_frame | integer  | X            |                 | [log\_frame](log_frame.md)(id\_log\_frame) | This is a foreign key to the table log\_frame. The group belongs to the log\_frame related. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/log_frame_group.svg' />
