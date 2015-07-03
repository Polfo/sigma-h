# Table amendment\_history\_token #
## Remarks ##
The table amendment\_history\_token associates values of elements in a project to an amendment.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| amendment\_id\_amendment | integer  | X            |                 | [amendment](amendment.md)(id\_amendment) | This is a foreign key to the table amendment. |
| values\_id\_history\_token | integer  | X            |                 | [history\_token](history_token.md)(id\_history\_token) | This is a foreign key to the table history\_token. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/amendment_history_token.svg' />

