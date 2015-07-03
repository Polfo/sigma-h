# Table projectreport #
## Remarks ##
This table corresponds to a concrete report based on a report model (contained in the table ProjectReportModel).

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id       | integer  | X            | X               |                 | This is the primary key of the table. |
| datedeleted | timestamp(0) |              |                 |                 | This is the date the report was deleted. |
| name     | character varying(255) |              |                 |                 | This is the human readable name of the report. |
| currentversion\_id | integer  | X            |                 | [projectreportversion](projectreportversion.md)(id) | This is a foreign key to the table projectreportversion. It corresponds to the current version of the report. |
| flexibleelement\_id\_flexible\_element | bigint   | X            |                 | [flexible\_element](flexible_element.md)(id\_flexible\_element) | This is a foreign key to the table flexible\_element. This is the flexible element that contains this report. |
| model\_id | integer  | X            |                 | [projectreportmodel](projectreportmodel.md)(id) | This is a foreign key to the table ProjectReportModel. This report follow the same architecture than this model. |
| orgunit\_partnerid | integer  | X            |                 | [partner](partner.md)(partnerid) | This is a foreign key to the table partner. In Sigmah, this column is not used. |
| project\_databaseid | integer  | X            |                 | [project](project.md)(databaseid) | This is a foreign key to the table userdatabase. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/projectreport.svg' />
