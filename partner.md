# Table partner #
## Remarks ##
A partner is another word for organizational unit (concise to org unit in several columns or tables in the database). It corresponds to a headquarter or a center of the NGO related.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| partnerid | integer  | X            | X               |                 | This is the primary key of the table. |
| calendarid | integer  |              |                 |                 | This is a hidden foreign key to the table personalcalendar. It corresponds to a calendar which have events visible to all users wich belongs to the NGO related. |
| deleted  | timestamp(0) |              |                 |                 | This is the date the organizational unit was deleted. |
| fullname | character varying(64) |              |                 |                 | This is a human readable name for the organizational unit. |
| name     | character varying(16) | X            |                 |                 | This is a short name for the organizational unit. |
| planned\_budget | double precision |              |                 |                 | It corrersponds to the planned budget that will be given to this organizational unit. |
| received\_budget | double precision |              |                 |                 | It corresponds to the received budget  for the organizational unit. |
| spend\_budget | double precision |              |                 |                 | It corresponds to the spent budget  for the organizational unit. |
| location\_locationid | integer  |              |                 | [location](location.md)(locationid) | This is a foreign key to the table location. It corresponds to the location of this organizational unit. |
| office\_country\_id | integer  |              |                 | [country](country.md)(countryid) | This is a foreign key to the table country. It corresponds to the country of the location of the organizational unit. |
| id\_org\_unit\_model | integer  |              |                 | [org\_unit\_model](org_unit_model.md)(org\_unit\_model\_id) | This is a foreign key to the table org\_unit\_model. it corresponds to the model of the organizational unit. |
| organization\_id\_organization | integer  |              |                 | [organization](organization.md)(id\_organization) | This is a foreign key to the table organization. |
| parent\_partnerid | integer  | X            |                 | [partner](partner.md)(partnerid) | This is a foreign key to the table partner. Indeed, an organizational unit can be managed by other organizational units. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/partner.svg' />
