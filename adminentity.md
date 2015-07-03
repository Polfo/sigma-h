# Table adminentity #
## Remarks ##
An adminentity corresponds to an administrative entity. These entities are created in order to split a country in administratrive areas.
It could be use to localizing a site within an administrative area and on what an indicator is about.

This table has coords in order to know where it is localised and its area.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| adminentityid | integer  | X            | X               |                 | This is the primary key of the table. |
| x1       | double precision |              |                 |                 | The first abscissa of the area coords. |
| x2       | double precision |              |                 |                 | The second abscissa of the area coords. |
| y1       | double precision |              |                 |                 | The first ordinate of the area coords. |
| y2       | double precision |              |                 |                 | The second ordinate of the area coords. |
| code     | character varying(15) |              |                 |                 | This is a short name for the administrative entity. |
| name     | character varying(50) | X            |                 |                 | This is an human readable name for the administrative entity. |
| soundex  | character varying(50) |              |                 |                 | This is the soundex corresponding to the name of the administrative entity. |
| adminlevelid | integer  | X            |                 | [adminlevel](adminlevel.md)(adminlevelid) | This is a foreign key to the table adminlevel. |
| adminentityparentid | integer  | X            |                 | [adminentity](adminentity.md)(adminentityid) | This is a foreign key to the table adminentity. It corresponds to the administrative entity which is its parent. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/adminentity.svg' />

