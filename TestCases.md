# Introduction #

This page sums up all test cases written for the Sigmah project.
Each time a new relase of Sigmah is made, the full list of tests below should be runned.

These tests are based on the demo data set v1.2 which contains the following users :
  * **Demo user** : email address : demo@sigmah.org
    * has every rights and is associated to the highest level of organizational unit of the organisation.

  * **user2** : email address : user2@sigmah.org
    * This user has only the right to view projects and belongs to an organisational unit from the highest level of them.

  * **user3** : email address: user3@sigmah.org
    * has only the right to view and modify projects and belongs to a profile having rights to modify fields belonging to the confidentiality group « Suivi RH ». He belongs to an organisational unit from the lowest level of them.

  * **user4** : email address : user4@sigmah.org
    * This user is associated to an organisational unit from the highest level of them and has every rights excepts the following :
      * Create project
      * Change phase
      * Delete a file

  * **user5** : email address : user5@sigmah.org
    * This user is associated to an organisational unit from the highest level of them and has every rights excepts the following :
      * Modify project

  * **user6** : email address : user6@sigmah.org
    * This user is associated to an organisational unit from the highest level of them and has every rights excepts the following :
      * View projects


# Summary of all test cases #

| **Code**| **Name** | **URL** |
|:--------|:---------|:--------|
| LPC     | List of checkpoints | [ListCheckPoints](ListCheckPoints.md) |
|         | **Users and sessions management** | [TestScenario4UserSessionRight](TestScenario4UserSessionRight.md) |
| USR1    | User signing in | [TestScenario4UserSessionRight#USR1](TestScenario4UserSessionRight#USR1.md) |
| USR2    | User logging out | [TestScenario4UserSessionRight#USR2](TestScenario4UserSessionRight#USR2.md) |
| USR3    | Recovering lost password | [TestScenario4UserSessionRight#USR3](TestScenario4UserSessionRight#USR3.md) |
| USR4    | Unreachable pages if no user is logged in | [TestScenario4UserSessionRight#USR4](TestScenario4UserSessionRight#USR4.md) |
| USR5    | Display of user's NGO 's information | [TestScenario4UserSessionRight#USR5](TestScenario4UserSessionRight#USR5.md) |
| USR6    | Pop-up help (#82) | [TestScenario4UserSessionRight#USR6](TestScenario4UserSessionRight#USR6.md) |
| USR7    | Pop-up credits (#91) | [TestScenario4UserSessionRight#USR7](TestScenario4UserSessionRight#USR7.md) |
| USR8    | Create a user (#105) | [TestScenario4UserSessionRight#USR8](TestScenario4UserSessionRight#USR8.md) |
|         | **Dashboard Projects Table** | [TestScenario4DashboardProjectTable](TestScenario4DashboardProjectTable.md) |
| DPT2    | Projects table loading| [TestScenario4DashboardProjectTable#DPT2](TestScenario4DashboardProjectTable#DPT2.md) |
| DPT3    | Global export live data | [TestScenario4DashboardProjectTable#DPT3](TestScenario4DashboardProjectTable#DPT3.md) |
| DPT4    | Global export other format exportation | [TestScenario4DashboardProjectTable#DPT4](TestScenario4DashboardProjectTable#DPT4.md) |
| DPT5    | Columns filter | [TestScenario4DashboardProjectTable#DPT5](TestScenario4DashboardProjectTable#DPT5.md) |
| DPT6    | Projects' table grouping manipulation | [TestScenario4DashboardProjectTable#DPT6](TestScenario4DashboardProjectTable#DPT6.md) |
| DPT7    | Limited project's access according to user's rights |  [TestScenario4DashboardProjectTable#DPT7](TestScenario4DashboardProjectTable#DPT7.md) |
| DPT8    | Reload dashboard projects table | [TestScenario4DashboardProjectTable#DPT8](TestScenario4DashboardProjectTable#DPT8.md) |
| DPT9    | Automatic Excel global export | [TestScenario4DashboardProjectTable#DPT9](TestScenario4DashboardProjectTable#DPT9.md) |
|         | **Project management** | [TestScenario4ProjectManagement](TestScenario4ProjectManagement.md) |
| PRJM2   | Open a project page | [TestScenario4ProjectManagement#PRJM2](TestScenario4ProjectManagement#PRJM2.md) |
| PRJM3   | Modify a project's attributes | [TestScenario4ProjectManagement#PRJM3](TestScenario4ProjectManagement#PRJM3.md) |
| PRJM4   | Fill project mandatory field | [TestScenario4ProjectManagement#PRJM4](TestScenario4ProjectManagement#PRJM4.md) |
| PRJM5   | Switch from a phase to another | [TestScenario4ProjectManagement#PRJM5](TestScenario4ProjectManagement#PRJM5.md) |
| PRJM6   | Out of phase project attribute modification | [TestScenario4ProjectManagement#PRJM6](TestScenario4ProjectManagement#PRJM6.md) |
| PRJM7   | Link a new project as source of funding of an existing project | [TestScenario4ProjectManagement#PRJM7](TestScenario4ProjectManagement#PRJM7.md) |
| PRJM8   | Link an existing project as source of funding of an existing project | [TestScenario4ProjectManagement#PRJM8](TestScenario4ProjectManagement#PRJM8.md) |
| PRJM9   | Link a new project as funded project of an existing project | [TestScenario4ProjectManagement#PRJM9](TestScenario4ProjectManagement#PRJM9.md) |
| PRJM10  | Link a existing project as funded project of an existing project | [TestScenario4ProjectManagement#PRJM10](TestScenario4ProjectManagement#PRJM10.md) |
| PRJM11  | Project's attribute history consultation | [TestScenario4ProjectManagement#PRJM11](TestScenario4ProjectManagement#PRJM11.md) |
| PRJM12  | Add a reminder | [TestScenario4ProjectManagement#PRJM11](TestScenario4ProjectManagement#PRJM11.md) |
| PRJM13  | Add a late reminder| [TestScenario4ProjectManagement#PRJM13](TestScenario4ProjectManagement#PRJM13.md) |
| PRJM14  | Check a reminder | [TestScenario4ProjectManagement#PRJM14](TestScenario4ProjectManagement#PRJM14.md) |
| PRJM15  | Add a reminder after attaching files | [TestScenario4ProjectManagement#PRJM15](TestScenario4ProjectManagement#PRJM15.md) |
| PRJM16  | Accessing project's information according to user's rights | [TestScenario4ProjectManagement#PRJM16](TestScenario4ProjectManagement#PRJM16.md) |
| PRJM17  | Lock information with an amendment (#89) | [TestScenario4ProjectManagement#PRJM17](TestScenario4ProjectManagement#PRJM17.md) |
| PRJM18  | Project manager modification (#92) | [TestScenario4ProjectManagement#PRJM18](TestScenario4ProjectManagement#PRJM18.md) |
| PRJM19  | Project's organizational unit modification (#93) | [TestScenario4ProjectManagement#PRJM19](TestScenario4ProjectManagement#PRJM19.md) |
| PRJM20  | Create a draft project  (#97) | [TestScenario4ProjectManagement#PRJM20](TestScenario4ProjectManagement#PRJM20.md) |
| PRJM21  | Manipulate a project's links to other projects (#115)| [TestScenario4ProjectManagement#PRJM21](TestScenario4ProjectManagement#PRJM21.md) |
| PRJM22  | Create a project (#142)| [TestScenario4ProjectManagement#PRJM22](TestScenario4ProjectManagement#PRJM22.md) |
| PRJM23  | Add a new version of an attached file | [TestScenario4ProjectManagement#PRJM23](TestScenario4ProjectManagement#PRJM23.md) |
| PRJM24  | Delete a draft project | [TestScenario4ProjectManagement#PRJM24](TestScenario4ProjectManagement#PRJM24.md) |
| PRJM25  | Delete a project | [TestScenario4ProjectManagement#PRJM25](TestScenario4ProjectManagement#PRJM25.md) |
| PRJM26  | Export Project synthesis Excel file | [TestScenario4ProjectManagement#PRJM26](TestScenario4ProjectManagement#PRJM26.md) |
|         | **Project/Orgunit Model Management**  | [TestScenario4ProjectOrgunitModelManagement](TestScenario4ProjectOrgunitModelManagement.md) |
| POMM2   | Import project model | [TestScenario4ProjectOrgunitModelManagement#POMM2](TestScenario4ProjectOrgunitModelManagement#POMM2.md) |
| POMM3   | Duplicate a project model | [TestScenario4ProjectOrgunitModelManagement#POMM3](TestScenario4ProjectOrgunitModelManagement#POMM3.md) |
| POMM4   | Delete project model with test projects | [TestScenario4ProjectOrgunitModelManagement#POMM4](TestScenario4ProjectOrgunitModelManagement#POMM4.md) |
| POMM5   | Create a project model (#94) | [TestScenario4ProjectOrgunitModelManagement#POMM5](TestScenario4ProjectOrgunitModelManagement#POMM5.md) |
| POMM6   | Add a new field to a project model | [TestScenario4ProjectOrgunitModelManagement#POMM6](TestScenario4ProjectOrgunitModelManagement#POMM6.md) |
| POMM7   | Add a new phase to a project model | [TestScenario4ProjectOrgunitModelManagement#POMM7](TestScenario4ProjectOrgunitModelManagement#POMM7.md) |
| POMM8   | Switch two fields in a model | [TestScenario4ProjectOrgunitModelManagement#POMM8](TestScenario4ProjectOrgunitModelManagement#POMM8.md) |
| POMM9   | Add a mandatory field to a project | [TestScenario4ProjectOrgunitModelManagement#POMM9](TestScenario4ProjectOrgunitModelManagement#POMM9.md) |
| POMM10  | Reorganize a project model's attributes of the synthesis section| [TestScenario4ProjectOrgunitModelManagement#POMM10](TestScenario4ProjectOrgunitModelManagement#POMM10.md) |
| POMM11  | Modify available groups' types from a logical frame model | [TestScenario4ProjectOrgunitModelManagement#POMM11](TestScenario4ProjectOrgunitModelManagement#POMM11.md) |
| POMM12  | Modify elements creation's constraints of a logical frame from its model | [TestScenario4ProjectOrgunitModelManagement#POMM12](TestScenario4ProjectOrgunitModelManagement#POMM12.md) |
| POMM13  | Modify Date field's constraints | [TestScenario4ProjectOrgunitModelManagement#POMM13](TestScenario4ProjectOrgunitModelManagement#POMM13.md) |
| POMM14  | Modify Number field's constraints | [TestScenario4ProjectOrgunitModelManagement#POMM14](TestScenario4ProjectOrgunitModelManagement#POMM14.md) |
| POMM15  | Modify a Number field's numeric type | [TestScenario4ProjectOrgunitModelManagement#POMM15](TestScenario4ProjectOrgunitModelManagement#POMM15.md) |
| POMM16  | Modify text field's constraints | [TestScenario4ProjectOrgunitModelManagement#POMM16](TestScenario4ProjectOrgunitModelManagement#POMM16.md) |
| POMM17  | Convert a report list field to a mandatory field | [TestScenario4ProjectOrgunitModelManagement#POMM17](TestScenario4ProjectOrgunitModelManagement#POMM17.md) |
| POMM18  | Key question modification of a report | [TestScenario4ProjectOrgunitModelManagement#POMM18](TestScenario4ProjectOrgunitModelManagement#POMM18.md) |
| POMM19  | Add a key question to a report | [TestScenario4ProjectOrgunitModelManagement#POMM19](TestScenario4ProjectOrgunitModelManagement#POMM19.md) |
| POMM20  | Modify the information's confidentiality | [TestScenario4ProjectOrgunitModelManagement#POMM20](TestScenario4ProjectOrgunitModelManagement#POMM20.md) |
| POMM21  | Restricted modification rights according to amendments | [TestScenario4ProjectOrgunitModelManagement#POMM21](TestScenario4ProjectOrgunitModelManagement#POMM21.md) |
| POMM22  | Modify files list field's constraints (#83) | [TestScenario4ProjectOrgunitModelManagement#POMM22](TestScenario4ProjectOrgunitModelManagement#POMM22.md) |
| POMM23  | Edit draft project model (#97) | [TestScenario4ProjectOrgunitModelManagement#POMM23](TestScenario4ProjectOrgunitModelManagement#POMM23.md) |
| POMM24  | Make a draft project model ready (#97) | [TestScenario4ProjectOrgunitModelManagement#POMM24](TestScenario4ProjectOrgunitModelManagement#POMM24.md) |
| POMM25  | Edit a group of fields | [TestScenario4ProjectOrgunitModelManagement#POMM25](TestScenario4ProjectOrgunitModelManagement#POMM25.md) |
| POMM26  | Remove a field from Project Synthesis export files | [TestScenario4ProjectOrgunitModelManagement#POMM26](TestScenario4ProjectOrgunitModelManagement#POMM26.md) |
| POMM27  | Add category to a project model | [TestScenario4ProjectOrgunitModelManagement#POMM27](TestScenario4ProjectOrgunitModelManagement#POMM27.md) |
| POMM28  | Change budget field composition | [TestScenario4ProjectOrgunitModelManagement#POMM28](TestScenario4ProjectOrgunitModelManagement#POMM28.md) |
|         | **Report model management (#96)** | [TestScenario4ReportModelManagement](TestScenario4ReportModelManagement.md) |
| RMM2    | Create report model| [TestScenario4ReportModelManagement#RMM2](TestScenario4ReportModelManagement#RMM2.md) |
| RMM4    | Add a report model's section| [TestScenario4ReportModelManagement#RMM4](TestScenario4ReportModelManagement#RMM4.md) |
| RMM5    | Modify report model's sections | [TestScenario4ReportModelManagement#RMM5](TestScenario4ReportModelManagement#RMM5.md) |
| RMM6    | Delete a report model's section | [TestScenario4ReportModelManagement#RMM6](TestScenario4ReportModelManagement#RMM6.md) |
| RMM7    | Delete report model| [TestScenario4ReportModelManagement#RMM7](TestScenario4ReportModelManagement#RMM7.md) |
|         | **Agenda** | [TestScenario4Agenda](TestScenario4Agenda.md) |
| AGN2    | Time navigation through the calendar| [TestScenario4Agenda#AGN2](TestScenario4Agenda#AGN2.md) |
| AGN3    | Add an event| [TestScenario4Agenda#AGN3](TestScenario4Agenda#AGN3.md) |
| AGN4    | Modify an event | [TestScenario4Agenda#AGN4](TestScenario4Agenda#AGN4.md) |
| AGN5    | Delete an event | [TestScenario4Agenda#AGN5](TestScenario4Agenda#AGN5.md) |
|         | **Logical Framework** | [TestScenario4LogicalFramework](TestScenario4LogicalFramework.md) |
| LF2     | Create a minimal logframe without indicators | [TestScenario4LogicalFramework#LF2](TestScenario4LogicalFramework#LF2.md) |
| LF3     | Create indicators in a logframe | [TestScenario4LogicalFramework#LF3](TestScenario4LogicalFramework#LF3.md) |
| LF4     | Move an element from a logical frame | [TestScenario4LogicalFramework#LF4](TestScenario4LogicalFramework#LF4.md) |
| LF5     | Delete an element from a logical frame | [TestScenario4LogicalFramework#LF5](TestScenario4LogicalFramework#LF5.md) |
| LF6     | Add an activity linked to the calendar | [TestScenario4LogicalFramework#LF6](TestScenario4LogicalFramework#LF6.md) |
| LF7     | Edit an activity (#113) | [TestScenario4LogicalFramework#LF7](TestScenario4LogicalFramework#LF7.md) |
| LF8     | Copy logical frame (#111) | [TestScenario4LogicalFramework#LF8](TestScenario4LogicalFramework#LF8.md) |
| LF9     | Add a group to a logical framework | [TestScenario4LogicalFramework#LF9](TestScenario4LogicalFramework#LF9.md) |
| LF10    | Remove a group from a logical framework (#149) | [TestScenario4LogicalFramework#LF10](TestScenario4LogicalFramework#LF10.md) |
| LF11    | Export a logical framework | [TestScenario4LogicalFramework#LF11](TestScenario4LogicalFramework#LF11.md) |
|         | **Reports & Documents Management** | [TestScenario4ReportsDocumentsManagement](TestScenario4ReportsDocumentsManagement.md) |
| RDM2    | Create a new report | [TestScenario4ReportsDocumentsManagement#RDM2](TestScenario4ReportsDocumentsManagement#RDM2.md) |
| RDM3    | Open an existing report | [TestScenario4ReportsDocumentsManagement#RDM3](TestScenario4ReportsDocumentsManagement#RDM3.md) |
| RDM4    | Close a report | [TestScenario4ReportsDocumentsManagement#RDM4](TestScenario4ReportsDocumentsManagement#RDM4.md) |
| RDM5    | Save a report | [TestScenario4ReportsDocumentsManagement#RDM5](TestScenario4ReportsDocumentsManagement#RDM5.md) |
| RDM6    | Manipulate a report | [TestScenario4ReportsDocumentsManagement#RDM6](TestScenario4ReportsDocumentsManagement#RDM6.md) |
| RDM7    | Create a report from a project's phase page | [TestScenario4ReportsDocumentsManagement#RDM7](TestScenario4ReportsDocumentsManagement#RDM7.md) |
| RDM8    | Access a report created through the « Reports & documents » tab from a project's phase page | [TestScenario4ReportsDocumentsManagement#RDM8](TestScenario4ReportsDocumentsManagement#RDM8.md) |
| RDM9    | Impossible to create a report in a future phase | [TestScenario4ReportsDocumentsManagement#RDM9](TestScenario4ReportsDocumentsManagement#RDM9.md) |
| RDM10   | Impossible to create two reports for a « single » reports list field | [TestScenario4ReportsDocumentsManagement#RDM10](TestScenario4ReportsDocumentsManagement#RDM10.md) |
| RDM11   | Visibility of attached documents in the « Reports & documents » tab | [TestScenario4ReportsDocumentsManagement#RDM11](TestScenario4ReportsDocumentsManagement#RDM11.md) |
| RDM12   | Answer to a report's key question | [TestScenario4ReportsDocumentsManagement#RDM12](TestScenario4ReportsDocumentsManagement#RDM12.md) |
| RDM13   | Personal draft cycle of a report | [TestScenario4ReportsDocumentsManagement#RDM13](TestScenario4ReportsDocumentsManagement#RDM13.md) |
| RDM14   | Automatic saving of reports (#88) | [TestScenario4ReportsDocumentsManagement#RDM14](TestScenario4ReportsDocumentsManagement#RDM14.md) |
| RDM15   | Export report into a text document format (#109) | [TestScenario4ReportsDocumentsManagement#RDM15](TestScenario4ReportsDocumentsManagement#RDM15.md) |
|         | **Organizational Units Management** | [TestScenario4OrgUnitManagement](TestScenario4OrgUnitManagement.md) |
| OUM2    | Create an organizational unit (#126) | [TestScenario4OrgUnitManagement#OUM2](TestScenario4OrgUnitManagement#OUM2.md) |
| OUM3    | Delete an organizational unit (#126)| [TestScenario4OrgUnitManagement#OUM3](TestScenario4OrgUnitManagement#OUM3.md) |
| OUM4    | Move an organizational unit (#126) | [TestScenario4OrgUnitManagement#OUM4](TestScenario4OrgUnitManagement#OUM4.md) |
| OUM5    | Project - Organizational Unit link | [TestScenario4OrgUnitManagement#OUM5](TestScenario4OrgUnitManagement#OUM5.md) |
| OUM6    | Organizational Unit's flexibility | [TestScenario4OrgUnitManagement#OUM6](TestScenario4OrgUnitManagement#OUM6.md) |
| OUM7    | Modify the attributes of an Organizational Unit | [TestScenario4OrgUnitManagement#OUM7](TestScenario4OrgUnitManagement#OUM7.md) |
| OUM8    | Modify the calendar of an Organizational Unit | [TestScenario4OrgUnitManagement#OUM8](TestScenario4OrgUnitManagement#OUM8.md) |
| OUM9    | Organizational Unit's attribute history consultation | [TestScenario4OrgUnitManagement#OUM9](TestScenario4OrgUnitManagement#OUM9.md) |
| OUM10   | Export Organizational Unit synthesis Excel file | [TestScenario4OrgUnitManagement#OUM10](TestScenario4OrgUnitManagement#OUM10.md) |
|         | **Rights** | [TestScenario4Rights](TestScenario4Rights.md) |
| `R1`    | Rights for user 4 | [TestScenario4Rights#R1](TestScenario4Rights#R1.md) |
| `R2`    | Rights for user 5 | [TestScenario4Rights#R2](TestScenario4Rights#R2.md) |
| `R3`    | Rights for user 6 | [TestScenario4Rights#R3](TestScenario4Rights#R3.md) |
| `R4`    | Rights for user 2 | [TestScenario4Rights#R4](TestScenario4Rights#R4.md) |
|         | **Administration Users tab** | [TestScenario4AdministrationUsers](TestScenario4AdministrationUsers.md) |
| AUSR2   | Open Administration Users | [TestScenario4AdministrationUsers#AUSR2](TestScenario4AdministrationUsers#AUSR2.md) |
| AUSR3   | Add a new privacy group | [TestScenario4AdministrationUsers#AUSR3](TestScenario4AdministrationUsers#AUSR3.md) |
| AUSR4   | Add a new profile | [TestScenario4AdministrationUsers#AUSR4](TestScenario4AdministrationUsers#AUSR4.md) |
| AUSR5   | Add a new user | [TestScenario4AdministrationUsers#AUSR5](TestScenario4AdministrationUsers#AUSR5.md) |
| AUSR6   | Delete a privacy group | [TestScenario4AdministrationUsers#AUSR6](TestScenario4AdministrationUsers#AUSR6.md) |
| AUSR7   | Delete a profile | [TestScenario4AdministrationUsers#AUSR7](TestScenario4AdministrationUsers#AUSR7.md) |
|         | **Administration Settings tab** | [TestScenario4AdministrationGlobalManagement](TestScenario4AdministrationGlobalManagement.md) |
| AGM2    | Open Administration Settings | [TestScenario4AdministrationGlobalManagement#AGM2](TestScenario4AdministrationGlobalManagement#AGM2.md) |
| AGM3    | Backup all last versions of files from top orgunit | [TestScenario4AdministrationGlobalManagement#AGM3](TestScenario4AdministrationGlobalManagement#AGM3.md) |
| AGM4    | Backup all versions of each file from one orgunit | [TestScenario4AdministrationGlobalManagement#AGM4](TestScenario4AdministrationGlobalManagement#AGM4.md) |
| AGM5    | Change organization's logo and name | [TestScenario4AdministrationGlobalManagement#AGM5](TestScenario4AdministrationGlobalManagement#AGM5.md) |
| AGM6    | Default spreadsheet export file format | [TestScenario4AdministrationGlobalManagement#AGM6](TestScenario4AdministrationGlobalManagement#AGM6.md) |
|         | **Indicators** | [TestScenario4Indicators](TestScenario4Indicators.md) |
| I1      | Create an indicator | [TestScenario4Indicators#I1](TestScenario4Indicators#I1.md) |
| I2      | Edit an indicator | [TestScenario4Indicators#I2](TestScenario4Indicators#I2.md) |
| I3      | Delete an indicator | [TestScenario4Indicators#I3](TestScenario4Indicators#I3.md) |
| I4      | Create a site (#153) | [TestScenario4Indicators#I4](TestScenario4Indicators#I4.md) |
| I5      | Create and delete an indicator group | [TestScenario4Indicators#I5](TestScenario4Indicators#I5.md) |
| I6      | Export all project's indicators to Excel | [TestScenario4Indicators#I6](TestScenario4Indicators#I6.md) |
| I10     | Team work on indicator data entry | [TestScenario4Indicators#I10](TestScenario4Indicators#I10.md) |
|         | **Importation(#387)** | [TestScenario4Import](TestScenario4Import.md) |
| IMP2    | Create an importation scheme| [TestScenario4Import#IMP2](TestScenario4Import#IMP2.md) |
| IMP3    | Edit an importation scheme | [TestScenario4Import#IMP3](TestScenario4Import#IMP3.md) |
| IMP4    | Create a variable| [TestScenario4Import#IMP4](TestScenario4Import#IMP4.md) |
| IMP5    | Edit a variable |  [TestScenario4Import#IMP5](TestScenario4Import#IMP5.md) |
| IMP6    | Associate an importation scheme to a project model | [TestScenario4Import#IMP6](TestScenario4Import#IMP6.md) |
| IMP7    | Add a matching rule for a project model|  [TestScenario4Import#IMP7](TestScenario4Import#IMP7.md) |
| IMP8    | Add a budget matching rule for a project model| [TestScenario4Import#IMP8](TestScenario4Import#IMP8.md) |
| IMP9    | Associate an importation scheme to an org unit model | [TestScenario4Import#IMP9](TestScenario4Import#IMP9.md) |
| IMP10   | Add a budget matching rule | [TestScenario4Import#IMP10](TestScenario4Import#IMP10.md) |
| IMP11   | Import a sheet-by-sheet (Several) projects .xlsx file | [TestScenario4Import#IMP11](TestScenario4Import#IMP11.md) |
| IMP12   | Unlock project core from "Import validation" popup |  [TestScenario4Import#IMP12](TestScenario4Import#IMP12.md) |
| IMP13   | Create a project from "Import validation" popup | [TestScenario4Import#IMP13](TestScenario4Import#IMP13.md) |
| IMP14   | Confirm the validation details from "Import validation" popup | [TestScenario4Import#IMP14](TestScenario4Import#IMP14.md) |
| IMP15   | Import a unique project .xlsx file | [TestScenario4Import#IMP15](TestScenario4Import#IMP15.md) |
| IMP16   | Import a sheet-by-sheet (Several) projects .ods file | [TestScenario4Import#IMP16](TestScenario4Import#IMP16.md) |
| IMP17   | Import a unique project .ods file | [TestScenario4Import#IMP17](TestScenario4Import#IMP17.md) |
| IMP18   | Import a line-by-line  projects .xlsx file | [TestScenario4Import#IMP18](TestScenario4Import#IMP18.md) |
| IMP19   | Import a line-by-line projects .ods file | [TestScenario4Import#IMP19](TestScenario4Import#IMP19.md) |
| IMP20   | Delete a variable |  [TestScenario4Import#IMP20](TestScenario4Import#IMP20.md) |
| IMP21   | Delete an importation scheme | [TestScenario4Import#IMP21](TestScenario4Import#IMP21.md) |
|         | **Transversal Behaviors** | [TestScenario4TransversalBehaviors](TestScenario4TransversalBehaviors.md) |
| TB2     | Quit without saving | [TestScenario4TransversalBehaviors#TB2](TestScenario4TransversalBehaviors#TB2.md) |
| TB3     | Timezone difference management | [TestScenario4TransversalBehaviors#TB3](TestScenario4TransversalBehaviors#TB3.md) |
| TB4     | Create and test a scheme to import a line-by-line projects .xlsx file | [TestScenario4TransversalBehaviors#TB4](TestScenario4TransversalBehaviors#TB4.md) |
|         | **User interface** | [TestScenario4UserInterface](TestScenario4UserInterface.md) |
| UI2     | Main dashboard | [TestScenario4UserInterface#UI2](TestScenario4UserInterface#UI2.md) |