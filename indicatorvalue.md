# Table indicatorvalue #
## Remarks ##
This table associates an indicator with a reportingperiod. It corresponds to the indicator value in a given period.
The primary key is formed by indicatorid and reportingperiodid.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| indicatorid | integer  | X            | X               | [indicator](indicator.md)(indicatorid) | This is a foreign key to the table indicator. |
| reportingperiodid | integer  | X            | X               | [reportingperiod](reportingperiod.md)(reportingperiodid) | This is a foreign key to the table reportingperiod. |
| value    | double precision | X            |                 |                 | This is the value of the indicator at the given period. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/indicatorvalue.svg' />
