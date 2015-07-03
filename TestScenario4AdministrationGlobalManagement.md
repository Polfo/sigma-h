

# Introduction #

This scenario is based on the v1.2 demo data set.

_Note: the "Settings" tab used to be named "Global Management", and this is the reason of the early name of this test scenario_


# Test cases #

## AGM1 ##
### _Title:_ User signing in ###
### _See test on:_ [TestScenario4UserSessionRight#USR1](TestScenario4UserSessionRight#USR1.md) ###


## AGM2 ##
### _Title:_ Open Administration Settings ###
<table border='1'><th> <b>#</b> </th><th> <b>Steps to reproduce</b> </th><th> <b>Expected result</b> </th>
<tr><td> 1 </td>
<td> From the main dashboard, click on the Administration button</td>
<td>A new tab named "Administration" opens up in the application.</td></tr>
<tr><td> 2 </td>
<td>Click on "Settings " hyperlink on the left part of screen</td>
<td>A screen with 3 parts appears on the right: "Organization management", "Back up all files", "Default spreadsheet export file format".</td></tr>
</table>



## AGM3 ##
### _Title:_ Backup all last versions of files from top orgunit ###
<table border='1'><th> <b>#</b> </th><th> <b>Steps to reproduce</b> </th><th> <b>Expected result</b> </th>
<tr><td>1 </td>
<td> From the "Settings" part of the Administration area, select "Only the last version of each file" as "Download" option in the "Back up all files" block, and the headquarters ("Siège" in French) as root orgunit to build the backup from.</td>
<td></td></tr>
<tr><td> 2 </td>
<td>Click on "Backup All Files" button</td>
<td>A file named as the organization name is proposed for download.</td></tr>
<tr><td> 3 </td>
<td>Accept to save the file somewhere on your hard drive, and opens it once downloaded.</td>
<td>The zip contains the full hierarchy of all orgunits and projects of the organization as folders, and in each folder the latest version of the files attached to each object.</td></tr>
</table>


## AGM4 ##
### _Title:_ Backup all versions of each file from one orgunit ###
<table border='1'><th> <b>#</b> </th><th> <b>Steps to reproduce</b> </th><th> <b>Expected result</b> </th>
<tr><td>1 </td>
<td> From the "Settings" part of the Administration area, select "All versions of each file" as "Download" option in the "Back up all files" block, and "Myanmar" as root orgunit to build the backup from.</td>
<td></td></tr>
<tr><td> 2 </td>
<td>Click on "Backup All Files" button</td>
<td>A file named as the organization name is proposed for download.</td></tr>
<tr><td> 3 </td>
<td>Accept to save the file somewhere on your hard drive, and opens it once downloaded.</td>
<td>The zip contains a folder named Myanmar. In this Myanmar folder, there should be a folder "PosterSigmah_inEnglish_f1632" instead of a single file, and this folder contains 2 files which are the 2 versions of the files attached for test purpose. Those 2 files have 2 different suffix with version numbers.</td></tr>
</table>


## AGM5 ##
### _Title:_ Change organization's logo and name ###
<table border='1'><th> <b>#</b> </th><th> <b>Steps to reproduce</b> </th><th> <b>Expected result</b> </th>
<tr><td>1 </td>
<td> Go to the "Settings" part of the Administration area</td>

<td>A screen with 3 parts appears on the right: "Organization management", "Back up all files", "Default spreadsheet export file format".</td></tr>
<tr><td> 2 </td>
<td>Change the content of "Name of the organization" and "Logo of the organization" fields, and click on the "Save changes" button.</td>
<td>Confirmation status messages are sent, and you see the logo changed only inside this screen.</td></tr>
<tr><td> 3 </td>
<td>Click on the "Log out" hyperlink</td>
<td>The Log In screen opens up.</td></tr>
<tr><td> 4 </td>
<td>Log in back (see <a href='TestScenario4UserSessionRight#USR1.md'>TestScenario4UserSessionRight#USR1</a> for more info)</td>
<td>The logo and the name of the organization are changed on the top banner of the application.</td></tr>
</table>


## AGM6 ##
### _Title:_ Default spreadsheet export file format ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | Go to the "Settings" part of the Administration area. | A screen with 3 parts appears on the right: "Organization management", "Back up all files", "Default spreadsheet export file format". |
| 2 | Change "Default spreadsheet export file format" parameter value to the other available value (if the value is ".xls", change it to ".ods"; if the value is ".ods", change if to ".xls") and click on the "Save configuration" button. |                     |
| 3 | Open any project, and click on the "Export project" button.  | A file in the file format just set up should be downloaded. |