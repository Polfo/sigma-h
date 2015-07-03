

# Introduction #

This scenario is based on the v1.2 demo data set.


# Test cases #

## OUM1 ##
### _Title:_ User signing in ###
#### _See test on:_ [TestScenario4UserSessionRight#USR1](TestScenario4UserSessionRight#USR1.md) ####

## OUM2 ##
### _Title:_ Create an organizational unit (#126) ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Click on the « Administration » button on the home page. | The « Administration » page should appear. |
| 2     | Click on the « Organizational units » link. | 	A table of the existing organizational units should be displayed. |
| 3     | The « Afrique » organizational unit which will be the parent of the organizational unit you are going to create. | The button « Add » is now enabled. |
| 4     | Click on it.           | A pop-up should open letting you specify the information of the new organizational unit. |
| 5     | Give « Japon » as title of the new organizational unit and fill the other fields as you want. | A new row should be added to the table under the parent's row of the organizational unit created. |

## OUM3 ##
### _Title:_ Delete an organizational unit (#126) ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Select the row of the organizational unit « Japon ». | The button « Delete » should now be enabled. |
| 2     | Click on the « Delete » button. | A pop-up for confirming the deletion should open. |
| 3     | Click on « Ok ».       | The row corresponding to the organizational unit should disappear. |

## OUM4 ##
### _Title:_ Move an organizational unit (#126) ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Select the row of the organizational unit « Japon ». | The button « Move » should now be enabled. |
| 2     | Click on the « Move » button. | A pop-up should open letting you choose the new parent organizational unit. |
| 3     | Choose « Asie » and click on « Ok ». | The row corresponding to the organizational unit should be moved from « Afrique » to « Asie ». |

## OUM5 ##
### _Title:_ Project - Organizational Unit link ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the home page, click on « New project ». | A pop-up should open where you can specify the new project's attributes. |
| 2     | Click on the list corresponding to the « Organizational Unit » attributes. |  You should see all the available Organization Units from any level. |


## OUM6 ##
### _Title:_ Organizational Unit's flexibility ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the homepage, click on the « Administration » button. |                     |
| 2     | Click on « Organisational unit models ». | The list of all the OrgUnit models should be displayed. |
| 3     | Click on « HQ model ». | The OrgUnit should open and you should be able to modify it. |
| 4     | Click on the « Add » button in the « Fields » tab. | A pop-up should open where you can specify the attributes of the new field. |
| 5     | Enter any information for the field and click on « Save ». | A new row should be added to the fields table. |
| 6     | Click on the « Add » button in the « Fields » tab once again, and enter any information in the popup for this second new field and click on « Save ». |A new row should be added to the fields table. |
| 7     | Select the latest field you've added and click on « Delete selected fields ». | The row corresponding to the field should disappear. |
| 8     | Go back to the home page, open the OrgUnit "HQ - Siège(Paris)" and then click on the "Information" sub-tab. | The orgunit should have the field that you have added but not the one that you have deleted. |

## OUM7 ##
### _Title:_ Modify the attributes of an Organizational Unit ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On an OrgUnit dashboard, go in the « Information » sub-tab, modify any attribute. |                     |
| 2     | Modify the "Country" attribute and click on « Save ». |                     |
| 3     | Close and reopen the OrgUnit dashboard. | The modifications that you have made are still there. |

## OUM8 ##
### _Title:_ Modify the calendar of an Organizational Unit ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | In the sub-tab « Calendar » of the dashboard of an OrgUnit, click on the « Add event » button. | A pop-up should open where you can specify the information of the new event. |
| 2     | Click on « Save ».     | The event should be added on the day that you have specified. |
| 3     | Click on the event.    | A small window should open and display the information of the event as well as two links « Edit event » and « Delete event ». |
| 4     | Click on « Edit event ». | A pop-up should open allowing you to modify the information of the event. |
| 5     | Modify any field and click on « Ok ». | The information should be changed on the week and month view. |
| 6     | Close and reopen the project you are in. | The modification should have been retained. |
| 7     | Click on the event.    |A small window should open and display the information of the event as well as two links « Edit event » and « Delete event ». |
| 8     | Click on « Delete event ». | The event should disappear on the month and the week view.|

## OUM9 ##
### _Title:_ Organizational Unit's attribute history consultation ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From an OrgUnit « Information » sub-tab, right click on one of the following field's type ( numeric, date, simple text, paragraph, triplet, multiple choice list, check box). | A contextual menu should open with the action « Show history ». |
| 2 | Click on the action « Show history ». | A pop-up should open with the field's modification history with, for each modification, the date, the other and the value given on the modification. |

## OUM10 ##
### _Title:_ Export Organizational Unit synthesis Excel file ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | Open any organizational unit. |                     |
| 2 | Click on the "Export" button, which looks like a normal rectangular button with rounded corners and is on the extreme right of the line where all the sub-tabs ("Overview", "Information", etc.) are. | An Excel (or OpenDocument depending of the General parameter "Default spreadsheet export file format") is downloaded on your computer.  |
| 3 | Open the spreadsheet file.  | All the content of the orgunit's fields must appear in the exported file. |