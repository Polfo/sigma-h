# Table quality\_framework #
## Remarks ##
This table contains a list of quality framework that could be used in Sigmah. You can notice that this feature is already not implemented. It should be done in a future release.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_quality\_framework | integer  | X            | X               |                 | This is the primary key of the table. |
| label    | character varying(8192) | X            |                 |                 | This is the name of the quality framework. |
| id\_organization | integer  | X            |                 | [organization](organization.md)(id\_organization) | This is a foreign key to the table organization. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/quality_framework.svg' />

