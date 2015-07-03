# Table reporttemplate #
## Remarks ##
A report template is a model of a report created with ActivityInfo. All its columns are defined with the xml column.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| reporttemplateid | integer  | X            | X               |                 | This is the primary key of the table. |
| datedeleted | timestamp(0) |              |                 |                 | This is the date the report was deleted. |
| day      | integer  |              |                 |                 | It corresponds to a day of a week. |
| description | text     |              |                 |                 | This is a description of the report. |
| frequency | character varying(255) |              |                 |                 | It corresponds to the frequency of each report. |
| title    | character varying(255) |              |                 |                 | This is the title of the report set by the xml field &lt;title&gt; |
| visibility | integer  |              |                 |                 | It defines the visibility of the report. |
| xml      | text     | X            |                 |                 | This is the xml document that defines the report. |
| databaseid | integer  | X            |                 | [userdatabase](userdatabase.md)(databaseid) | This is a foreign key to the table userdatabase. |
| owneruserid | integer  | X            |                 | [userlogin](userlogin.md)(userid) | This is a foreign key to the table userlogin. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/reporttemplate.svg' />

