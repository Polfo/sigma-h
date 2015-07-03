

# Introduction #

This scenario is based on the v1.2 demo data set.


# Test cases #

## TB1 ##
### _Title:_ User signing in ###
### _See test on:_ [TestScenario4UserSessionRight#USR1](TestScenario4UserSessionRight#USR1.md) ###

## TB2 ##
### _Title:_ Quit without saving ###

<table border='1'><th> <b>#</b> </th><th> <b>Steps to reproduce</b> </th><th> <b>Expected result</b> </th>
<tr><td> 1 </td>
<td>For each of the following screen, try to enter some data in the screen, and leave the screen without saving:<br>
<ul><li>Project "Management board" sub-tab<br>
</li><li>Project "Details" sub-tab<br>
</li><li>Project "Logical Framework" sub-tab<br>
</li><li>Project "Manage Indicators" sub-tab<br>
</li><li>Project "Indicator Data Entry" sub-tab<br>
</li><li>Project "Calendar" sub-tab<br>
</li><li>Project "Reports & documents" sub-tab<br>
</li><li>Orgunit "Overview" sub-tab<br>
</li><li>Orgunit "Information" sub-tab<br>
</li><li>Orgunit "Calendar" sub-tab<br>
</li><li>Orgunit "Reports & documents" sub-tab<br>
</li><li>Administration "Project model" edition screen<br>
</li><li>Administration "Orgunit model" edition screen<br>
</li><li>Administration "Report models" screen<br>
</li><li>Administration "Global management" screen    </td>
<td>For each screen, when trying to leave without having saved, a small window should popup to ask you to confirm you want to quit without saving.</td></tr>
</table></li></ul>

## TB3 ##
### _Title:_ Timezone difference management ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Log out from Sigmah.   | You're back to login screen. |
| 2     | Change the timezone of your operating system to a timezone which is different from the timezone where the Sigmah server you're connected to is located. For example, if you're connected to demo.sigmah.org which is a server located in France, you should change the timezone of your operating system (ie: Ubuntu, MS Windows, MacOS) to a timezone which is not the Paris timezone. | After changing the timezone, the current time of your computer should be different from the time on your watch or mobile phone. |
| 3     | Log in with the demo@sigmah.org / sigmah credentials. | You're now on the main dashboard. |
| 4     | Open the IF1389 project, and then click on the "Details" sub-tab. |                     |
| 5     | Change the start date of the project, and click on the "Save" button. | You get a message "Your data has been correctly saved". |
| 6     | Open the "Indicator Data Entry" tab. |                     |
| 7     | Enter a value in an empty cell for an indicator, and click on the "Save" button. | Once "Save" is clicked, the button switched to disabled state and is renamed "Saved".  |
| 8     | Log out from Sigmah.   | You're back to login screen. |
| 9     | Change the timezone of your operating system to a timezone which is different similar to the timezone where the Sigmah server you're connected to is located. |                     |
| 10    | Log in with the demo@sigmah.org / sigmah credentials. | You're now on the main dashboard. |
| 11    | Open the IF1389 project, and then click on the "Details" sub-tab. | The start date in the project banner and in the field of the "Details" sub-tab should have the same value as the one you've entered when your operating system was set to a different timezone. |
| 12    | Open the "Indicator Data Entry" tab and search for the Month view where you've entered a new indicator value previously (you must be in a "Month" view, and not in an "Indicator" or "Site" view) | The value you've entered previously is still visible and is unchanged.  |


