# Table attributevalue #
## Remarks ##
An attribute can have a value according to a site.

So, the primary key of the table is the column attributeid and the column siteid.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| attributeid | integer  | X            | X               | [attribute](attribute.md)(attributeid) | This is a foreign key to the table attribute. |
| siteid   | integer  | X            | X               | [site](site.md)(siteid) | This is a foreign key to the table site. |
| value    | bool     |              |                 |                 | This is the boolean value of the attribute. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/attributevalue.svg' />
