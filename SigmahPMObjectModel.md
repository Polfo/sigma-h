# Originally Proposed #


![https://lh6.googleusercontent.com/41gL5m_QcX6bYNiqdGHjOoSGhSqxQc3lwTmvVwppkoq5xO7xAjK08t3JsGpWhvz4CeNBYwWbVRwHOsjJt62hWwofag=s512?.jpg](https://lh6.googleusercontent.com/41gL5m_QcX6bYNiqdGHjOoSGhSqxQc3lwTmvVwppkoq5xO7xAjK08t3JsGpWhvz4CeNBYwWbVRwHOsjJt62hWwofag=s512?.jpg)


# Key points regarding the objectives of the project #
ActivityInfo core objective is originally to make available an environment for sharing data horizontally between organisations. On the other hand, the original objective of Sigmah is to release a software that helps information sharing information a unique organization and follows the current vertical sharing information hierarchy.

Sharing information horizontally between organisations is only possible for organizations sharing the same installation of Sigmah, for example for organizations having an account on the common SaaS server of sigmah.org.

In order to merge the 2 objectives mentionned above, the following has been decided:
  * Each organization can choose between the list of all organizations having an account on the same server a subset of organizations which can be direct horizontal partners on their projects. If an organization prefers not to have even a single project horizontally shared, they can choose to keep the list empty as it is by default.
  * At the creation of a project, the project author can decide which organizations are stakeholders of the project, and what are their rights. If an organization is defined as stakeholder and is member of the list of accepted organizations for direct horizontal data sharing, it is possible to give the right to read and also modify the data of the project. If the organization is not member of that list, no right to read or modify the data of the projects is available.

# Modifications Proposed #

## OrganizationalUnit ##

Collapse "Zone d'Intervention", "Base Operationnelle" and "Départment" into single "OrganizationalUnit" entity. An Organization **posseses** a root OrganizationalUnit, and OrganizationalUnits can **manage** any number of subordinate units.

Rationale:
  * This is essentially an Organizational object, which can sometimes follow geographic lines, but not always.
  * NGOs can have very different structures, I think it's best to rest generic rather than imposing a single structure on all organizations (e.g. Base Operationnelle, Department, Zone d'Intervention)

An OrganizationalUnit _can_ have a Location (which is associated with a single Country) which represents the Unit's physical location for the purposes of mapping. [example](http://www.pear.cd/contenu/cartes/PEAR%20Contacts%20-%20Point%20Focaux%202009%2005%2012.pdf)

An OrganizationalUnit, however, does not carry geographic constraints.

Rationale: it is not uncommon for field offices to take on projects outside of their nominal geographic responsibility. For example:
  * IRC's Pakistan office carried out projects in Afghanistan for a number of years pre-2001
  * UNICEF's DRC office provided assistance to refugees in neighboring Congo-Brazaville
  * Projects in the IDPs camps around Hombo, North Kivu, are most frequently managed by NGO's field offices in South Kivu because they are close to the border and inaccessible from Goma.

Projects are linked to geography through Project->Site->Location. See GeographyObjectModel.


## Project ##

The relationship between a Project and an OrganizationalUnit should be many-to-many. The reality is that projects typically bring together a number of Organizations and OrganizationalUnits.

For example, large NGOs often have parallel geographic and technical structures. A project to rehabilitate schools will be "line" managed by:
  * The Katanga sub-office, who will have final say over all things logistic, financial, and HR,
  * The Education Technical Unit (based in NY for IRC, based in Kinshasa for UNICEF) who is responsible for assuring good project design.

At the same time, nearly all projects involve multiple organizations. For example, the same education project will also involve:
  * The Education Ministry, who are invited to participate in the design of the project and its monitoring, for the sake of assuring the sustainability of the project.
  * The local NGO or contractor who will do the actual rehabilitation

In addition, each Project is **owned** by a single User, who is the User that created the Database and has the initial rights to make associations with OrganizationalUnits and Users.

## Permissions ##

User Permissions need to be established at two levels: the OrganizationalUnit level, and the Project level.

### Project-level Permissions ###

The Owner of a Project can grant additional Users the right to participate in a project on behalf of one of the OrganizationalUnits participating in the project.

These users can be given the rights:
- View project documents and results
- Add/Modify ... project documents and results
- Add/Manage Users for the project
- Design - modify the structure of the project's logframe, etc

Each of these permissions can be granted for the user's OrganizationalUnit or for all participating OrgUnits

### OrganizationalUnit-level Permissions ###

In addition to project-level permissions, certain users may be granted permission at the Organizational level, which grants them the rights to data associated with the OrgUnit, (e.g. Security Incidents) as well as over all projects associated with the OrgUnit, or a descendant OrgUnit.

Not all users associated with an OrgUnit (a field office, for example) would be granted automatic rights on all projects -- a field office can have 50+ staff and dozens of projects, so this kind of right would be reserved for Chiefs of Mission or Logistics Coordinator, etc. The rest of field office's staff would receive their rights on a project-by-project basis.


## Mapping to the existing ActivityInfo model ##

With the proposed modifications above, the existing ActivityInfo model maps cleanly onto that required for the ECHO project:

| Target Object | Mapped by ActivityInfo Object | Notes |
|:--------------|:------------------------------|:------|
| Project       | UserDatabase                  |       |
| ProjectPermission | UserPermission                |       |
| Organisation  | -new-                         | Organisations will be created for each existing Partner/OrgUnit |
| OrgUnit       | Partner                       |       |
| OrgUnitPermission | - new -                       |       |
| LogFrameRow   | Activity                      | An Activity is typeof LogFrameRow |
| Indicator     | Indicator                     | Add a "target" property |
| User          | User                          | Need to seperate FirstName and LastName from Name |

All other objects have no corollary in Activity and so can be defined without constraints.

The ActivityInfo GeographyObjectModel remains unchanged.