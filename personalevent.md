# Table personalevent #
## Remarks ##
A personalevent is an event directly created in the calendar, contrary to others events which are automatically inserted.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id       | integer  | X            | X               |                 | This is the primary key of the table. |
| calendarid | integer  |              |                 |                 | This is a hidden foreign key to the table personalcalendar. |
| datecreated | timestamp(0) |              |                 |                 | This is the date the event was created. |
| datedeleted | timestamp(0) |              |                 |                 | This is the date the event was deleted. |
| description | character varying(255) |              |                 |                 | This is a description of the event, what will happened to this event. |
| enddate  | timestamp(0) |              |                 |                 | This is the date the event ends. |
| startdate | timestamp(0) |              |                 |                 | This is the date the event starts. |
| summary  | character varying(255) |              |                 |                 | This is the object of the event. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/personalevent.svg' />
