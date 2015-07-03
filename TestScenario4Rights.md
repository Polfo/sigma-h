

# Introduction #

This scenario is based on the demo data set which is supposed to have all the required proprieties to pass these tests.


# Test cases #

## `R1` ##
### _Title:_ Rights for user 4 ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Connect as user4.      | The home page should be displayed. You shouldn't see any button allowing you to create a project in lower-left section of the dashboard. Moreover, you shouldn't be able to see the "Export" button on the Dashboard projects table. |
| 2     | Open any project with a files list field in its current phase. | The project page should open and the project dashboard should be displayed, but the "Delete project" button should not be visible. You should not see any button allowing you to close or activate a phase. In the « Amendments » section, there shouldn't be the links « Validate amendment » and « Reject amendment ». |
| 3     | Open the « Details » sub-tab. | You should be able to modify the project's attributes. |
| 4     | Attach a file to files list field. | A row should be added to the files list field. At the end of the row, you shouldn't see a bin icon allowing you to delete the file. |
| 5     | Open the "Reports & documents" sub-tab of project "IF1389". | In the list of documents, you should not be able to see the file "Evaluation\_RH\_equipe\_IF1389.ods", which is linked to the "Evaluations des membres de l'équipe" field. |


## `R2` ##
### _Title:_ Rights for user 5 ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Connect as user5.      | The home page should be displayed. There should be a « New project » button in the lower-left section of the dashboard. |
| 2     | Create a project.      | A row is added to the project's table by selecting the filter that corresponds to the project you have created (NGO project, Funding project or local partner project ). |
| 3     | Open the project you have just created. | You should not be able in the amendments' section and in the « Details », « Dashboard », « Agenda » and « Reports & Documents » sub-tabs. |

## `R3` ##
### _Title:_ Rights for user 6 ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Connect as user6.      | The home page should be displayed. There should be a « New project » button in the lower-left section of the dashboard. In the project section, there should be a message informing you that you don't have the right to view projects. |
| 2     | Create a project.      | A message should inform you that the project has been created but you should still not be able to view projects, including the one you have just created. |




## `R4` ##
### _Title:_ Rights for user 2 ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Connect as user2.      | The home page should be displayed. There should be no button in the lower-left section of the dashboard. |
| 2     | Click on any Organisational Unit in Organisation chart. | You should not be able to edit the content of the Organisational unit. |