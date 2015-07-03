# Goals #

In modelling the Geographic Domain objects, there were several key design goals:

  1. Be able to analyze data both by geographic administrative entities (e.g. Provinces, Health Zones, Postal Zones, etc) and spatially as lat/lng points
  1. Support any number of countries/territories, each with their own specific admin heirarchie(s).
  1. Be able to analyze multiple geographical heirarchies within a single country when they exists, such as health management zones, postal heirarchies, church administration, whatever.
  1. Be able to analyze data by facility, such as camps, schools, health centers, etc
  1. Be able to validate GPS coordinate data
  1. Be able to localise data at any level of precision, for example some data at the province level, other more detailed data might be attributed to the territory level


# Entities #

To address each of these points, each country has two sets of objects: AdminEntities and Locations.

**AdminEntities** are well-defined geographic areas (geographically modeled as polygons) that contain known populations (more or less) and that are expected to change infrequently. AdminEntities are organized into hiearchic levels defined by AdminLevel entities. A given country can have multiple independent hierarchies, or multiple hierarchies that share common ancestors.

**Locations**, in contrast are **points** that fall in zero or more AdminEntities. Locations can be a physical facility, such as a school, clinic, or camp, or may be an arbitrarily defined population, such as a collection of villages that received assistance. Locations are organized into **LocationTypes**.

![http://activity-info.googlecode.com/svn/wiki/diagrams/admin.png](http://activity-info.googlecode.com/svn/wiki/diagrams/admin.png)

# Examples #

## "Decoupage" in the DRC ##

In the DRC, as in many contexts, there are multiple geographic heirarchies that are relevant to different groups of actors. There is first the "adminstrative" hierarchy of 6 levels that is relevant to the most actors and includes Province, District, Territoire, Secteur, Groupement, and Localite (not pictured below). Health services, however, are organized along a parallel hierarchy of Province, District Sanitaire, Zone de Sante and Aire de Sante. For humanitarian actors, the relevant "decoupage" often depends on the sector. WASH projects, which have strong links to the health system, often operate by Aire de Sante. More "development-y" projects, particularly those of UNDP lend more importance to the groupement. To complicate things further, the Ministry of Education has its own heirarchy of Provinces, "Sous-divisions" and "Sites" (not pictured).

![http://activity-info.googlecode.com/svn/wiki/diagrams/admin-rdc.png](http://activity-info.googlecode.com/svn/wiki/diagrams/admin-rdc.png)

One of the goals of ActivityInfo is to facilitate communication among actors of different sectors. That is, it is important to link an education activity with health hierarchy so that WASH actors with activities in that Zone de Sante where the school is located could potentially follow up. For this reason, "points" like Schools and Villages are modeled seperately in ActivityInfo from AdminEntities can be linked to AdminEntities in multiple levels.

Below is what the diagram above looks like in the underlying SQL database. Note: bounds columns are not displayed.

### Country ###

|CountryId|Name|
|:--------|:---|
|1        |RDC |

### AdminLevel ###

|AdminLevelId|CountryId|Name|ParentAdminLevelId|
|:-----------|:--------|:---|:-----------------|
|1           |1        |Province|null              |
|2           |1        |District|1                 |
|3           |1        |Territoire|2                 |
|4           |1        |Secteur|3                 |
|5           |1        |Groupement|4                 |
|6           |1        |Zone de Sante|1                 |
|7           |1        |Aire de Sante|2                 |
|8           |1        |Sous-Division|1                 |

### AdminEntity ###

|AdminEntityId|AdminLevelId|Code|Name|ParentAdminEntityId|
|:------------|:-----------|:---|:---|:------------------|
|1            |1           |61  |Nord Kivu|null               |
|2            |1           |50  |Province Orientale|null               |
|3            |2           |611 |Nord Kivu|1                  |
|4            |2           |505 |Ituri|2                  |
|5            |3           |6111|Rutshuru|3                  |
|6            |3           |5051|Irumu|4                  |
|7            |3           |5052|Mahagi|4                  |


# Open Issues #

  * There is currently no hierarchial relationship between LocationTypes, even though this would be preferable in some cases, such as the link between villages and schools.
  * Currently, each Site can linked to no more than one AdminEntity per AdminLevel and no more than one Location of any LocationType. One of the cases in which this is annoying is that of school distributions, where it is not really useful to break down the distribution  counts by school, but we would like to know which schools have been served (or trained, etc).