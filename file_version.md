# Table file\_version #
## Remarks ##
The table file\_version contains all versions of each file. Each version is stored in the filesystem and can be retrieved with this table.
Deleted versions in the database are not deleted on the filesystem in order to retrieve them if the user had made a mistake. But these files are hidden from the view.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_file\_version | integer  | X            | X               |                 | This is the primary key of the table. |
| added\_date | timestamp(0) | X            |                 |                 | This column corresponds to the date of the upload of this file version |
| comments | text     |              |                 |                 | It contains some comments on the file version. |
| datedeleted | timestamp(0) |              |                 |                 | When a file version is deleted, this column take the current date. |
| extension | character varying(1024) |              |                 |                 | It contains the extension of the file (like .jpg, .doc, ...) |
| name     | text     | X            |                 |                 | This is the name of the file without the extension |
| path     | text     | X            |                 |                 | This column contains the UUID in which the file is renamed in the filesystem |
| size     | bigint   | X            |                 |                 | It corresponds to the size of the file in bytes. |
| version\_number | integer  | X            |                 |                 | It corresponds the the number of this version. The version with the higher version\_number is the current file. |
| id\_author | integer  | X            |                 | [userlogin](userlogin.md)(userid) | This is a foreign key to the table userlogin. It corresponds to the uploader of the file. |
| id\_file | integer  | X            |                 | [file\_meta](file_meta.md)(id\_file) | This is a foreign key to the table file\_meta. It corresponds to the linked file. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/file_version.svg' />
