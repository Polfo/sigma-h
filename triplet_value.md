# Table triplet\_value #
## Remarks ##
A triplet\_value is a value of a triplets\_list\_element.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_triplet | bigint   | X            | X               |                 | This is the primary key of the table. |
| code     | text     | X            |                 |                 | This is a short name for the triplet. |
| datedeleted | timestamp(0) |              |                 |                 | This is the date the triplet was deleted. |
| name     | text     | X            |                 |                 | This is an human-readable name for the triplet. |
| period   | text     | X            |                 |                 | It corresponds to a period. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/triplet_value.svg' />

