# Table message\_element #
## Remarks ##
This table corresponds to a label that will be displayed in a project. The user can't interact with this label.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_flexible\_element | bigint   | X            | X               | [flexible\_element](flexible_element.md)(id\_flexible\_element) | This is the primary key of the table and also a foreign key on the table flexible\_element which is its parent table. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/message_element.svg' />
