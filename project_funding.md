# Table project\_funding #
## Remarks ##
The table project\_funding was created for knowing which are the projects that fund other projects.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_funding | integer  | X            | X               | [project\_funding](project_funding.md)(id\_funding) | This is the primary key of the table. |
| percentage | double precision |              |                 |                 | This is the percentage of funds given relative to the funds expected for the project linked. |
| id\_project\_funded | integer  | X            |                 | [project](project.md)(databaseid) | This is a foreign key to the table Project. It corresponds to the Project which receives the funds. |
| id\_project\_funding | integer  | X            |                 | [project](project.md)(databaseid) | This is a foreign key to the table Project. It corresponds to the Project which give the funds. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/project_funding.svg' />
