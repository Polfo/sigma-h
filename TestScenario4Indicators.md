

# Introduction #

This scenario is based on the v1.2 demo data set.


# Test cases #

## I1 ##
### _Title:_ Create an indicator ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | From the main dashboard,  open the project EUR1109 and click on the « Manage indicators » sub-tab. | The indicators panel should be displayed. |
| 2     | Click on the « New indicator » button. | A pop-up should open letting you specify the information of the new indicator. |
| 3     | Select « Qualitative » as type of the indicator. | The fields "Aggregation method", "Units" and "Target Value" should be replaced by the field "Possible values". |
| 4     | Check the « Other indicators? » checkbox. | A table should appear underneath the field letting add indicators from other projects. |
| 5     | Click on the « Add » button of the table. | A pop-up should appear with the different projects. |
| 6     | Open the project « Aide d’urgence pour améliorer les conditions de vie des populations affectées par la reprise du conflit au Nord Kivu », select one of its indicator and click on « Ok ». |The indicator selected should be added to the other indicators' table. |
| 7     | Fill the other fields as you want and click on « Ok ». | The indicator created should be added to the indicators table. |
| 8     | Close and reopen the project dashboard and come back to the « Manage indicators » sub-tab. | The indicator should still be there. |

## I2 ##
### _Title:_ Edit an indicator ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the « Manage indicators » sub-tab of the project EUR1109's dashboard, click on the link of the indicator you have created. |  A pop-up should open letting you modify the information of the new indicator. |
| 3     | Select « Quantitative » as type of the indicator. | The field "Possible values" should be replaced by the fields "Aggregation method", "Units" and "Target Value". |
| 4     | Fill those fields as you want, add a hash to your title and add as many characters to it to make it at least 200 characters long. Then click on « Ok ». | The title of the indicator should be updated on the indicators' table. |
| 5     | Close and reopen the project dashboard and come back to the « Manage indicators » sub-tab. | The modification you made should still be there. |

## I3 ##
### _Title:_ Delete an indicator ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the « Manage indicators » sub-tab of the project EUR1109's dashboard, select the indicator you have created.|                     |
| 2     | Click on the « Delete » button of the toolbar. |  A pop-up for confirming the deletion. |
| 3     | Click on « Ok ».       | The indicator should disappear from the indicators table. |
| 4     | Close and reopen the project dashboard and come back to the « Manage indicators » sub-tab. | The indicator should still not be on the indicators' table. |

## I4 ##
### _Title:_ Create a site (#153) ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the « Manage indicators » sub-tab of the project EUR1109's dashboard, on the right-hand side panel, click on the « Sites » .| A table with all the existing sites should be displayed. |
| 2     | Click on the « New site » button. |  A pop-up should open where you can specify the information about the new site. |
| 3     | Fill the different fields and click on » Ok ». | The new site should be added to the table and a message should confirm you that it has been saved. |

## I5 ##
### _Title:_ Create and delete an indicator group ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Open the « Manage indicators » sub-tab of the project EUR1109 |                     |
| 2     | Create an indicator group by clicking on the "New Indicator Group" button. |  A pop-up should open where you can set the name of the new indicator group. |
| 3     | Enter a name and click on the Save button. | The new indicator group should be added to the table. |
| 4     | Create an indicator (see #I1) in this group |                     |
| 5     | Save the modifications in the screen by clicking on the "Save" button |                     |
| 6     | Click on the indicator group row. | The indicator group row gets highlighted in blue.  |
| 7     | Click on the "Delete" button. | The indicator group row disappears.  |
| 8     | Save the modifications in the screen by clicking on the "Save" button |                     |
| 9     | Click on the "Refresh view" button. | The content of the table should remain the same.  |


## I6 ##
### _Title:_ Export all project's indicators to Excel ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the « Manage indicators » sub-tab of the project IF1389's dashboard, click on the "Export" button on the top-right corner of the indicators table.| An Excel (or OpenDocument depending of the General parameter "Default spreadsheet export file format") is downloaded on your computer.  |
| 2     | Open the spreadsheet file.  |  All the detailed content of all indicators must appear in the exported file. |

## I10 ##

_We start with 10 for this test case because we know it is a quite advanced test case, and it won't remain 1 if we would have chosen to call it "I1"..._

### _Title:_ Team work on indicators data entry ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Sign in the application with login user1@sigmah.org (password: sigmah).|                     |
| 2     |Open the project IF1389, which is taking place in DRC.|                     |
| 3     |Open the "Manage Indicators" sub-tab of the IF1389 project.|                     |
| 4     |Create 2 different sites.|                     |
| 5     |Create one quantitative indicator.|                     |
| 6     |Open the "Indicator Data Entry" sub-tab of the IF1389 project.|                     |
| 7     |Add some value for one site for the indicator just created, and click on save.|                     |
| 8     |Log off, and sign in the application with login user2@sigmah.org (password: sigmah).|                     |
| 9     |Open the sub-tab "Indicator Data Entry" of the IF1389 project.|You should see the value entered just before by user1, and the two sites user1 has created.|
| 10    |Add some value for the other site for the indicator just created by user1, and click on save.|The saving process should work without any problem.|
| 11    | Open the "Manage Indicators" tab.| The "Sites" list should be filled by the two sites user1 has created.|