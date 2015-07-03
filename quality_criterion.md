# Table quality\_criterion #
## Remarks ##
This table contains all criterion relative to a quality framework.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_quality\_criterion | integer  | X            | X               |                 | This is the primary key of the table. |
| code     | character varying(8192) | X            |                 |                 | It corresponds to a short label for this quality criterion. |
| label    | text     | X            |                 |                 | It corresponds to an human-readable name for the quality criterion. |
| id\_organization | integer  | X            |                 | [organization](organization.md)(id\_organization) | This is a foreign key to the table organization. |
| id\_quality\_framework | integer  | X            |                 | [quality\_framework](quality_framework.md)(id\_quality\_framework) | This is a foreign key to the table quality\_framework. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/quality_criterion.svg' />
