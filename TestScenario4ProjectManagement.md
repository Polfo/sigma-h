

# Introduction #

The test project available in the application is supposed to have the necessary properties to pass these following tests. These tests have been realized with the application configured with the language EN.


# Test cases #

## PRJM1 ##
### _Title:_ User signing in ###
### _See test on:_ [TestScenario4UserSessionRight#USR1](TestScenario4UserSessionRight#USR1.md) ###

## PRJM2 ##
### _Title:_ Open a project page ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From the home page, click on a project's name link. | The project management page should appear in a new tab. The page is open with the subtab « Dashboard » displayed by default. |


## PRJM3 ##
### _Title:_ Modify a project's attributes ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From the project page, modify the following attributes'type in the current phase (a number; a date; a text; a paragraph; a simple choice list among a triplet (code, name, validity period); a single choice list; a multiple choice list; a files list) then save the page. | If you  close and reopen, the modifications should be retained. |

## PRJM4 ##
### _Title:_ Fill project mandatory field ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 2 | From the project page, fill a mandatory field for the current phase. | Automatically, the field should be noted as filled in the mandatory fields list for the current phase. |

## PRJM5 ##
### _Title:_ Switch from a phase to another ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From the project page, fill all the mandatory fields, click on the next phase, and make the following phase the active phase. | On the home page, the phase indicated for the project has changed. |

## PRJM6 ##
### _Title:_ Out of phase project attribute modification ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From the project page, click on the sub-tab « Details », modify several attributes and click on « Save ». | If you  close and reopen, the modifications should be retained.|

## PRJM7 ##
### _Title:_ Link a new project as source of funding of an existing project ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From the dashboard of an NGO project, click on the « Create » button in the « Funding sources » table. | A pop-up to create a project should open where you can specify the amount that the new project is going to give to the NGO project. |
| 2 | Fill the pop-up and click on « Ok ». | A new line should appear in the table « Funding sources » with the new project's code, title and amount of money coming from this new project. |
| 3 | Open the dashboard of the new funding project. | The NGO project used for creating the project should appear in the « Funded projects » table. |

## PRJM8 ##
### _Title:_ Link an existing project as source of funding of an existing project ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From the dashboard of an NGO project, click on the « Attach » button in the « Funding sources » table. | A pop-up should open where you can select the project that you want to attach and specify the amount that the project is going to give to the NGO project. |
| 2 | Fill the pop-up and click on « Ok ». | A new line should appear in the table « Funding sources » with the project's code, title and the amount of money coming from the attached project. |
| 3 | Open the dashboard of the new funding project. | The NGO project used should appear in the « Funded projects » table with the amount of money attributed. |

## PRJM9 ##
### _Title:_ Link a new project as funded project of an existing project ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From the dashboard of an NGO project, click on the « Create » button in the « Funded projects » table. | A pop-up to create a project should open with an additional field allowing you to specify the amount that the new project will receive from the NGO project. |
| 2 | Fill the pop-up and click on « Ok ». | A new line should appear in the table « Funded projects » with the new project's code, title and amount of money coming from this new project. |
| 3 | Open the dashboard of the new funded project. | The NGO project used for creating the project should appear in the « Funding sources » table with the amount given. |

## PRJM10 ##
### _Title:_ Link a existing project as funded project of an existing project ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From the dashboard of an NGO project, click on the « Attach » button in the « Funded projects » table. | A pop-up should open where you can select the project that you want to attach and specify the amount that the project will receive from the NGO project. |
| 2 | Fill the pop-up and click on « Ok ». | A new line should appear in the table « Funded projects » with the project's code, title and the amount of money coming from the attached project. |
| 3 | Open the dashboard of the funded project. | The NGO project used should appear in the « Funding sources » table with the amount of money attributed. |

## PRJM11 ##
### _Title:_ Project's attribute history consultation ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From an open phase tab in the project dashboard or the « Details » sub-tab, search successively to field of the following type: numeric, date, simple text, paragraph, triplet, multiple choice list, check box; as well as default fields: Code, Title, Budget, Start Date, End Date, Country, Owner, Manager, Organisational Unit. |                     |
| 2 | Right-click on the field | A contextual menu should open with the action « Show history ». |
| 3 | Click on the action « Show history ». | A pop-up should open with the field's modification history with, for each modification, the date, the author and the value given during the modification. |
| 4 | Go back to step 1 of this test case, and repeat with the next type of field until you have tested with all of them. |                     |

