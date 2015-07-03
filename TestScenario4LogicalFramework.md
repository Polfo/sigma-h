

# Introduction #

This scenario is based on the v1.2 demo data set.


# Test cases #

## LF1 ##
### _Title:_ User signing in ###
#### _See test on:_ [TestScenario4UserSessionRight#USR1](TestScenario4UserSessionRight#USR1.md) ####

## LF2 ##
### _Title:_ Create a minimal logframe without indicators ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | From the Main dashboard, create a new project from the model « Contrat de financement v1 » (code and title free to choose).|The new project gets available in the Projects table (visible only if table is grouped by « Source of Funding project".|
| 2     |Open the new project.   |A new tab opens up in the application with the new project.|
| 3     |Open the « Log frame » sub-tab of this new project.|A screen with an empty logical framework is displayed. The title of the project should appear at the upper-left part of the logical frame. |
| 4     | Modify the content of the Main objective, and click on the « Add » button of the « Specific objectives » row.|This first specific objective gets code « SO A. »  and the cells « Intervention logic » and « Risks and assumptions » become open for modification.|
| 5     |Enter any data in the « Intervention logic » and « Risks and assumptions » cells for this specific objective, and click on the « Add » button of the « Expected result » row.|A popup opens up asking you to choose a parent specific objective for this expected result.|
| 6     |Select « SO A. » and click on « Save".|This first expected result gets code « ER A.1. »  and the cells « Intervention logic » and « Risks and assumptions » become open for modification for this row.|
| 7     |Enter any data in the « Intervention logic » and « Risks and assumptions » cells for this expected result, and click on the « Add » button of the « Activities » row.|A popup opens up asking you to choose a parent expected result, a start and end dates for this new activity.|
| 8     |Select « ER A.1. » and choose any date and click on « Save".|This first expected result gets code « A A.1.1. »  and the cell « Intervention logic » becomes open for modification for this row.|
| 9     |Enter any data in the « Intervention logic » cell for this activity, and click on the « Add » button of the « Prerequisites » row.|This first prerequisite gets code « P 1. »  and the a long cell « Intervention logic » becomes open for modification for this row.|
| 10    |Enter any data in the « Intervention logic » cell for this prequisite, and click on the « Save » button of this screen. |You get a confirmation message that your data has been correctly saved, and the « Save » button becomes disabled.|
| 11    |Close the project dashboard, reopen the project and come back to this « Log frame » sub-tab.|All the data you've entered are still here.|


## LF3 ##
### _Title:_ Create indicators in a logframe ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Open the « Log frame » sub-tab of any project which has already an empty logframe, or create a new project and opens its « Log frame ». |A screen with a logical framework is displayed.|
| 2     | For each row of the logframe (Specific objectives, Expected results, Activities), create a logframe element with at least one element with a long name (more than 50 characters), and create a new indicator by clicking accordingly on the « New indicator » hyperlink and filling all indicators attributes. |In each row, an indicator should be visible with its name in the « Indicators » column, and its source of verification in the « Means of verification » column.|
| 3     | Click on the « Save » button of this screen.| You get a confirmation message that your data has been correctly saved, and the « Save » button becomes disabled.|
| 4     | Go to the « Manage indicators » sub-tab. | All the indicators you've created in the logframe are also listed here, with their target values and all attributes.|
| 5     | Go back to the « Log frame » sub-tab. | All the data you've entered previously are still here.|
| 6     | Modify a cell in the logframe (like the title of a specific objective) and click on the « Save » button of this screen.| You get a confirmation message that your data has been correctly saved, and the « Save » button becomes disabled. |
| 7     | Go to the « Manage indicators » sub-tab, and click on the "Refresh Preview" button. | All the indicators you've created in the logframe are still listed here, with their target values and all attributes still similar as what they used to be.|

