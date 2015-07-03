# Table log\_frame\_specific\_objective #
## Remarks ##
A log\_frame\_specific\_objective is an element in a logical framework that indicates what are the specific objectives of the logical framework.

This table has a joint to the table log\_frame\_element because, in the Java code, the class LogFrameElement is the parent class of the class LogFrameSpecificObjective.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_element | integer  | X            | X               |                 | This is a foreign key to the parent table log\_frame\_element. It is also the primary key of this table. |
| intervention\_logic | text     |              |                 |                 | It corresponds to the textual field named Intervention Logic in the logical framework view. It can be considered as the title of the log frame element. |
| id\_log\_frame | integer  | X            |                 | [log\_frame](log_frame.md)(id\_log\_frame) | This is a foreign key to the table log\_frame\_specific\_objective. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/log_frame_specific_objective.svg' />
