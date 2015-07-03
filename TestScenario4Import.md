

# Introduction #

This scenario is based on the v1.3 demo data set.


# Test cases #


## IMP1 ##
### _Title:_ User signing in ###
### _See test on:_ [TestScenario4UserSessionRight#USR1](TestScenario4UserSessionRight#USR1.md) ###


## IMP2 ##
### _Title:_ Create an importation scheme ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     |	From the Main dashboard, click on the « Administration » button. |  The Administration tab opens up. |
| 2     | Click on the « Import settings » link. |  The "Import settings" tab should appear, displaying two grids. |
| 3     | Click on the "Add" button to create a new importation scheme. |  The "New importation scheme" popup opens. |
| 4     | Give "Own and local projects budget" as name to the scheme, select "Excel" as file format, "Several" as importation mode and click on the "Save" button. | The importation scheme should be added to left-side grid. |


## IMP3 ##
### _Title:_ Edit an importation scheme ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Click on the "Edit" button of the just created importation scheme. |  The "Edit importation scheme" popup opens. |
| 2     | Give  "Own and local projects budget(Excel,Several)" as new name of the importation schema and click on the "Save" button.  | You should be notified that the importation scheme has been updated and the name of the importation scheme should be updated on the grid. |

## IMP4 ##
### _Title:_ Create  a variable ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Click on the title  the just created importation scheme. |  The "Add" button of the variable grid should be enabled. |
| 2     | Click on the "Add" button to create a new variable. |  The "New ivariable" popup opens. |
| 3     | Enter "B1" in the cell field and "Variable" for the variable name and click on the "Save" button. | The variable should be added to right-hand side grid. |
| 4     | Repeat the step 2 and 3 with {"B2", "VariableStartDate"}, {"B3", "VariableEndDate"}, {"B4", "VariableSpentBudget"}, {"B5", "VariablePlannedBudget"}. | All the variables should be added to the grid. |

## IMP5 ##
### _Title:_ Edit a variable ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Click on the "Edit" button of variable "Variable". |  The "Edit variable" popup opens. |
| 2     | Give  "VariableCode" as new name of variable and click on the "Save" button.  | You should be notified that the variable has been updated and the name of the variable should be updated on the grid. |



## IMP6 ##
### _Title:_ Associate an importation scheme to a project model ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | In the "Administration" side bar, click on the « Project mmodels » link. |  The list of the project models should be displayed. |
| 2     | Open the "Projet propre v1" project model. |                     |
| 3     | Open the "Importation schemes" tab. |                     |
| 4     | Click on the "Add" button of the left-side grid. | The "Configure another scheme" popup should open. |
| 5     | Select the importation scheme "Own and local projects budget(Excel,Several)" and click on the "Save" button. |  The importation scheme should be added to the left-side grid and a "Set matching rule" popup should open. |
| 6     | Select the flexible element "Code" and the variable "VariableCode" and click on the "Save" button. | The matching rule should be added to the right-hand grid. |

## IMP7 ##
### _Title:_ Add a matching rule for a project model ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the "Importation scheme" tab of the project model "Projet propre v1", click on the title of the importation scheme "Own and local projects budget(Excel,Several)". |                     |
| 2     | Click on the "Add" button of the right-hand side grid. | The "Set matching rule" popup should open. |
| 3     | Select the flexible element "Start date" and the variable "VariableStartDate". | The matching rule should be added to the grid. |
| 4     | Repeat the steps 2 and " for the flexible element "End date" and the variable "VariableEndDate". |  The matching rules should all be added to the grid. |

## IMP8 ##
### _Title:_ Add a budget matching rule for a project model ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the "Importation scheme" tab of the project model "Projet propre v1", click on the title of the importation scheme "Own and local projects budget(Excel,Several)". |                     |
| 2     | Click on the "Add" button of the right-hand side grid. | The "Set matching rule" popup should open. |
| 3     | Select the flexible element "Budget" . | The list of budget sub fields should appear. |
| 4     | For the budget fields "Planned budget" and "Spend budget", select correspondingly the variables "VariablePlannedBudget" and "VariableSpentBudget" and check their corresponding checkboxes and click on the "Save" button. |  The matching rule should be added to the grid, in the variable's name column, there should be "VariablePlannedBudget" and "VariableSpentBudget". |


