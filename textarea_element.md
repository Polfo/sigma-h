=Table textarea\_element=
## Remarks ##
A Textarea\_Element corresponds to a textual field that can take either a number, a little or large string or a date (formatted by a string).

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_flexible\_element | bigint   | X            | X               | [flexible\_element](flexible_element.md)(id\_flexible\_element) | This is the primary key of the table and also a foreign key on the table flexible\_element which is its parent table. |
| is\_decimal | bool     |              |                 |                 | It shows if the element is a decimal element (otherwise it means that it’s a textual element). |
| length   | integer  |              |                 |                 | This field represents the size of the string (if the element contains a string). |
| max\_value | bigint   |              |                 |                 | It represents the upper limit of the decimal value (if the element contains a decimal value) |
| min\_value | bigint   |              |                 |                 | It represents the lower limit of the decimal value (if the element contains a decimal value) |
| type     | bpchar   |              |                 |                 | It represents the type of data of the element (T for Text (or  for little text), P for Paragraph (or large text),  D for Date and N for Number. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/textarea_element.svg' />

