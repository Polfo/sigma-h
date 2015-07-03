# Table country #
## Remarks ##
This table contains a list of country. It can contain some coords that represents the country with a rectangle. In Sigmah, this table is initialized in the beginning and it is not updated after in the software. The coords system is also not used.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| countryid | integer  | X            | X               |                 | This is the primary key of the table. |
| x1       | double precision | X            |                 |                 | It corresponds to the first abscissa of the map. In Sigmah, this column is already not used. |
| x2       | double precision | X            |                 |                 | It corresponds to the second abscissa of the map. In Sigmah, this column is already not used. |
| y1       | double precision | X            |                 |                 | It corresponds to the first ordinate of the map. In Sigmah, this column is already not used. |
| y2       | double precision | X            |                 |                 | It corresponds to the second ordinate of the map. In Sigmah, this column is already not used. |
| iso2     | character varying(2) |              |                 |                 | This is the ISO2 code for the country. |
| name     | character varying(50) | X            |                 |                 | This column corresponds to an human-readable name for the country. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/country.svg' />