## IMP9 ##
### _Title:_ Associate an importation scheme to an org unit model ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | In the "Administration" side bar, click on the « Organisational Unit models » link. |  The list of the project models should be displayed. |
| 2     | Open the "Projet propre v1" project model. |                     |
| 3     | Open the "Importation schemes" tab. |                     |
| 4     | Click on the "Add" button of the left-side grid. | The "Configure another scheme" popup should open. |
| 5     | Select the importation scheme "Own and local projects budget(Excel,Several)" and click on the "Save" button. |  The importation scheme should be added to the left-side grid and a "Set matching rule" popup should open. |
| 6     | Select the flexible element "Code" and the variable "VariableCode" and click on the "Save" button. | The matching rule should be added to the right-hand grid. |


## IMP10 ##
### _Title:_ Add a budget matching rule for an org unit model ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the "Importation scheme" tab of the project model "Mission v1", click on the title of the importation scheme "Own and local projects budget(Excel,Several)". |                     |
| 2     | Click on the "Add" button of the right-hand side grid. | The "Set matching rule" popup should open. |
| 3     | Select the flexible element "Budget" . | The list of budget sub fields should appear. |
| 4     | For the budget fields "Planned budget" and "Spend budget", select correspondingly the variables "VariablePlannedBudget" and "VariableSpentBudget" and check their corresponding checkboxes and click on the "Save" button. |  The matching rule should be added to the grid, in the variable's name column, there should be "VariablePlannedBudget" and "VariableSpentBudget". |



