# Table projectreportversion #
## Remarks ##
Each time an user edits a project, a version of the report is created. Older versions are kept in the database.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id       | integer  | X            | X               |                 | This is the primary key of the table. |
| editdate | timestamp(0) |              |                 |                 | This is the date the version was created. |
| phasename | character varying(255) |              |                 |                 | This is the phase the report belongs. |
| version  | integer  |              |                 |                 | It corresponds to the version number of this report. |
| editor\_userid | integer  |              |                 | [userlogin](userlogin.md)(userid) | This is a foreign key to the table userlogin. It corresponds to the author of this version. |
| report\_id | integer  |              |                 | [projectreport](projectreport.md)(id) | This is a foreign key to the table ProjectReport. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/projectreportversion.svg' />
