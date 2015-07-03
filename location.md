# Table location #
## Remarks ##
A location corresponds to a site in Sigmah. An indicator needs a site in order to have a value. A site corresponds to a place in the world. These informations are set with the Google Maps panel and has some geographical coordinates.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| locationid | integer  | X            | X               |                 | This is the primary key of the table. |
| axe      | character varying(50) |              |                 |                 | This column corresponds to the name of the nearest road or a waterway. |
| datecreated | timestamp(0) |              |                 |                 | This is the date of the creation of the location. |
| dateedited | timestamp(0) |              |                 |                 | This is the date of the last update of the location. |
| locationguid | character varying(36) |              |                 |                 | This is the Guid of the location. This column is not used in Sigmah. |
| name     | character varying(50) | X            |                 |                 | It corresponds to an human-readable name for the location. |
| x        | double precision |              |                 |                 | This column is the abscissa of the geographical coordinates on Google Maps. |
| y        | double precision |              |                 |                 | This column is the ordinate of the geographical coordinates on Google Maps. |
| locationtypeid | integer  | X            |                 | [locationtype](locationtype.md)(locationtypeid) | This is a foreign key to the table locationtype. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/location.svg' />
