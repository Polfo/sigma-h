# Table activity #
## Remarks ##
The table Activity is used to represent an indicator group used to difference each activity type these indicators can be assigned.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| activityid | integer  | X            | X               |                 | This is the primary key of the table. |
| allowedit | bool     | X            |                 |                 | It indicates if this activity is editable. In Sigmah, this column is not used. |
| isassessment | bool     | X            |                 |                 | It indicates if this activity is an assessment. In Sigmah, this column is not used. |
| category | character varying(255) |              |                 |                 | It corresponds to the category of the activity. In Sigmah, this column is not used. |
| datedeleted | timestamp(0) |              |                 |                 | This is the date it was deleted |
| mapicon  | character varying(255) |              |                 |                 | This is the path of the icon representing the activity on the map. In Sigmah, this column is not used. |
| name     | character varying(45) | X            |                 |                 | This is the label of the activity |
| reportingfrequency | integer  | X            |                 |                 | It corresponds to the frequency of each report, of each filling of an child indicator. In Sigmah, this column is not used. |
| sortorder | integer  | X            |                 |                 | It corresponds to the order it will be displayed |
| databaseid | integer  | X            |                 | [userdatabase](userdatabase.md)(databaseid) | This is a foreign key to the table userdatabase. |
| locationtypeid | integer  | X            |                 | [locationtype](locationtype.md)(locationtypeid) | This is a foreign key to the table Location. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/activity.svg' />

