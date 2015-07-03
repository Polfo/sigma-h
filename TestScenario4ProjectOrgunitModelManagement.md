

# Introduction #

This scenario is based on the 1.2 demo data set.
These tests are based on projects models but should be executed for OrgUnit models as well.


# Test cases #

## POMM1 ##
### _Title:_ User signing in ###
### _See test on:_ [TestScenario4UserSessionRight#USR1](TestScenario4UserSessionRight#USR1.md) ###

## POMM2 ##
### _Title:_ Import project model ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     |From the Main dashboard, click on the "Administration" button | The Administration tab opens up.|
| 2     | Click on the « Project models » hyperlink| The list of existing project models is loaded on the right of the screen.|
| 3     | Click on the « Import » Button| The « Importing project model... » popup opens up.|
| 4     | Select one project model file coming from the [ProjectModelsFiles.zip](http://www.sigmah.org/issues/file_download.php?file_id=62&type=bug) archive you've unzipped beforehand, choose any project type, and click on the "OK" button.| A status message pops up with the message « The project model has been imported », and a new project model appears in the list in "Draft status.|



## POMM3 ##
### _Title:_ Duplicate a project model ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | From the "Project models" part of the Administration, click on the « Duplicate » button for any of the existing project models.| A status box titled   « Project model duplication » opens up with the message « The project model has been duplicated », and a new row appears in the list of project models with a « Draft" project title « Copy of » the title of existing project selected for duplication.|

## POMM4 ##
### _Title:_ Delete project model with test projects ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the Main dashboard, click on the « Draft project » button |
The « Create new draft project » popup opens up.
| 2     | Give any Code, Title to your new draft project, select as Model a project model you're ready to delete afterwards, and click on the « Create » button.| A status message informing you that « your draft project has been successfully created » pops up, and a new row with your project appears in « Your draft projects » list of the « Create new draft project » popup and in the Dashboard project table behind the popup.|
| 3     | Close the « Create new draft project » popup.| The popup closes.   |
| 4     | Go to the « Project models » part of the Administration.| The list of existing project models is loaded on the right of the screen.|
| 5     | Click on the « Delete" button for the project model you've just created a draft project from.| A confirmation message box pops up asking you « Warning: all objects and projects using this project model will be deleted. Are you sure you want to delete it? ».|
| 6     |Click on « Yes ».       | A status message informing you that « The project model has been deleted », and the row with the selected project model is removed from the project models list.|
| 7     | Go back to the main dashboard.| The draft project created earlier is nowhere in the projects table.|
| 8     | Click on « Draft project » button.| The draft project created earlier is no more in the « Your draft projects » list.|

## POMM5 ##
### _Title:_ Create a project model (#94) ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Click on the « Administration » button on the home page. | The « Administration » page should appear. |
| 2     | Click on the « Project models » link. | A table of the existing project model should be displayed. |
| 3     | Click on the « Add » button on the top of the table. | A pop-up where you can specify the information of the new project model should open. |
| 4     | Fill the new project's attributes and click on the « Save » button. | A row should be added to the table with the name that you have given to the project model. |
| 5     | Click on the name of the new project model. | You should be able to see and modify the name and the type of the new project model. You should also see a table with, by default, the fields Code, Title, Start date, End date, Org Unit, Country, Manager, Author and Budget. |

## POMM6 ##
### _Title:_ Add a new field to a project model ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Open a project model in draft status and click on the « Add » button in the « Fields » tab. | A pop-up should open where you can specify the attributes of the new field. |
| 2     | Fill the different fields and click on the « Save » button. | A row should be added in the Fields table with the information that you have entered. |

## POMM7 ##
### _Title:_ Add a new phase to a project model ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the project models management page, open a project model in draft status and click on the « Add » button in the « Phases » tab. | A pop-up should open where you can specify the attributes of the new phase. |
| 2     | Fill the different fields and click on the « Save » button. | A row should be added in the phases table with the information that you have entered. |

## POMM8 ##
### _Title:_ Switch two fields in a model ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the project models management page, open a project model in draft status and choose two fields from the same container and group. Click on the title of each of these fields to read and remember their current "Order" value. |                     |
| 2     | Open once again both fields and switch the value of their "Order" attribute, and then click "Save" to exit the field edition popup. |                     |
| 3     | Open a project created from this model, or create a new draft project from it, and go the container containing those fields in this project. | The position of the fields should change. The field that was above the other should now be under the other. |


## POMM9 ##
### _Title:_ Add a mandatory field to a project ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     |   On the project models management page, open a project model in draft status. Click on the « Add » button in the « Fields » tab. |A pop-up should open where you can specify the attributes of the new field. |
| 2     | Fill the different fields, check the checkbox « Mandatory » and click on the « Save » button. | The projects depending on the project model should be updated, so, on the field's phase of these projects, the field should be added to the mandatory fields' list. |

## POMM10 ##
### _Title:_ Reorganize a project model's attributes of the synthesis section ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the project models management page, open a project model in draft status. Click on any field of "Default element" type in the « Fields » tab. | A pop-up should open where you can modify the attributes of the field. |
| 2     | Check the « Banner » checkbox and set the position in the banner to 1. | The field should now be the one displayed on the upper-left of the banner of every projects depending on the project model. |

## POMM11 ##
### _Title:_ Modify available groups' types from a logical frame model ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the project models management page, open a project model in draft status. |                     |
| 2     |  In the « Log frame » tab, modify the "Enable groups" parameter for any the four elements type of the logical frame and click on the « Save » button. | A message should appear confirming you that the project model has been updated. |
| 3     | Create a new draft project depending on the project model (see [PRJM20](TestScenario4ProjectManagement#PRJM20.md) for draft project creation procedure), and open the Logframe sub-tab of this new project. | The "Add group" hyperlink is present or not according to the parameter you've just modified.|

## POMM12 ##
### _Title:_ Modify elements creation's constraints of a logical frame from its model ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the project models management page, open a project model in draft status. |                     |
| 2     |  In the « Log frame » tab, modify the maximum number of groups and elements which is possible to create for each of the four elements type of the logical frame and click on the « Save » button. | A message should appear confirming you that the project model has been updated. |
| 3     | Create a new draft project depending on the project model (see [PRJM20](TestScenario4ProjectManagement#PRJM20.md) for draft project creation procedure). | You are limited depending on the maximum number of groups' type you have specified.|

## POMM13 ##
_Test case disabled until feature "0000569: Missing a calendar component to enter constraints for date fields" is developed._
### _Title:_ Modify Date field's constraints ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     |   On the project models management page, open a project model in draft status. Click on a Date field in the « Fields » tab. | A pop-up should open where you can change the attributes of the field. |
| 2     | Specify the upper and lower limit of the Date field and click on the « Save » button.| A message should appear confirming you that the field has been updated. |
| 3     |  Create a new draft project depending on the project model.(see [PRJM20](TestScenario4ProjectManagement#PRJM20.md) for draft project creation procedure) Click on the « Details » tab. | You should not be able to modify the field with values that are out of bounds. |

## POMM14 ##
### _Title:_ Modify Number field's constraints ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     |   On the project models management page, open a project model in draft status. Click on a Number field in the « Fields » tab. | A pop-up should open where you can specify the attributes of the field. |
| 2     | Specify the upper and lower limit of the Number field and click on the « Save » button.| A message should appear confirming you that the field has been updated. |
| 3     |  Create a new draft project depending on the project model (see [PRJM20](TestScenario4ProjectManagement#PRJM20.md) for draft project creation procedure). Open the project and try several values for the Number field you've just modified. | You should not be able to modify the field with values that are out of bounds. |

## POMM15 ##
### _Title:_ Modify a Number field's numeric type ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     |   On the project models management page, open a project model in draft status. Click on a Number field in the « Fields » tab. | A pop-up should open where you can specify the attributes of the field. |
| 2     | Specify the type of the Number field (decimal or not) and click on the « Save » button.| A message should appear confirming you that the field has been updated. |
| 3     |  Create a new draft project depending on the project model (see [PRJM20](TestScenario4ProjectManagement#PRJM20.md) for draft project creation procedure). Open the project and try to enter a decimal and non-decimal number. | You should not be able to modify the field with a decimal or a non decimal number depending on the choice made. |

## POMM16 ##
### _Title:_ Modify text field's constraints ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     |   On the project models management page, open a project model in draft status. Click on a text field in the « Fields » tab. | A pop-up should open where you can specify the attributes of the field. |
| 2     | Specify the maximal length of the text field and click on the « Save » button.| A message should appear confirming you that the field has been updated. |
| 3     |  Create a new draft project depending on the project model (see [PRJM20](TestScenario4ProjectManagement#PRJM20.md) for draft project creation procedure). Open the project and try several values for the text field you've just modified. | You should not be able to modify the field with a text longer than maximal length. |


## POMM17 ##
### _Title:_ Convert a report list field to a mandatory field ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     |   On the project models management page, open a project model in draft status. Click on a reports' list field in the « Fields » tab. | A pop-up should open where you can specify the attributes of the field. |
| 2     |  Check the checkbox « Mandatory » and click on the « Save » button.| A message should appear confirming you that the field has been updated. |
| 3     |  Create a new draft project depending on the project model (see [PRJM20](TestScenario4ProjectManagement#PRJM20.md) for draft project creation procedure). Open the project and create the report and edit it. | You should not be able to close the phase without having creating and validating the corresponding report and the name of report's list field is added to the mandatory fields' list. |

## POMM18 ##
### _Title:_ Key question modification of a report ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     |   On the report models management page, click a report model. Then, click on a key question in the table on the right. | You should be able to modify the question. |
| 2     |  Write the new key question and click on the « Save » button.| A message should appear confirming you that the report model has been updated. |
| 3     |  Create a new draft project with a reports' list depending on the report model (see [PRJM20](TestScenario4ProjectManagement#PRJM20.md) for draft project creation procedure). Create a report. | You see that the corresponding key question has been changed. |


## POMM19 ##
### _Title:_ Add a key question to a report ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     |   On the report models management page, click a report model. Then, in the right-hand panel, click on the « Add » button. | A row should be added to the sections table. |
| 2     |  Click on the cell of the new row corresponding to the « Section name » column. | You should be able to specify the question. |
| 3     | Write the new key question and click on the « Save » button.| A message should appear confirming you that the report model has been updated. |
| 4     |  Create a new draft project with a reports' list depending on the report model (see [PRJM20](TestScenario4ProjectManagement#PRJM20.md) for draft project creation procedure). Create a report. | You see that the corresponding key question has been added. |

## POMM20 ##
### _Title:_ Modify the information's confidentiality ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the project models page management page, open the NGO project model « Projet propre v2 » and add a new field with "Suivi RH" as confidentiality group (which is a confidentiality group editable by user3). |                     |
| 2     | Create a draft project depending on the NGO project model, and change its parent Organisational Unit from its Details sub-tab so that the draft project will be visible to all. |                     |
| 3     | Connect to the application as user4 and open the project you've just created. | You should not be able to see and to modify the field from step 1. |

## POMM21 ##
### _Title:_ Restricted modification rights according to amendments ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the project models management page, open a project model. Click on any field in the « Fields » tab. | A pop-up should open where you can modify the attributes of the field. |
| 2     | Check the « Amendable » checkbox and click on the « Save » button. | A message should appear confirming you that the project model has been updated. |
| 3     | Create a draft project depending on this project model and click on the « Lock the Amendment » link with active amendment from the project page. (see [PRJM20](TestScenario4ProjectManagement#PRJM20.md) for draft project creation procedure) | The field made amendable should not be editable anymore in the project. |

## POMM22 ##
### _Title:_ Modify files list field's constraints (#83) ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the project models management page, open a project model. Click on a files' list field in the « Fields » tab. | A pop-up should open where you can modify the attributes of the field. |
| 2     | Modify the upper limit of the number of files and click on the « Save » button. | A message should appear confirming you that the project model has been updated. |
| 3     | Create a draft project depending on this project model.(see [PRJM20](TestScenario4ProjectManagement#PRJM20.md) for draft project creation procedure). Open the project and go to the Files list field you've just modified. |You should be informed how many files you can attach for this field. |
| 4     | Attach as many files as it is specified you can. | You should not be able to attach files for that field anymore. |

## POMM23 ##
### _Title:_ Edit draft project model (#97) ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | On the project models management page, open the draft project model you used for the draft project you created in the scenario PRJM20]. |                     |
| 2 | Change the type and the name of a field of the current phase and click on « Save ». |                     |
| 3 | From the main dashboard, click on the draft project IF1400, created in the scenario PRJM20. | The type and name of the field that you have changed should be changed as well on the project page. |

## POMM24 ##
### _Title:_ Make a draft project model ready (#97) ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | On the project models management page, open the project model « Projet propre v2 ». |                     |
| 2 | Change its status to « Ready » and click on « Save ». | A pop-up should warn you that you won't be able to update the project model anymore. |
| 3 | Click on « Ok ».       |                     |
| 4 | From the main page, click on « Draft project ». | A pop-up should open. You shouldn't see the project IF1400 in the table at the bottom of the pop-up. |


## POMM25 ##
### _Title:_ Edit a group of fields ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the project models management page, open a draft project model. Click on any group hyperlink in the "Group" column of the « All Fields » tab. | A pop-up should open where you can modify the attributes of the group, and all parameters of the group should have the existing value loaded, including the "Vertical position". |
| 2     | Modify one or several parameters of the group, and click on the "Save" button. | The popup closes itself, and a message should appear confirming you that the fields group has been updated. |


## POMM26 ##
### _Title:_ Remove a field from Project Synthesis export files ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the project models management page, open a draft project model, like "Projet propre v2". |                     |
| 2     | Click on any field except Files or Reports field. | A "Field" popup open. |
| 3     | Uncheck the "Exportable" checkbox, and click on the "Save" button. | A status message confirms that the operation has been saved. |
| 4     | Create a draft project from the draft project model you've just modified (see [PRJM20](TestScenario4ProjectManagement#PRJM20.md) for more details about how to creat a draft project). | The draft project appears in the Dashboard projects table. |
| 5     | Open the draft project you've just created. |                     |
| 6     | Click on the "Export project" button, which looks like a normal rectangular button with rounded corners and is on the extreme right of the line where all the sub-tabs ("Management board", "Details", etc.) are. | An "Export data" popup opens. |
| 7     | Click on the "Export" button without checking the "Logical Framework" and "Indicators list" checkboxes. | An Excel (or OpenDocument? depending of the General parameter "Default spreadsheet export file format") is downloaded on your computer.  |
| 8     | Open the spreadsheet file.  | All the content of the fields must appear in the exported file except all files and reports fields, and the field you've previously unchecked as "Exportable". |


## POMM27 ##
### _Title:_ Add category to a project model ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the Administration page, click on "Categories" menu item on the left. | A screen divided in two columns opens. |
| 2     | Use the drop-down list on the top-left corner to choose a symbol, enter any title in text field next and click on the "Add" button to create a new category. | A status message confirms to you the creation of the new category, and you can see in the list of categories a new row with the symbol and the title you've chosen.  |
| 3     | Click on the title hyperlink of the new category. | An empty table with 2 columns (Colour, Label) is loaded on the right part of the screen. |
| 4     | In the right side of the screen, enter a value, select a color in the color selection drop-down list and click on the "Add" button to add a new value to your new category. | A status message informs you that your category has been correctly updated, and a new row is added on the right side of the screen with the values you've entered. |
| 5     | Repeat previous step at least 2 times to add 2 more items to this category. |                     |
| 6     | Select one of the category item you've just created, and click on the "Delete" button of the right side of the screen. | After a little while during which you can see message "Verifying and deleting...", your category item is properly deleted. |
| 7     | Open the "Project models" part of the Administration area, and open from it the "Projet propre v2" draft project model. |                     |
| 8     | Add a new Choice list field (see [POMM6](TestScenario4ProjectOrgunitModelManagement#POMM6.md)), select the category you've just created as "Related category" and check the "Multiple answers" checkbox.   | Your field is added in the list of fields. |
| 9     | Create a draft project from project model "Projet propre v2" or open an existing project created from this model. |                     |
| 10    | In this draft project, check several values of the field you've created from your category, and Save. |                     |
| 11    | Go back to the Main dashboard, and click on the "Reload" button of the projects table. | You should see your category symbols in the Category column for the project you've just modified. |
| 12    | Go back to your draft project, uncheck all values for the category field you've created, and click on "Save". |                     |
| 13    | Go back to the Main dashboard, and click on the "Reload" button of the projects table. | You should no more see any category symbol in the Category column for the project you've just modified. |


## POMM28 ##
### _Title:_ Change budget field composition ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Open the "Project models" part of the Administration area, and open from it the "Projet propre v2" draft project model. |                     |
| 2     | In the list of fields in the "All fields" tab, search for the "Budget" default field and open it. | The Field popup for the "Budget" default element gets open.  |
| 3     | Add a "Planned budget at end of project" sub-field in the list of sub-fields. | A new row "Planned budget at end of project" should now be visible in the list of budget sub-fields.  |
| 4     | Move this "Planned budget at end of project" sub-field on top of the list of sub-fields. | The row "Planned budget at end of project" should now be on top of the list of budget sub-fields.  |
| 5     | Replace the "Planned budget" sub-field by this "Planned budget at end of project" sub-field in the computation formula of the budget consumption, and click on "Save". | A notification message informs you that your modifications are saved, and the Field popup is closed.  |
| 6     | Create a draft project from project model "Projet propre v2" or open an existing project created from this model. |                     |
| 7     | In this draft project, open the "Details" sub-tab and search for the Budget field. | A "Planned budget at end of project" sub-field should now be visible on top of the Budget group of fields.  |
| 8     | Enter any value in the "Planned budget at end of project"  and "Spend budget" sub-fields, and click on "Save". |                     |
| 9     | Go back to the main Dashboard page and click on the "Reload" button of the projects table.  | The budget consumption of your draft project should have changed. |
| 10    | Move your mouse cursor above the budget consumption progress bar of your draft project. | You should see a tooltip like "44% (Spend budget/Planned budget at end of project)".  |