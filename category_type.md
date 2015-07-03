# Table category\_type #
## Remarks ##
A category\_type is composed of a set of category elements. It can used on a question\_element instead of adding yourself all elements.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_category\_type | integer  | X            | X               |                 | This is the primary key of the table. |
| icon\_name | character varying(8192) | X            |                 |                 | It corresponds to the geometric type of the icon. It is represented by an enumeration in Java and can have one of these values : CIRCLE, CROSS, DIAMOND, SQUARE, STAR or TRIANGLE. |
| label    | character varying(8192) | X            |                 |                 | This is an human readable name for the category type. |
| id\_organization | integer  |              |                 | [organization](organization.md)(id\_organization) | This is a foreign key to the table organization. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/category_type.svg' />
