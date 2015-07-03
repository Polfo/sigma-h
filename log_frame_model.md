# Table log\_frame\_model #
## Remarks ##
The table log\_frame\_model corresponds to a logical framework model created in the same time that a project model. It has some informations used for each tab of a log\_frame (Specific Objectives, Expected Results, Activities and Prerequisites).

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_log\_frame | integer  | X            | X               |                 | This is the primary key of the table. |
| a\_gp\_max | integer  |              |                 |                 | It corresponds to the maximum of group in the tab named Activities |
| a\_max   | integer  |              |                 |                 | It corresponds to the maximum of group of activities in the tab named Activities |
| a\_per\_er\_max | integer  |              |                 |                 | It corresponds to the maximum of activities related to an expected result in the tab named Activities |
| a\_per\_gp\_max | integer  |              |                 |                 | It corresponds to the maximum of activities in a group in the tab named Activities |
| a\_enable\_groups | bool     |              |                 |                 | This column indicates if groups are enabled in the tab named Activities. |
| er\_enable\_groups | bool     |              |                 |                 | This column indicates if groups are enabled in the tab named Expected Results. |
| p\_enable\_groups | bool     |              |                 |                 | This column indicates if groups are enabled in the tab named Prerequisites. |
| so\_enable\_groups | bool     |              |                 |                 | This column indicates if groups are enabled in the tab named Specific Objectives. |
| er\_gp\_max | integer  |              |                 |                 | It corresponds to the maximum of groups in the tab named Expected Results. |
| er\_max  | integer  |              |                 |                 | It corresponds to the maximum of expected results in the tab named Expected Results. |
| er\_per\_gp\_max | integer  |              |                 |                 | It corresponds to the maximum of expected results in a group in the tab named Expected Results. |
| er\_per\_so\_max | integer  |              |                 |                 | It corresponds to the maximum of expected results related to a specific objective in the tab named Expected Results. |
| name     | character varying(8192) | X            |                 |                 | This column corresponds to the name of the logical framework model. |
| p\_gp\_max | integer  |              |                 |                 | It corresponds to the maximum of groups in the tab named Prerequisites |
| p\_max   | integer  |              |                 |                 | It corresponds to the maximum of prerequisites in the tab named Prerequisites |
| p\_per\_gp\_max | integer  |              |                 |                 | It corresponds to the maximum of prerequisites in a group in the tab named Prerequisites. |
| so\_gp\_max | integer  |              |                 |                 | It corresponds to the maximum of groups in the tab named Specific Objectives. |
| so\_max  | integer  |              |                 |                 | It corresponds to the maximum of specific objectives in the tab named Specific Objectives. |
| so\_per\_gp\_max | integer  |              |                 |                 | It corresponds to the maximum of specific objectives in a group in the tab named Specific Objectives. |
| id\_project\_model | bigint   | X            |                 | [project\_model](project_model.md)(id\_project\_model) | This is a foreign key to the table project\_model. The project model related is the project model with which the logical framework model had been created. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/log_frame_model.svg' />
