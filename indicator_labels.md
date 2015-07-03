# Table indicator\_labels #
## Remarks ##
This table contains all possible values of an indicator which have is aggregation column with the value 3 (=AGGREGATE\_MULTINOMIAL). The indicator related is like a listbox.
This table can be compared to a list of choices : each element has its own index (with the column code). This table is created with the annotation @CollectionOfElements on the field labels of the class Indicator in Java.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| indicator\_indicatorid | integer  | X            | X               | [indicator](indicator.md)(indicatorid) | This is a foreign key to the table indicator. |
| code     | integer  | X            |                 |                 | This is the number of the value in the listbox. |
| element  | character varying(255) |              |                 |                 | This is a value of the "listbox". |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/indicator_labels.svg' />
