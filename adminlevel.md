# Table adminlevel #
## Remarks ##
An adminlevel corresponds to a hierarchy of locationtype related to a country.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| adminlevelid | integer  | X            | X               |                 | This is the primary key of the table. |
| allowadd | bool     | X            |                 |                 | This column indicates if the current entry can have some children or if it is a leaf node in computer science language.  |
| name     | character varying(30) | X            |                 |                 | This is the human-readable name of the adminlevel. |
| countryid | integer  | X            |                 | [country](country.md)(countryid) | This is a foreign key to the table country. |
| parentid | integer  | X            |                 | [adminlevel](adminlevel.md)(adminlevelid) | It corresponds to the parent of the adminlevel in the hierarchical tree. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/adminlevel.svg' />

