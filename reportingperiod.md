# Table reportingperiod #
## Remarks ##
The table reportingperiod is created for defining period. These periods is needed for the indicators because an indicator change over the time. The period commonly used on Sigmah corresponds to a month of the year.
So, the period begin usally the first day of a month and it ends at the last day of the month.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| reportingperiodid | integer  | X            | X               |                 | This is the primary key of the table. |
| comments | text     |              |                 |                 | This column contains some comments on the element. In Sigmah, this column is not used. |
| date1    | date     | X            |                 |                 | The period starts at this date. |
| date2    | date     | X            |                 |                 | The period ends at this date. |
| datecreated | timestamp(0) | X            |                 |                 | This is the ate the reportingperiod was created. |
| datedeleted | timestamp(0) |              |                 |                 | This is the date the reportingperiod was deleted. |
| dateedited | timestamp(0) | X            |                 |                 | This is the date the reportingperiod was updated. |
| monitoring | bool     | X            |                 |                 | This column indicates if it is monitored. |
| siteid   | integer  | X            |                 | [site](site.md)(siteid) | This is a foreign key to the table site. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/reportingperiod.svg' />

