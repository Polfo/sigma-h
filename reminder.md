# Table reminder #
## Remarks ##
A reminder is an action referenced in the panel named "To do" in the project view.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_reminder | integer  | X            | X               |                 | This is the primary key of the table. |
| completion\_date | timestamp(0) |              |                 |                 | This is the date the action has been completed. |
| deleted  | bool     |              |                 |                 | This is the date the action has been deleted. |
| expected\_date | timestamp(0) | X            |                 |                 | This is the date the action should be finished. |
| label    | character varying(8192) | X            |                 |                 | This is an human readable name for the action. |
| id\_list | integer  | X            |                 | [reminder\_list](reminder_list.md)(id\_reminder\_list) | This is a foreign key to the table reminder\_list. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/reminder.svg' />