## PRJM12 ##
### _Title:_ Add a reminder ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From a project dashboard, in the « Reminders » panel, in the « To do » table or in the « Expected » table, click on the « Add » button. | A pop-up should open where you can specify the title and the date of the reminder. |
| 2 | Fill the fields and click on « Ok ». | The reminder should appear in the « Reminders » panel in the corresponding table, in the position corresponding to its date in a chronological order. |

## PRJM13 ##
### _Title:_ Add a late reminder ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From a project dashboard, in the « Reminders » panel, in the « To do » table or in the « Expected » table, click on the « Add » button. | A pop-up should open where you can specify the title and the date of the reminder. |
| 2 | Fill the fields, the Date field must be filled with an already passed date and click on « Ok ». | The reminder should appear in the « Reminders » panel in the corresponding table, in the position corresponding to its date in a chronological order. Its icon should have a red arrow. |

## PRJM14 ##
### _Title:_ Check a reminder ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From a project's dashboard, in the « Reminders » panel,  in the « To do » table or in the « Expected » table, click on the checkbox, on the left of a reminder which is not already checked. | The checkbox should remain checked and the reminder's icon should be grayed. The reminder's title should be crossed out and the closed date should be filled with today's date on the right-hand column. |

## PRJM15 ##

_Test disabled for version 1.2. This test should be revised when [issue #534](http://www.sigmah.org/issues/view.php?id=534) will be developed. This feature has been removed in version 1.2 by [issue #495](http://www.sigmah.org/issues/view.php?id=495) because the suggestion do add a reminder was for all attached files fields, which is not very convenient._

### _Title:_ Add a reminder after attaching files ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From the « Details » or on an active phase allowing file attachment, click on the « Add » or « New version » button. | A pop-up opens to let you choose the file that you want to attach. |
| 2 | Choose a file to attach. Click on the « Open » button to attach the file. | A pop-up should open to the user to offer you to add a reminder. |
| 3 | Click on « Yes ».      | A pop-up should open where you can specify the title and the date of the reminder. |
| 4 | Fill the fields and click on « Ok ». | The reminder should appear in the « Reminders » panel, from the dashboard tab in the « Expected » table, in the position corresponding to its date in a chronological order. |

## PRJM16 ##
### _Title:_ Accessing project's information according to user's rights ###
_Test case removed because no more up-to-date and replaced by test cases of TestScenario4Rights ._

## PRJM17 ##
### _Title:_ Lock information with an amendment (#89) ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | On a the dashboard of a project which the project budget and the beginning and ending dates are amendable, in the « Amendments » panel, click on the « Lock amendments » link. | You shouldn't be able to modify the logical frame, the project budget (planned budget only) and the beginning and ending dates. |

## PRJM18 ##
### _Title:_ Project manager modification (#92) ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From the « Details » tab on a project's dashboard, modify the project manager and click on the « Save » button. | If you close and reopen the project's dashboard, the information about the project's manager has been retained. |

## PRJM19 ##
### _Title:_ Project's organizational unit modification (#93) ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From the « Details » tab on a project's dashboard, modify the OrgUnit and click on the « Save » button. | If you close and reopen the project's dashboard, the information about the project's OrgUnit has been retained. |

## PRJM20 ##
### _Title:_ Create a draft project (#97) ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From the home page, click on the « Draft project » button. | A  pop-up should open letting you specify the attributes of the new draft project. |
| 2 | Use "d-prjm20" as  project code and fill the other attributes as you want, but select as project model « Projet propre v2 » and click on « Create ». | A row should be added to the table at the bottom of the pop-up and a row should be added to the project's table on the main dashboard. |

## PRJM21 ##
### _Title:_ Manipulate a project's links to other projects (#115) ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From the project IF1247's page, in the « Linked project » panel, click on one of the icon with a pencil on it of the link with the project UCF1217.  | A pop-up should open letting you change the link between this project and the page's project.  |
| 2 | Change the financing budget to 10000 and click on « Save ». | The linked project's row should be updated with the new budget. |
| 3 | Click on this row again. |                     |
| 4 | Click on « Delete ».   | A pop-up will open to confirm your action. |
| 5 | Click on « Ok ».       |  The linked project's row should be disappear.|

## PRJM22 ##
### _Title:_ Create a project (#142) ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From the home page, click on the « New project » button. | A  pop-up should open letting you specify the attributes of the new project. |
| 2 | Use "prjm22" as  project code and fill the other attributes as you want and click on « Create ». | A row should be added to the project's table on the main dashboard where the information appear in its corresponding column. |

## PRJM23 ##
### _Title:_ Add a new version of an attached file ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | Open project "LOC1274", and look for a file list field. |                     |
| 2 | Add to this field a file by clicking on the "Add file" button. |                     |
| 3 | Add to this file several new version by clicking on the "New version" button. | The file name gets updated with the file name of the new version, and the "Version" number gets increased each time a new version is added. |
| 4 | Click on the "History" hyperlink linked to tis file. | An "History" popup opens up. |
| 5 | Delete some versions including the last by clicking on the associated dustbin icon. | The versions are removed from the list of versions. |
| 6 | Close the file history popup and download the file from the field. | The downloaded file should be the latest version of the file not deleted. |
| 7 | Add to this file a new version by clicking on the "New version" button. | The file name gets updated with the file name of the new version, and the "Version" number gets increased, as it was while adding versions previously. |


## PRJM24 ##
### _Title:_ Delete a draft project ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | Open the project "prjm22" you've created before. |                     |
| 2 | In a similar way as in test [PRJM8](#PRJM8.md), link draft project "d-prjm20" as funding source" of project "prjm22". | Draft project "d-prjm20" should now appear in the list of Funding source projects of "prjm22". |
| 3 | Close project "prjm22" and go back to the main dashboard. |                     |
| 4 | Click on the "Reload" button of the dashboard Projects table, and search for project "prjm22". | You should see draft project "d-prjm20" below project "prjm22", as a project linked to it. |
| 5 | Click on the "+ Draft project" button. | The "Create new draft project" popup opens up. |
| 6 | Search for project "d-prjm20" in the list of "Your draft projects" and click on the "-" button on its row to delete it. | A confirmation popup opens up asking you "Do you want to delete this draft project ?". |
| 7 | Click on "No".         | Nothing happens, and you're coming back to the "Create new draft project" popup. |
| 8 | Search again for project "d-prjm20" in the list of "Your draft projects" and click on the "-" button on its row to delete it once again. | A confirmation popup opens up asking you "Do you want to delete this draft project ?". |
| 9 | Click on "Yes" this time. | A status message "Your draft project has been successfully deleted." is displayed, and you're coming back to the "Create new draft project" popup where the draft project "d-prjm20" has been removed. |
| 10 | Close the Create new draft project" popup, click on the "Reload" button of the dashboard projects table and then search in it for project "prjm22". | The draft project "d-prjm20" should not be visible in the table.  |
| 11 | Open the project "prjm22". | Draft project "d-prjm20" should no more appear in the list of Funding source projects of "prjm22". |

## PRJM25 ##
### _Title:_ Delete a project ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | Open the project "prjm22" if it is not alread opened. |                     |
| 2 | Click on the "Delete project" button (which looks like a normal rectangular button with rounded corners). | A confirmation popup opens up and asks you "Do you really want to delete this project ?". |
| 3 | Click on "No".         | Nothing happens, and the confirmation popup closes down. |
| 4 | Click once again on the "Delete project" button. | The confirmation popup opens up againand asks you "Do you really want to delete this project ?". |
| 5 | Click this time on "Yes". | A status message informs you that "The project was correctly deleted", the popup closes down, as well as the whole project you've just deleted. You are redirected to the main dashboard where the projects table is automatically reloaded and where you can confirm that the project "prjm22" has been removed. |


## PRJM26 ##
### _Title:_ Export Project synthesis Excel file ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | Open any project.      |                     |
| 2 | Click on the "Export project" button, which looks like a normal rectangular button with rounded corners and is on the extreme right of the line where all the sub-tabs ("Management board", "Details", etc.) are. | An "Export data" popup opens. |
| 3 | Check both "Logical Framework" and "Indicators list" and click on the "Export" button. | An Excel (or OpenDocument? depending of the General parameter "Default spreadsheet export file format") is downloaded on your computer.  |
| 4 | Open the spreadsheet file.  | All the content of the fields, logframe and indicators must appear in the exported file. |
| 5 | Once again, click on the "Export project" button. | An "Export data" popup opens. |
| 6 | Click on the "Export" button without checking the "Logical Framework" and "Indicators list" checkboxes. | The exported file is similar to the previous but without the data for the logframe and the indicators. |