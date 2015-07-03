# Table authentication #
## Remarks ##
The table authentication corresponds to session of a user with a secure session id and starting at the current time

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| authtoken | character varying(32) | X            | X               |                 | It corresponds to the secure id of the authentication and also the primary key of the table. It is a 128-bit random number represented as a 32-character hexadecimal string |
| datecreated | timestamp(0) |              |                 |                 | This is the date of the creation of the creation of the session |
| datelastactive | timestamp(0) |              |                 |                 |             |
| userid   | integer  | X            |                 | [userlogin](userlogin.md)(userid) | This is a foreign key to the table userlogin. It corresponds to the user who wanted to login on the application. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/authentication.svg' />