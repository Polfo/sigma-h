# Table value #
## Remarks ##
A flexible\_element in an available project can have a value. This table corresponds to the current value of the flexible\_element. Old values are sent to the table [history\_token](history_token.md).

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_value | bigint   | X            | X               |                 | This is the primary key of the table. |
| id\_project | integer  | X            |                 |                 | This column is linked to either the table project or the table partner. |
| action\_last\_modif | bpchar   | X            |                 |                 | This column contains a character that corresponds to the last action made on the flexible\_element linked. |
| date\_last\_modif | timestamp(0) | X            |                 |                 | This column correspond to the date of the last action made on the flexible\_element linked. |
| value    | text     |              |                 |                 | This columns contains the value of the flexible element in a string representation |
| id\_flexible\_element | bigint   | X            |                 | [flexible\_element](flexible_element.md)(id\_flexible\_element) | This is a foreign key to the table flexible\_element. This value belong to this flexible\_element. |
| id\_user\_last\_modif | integer  | X            |                 | [userlogin](userlogin.md)(userid) | This is a foreign key to the table userlogin. This user corresponds to the last contributor on the flexible element associated. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/value.svg' />
