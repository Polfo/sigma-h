# Table reportsubscription #
## Remarks ##
This table contains subscriptions on a report.
The primary key is composed of ReportTemplateId and UserId.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| reporttemplateid | integer  | X            | X               | [reporttemplate](reporttemplate.md)(reporttemplateid) | This is a foreign key to the table ReportTemplate. |
| userid   | integer  | X            | X               | [userlogin](userlogin.md)(userid) | This is a foreign key to the table userlogin. |
| subscribed | bool     | X            |                 |                 | It indicates if the user related has subscribed to the report. |
| invitinguserid | integer  | X            |                 | [userlogin](userlogin.md)(userid) | It corresponds to the user that had invited the user subscribed here. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/reportsubscription.svg' />

