# Table keyquestion #
## Remarks ##
A keyquestion is a question related to a section in a report. This question must be completed in order to valid a report.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id       | integer  | X            | X               |                 | This is the primary key of the table. |
| sort\_order | integer  |              |                 |                 | It corresponds to the order it will be displayed. |
| label    | character varying(255) |              |                 |                 | This is a human readable name for the question. |
| sectionid | integer  | X            |                 | [projectreportmodelsection](projectreportmodelsection.md)(id) | This is a foreign key to the table ProjectReportModelSection. |
| qualitycriterion\_id\_quality\_criterion | integer  | X            |                 | [quality\_criterion](quality_criterion.md)(id\_quality\_criterion) | This is a foreign key to the table quality\_criterion. It is not actually used in Sigmah. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/keyquestion.svg' />
