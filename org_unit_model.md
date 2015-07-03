# Table org\_unit\_model #
## Remarks ##
An org unit model is a model of organizational unit. An organizational unit belongs to a model created before it. A model can be used by an infinite number of organizational units.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| org\_unit\_model\_id | integer  | X            | X               |                 | This is the primary key of the table. |
| can\_contain\_projects | bool     | X            |                 |                 | It indicates if the organizational units created with this model can contain projects. |
| has\_budget | bool     |              |                 |                 | It indicates if an organizational unit has a budget. |
| name     | character varying(8192) | X            |                 |                 | This is a human readable name for the org\_unit\_model. |
| status   | character varying(255) | X            |                 |                 | This is the state of the org unit model. It corresponds to a Java enumeration (DRAFT, READY, USED or UNAVAILABLE). |
| title    | character varying(8192) | X            |                 |                 | It is the type (also a short name) of the organizational unit. |
| id\_organization | integer  |              |                 | [organization](organization.md)(id\_organization) | This is a foreign key to the table organization. The organizational unit belongs to the organization related. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/org_unit_model.svg' />
