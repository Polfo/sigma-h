# Table userlogin #
## Remarks ##
The table UserLogin is the table that save all informations of the users of Sigmah.


## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| userid   | integer  | X            | X               |                 | This is the primary key of the table. |
| active   | bool     |              |                 |                 | This column says if a user is active or not. |
| changepasswordkey | character varying(34) |              |                 |                 | When an user want to change his password, it has a key for verifying the authenticity of the user. |
| datechangepasswordkeyissued | timestamp(0) |              |                 |                 | This is the date of the last update of the password. |
| email    | character varying(75) | X            |                 |                 | Each user must have an email address in order to log in. An email must be unique because it is the identifier of the user. |
| firstname | character varying(50) |              |                 |                 | This column contains the firstname of the user. |
| password | character varying(150) |              |                 |                 | This is the password of the user used to log in. This password is encrypted in the database. |
| locale   | character varying(10) | X            |                 |                 | This column indicates the locality of the user and it is used to know what is the language that must be set on the application for this user. |
| name     | character varying(50) | X            |                 |                 | It corresponds to the lastname of the user. |
| newuser  | bool     | X            |                 |                 | It indicates if the user is new on the application. |
| id\_organization | integer  | X            |                 | [organization](organization.md)(id\_organization) | This is a foreign key to the table organization. It indicate also in which organization this user worked for. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/userlogin.svg' />
