# Table budget\_element #
## Remarks ##
This table corresponds to a Budget element in the software and is intended for several budget fields.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| id\_flexible\_element | bigint   | X            | X               | [flexible\_element](flexible_element.md)(id\_flexible\_element) | This is the primary key of the table and also a foreign key on the table flexible\_element which is its parent table. |
| id\_ratio\_divisor| bigint   |              |                 | [budget\_sub\_field](budget_sub_field.md)(id\_budget\_sub\_field) | This is a foreign key on the table budget\_sub\_field referring to the divisor of the budget consumption ratio. |
| id\_ratio\_dividend| bigint   |              |                 | [budget\_sub\_field](budget_sub_field.md)(id\_budget\_sub\_field) | This a foreign key on the table budget\_sub\_field  referring to the dividend of the budget consumption ratio. |