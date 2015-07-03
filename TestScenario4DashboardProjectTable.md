

# Introduction #

This scenario is based on the v1.2 demo data set.


# Test cases #

## DPT1 ##
### _Title:_ User signing in ###
### _See test on:_ [TestScenario4UserSessionRight#USR1](TestScenario4UserSessionRight#USR1.md) ###

## DPT2 ##
### _Title:_ Projects table loading ###
<table border='1'><th> <b>#</b> </th><th> <b>Steps to reproduce</b> </th><th> <b>Expected result</b> </th>
<tr><td> 1 </td><td> Just after signing in, the user sees the projects table getting loaded. </td><td> - A progress bar show the progress of the loading of the projects in the table<br>
- The projects table has the following column shown by default<br>
<ul><li>code<br>
</li><li>title<br>
</li><li>current phase<br>
</li><li>organizational unit<br>
</li><li>budget consumption<br>
</li><li>available time consumption<br>
</li><li>activity progress<br>
</li><li>categories to which this project belongs to </td></tr></table></li></ul>


## DPT3 ##
### _Title:_ Global export live data ###
<table border='1'><th> <b>#</b> </th><th> <b>Steps to reproduce</b> </th><th> <b>Expected result</b> </th>
<tr><td> 1 </td><td> From the projects table, click on the "Export all" button </td><td> The Global export popup opens up. </td></tr>
<tr><td> 2 </td><td> Let the "Live data" checked by default and click on the "Export" button. </td><td> After a while, an Excel file should be proposed to be downloaded. </td></tr>
<tr><td> 3 </td><td> Save the Excel file on your hard drive and open it. </td><td> The Excel file should contain a tab per project model which has projects associated to it.<br>
In each tab, all the fields of the project model should be given as column (except files fields) and each row should be a project.<br>
All projects, except test and deleted projects, should be in one or another tab of this Excel file. </td></tr></table>


## DPT4 ##
### _Title:_ Global export other format exportation ###
<table border='1'><th> <b>#</b> </th><th> <b>Steps to reproduce</b> </th><th> <b>Expected result</b> </th>
<tr><td> 1 </td><td> From the projects table, click on the "Export all" button </td><td> The Global export popup opens up. </td></tr>
<tr><td> 2 </td><td> Click on the "Change configuration" button </td><td> The Global export configuration popup opens up on top of the Global export popup. </td></tr>
<tr><td> 3 </td><td> Change the "file type" parameter to the other value. (if it was Excel, switch it to Open document: for the rest of the test case, we assume that the new format is Open document), and click on the "Save configuration" button. </td><td> The Global export configuration popup closes itself, a status message "Global export configuration has been successfully updated is displayed", and the user is now back in front of the Global export popup. </td></tr>
<tr><td> 4 </td><td> Let the "Live data" checked by default and click on the "Export" button. </td><td> After a while, an open document spreadsheet (<b>.ods) should be proposed to be downloaded. </td></tr></b><tr><td> 5 </td><td> Save the ODS file on your hard drive, open it and compare it with the Excel file generated in previous test case. </td><td> Both files should contain exactly the same tabs, with the same columns and rows in each tab. </td></tr></table>




## DPT5 ##
### _Title:_ Columns filter ###
<table border='1'><th> <b>#</b> </th><th> <b>Steps to reproduce</b> </th><th> <b>Expected result</b> </th>
<tr><td> 1 </td><td> From the projects table, move your mouse above any of the following columns: Code, Title, Active Phase, Organizational Unit </td><td> On the right of the column, a column contextual menu button in the form of triangle facing down shows up.</td></tr>
<tr><td> 2 </td><td> Click on the column contextual menu button </td><td> The column contextual menu opens up.</td></tr>
<tr><td> 3 </td><td> Move your mouse cursor until the "Filters" menu item. </td><td> A text field appears on the right of the menu item with the text invitation: "Enter filter text"</td></tr>
<tr><td> 4 </td><td> Type any text that you see in the content of the selected column </td><td>The checkbox in front of the "Filters" menu item gets automatically checked, and in the projects table only the rows containing the text put in the filter text field remain.</td></tr>
<tr><td> 5 </td><td> Uncheck the checkbox in front of the "Filters" item menu you've just filled </td><td>The project table gets back all the rows available at the beginning of this test case.</td></tr>
<tr><td> 6 </td><td> Open now the "Filters" menu item for the "Category" column </td><td>A list with checkboxes of all the categories group by category type opens up.</td></tr>
<tr><td> 7 </td><td> Check one or several categories item among the ones available in the column </td><td>The project table gets filtered accordingly.</td></tr>
</table>

