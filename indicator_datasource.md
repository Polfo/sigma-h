# Table indicator\_datasource #
## Remarks ##
This table associates an indicator to another indicator. The last one corresponds to the datasource of the first one. The primary key is formed by both columns .

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| indicatorid | integer  | X            | X               | [indicator](indicator.md)(indicatorid) | This is a foreign key to the table indicator. |
| indicatorsourceid | integer  | X            | X               | [indicator](indicator.md)(indicatorid) | This is a foreign key to the table indicator. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/indicator_datasource.svg' />
