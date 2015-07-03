# Table locationtype #
## Remarks ##
A locationtype corresponds to a type of site like a distribution site, a school, a health center, a well, ...

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| locationtypeid | integer  | X            | X               |                 | This is the primary key of the table. |
| name     | character varying(50) | X            |                 |                 | This is the human-readable name of the location type. |
| reuse    | bool     | X            |                 |                 | This is a boolean that indicates if the location type can be reused. |
| boundadminlevelid | integer  | X            |                 | [adminlevel](adminlevel.md)(adminlevelid) | This is a foreign key to the table adminlevel. |
| countryid | integer  | X            |                 | [country](country.md)(countryid) | This is a foreign key to the table country. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/locationtype.svg' />