## LF4 ##
### _Title:_ Move an element of a logical framework ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Open the « Log frame » sub-tab of any project which has a log frame that has 3 elements of the same type. |A screen with a logical framework is displayed.|
| 2     |Click on the icon with the arrow going down next to the element in the middle. | A contextual menu should appear. |
| 3     | Click on « Up » or « Down » and click on « Save ». | The element is moved accordingly to the choice you have made.|
| 4     | Close and reopen the project dashboard and come back to the « Log frame » sub-tab. | The element should be in the same position that he was after you moved it. |

## LF5 ##
### _Title:_ Delete an element from a logical framework ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Open the « Log frame » sub-tab of any project which has already a minimal logframe you're ready to modify. |A screen with a logical framework is displayed.|
| 2     | Click on the icon with the arrow going down next to an element in the log frame that doesn't have any depending element (like activity). | A contextual menu should appear. |
| 3     | Click on « Delete ».   | The element should disappear. |
| 4     | Close and reopen the project dashboard and come back to the « Log frame » sub-tab. | The element should not be displayed. |

## LF6 ##
### _Title:_ Add an activity linked to the calendar ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Open the « Log frame » sub-tab of any project which has already a minimal logframe you're ready to modify. |A screen with a logical framework is displayed.|
| 2     | Click on « Add » in the « Activities » section. | A pop-up should open where you can specify the information of the new activity. |
| 3     | Fill the activity's fields, click on « Save » and click on « Save » in the toolbar of the logical frame panel. | An activity should be added to the « Activities » row. |
| 4     | Open the « Calendar  » tab. | You should see the activity that you have added on each day between the start and end date of the activity. |

## LF7 ##
### _Title:_ Modify an activity (#113) ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     |  Open the « Log frame » sub-tab of any project which has already a minimal logframe you're ready to modify. |A screen with a logical framework is displayed.|
| 2     | Click on an activity's link. | A contextual menu should open. |
| 3     | Change the progress of the activity and click on « Ok ». |                     |
| 4     | Go to the main dashboard of the application and click on « Refresh » in the projects panel. | In the project table, you should see that the progress bar for the project has been updated. |

## LF8 ##
### _Title:_ Copy logical framework (#111) ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Opens the « Log frame » sub-tab of any project which has already a minimal logical frame. |A screen with a logical framework is displayed.|
| 2     | Click on the « Copy » button. |                     |
| 3     | Open the « Log frame » sub-tab of another project, and click on the "Paste" button. |  A pop-up should open to let you confirm the action and link the indicators to the source logical frame. |
| 4     | Click on « Ok ».       | The logical frame you have copied should be pasted with the indicators. |
| 5     | Close and reopen the project. | The logical frame should still be the one you pasted. |

## LF9 ##
_Note: used to be LF8 by mistake, and known as LF8bis_
### _Title:_  Add a group to a logical framework ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Open the « Log frame » sub-tab of any project which has already a minimal logical frame. | A screen with a logical framework is displayed.|
| 2     | Click on « Add a group » in the « Specific objectives » section. | A pop-up should open letting you specify the name of the group you are creating. |
| 3     | Give the name that you want and click on « Ok ». | The group should be added to the table in the « Specific objectives » section. |



## LF10 ##
_Note: used to be LF9, because there were 2 LF8 by mistake_
### _Title:_  Remove a group from a logical framework (#149) ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Open the « Log frame » sub-tab of any project which has already a minimal logical framework and contains groups. |                     |
| 2     | Click on the pointing down arrow button next to a group. |  A contextual menu should open. |
| 3     | Click on the « Delete » button. | The group should disappear from the table. |



## LF11 ##
_Note: used to be LF10, because there were 2 LF8 by mistake_
### _Title:_  Export a logical framework ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Open the « Log frame » sub-tab of any project which has already a minimal logical framework (like "IF1389"). |                     |
| 2     | Click on the « Export » button on the top corner right of the window. | An Excel (or OpenDocument depending of the General parameter "Default spreadsheet export file format") is downloaded on your computer. |
| 3     | Open the spreadsheet file. | All the content of the logframe must appear in the exported file. |