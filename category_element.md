# Table category\_element #
## Remarks ##
A category element is an element of a category type. Each category element is represented by an icon (icon determined by the column icon\_name of the table category\_type) and has its own color.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_category\_element | integer  | X            | X               |                 | This is the primary key of the table. |
| color\_hex | character varying(6) | X            |                 |                 | This is the hexadecimal code of the color of the element. |
| label    | text     | X            |                 |                 | This is an human readable name for the category element. |
| id\_organization | integer  |              |                 | [organization](organization.md)(id\_organization) | This is a foreign key to the table organization. |
| id\_category\_type | integer  | X            |                 | [category\_type](category_type.md)(id\_category\_type) | This is a foreign key to the table category\_type. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/category_element.svg' />
