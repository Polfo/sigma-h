# Table question\_element #
## Remarks ##
A Question\_Element corresponds to a list of choices, a ListBox for GUI designers or in a more programming vision an enumeration of strings.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_flexible\_element | bigint   | X            | X               | [flexible\_element](flexible_element.md)(id\_flexible\_element) | This is the primary key of the table and also a foreign key on the table flexible\_element which is its parent table. |
| is\_multiple | bool     |              |                 |                 | It indicates if several values can be selected or only one value. |
| id\_category\_type | integer  | X            |                 | [category\_type](category_type.md)(id\_category\_type) | This is a foreign key to the table category\_type. |
| id\_quality\_criterion | integer  | X            |                 | [quality\_criterion](quality_criterion.md)(id\_quality\_criterion) | This is a foreign key to the table quality\_criterion. It says if a question element corresponds to a question linked to a quality criterion. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/question_element.svg' />

