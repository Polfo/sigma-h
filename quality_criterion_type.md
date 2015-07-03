# Table quality\_criterion\_type #
## Remarks ##
This table defines the type of each level of criteria.
Indeed, a criterion can have sub criteria and these sub criteria has a meaning for the quality framework.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_criterion\_type | integer  | X            | X               |                 | This is the primary key of the table. |
| label    | character varying(8192) | X            |                 |                 | This is an human readable name for the type of quality criterion. |
| level    | integer  | X            |                 |                 | It defines the level for this type of quality criterion. |
| id\_quality\_framework | integer  | X            |                 | [quality\_framework](quality_framework.md)(id\_quality\_framework) | This is a foreign key to the table quality\_framework. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/quality_criterion_type.svg' />

