# Table userdatabase #
## Remarks ##
This table is an extension of the table Project. These tables are not merged in order to not touch to the ActivityInfo datamodel.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| databaseid | integer  | X            | X               |                 | This is the primary key of the table and also a foreign key on the table Project which is its parent table. |
| datedeleted | timestamp(0) |              |                 |                 | This is the date of the removal of the project. |
| fullname | character varying(500) |              |                 |                 | This is the name of the project. |
| lastschemaupdate | timestamp(0) | X            |                 |                 | This is the date of the last update on a field of the project |
| name     | character varying(16) | X            |                 |                 | This column corresponds to the short name of the project. |
| startdate | date     |              |                 |                 | It corresponds to the date of the start of the project. |
| countryid | integer  | X            |                 | [country](country.md)(countryid) |             |
| owneruserid | integer  | X            |                 | [userlogin](userlogin.md)(userid) |             |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/userdatabase.svg' />
