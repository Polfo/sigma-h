# Table quality\_criterion\_children #
## Remarks ##
A quality criterion can have several sub criteria.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_quality\_criterion\_child | integer  | X            |                 | [quality\_criterion](quality_criterion.md)(id\_quality\_criterion) | This is a foreign key to the table quality\_criterion. It is also the primary key of the table. It corresponds to the quality criterion that defines the sub criterion. |
| id\_quality\_criterion | integer  |              |                 | [quality\_criterion](quality_criterion.md)(id\_quality\_criterion) | This is a foreign key to the table quality\_criterion. It corresponds to the parent criterion. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/quality_criterion_children.svg' />