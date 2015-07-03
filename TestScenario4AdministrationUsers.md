

# Introduction #

The test project available in the application is supposed to have the necessary properties to pass these following tests.

# Test cases #

## AUSR1 ##
### _Title:_ User signing in ###
### _See test on:_ [TestScenario4UserSessionRight#USR1](TestScenario4UserSessionRight#USR1.md) ###

## AUSR2 ##
### _Title:_ Open Administration Users ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | From the main dashboard, click on the Administration button | A new tab named "Administration" opens up in the application, and should already be opened on the Users administration part. The Users administration part has 3 parts : "Users", "Profiles", "Privacy groups".  |


## AUSR3 ##
### _Title:_ Add a new privacy group ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | In the "Privacy groups" block, click on "Add" button | An "Add" popup opens up.  |
| 2     | Enter data for Code (only numbers for Code) and Title |                     |
| 3     | Click on "Save" button. | The popup gets closed, a status message should inform that the privacy group has been properly created, and the privacy group should now be visible in the list of privacy groups with all the parameters entered during the creation.  |


## AUSR4 ##
### _Title:_ Add a new profile ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Click on "Add profile" button | An "Add profile" popup opens up.  |
| 2     | Enter data for Name    |                     |
| 3     | Select several Global Authorisations by clicking the checkbox |                     |
| 4     | Add two privacy groups to the user | The privacy should get selected below the profiles selection drop down list.  |
| 5     | Remove one of the two privacy groups selected by clicking on the cross next to it. | The privacy group selected for deletion should disappear.  |
| 6     | Move your mouse cursor to the bottom boundary of the "Add profile" popup. | The mouse cursor get changed to two-directions arrow.  |
| 7     | Click with the left button of the mouse, and while keeping the mouse button pressed, move your cursor upwards until you are above the "Save" button of the popup, and then release the mouse button. | The "Add profile" popup should get reduced to the size you have chosen, and a scrollbar must have appear on right side to enable to scroll until the "Save" button.   |
| 8     | Click on "Save" button. | The popup is frozen with a message "Saving changes", and it is impossible to click once again on the "Save" button" until the popup closes itself automatically. Then a status message should inform that the profile has been properly updated, and the profile should now be visible in the list of profiles with all the parameters selected during the creation.  |

## AUSR5 ##
### _Title:_ Add a new user ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Click on "Add user" button | A "New user" popup opens up.  |
| 2     | Enter data for Surname, First name and Email |                     |
| 3     | Select an invitation language, and an organizational unit |                     |
| 4     | Add two profiles to the user | The profiles should get selected below the profiles selection drop down list.  |
| 5     | Remove one of the two profiles selected by clicking on the cross next to it. | The profile selected for deletion should disappear.  |
| 6     | Move your mouse cursor to the bottom boundary of the "New user" popup. | The mouse cursor get changed to two-directions arrow.  |
| 7     | Click with the left button of the mouse, and while keeping the mouse button pressed, move your cursor upwards until you are above the "Save" button of the popup, and then release the mouse button. | The "New User" popup should get reduced to the size you have chosen, and a scrollbar must have appear on right side to enable to scroll until the "Save" button.   |
| 8     | Click on "Save" button. | The popup is frozen with a message "Saving changes", and it is impossible to click once again on the "Save" button" until the popup closes itself automatically. Then a status message informs that the user has been properly updated, and the user should now be visible in the list of users with all the parameters chosen while creating it.  |



## AUSR6 ##
### _Title:_ Delete a privacy group ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | In the "Privacy groups" block, select a row of a privacy group you've created and that you haven't attached to any field | The row should get highlighted.  |
| 2     | Click on the "Delete" button. | A deletion confirmation popup should open up. |
| 3     | Confirm the deletion.  | A status message should confirm the deletion of the privacy group.  |



## AUSR7 ##
### _Title:_ Delete a profile ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | In the "Profiles" block, select a row | The row should get highlighted.  |
| 2     | Click on the "Delete" button. | A deletion confirmation popup should open up. |
| 3     | Confirm the deletion.  | A status message should confirm the deletion of the profile.  |