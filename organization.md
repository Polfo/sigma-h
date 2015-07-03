# Table organization #
## Remarks ##
This table contains information about the organizations which used Sigmah.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_organization | integer  | X            | X               |                 | This is the primary key of the table. |
| logo     | text     |              |                 |                 | This is the relative path of the logo of the organization. |
| name     | text     | X            |                 |                 | This is the name of the NGO. |
| id\_root\_org\_unit | integer  | X            |                 | [partner](partner.md)(partnerid) | This is a foreign key to the table partner. It corresponds to the main organizational unit (or also the headquarter) of this NGO. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/organization.svg' />
