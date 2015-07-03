# Table site #
## Remarks ##
A site associates a location to an activity (a group of indicators), a project and a partner.

## Schema ##
| **Name** | **Type** | **Not Null** | **Primary Key** | **Foreign Key** | **Remarks** |
|:---------|:---------|:-------------|:----------------|:----------------|:------------|
| siteid   | integer  | X            | X               |                 | This is the primary key of the table. |
| comments | text     |              |                 |                 | This column contains some comments on this site. In Sigmah, this column is not used. |
| date1    | date     |              |                 |                 | It corresponds to the date on which work at this site began. In Sigmah, this column is not used. |
| date2    | date     |              |                 |                 | It corresponds to the date on which work at this site ended. In Sigmah, this column is not used. |
| datecreated | timestamp(0) | X            |                 |                 | This is the date the site was created. |
| datedeleted | timestamp(0) |              |                 |                 | This is the date the site was deleted. |
| dateedited | timestamp(0) | X            |                 |                 | This is the last date the site was edited. |
| datesynchronized | timestamp(0) |              |                 |                 | It corresponds to the time at which this site was last synchronized with an external system. This field is only used when an external system is used as the source of this Site's data. In Sigmah, this column is not used. |
| siteguid | character varying(36) |              |                 |                 | This is the Globally-Unique Identifier (GUID) for this Site, used to link this Site to external systems. In Sigmah, this column is not used. |
| status   | integer  | X            |                 |                 | This is the status of the site. This column is **obsolete**. |
| target   | integer  | X            |                 |                 | This is the the type of site: 0 for work complete, 1 for program targets. In Sigmah, this column is not used because it is not yet implemented. |
| activityid | integer  |              |                 | [activity](activity.md)(activityid) | This is a foreign key to the table activity. In Sigmah, this column is not used. |
| assessmentsiteid | integer  | X            |                 | [site](site.md)(siteid) | This is a foreign key to the table site. It corresponds to the site of the needs assessment on which this site is based. In Sigmah, this column is not used. |
| databaseid | integer  | X            |                 | [userdatabase](userdatabase.md)(databaseid) | This is a foreign key to the table userdatabase. |
| locationid | integer  | X            |                 | [location](location.md)(locationid) | This is a foreign key to the table location. |
| partnerid | integer  | X            |                 | [partner](partner.md)(partnerid) | This is a foreign key to the table partner. |

## Diagram ##
<img src='http://www.sigmah.org/svg_load.php?file=http://sigma-h.googlecode.com/svn/wiki/diagrams/site.svg' />

