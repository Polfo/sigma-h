# Table history\_token #
## Remarks ##
A flexible\_element in an available project can have a value stored in  the table [value](value.md). But when a flexible element has its value replaced by another one, the old value is sent to the table [history\_token](history_token.md).

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_history\_token | integer  | X            | X               |                 | This is the primary key of the table. |
| history\_date | timestamp(0) | X            |                 |                 | This is the date of the action archived. |
| id\_element | bigint   | X            |                 |                 | This is a foreign key to the table flexible\_element. This history\_token belong to this flexible\_element. |
| id\_project | integer  | X            |                 |                 | This column is linked to either the table project or the table partner. |
| change\_type | character varying(255) |              |                 |                 | This column is like a java enum that can contains either ADD, REMOVE or EDIT. |
| value    | text     | X            |                 |                 | This columns contains an old value of the flexible element in a string representation |
| id\_user | integer  | X            |                 | [userlogin](userlogin.md)(userid) | This is a foreign key to the table userlogin. This user corresponds to the contributor on the flexible element associated.  |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/history_token.svg' />
