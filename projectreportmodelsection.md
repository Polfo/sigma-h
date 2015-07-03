# Table projectreportmodelsection #
## Remarks ##
This table contains all sections related to a projectReportModel. Indeed, a report is composed of several sections.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id       | integer  | X            | X               |                 | This is the primary key of the table. |
| sort\_order | integer  |              |                 |                 | It corresponds to the order it will be displayed. |
| name     | character varying(255) |              |                 |                 | It corresponds to an human-readable name for the section. |
| numberoftextarea | integer  |              |                 |                 | It defines the number of text area that will be displayed under the section. It can be compared to the number of paragraph of this section. |
| parentsectionmodelid | integer  | X            |                 | [projectreportmodelsection](projectreportmodelsection.md)(id) | This is a foreign key to a projectReportModelSection beacause a section can be under another section.  |
| projectmodelid | integer  |              |                 | [projectreportmodel](projectreportmodel.md)(id) | This is a foreign key to the table ProjectReportModel. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/projectreportmodelsection.svg' />
