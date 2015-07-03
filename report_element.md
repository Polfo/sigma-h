# Table report\_element #
## Remarks ##
With a Report\_Element, a report can be set on a project. But it is not used on the software and will be removed on a future revision. So this table can be considered as obsolete.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_flexible\_element | bigint   | X            | X               | [flexible\_element](flexible_element.md)(id\_flexible\_element) | This is the primary key of the table and also a foreign key on the table flexible\_element which is its parent table. |
| model\_id | integer  |              |                 | [projectreportmodel](projectreportmodel.md)(id) | This is a foreign key to the table ProjectReportModel. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/report_element.svg' />

