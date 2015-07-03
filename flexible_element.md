=Table flexible\_element=
## Remarks ##
This table corresponds to an element of the view. In Java, the class related is abstract. Each concrete element inherits of the class FlexibleElement. As inheritance doesn’t exist in the SQL format, Hibernate transforms this inheritance into joint (with the strategy InheritanceType.JOINED). So each element has a foreign-key (called id\_flexible\_element) to its parent table so the table flexible\_element. You can notice that these foreign-keys are also primary-keys for these elements.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_flexible\_element | bigint   | X            | X               |                 | This is the primary key of the table. |
| amendable | bool     | X            |                 |                 | This column is a boolean that show if the element is amendable or not. |
| label    | text     |              |                 |                 | This column corresponds to the sring which will be displayed in the view. |
| validates | bool     | X            |                 |                 | It determines if this element is required. |
| id\_privacy\_group | integer  | X            |                 | [privacy\_group](privacy_group.md)(id\_privacy\_group) | This is a foreign key to the table privacy\_group. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/flexible_element.svg' />
