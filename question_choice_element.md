# Table question\_choice\_element #
## Remarks ##
Each entry of this table corresponds to an element of an entry of the table Question\_Element. In other words, an entry of the table Question\_Element has several entry of the table Question\_Choice\_Element. So in Java code, the class Question\_Element has a list of Question\_Element.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_choice | bigint   | X            | X               |                 | This is the primary key of the table. |
| label    | character varying(8192) | X            |                 |                 | This column is the label of the choice which will be displayed in the listbox. |
| sort\_order | integer  |              |                 |                 | The sor\_order column indicates the order in which choices will be displayed |
| id\_category\_element | integer  | X            |                 | [category\_element](category_element.md)(id\_category\_element) | This is a foreign key to the table category\_element |
| id\_question | bigint   | X            |                 | [question\_element](question_element.md)(id\_flexible\_element) |             |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/question_choice_element.svg' />

