# Table project #
## Remarks ##
The table project contains all projects of the organizations.
A project is set by a project\_model that defines how it will be displayed.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| databaseid | integer  | X            | X               | [userdatabase](userdatabase.md)(databaseid) | This is the primary key of the table. It is also a foreign key to the table userdatabase that contains some metadata of the project. |
| activity\_advancement | integer  |              |                 |                 | This column indicates the progression of the activity |
| amendment\_revision | integer  |              |                 |                 | This column corresponds to the current number of the amendment revision |
| amendment\_status | character varying(255) |              |                 |                 | This columns defines the status of the amendment (DRAFT, LOCKED, ACTIVE, REJECTED or ARCHIVED) |
| amendment\_version | integer  |              |                 |                 | This column sepcifies the cureent number of the amendment version. |
| calendarid | integer  |              |                 |                 | This column is a link to the table personalcalendar |
| close\_date | date     |              |                 |                 | It specifies when the project will be finished. |
| end\_date | date     |              |                 |                 | It specifies when the project will begin. |
| planned\_budget | double precision |              |                 |                 | It defines the amount of funds expected |
| received\_budget | double precision |              |                 |                 | It defines the amount of funds received |
| spend\_budget | double precision |              |                 |                 | It defines the amount of funds spent |
| id\_current\_phase | bigint   | X            |                 | [phase](phase.md)(id\_phase) | This column defines which is the current phase of the project. |
| id\_manager | integer  | X            |                 | [userlogin](userlogin.md)(userid) | It's a foreign key to the table userlogin and corresponds to the manager of the project. |
| id\_monitored\_points\_list | integer  | X            |                 | [monitored\_point\_list](monitored_point_list.md)(id\_monitored\_point\_list) | This is a foreign key to the table monitored\_point\_list. |
| id\_project\_model | bigint   | X            |                 | [project\_model](project_model.md)(id\_project\_model) | This column specifies the type of the project. |
| id\_reminder\_list | integer  | X            |                 | [reminder\_list](reminder_list.md)(id\_reminder\_list) | This is the foreign key to a reminder list. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/project.svg' />