# Table amendment #
## Remarks ##
An amendment corresponds to a version of project. It can be used if the project roughly change and modify the main idea or how the project will be accomplished.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_amendment | integer  | X            | X               |                 | This is the primary key of the table. |
| history\_date | timestamp(0) |              |                 |                 | This is the date the amendment was created. |
| revision | integer  |              |                 |                 | This is the revision number of the amendment. |
| status   | character varying(255) |              |                 |                 | It defines the state of the amendment. It corresponds to a Java enumeration (DRAFT, LOCKED, ACTIVE, REJECTED or ARCHIVED). |
| version  | integer  |              |                 |                 | This is the version number of the revision number of the amendment. |
| id\_log\_frame | integer  | X            |                 | [log\_frame](log_frame.md)(id\_log\_frame) | This is a foreign key to the table log\_frame. The related logical framework belongs to this amendment. |
| id\_project | integer  | X            |                 | [project](project.md)(databaseid) | This is a foreign key to the table project. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/amendment.svg' />

