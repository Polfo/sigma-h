

# Introduction #

This scenario is based on the demo data set.


# Test cases #

## AGN1 ##
### _Title:_ User signing in ###
#### _See test on:_ [TestScenario4UserSessionRight#USR1](TestScenario4UserSessionRight#USR1.md) ####

## AGN2 ##
### _Title :_ Time navigation through the calendar ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On a project dashboard in the « Calendar » tab, click on the « Week » button. | The page of the calendar should display 7 days from Sunday to Monday (if user logged in with English language). |
| 2     | Click on the « Next » button. | The page should display the week after the one that was displayed. |
| 3     | Click on the « Previous » button. | The page should display the week before the one that was displayed. |
| 4     | Click on the « Today » button. | The page should now display the week we are in today. |
| 5     | Click on the link « Month » button. | The page of the calendar should display the month with the different days classified by the days of the week, from Monday to Sunday. |
| 6     | Click on the « Today » button. | The page should now display the month we are in today. |


## AGN3 ##
### _Title :_ Add an event ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On a project dashboard in the « Calendar » tab, click on the « Add event » button . | A pop-up should open allowing you to specify the information for the new event. |
| 2     | Fill the event's fields and click on « Ok ». | An event should be added to the day that you have specified on the week and the month view. |

## AGN4 ##
### _Title :_ Modify an event ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On a project dashboard in the « Calendar » tab, click on an event . | A small window should open and display the information of the event as well as two links « Edit event » and « Delete event ». |
| 2     | Click on « Edit event ». | A pop-up should open allowing you to modify the information of the event. |
| 3     | Modify any field and  click on « Ok ». | The information should be changed on the week and month view.|
| 4     | Close and reopen the project you are in. | The modification should have been retained. |

## AGN5 ##
### _Title :_ Delete an event ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On a project dashboard in the « Calendar » tab, click on an event . | A small window should open and display the information of the event as well as two links « Edit event » and « Delete event ». |
| 2     | Click on « Delete event ». | The event should disappear on the month and the week view. |