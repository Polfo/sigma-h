# Table indicator #
## Remarks ##
The table Indicator is used for defining an indicator, a numeric value that can change over time.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| indicatorid | integer  | X            | X               |                 | This is the primary key of the table. |
| aggregation | integer  | X            |                 |                 | This column indicates the type of aggregation used for the indicator (AGGREGATE\_SUM = 0, AGGREGATE\_AVG = 1, AGGREGATE\_SITE\_COUNT = 2 and AGGREGATE\_MULTINOMIAL = 3). |
| category | character varying(50) |              |                 |                 | This column corresponds to the category of the indicator. |
| listheader | character varying(30) |              |                 |                 | This column represents a short name for the indicator. It corresponds to the field nalmed "code" in the indicator form in Sigmah. |
| collectintervention | bool     | X            |                 |                 | It indicates if the indicator is collected during the actual intervention. |
| collectmonitoring | bool     | X            |                 |                 | It indicates if this indicator is collected during the monitoring phase |
| datedeleted | timestamp(0) |              |                 |                 | This is the date the indicator was deleted. |
| description | text     |              |                 |                 | This column contains a full description of this indicator, containing perhaps detailed instructions on how it is to be collected or calculated. |
| directdataentryenabled | bool     | X            |                 |                 | It indicates if the user can associate indicator values with this project, or false if this indicator takes its value exclusively from its data sources |
| name     | character varying(128) | X            |                 |                 | This is an human-readable name for the indicator. |
| objective | double precision |              |                 |                 | This is the numerical objective for this indicator. |
| sortorder | integer  | X            |                 |                 | This column indicates in which order these indicators will be displayed. |
| sourceofverification | text     |              |                 |                 | it is a text description of how this indicator will be verified. |
| units    | character varying(15) |              |                 |                 | This column is a description of the units in which this Indicator is expressed. Note that this is for descriptive purpose only for the user, it does not carry any semantics for our system. |
| activityid | integer  | X            |                 | [activity](activity.md)(activityid) | This is a foreignkey to the table activity. |
| databaseid | integer  | X            |                 | [userdatabase](userdatabase.md)(databaseid) | This is a foreign key to the table userdatabase. |
| id\_quality\_criterion | integer  | X            |                 | [quality\_criterion](quality_criterion.md)(id\_quality\_criterion) | This is a foreign key to the table quality\_criterion. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/indicator.svg' />
