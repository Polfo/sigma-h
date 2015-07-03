# Table log\_frame\_activity #
## Remarks ##
A log\_frame\_activity is an activity created in a logical framework. Do not confuse with the table Activity created in order to organize indicators in several groups in the indicator view.

This table has a joint to the table log\_frame\_element because, in the Java code, the class LogFrameElement is the parent class of the class LogFrameActivity.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_element | integer  | X            | X               | [log\_frame\_element](log_frame_element.md)(id\_element) | This is a foreign key to the parent table log\_frame\_element. It is also the primary key of this table. |
| advancement | integer  |              |                 |                 | This is the percentage of advancement of this activity. |
| enddate  | timestamp(0) |              |                 |                 | This is the date the activity ends. |
| startdate | timestamp(0) |              |                 |                 | This is the date the activity starts. |
| title    | text     |              |                 |                 | This is the title (or the intervention logic in Sigmah) of the activity. |
| id\_result | integer  | X            |                 | [log\_frame\_expected\_result](log_frame_expected_result.md)(id\_element) | This is a foreign key to the table log\_frame\_expected\_result. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/log_frame_activity.svg' />
