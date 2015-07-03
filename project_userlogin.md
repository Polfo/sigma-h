# Table project\_userlogin #
## Remarks ##
Users which have put a project into his favorite projects appeared here.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| project\_databaseid | integer  | X            | X               | [project](project.md)(databaseid) | This is a foreign key to the table project. |
| favoriteusers\_userid | integer  | X            | X               | [userlogin](userlogin.md)(userid) | This is a foreign key to the table userlogin. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/project_userlogin.svg' />
