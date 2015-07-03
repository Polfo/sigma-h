# Table personalcalendar #
## Remarks ##
A personalcalendar is a visual calendar which can contain several events.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id       | integer  | X            | X               |                 | This is the primary key of the table. |
| name     | character varying(255) |              |                 |                 | This is the name of the calendar. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/personalcalendar.svg' />