## IMP11 ##
### _Title:_ Import a sheet-by-sheet (Several) projects .xlsx file ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Repeat the test cases IMP5, IMP7 and IMP8 for the project model "Projet partenaire local v1". | You should observe the same results as the one observed previously. |
| 2     | Go back on the main dashboard, open the project "IF1389". |                     |
| 3     | Lock its amendment.    |                     |
| 4     | Go back to the main dashboard, and click on the "Import" button. | The "Import" popup opens. |
| 5     | Select the "Own and local projects budget(Excel,Several)" importation scheme, load the [import example file(Excel,Several)](http://www.sigmah.org/issues/file_download.php?file_id=125&type=bug), and click on the "Import" button. | The "Importation validation" popup opens, there should be one row for the idkey "IF1247" with the status "Project found and importation ready", one row for the idkey  "IF1389" with the status "Project found but importation impossible because modifications required on a locked project core" and  another row for the idkey "LOC1275" with the status "Project not found" (Don't close the window, you will need it for the next test cases.) |


## IMP12 ##
### _Title:_ Unlock project core from "Import validation" popup ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     |  On the "Import validation" popup, click on the "Unlock project core". | The status should become "Project found and importation ready",the "Unlock project code button" is now a "Confirm importation details" button and the corresponding row should now be selected. |
| 2     | On another tab of your  browser, open the project  "IF1389". | Its amendement should be unlocked. |


## IMP13 ##
### _Title:_ Create a project  from "Import validation" popup ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     |  On the "Import validation" popup, click on the "Create" button. | The "Create project" window should open, the "Code" field should contain "LOC1275". |
| 2     | Complete the information asked for in the window and click on "Create". | The project should be added to the projects list panel and the row corresponding to the id key "LOC1275" should be removed . |

## IMP14 ##
### _Title:_ Confirm the validation details  from "Import validation" popup ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     |  On the "Import validation" popup, click on the "Confirm importation details" button for the project "IF1389". | A "Confirm importation details" should open and there should be a row for each field (Code, Start date, End date, Planned budget, Spent budget}, in the old value column should appear the old value of the field, in the new value should respectively be { 01/04/2012, 31/12/2014, 120 453€, 350000€}. |
| 2 (NOT IMPLEMENTED YET) | Unselect the rows for the fields "Start date" and  "Planned budget",click on "Save" and click again on the "Confirm importation details". | You should see the same grid with only the rows for the "Planned budget" field and "Start date" field selected. |
| 3     | Click on the "Save" button, check that the rows for the id key "IF1389" and "IF1247" are selected and click on the "Import" button. | Two pop ups should inform you that the importation for the projects "IF1389" and "IF1247" have been successful. |
| 4     | On the main dashboard, open the project "IF1247". | The fields "StartDate", "End date", "Planned budget" and "Spent budget" should contain the respective values  01/04/2012, 31/12/2014, 120 453€, 350000€. |
| 5     | Go back on the main dashboard, open the project "IF1389". | The fields "End date" and "Spent budget" should contains respectively 30/11/2013, 156561€. |


## IMP15 ##
### _Title:_ Import a unique project .xlsx file ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Repeat the test case IMP2 (name = "Own and local projects budget(Excel,Unique)"). | You should observe the same results as the one observed previously. |
| 2     | Repeat the test case IMP4 with the following variables definitions {"B1", "VariableCode"},{"B2", "VariableStartDate"}, {"B3", "VariableEndDate"}, {"B4", "VariableSpentBudget"}, {"B5", "VariablePlannedBudget"} | You should observe the same results as the one observed previously. |
| 3     | Repeat the test cases IMP6, IMP7, IMP8 for the importation scheme "Own and local projects budget(Excel,Unique)" . | You should observe the same results as the one observed previously. |
| 4     | Go back on the main dashboard, open the project "IF1389" and lock its amendment. |                     |
| 5     | Go back to the main dashboard, and click on the "Import" button. | The "Import" popup opens. |
| 6     | Select the "Own and local projects budget(Excel, Unique)" importation scheme, load the [import example file(Excel, Unique)](http://www.sigmah.org/issues/file_download.php?file_id=127&type=bug), and click on the "Import" button. | The "Importation validation" popup opens, there should be one row for the idkey  "IF1389" with the status "Project found but importation impossible because modifications required on a locked project core" . |
| 7     | Click on the "Unlock project core" button of the row for the id key "IF1389". | The status should become "Project found and importation ready and the corresponding row should be selected. |
| 8     | Check that the rows corresponding for the id key "IF1389" are selected and click on the "Import" button. | A pop up should inform you that the importation for the projects "IF1389" has been successful. |
| 9     | Go back on the main dashboard, open the project "IF1389". | The fields "StartDate", "End date", "Planned budget" and "Spent budget" should contain the respective values  08/03/2013, 30/09/2013, 200000€, 300000€. |



## IMP16 ##
### _Title:_ Import a sheet-by-sheet (Several) projects .ods file ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Repeat the test cases IMP1 (name = "Own and local projects budget(Ods,Several)", file format = "OpenDocumentSpreasheet"), IMP3, IMP5, IMP7, IMP8 for the importation scheme with the  . | You should observe the same results as the one observed previously. |
| 2     | Go back on the main dashboard, open the project "IF1389" and lock its amendment. |                     |
| 3     | Go back to the main dashboard, and click on the "Import" button. | The "Import" popup opens. |
| 4     | Select the "Own and local projects budget(Ods,Several)" importation scheme, load the [import example file(Ods,Several)](http://www.sigmah.org/issues/file_download.php?file_id=126&type=bug), and click on the "Import" button. | The "Importation validation" popup opens, there should be one row for the idkey "SE" with the status "Organisational unit found and importation ready", one row for the idkey "EUR" with the status "Organisational unit not found", one row for the idkey "IF1247" with the status "Project found and importation ready", one row for the idkey  "IF1389" with the status "Project found but importation impossible because modifications required on a locked project core" and  another row for the idkey "LOC1276" with the status "Project not found". |
| 5     | Click on the "Create" button of the row for the id key "LOC1276". |  A "Create project" window should open, the "Code" field should contain "LOC1276". |
| 6     | Complete the form with any information and click on the "Create" button of the pop up.  | A notification should inform you that the project has been created and the corresponding row in the "Import validation" should be removed. |
| 7     | Click on the "Unlock project core" button of the row for the id key "IF1389". | The status should become "Project found and importation ready and the corresponding row should be selected. |
| 8     | Check that the rows corresponding for the id key "IF1389", "SE" and "IF1247" are selected and click on the "Import" button. | Two pop ups should inform you that the importation for the projects "IF1389" and "IF1247" have been successful. |
| 9     | On the main dashboard, open the project "IF1247". | The fields "StartDate", "End date", "Planned budget" and "Spent budget" should contain the respective values  01/03/2012, 31/11/2014, 121 354€, 530000€. |
| 10    | Go back on the main dashboard, open the project "IF1389". | The fields "StartDate", "End date", "Planned budget" and "Spent budget" should contain the respective values  08/01/2013, 30/10/2013, 143341€, 432000€. |
| 11    | Go back on the main dashboard, open the organisational unit "SE". | The fields "Planned budget" and "Spent budget" should contain the respective values   32089€, 100000€. |


## IMP17 ##
### _Title:_ Import a unique project .ods file **(NO FILE AVAILABLE YET FOR TESTING)** ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Repeat the test case IMP2 (name = "Own and local projects budget(Ods,Unique)"). | You should observe the same results as the one observed previously. |
| 2     | Repeat the test case IMP4 with the following variables definitions {"B1", "VariableCode"},{"B2", "VariableStartDate"}, {"B3", "VariableEndDate"}, {"B4", "VariableSpentBudget"}, {"B5", "VariablePlannedBudget"}.|  You should observe the same results as the one observed previously. |
| 3     | Repeat the test cases IMP6, IMP7, IMP8 for the importation scheme "Own and local projects budget(Ods,Unique)" . | You should observe the same results as the one observed previously. |
| 4     | Go back on the main dashboard, open the project "IF1389" and lock its amendment. |                     |
| 5     | Go back to the main dashboard, and click on the "Import" button. | The "Import" popup opens. |
| 6     | Select the "Own and local projects budget(Ods, Unique)" importation scheme, load the [import example file (Ods, Unique)](http://www.sigmah.org/issues/file_download.php?file_id=128&type=bug), and click on the "Import" button. | The "Importation validation" popup opens, there should be one row for the idkey  "IF1389" with the status "Project found but importation impossible because modifications required on a locked project core" . |

| 7 | Click on the "Unlock project core" button of the row for the id key "IF1389". | The status should become "Project found and importation ready and the corresponding row should be selected. |
|:--|:------------------------------------------------------------------------------|:------------------------------------------------------------------------------------------------------------|
| 8 | Check that the rows corresponding for the id key "IF1389" are selected and click on the "Import" button. | A pop up should inform you that the importation for the projects "IF1389" has been successful.              |
| 10 | Go back on the main dashboard, open the project "IF1389".                     | The fields "StartDate", "End date", "Planned budget" and "Spent budget" should contain the respective values  08/06/2013, 30/01/2014, 252000€, 363000€. |

## IMP18 ##
### _Title:_ Import a line-by-line projects .xls file **(NOT IMPLEMENTED YET)** ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|


## IMP19 ##
### _Title:_ Import a line-by-line projects .ods file **(NOT IMPLEMENTED YET)** ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|


## IMP20 ##
### _Title:_ Delete a variable ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Go the "Import settings" on he "Administration" tab. |                     |
| 2     | Click on the title of the importation scheme "Own and local projects budget(Excel,Several)". | The variables of the importation scheme should be displayed on the variable's grid. |
| 3     | Select all the variables in the grid and click on the "Delete" button in the toolbar. | A message should ask you to confirm the deletion of the variables. |
| 4     | Click on "Yes".        | A notification should confirm you the deletion of the variables and all the variables should be removed from the grid. |


## IMP21 ##
### _Title:_ Delete an importation scheme ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Select the importation schemes "Own and local projects budget(Excel,Several)" and "Own and local projects budget(Excel,Several)"  and click on the "Delete" button. | A message should ask you to confirm the deletion of the importation scheme. |
| 2     | Click on "Yes".        | You should be notified that the importation scheme has been deleted and the importation scheme should be deleted from the grid. |