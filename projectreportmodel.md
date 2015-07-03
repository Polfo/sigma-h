# Table projectreportmodel #
## Remarks ##
A ProjectReportModel is a model of report. It defines how the report must be displayed.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id       | integer  | X            | X               |                 | This is the primary key of the table. |
| name     | character varying(255) |              |                 |                 | This is the name that identify the ProjectReportModel. |
| id\_organization | integer  | X            |                 | [organization](organization.md)(id\_organization) | This is a foreign key to the table organization.  |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/projectreportmodel.svg' />
