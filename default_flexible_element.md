=Table default\_flexible\_element=
## Remarks ##
A Default\_Flexible\_Element corresponds to a default element, an element directly assigned to a project (like Code, Title, Budget, …).

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_flexible\_element | bigint   | X            |                 | [flexible\_element](flexible_element.md)(id\_flexible\_element) | This is the primary key of the table and also a foreign key on the table flexible\_element which is its parent table. |
| type     | character varying(255) |              |                 |                 | It has only one field : the field Type that corresponds to the default element linked with an enumeration of values (on the Java side) : CODE, TITLE, BUDGET, START\_DATE, END\_DATE, COUNTRY, OWNER, MANAGER or ORG\_UNIT. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/default_flexible_element.svg' />
