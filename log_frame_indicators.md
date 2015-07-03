# Table log\_frame\_indicators #
## Remarks ##
This table is created for associates the table log\_frame\_element and the table indicator. In Java, it corresponds to a many to many relation between the class LogFrameElement and the class Indicator

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| log\_frame\_element\_id\_element | integer  | X            | X               |                 | This is a foreign key to the table log\_frame\_element. It is also contained in the primary key constraint of the table. |
| indicators\_indicatorid | integer  | X            | X               |                 | This is a foreign key to the table indicator. It is also contained in the primary key constraint of the table. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/log_frame_indicators.svg' />
