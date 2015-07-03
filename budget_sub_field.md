# Table checkbox\_element #
## Remarks ##
This table corresponds to a Budget elements's sub field in the software.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_budget\_sub\_field| bigint   | X            | X               |                 | This is the primary key of the table. |
| label    | bigint   |              |                 |                 | This is the label displayed for the field. |
| id\_budget\_element| bigint   | X            |                 | [budget\_element](budget_element.md)(id\_flexible\_element) | This is a foreign key to the budget element to which the budget sub field belongs to. |
| fieldorder| bigint   |              |                 |                 | This is the order in which the field should be displayed in the budget element. |
| type     | character varying(255)|              |                 |                 | This is type of the budget sub field, it can be 'PLANNED', 'RECEIVED', 'SPENT' or NULL for the budget sub fields created by the user. |