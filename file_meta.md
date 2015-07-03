# Table file\_meta #
## Remarks ##
The table file\_meta corresponds to a file in a file\_list\_element.
Each file can have several versions (which are stored in the table file\_version).

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_file | integer  | X            | X               |                 | This is the primary key of the table. |
| datedeleted | timestamp(0) |              |                 |                 | When the user ask the server to delete a file, this column is set to the current date. Deleted files can be retrieved because they are not really deleted. They are always stored in order to prevent a mistake from the user. |
| name     | text     | X            |                 |                 | This is the global name of the file. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/file_meta.svg' />
