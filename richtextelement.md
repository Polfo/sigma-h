# Table richtextelement #
## Remarks ##
This table contains the content of a text area that belongs to a section of a report.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id       | integer  | X            | X               |                 | This is the primary key of the table. |
| sort\_order | integer  |              |                 |                 | It corresponds to the order it will be displayed. |
| sectionid | integer  |              |                 |                 | This is a foreign key to the table ProjectReportModelSection. |
| text     | text     |              |                 |                 | It contains the content of the text area. |
| version\_id | integer  |              |                 | [projectreportversion](projectreportversion.md)(id) | This is a foreign key to the table ProjectReportVersion. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/richtextelement.svg' />