## DPT6 ##
### _Title:_ Projects' table grouping manipulation ###
<table border='1'><th> <b>#</b> </th><th> <b>Steps to reproduce</b> </th><th> <b>Expected result</b> </th>
<tr><td> 1 </td><td> In the project table from the home page, click successively  on three  project grouping action:<br>
<ul><li>grouping by NGO projects<br>
</li><li>grouping by funding projects<br>
</li><li>grouping by local partner projects </td>
<td>For each grouping mode, it should display :<br>
</li><li>every projects of the right type are displayed once in the beginning of each row<br>
</li><li>if the project has linked projects :<br>
<ul><li>it is displayed in bold font<br>
</li><li>a small triangle appear next to the project's name, letting you display or hide the linked projects<br>
</li><li>by default, the linked projects are displayed<br>
</li><li>each linked project of any type is displayed in this order:<br>
<ul><li>first, the project as source of funding<br>
</li><li>second, the funded projects<br>
</li></ul></li><li>thus, a project can appears several times as a linked project but not as a project in the beginning of the line </td></tr></table></li></ul></li></ul>


## DPT7 ##
### _Title:_ Limited project's access according on user's rights ###
<table border='1'><th> <b>#</b> </th><th> <b>Steps to reproduce</b> </th><th> <b>Expected result</b> </th>
<tr><td> 1 </td><td> Connect to the application as user1, with the adress user1@sigmah.org and the password: sigmah </td><td> The home page should be displayed. </td></tr>
<tr><td> 2 </td><td> Create a project P1 accessible to the user3's OrgUnit (Myanmar) and a project P2 which shouldn't be accessible to user3 because it is attached to an OrgUnit of an upper-level or same level as his. Disconnect. </td><td> You should be redirected to the sign in page. </td></tr>
<tr><td> 3 </td><td> Connect as user3. </td><td> On your project table, you should see the project P1 but not the project P2. </td></tr></table>

## DPT8 ##
### _Title:_ Reload dashboard projects table ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From the home page, click on the "Reload" button of the Projects table. | The projects table is getting loaded. A progress bar show the progress of the loading of the projects in the table, until all projects are back in the list. |


## DPT9 ##
### _Title:_ Automatic Excel global export ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From the home page, click on the "Export" button of the Projects table. | The "Global export" popup opens up. |
| 2 | Click on the "Change configuration" button. | The "Global export configuration" popup opens up. |
| 3 | Set the "Auto-export schedule" frequency to "Daily", and click on the "Save configuration" button. | A status message "Global export configuration has been successfully updated." confirms to you that your options have been saved, and the "Global export configuration" closes. |
| 4 | Close the "Global export" popup. |                     |
| 5 | Create a project with code "t-export" from any project model (see [PRJM22](TestScenario4ProjectManagement#PRJM22.md) to see how to create a project). | The project "t-project" is added to the projects table. |
| 6 | **Next day** (because auto-export are always made at midnight), open once again the "Global export" popup by clicking on the "Export" button of the Projects table. |                     |
| 7 | Click on the "Backed-up data" radio button. | The "Export backup selection" options appear at the bottom of the "Global export" popup. |
| 8 | Select two dates which after before yesterday and after today, and click on the "Search" button for "1. Specify period to search for a backup". | The "2. Select export backup to export" drop-down list should get filled. |
| 9 | Select the backup you've configured the day before in the "2. Select export backup to export" drop-down list and click on the "Export" button. | The "Global export" popup close, and an Excel file should get downloaded on your computer. |
| 10 | Open the Excel file you've just downloaded. | The project "t-export" should be in the tab of the project model you've chosen, and have all the attributes you've set. |
| 11 | Open once again the "Global export" popup by clicking on the "Export" button of the Projects table. |                     |
| 12 | Click on the "Change configuration" button. | The "Global export configuration" popup opens up. |
| 13 | In the "Configure fields to export" table, click on the project model name you've chosen for your "t-export" project. | All this project model's fields are listed on the right side of the table. |
| 14 | Choose any field in the list, and uncheck its "Export?" column checkbox. |                     |
| 15 | Set the "Auto-export schedule" frequency to "Export every 3 days", and click on the "Save configuration" button. | A status message "Global export configuration has been successfully updated." confirms to you that your options have been saved, and the "Global export configuration" closes. |
| 16 | **3 days later**, export the new automaticly exported Excel file created during the night (see steps 6, 7, 8, 9 & 10 of this test case). | The project "t-export" should be in the tab of the project model you've chosen, and have all the attributes you've set or modified in between, and should miss the information about the field you've unchecked for "Export?".  |