# Table privacy\_group #
## Remarks ##
The table privacy\_group defines all type of privacy group. These privacy group are used to say if someone can read and/or write in a flexible element.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_privacy\_group | integer  | X            | X               |                 | This is the primary key of the table. |
| code     | integer  | X            |                 |                 | This is the code of the privacy group, more precisely a little label which wil identify the privacy group for the user. |
| title    | character varying(8192) | X            |                 |                 | This is the title of the privacy group. It is not the same as the column code which is shorter than the title. |
| id\_organization | integer  | X            |                 | [organization](organization.md)(id\_organization) | This is a foreign key to the table organization.  |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/privacy_group.svg' />
