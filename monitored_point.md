# Table monitored\_point #
## Remarks ##
A monitored point is an action referenced in the panel named Expected in the project view.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_monitored\_point | integer  | X            | X               |                 | This is the primary key of the table. |
| completion\_date | timestamp(0) |              |                 |                 | This is the date the action has been completed.  |
| deleted  | bool     |              |                 |                 | This is the date the monitored point is deleted. |
| expected\_date | timestamp(0) | X            |                 |                 | This is the date the action should be finished. |
| label    | character varying(8192) | X            |                 |                 | This is an human readable name for tthe action. |
| id\_file | integer  | X            |                 | [file\_meta](file_meta.md)(id\_file) | This is a foreign key to the table file\_meta. A file can be attached to a monitored point.  |
| id\_list | integer  | X            |                 | [monitored\_point\_list](monitored_point_list.md)(id\_monitored\_point\_list) | This is a foreign key to the table monitored\_point\_list. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/monitored_point.svg' />
