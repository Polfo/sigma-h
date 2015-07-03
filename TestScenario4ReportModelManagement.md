

# Introduction #

The test project available in the application is supposed to have the necessary properties to pass these following tests. These tests have been realized with the application configured with the language EN.


# Test cases #

## RMM1 ##
### _Title:_ User signing in ###
### _See test on:_ [TestScenario4UserSessionRight#USR1](TestScenario4UserSessionRight#USR1.md) ###

## RMM2 ##
### _Title:_ Create report model ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | From the Main dashboard, click on the « Administration » button. | The Administration tab opens up. |
| 2     | Click on the « Report models » link. | The list of existing report models is loaded on the right of the screen. |
| 3     | Enter any name in the text field located in the toolbar of the report models table and click on the « Add » button. | A new row should be added to the report models table. |

## RMM4 ##
### _Title:_ Add a report model's section ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Click on the report model you have created. | The list of the report's sections should be displayed on the right panel of the page. It should be empty in this particular case. |
| 2     | Click on the « Add » button of the right panel.  | A new row should be added to the right panel table. |
| 3     | Click on the the « Name's section » cell of the row. | You should now be able to enter information into the cell. |
| 4     | Enter any name for the section and click on « Save ». |                     |
| 5     | Click on any other report model and click again on the report model that you have created. | In the right panel, you should still see the section that you have created. |


## RMM5 ##
### _Title:_ Modify report model's sections ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Open the report model « Rapport mensuel de partenariat local ». | The list of its sections should be displayed on the right-hand panel. |
| 2     | Change the name of a section. |                     |
| 3     | Change the number of sections of text zones to another section. |                     |
| 4     | Change the parent section id of another section and click on « Save » . |                     |
| 5     | Open the project « IF1389 » and create a new report, if there isn't an existing one. |                     |
| 6     | Open it.               | You should see the modifications that you have made on the report model. |


## RMM6 ##
### _Title:_ Delete a report model's section ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Click on the « Administration » tab and open the report model management page. |                     |
| 2     | Open the report model you have created.|                     |
| 3     | Click on the « Delete » button in the row of the section you have created in RMM4. | The row of the section should disappear. |
| 4     | Click on another report model and click again on the report. | You shouldn't see the row. |


## RMM7 ##
### _Title:_ Delete report model ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Click on the report you have created and click on the « Delete » button of the left panel toolbar. | The row of the report should disappear. |