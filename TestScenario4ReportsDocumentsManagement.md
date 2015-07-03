

# Introduction #

This scenario is based on the demo data set. These tests are based on a project page but **have to be executed for the organizational unit page as well**.


# Test cases #

## RDM1 ##
### _Title:_ User signing in ###
#### _See test on:_ [TestScenario4UserSessionRight#USR1](TestScenario4UserSessionRight#USR1.md) ####

## RDM2 ##
### _Title:_ Create a new report ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Open the project « LOC1274 ». | The project's page should open. |
| 2     | On the project's dashboard in the « Reports & Documents » sub-tab, click on « New report » and choose to which report list you want to add the report. | A pop-up should open letting you specify the new report's title. |
| 3     | Enter a title and click on « Ok ». | A row should be added to the reports and documents table with the title that you have specified. |


## RDM3 ##
### _Title:_ Open an existing report ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the project « LOC1274 » dashboard in the « Reports & Documents » sub-tab, click on the created report.  | The report should be displayed on the right-hand panel of the sub-tab. |


## RDM4 ##
### _Title:_ Close a report ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the project « LOC1274 » dashboard in the « Reports & Documents » sub-tab, click on the report you have created. | The report should be displayed on the right-hand panel of the sub-tab. |
| 2     | Click on the « X » in the upper-right of the right-hand panel of the sub-tab. | The report should be closed and the right-hand panel of the sub-tab should be empty. |


## RDM5 ##
### _Title:_ Save a report ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the project « LOC1247 » dashboard in the « Reports & Documents » sub-tab, click on the report you have created. | The report should be displayed on the right-hand panel of the sub-tab. |
| 2     | Modify two different sections and click on « Save ». |                     |
| 3     | Close and reopen the report. | The modification made to the chapters should be retained. |


## RDM6 ##
### _Title:_ Manipulate a report ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On a project dashboard in the « Reports & Documents » sub-tab, click on a report's title. | The report should be displayed on the right-hand panel of the sub-tab. |
| 2     | Click on « Overview Mode ». | The content of the paragraphs of the report should not be displayed. |
| 3     | Click on « Full mode ». | The content of the paragraphs should be displayed. |
| 4     | Click on a paragraph's title. | If the content of the paragraph was visible, it should now be hidden. If it wasn't, it should now be visible. |
| 5     | Click on « Edit ».     | You should now be able to modify the report. |
| 6     | Write some text in one of the section, select it and click on a text transformation button (B, I, S, align left, align right, center, justify, bullets list, numbered list). | The text should be transformed accordingly to the button you clicked on. |
| 7     | Click on the icon with a frame and a plus on it. | A pop-up should open where you can specify the image's URL. |
| 8     | Enter an image URL and click on « Ok ». | The image should be added to the report. |

## RDM7 ##
### _Title:_ Create a report from a project's phase page ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On a dashboard of a project depending on a project model with a reports list field, click on the phase where the report list is attached to and click on « Add report ». | A pop-up should open where you can specify the title of the report. |
| 2     | Enter the title of the report and click on « Ok ». | A row corresponding to the report is added to the report's list section and to the left-hand panel of the « Reports & Documents » sub-tab. |

## RDM8 ##
### _Title:_ Access a report created through the « Reports & documents » tab from a project's phase page ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On a project page depending on a project model with a reports list field, in the « Reports & Documents » sub-tab, add a report. | The report should be added to the left-hand panel of the sub-tab. |
| 2     | On the project's dashboard, click on the phase corresponding to the reports list field in which you added the report. | You should see a row corresponding of the report just created in the reports list field table corresponding. |

## RDM9 ##
### _Title:_ Impossible to create a report in a future phase ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On a project's page in its initial phase, click on the « Reports & Documents » sub-tab and click on « New report ». | The report's model listed should only be the ones available in the current phase. |


## RDM10 ##
### _Title:_ Impossible to create two reports for a « single » reports list field ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Open "Reports & document" sub-tab of project 'IF1389'. |                     |
| 2     | Try to add a second report of type "Programmation | Rapport de mission" (if no report of that type has been created yet, create a first version and then try to create a second one) by clicking on the « New report »  | You should not be able to add a new report. |

## RDM11 ##
### _Title:_ Visibility of attached documents in the « Reports & documents » tab ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On a project's page in its current phase, click on « Attach file ». | A pop-up should open where you can select the file that you want to attach. |
| 2     | Select the file wanted and click on « Ok ». | A row corresponding to the file is added to the left-hand panel of the « Reports & Documents » sub-tab. |
| 3     | Click on the « Reports & Documents » sub-tab. | You should see a row corresponding to the report that you have just added. |


## RDM12 ##
_Test disabled for version 1.2. This test will be enabled when be revised when [issue #541](https://code.google.com/p/sigma-h/issues/detail?id=#541) (Key question management missing in report models administration) will be developed._

### _Title:_ Answer to a report's key question ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On a project's page in its initial phase, click on the « Reports & Documents » sub-tab and open an existing report. | The report should be displayed on the right-hand panel of the sub-tab. |
| 2     | Click on the icon in the form of a compass of a key question | A pop-up should open where you can answer the key question. |
| 3     | Answer the key question and click on « Ok ». | The icon next to the question should go from red to green and the number of answered key questions should  increment. |



## RDM13 ##
### _Title:_ Personal draft cycle of a report ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | Connect as user1, who has the right to modify a report. Modify the report with the "Edit" button, save it and click on the « Share » button. Let's called for this test the current state of the content of this report "state A". |                     |
| 2     | Reopen the same report, modify it and save it in a state called « B ». Don't click on the "Share" button. |                     |
| 3     | Close the report and the project and reopen them. | The report should be displayed as it was in the state « B ». |
| 4     | Connect as user2 who only has the right to consult the report and open it. | You should see the report as it was in state « A ». |

## RDM14 ##
### _Title:_ Automatic saving of reports (#88) ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the « Reports & Documents » sub-tab, open a report. | The report should be displayed on the right-hand panel of the sub-tab. |
| 2     | Without saving it, go back to the home page (main dashboard), open another project and stay on this project for about 10 minutes. | During the 10 minutes, the opened report has at least been saved once and you have been informed of it. |

## RDM15 ##
### _Title:_ Export report into a text document format (#109) ###
| **#** | **Steps to reproduce** | **Expected result** |
|:------|:-----------------------|:--------------------|
| 1     | On the project « LOC1274 » dashboard in the « Reports & Documents » sub-tab, click on the report you have created. | The report should be displayed on the right-hand panel of the sub-tab. |
| 2     | In the toolbar of the right hand panel, click on « Export Word ». | A file in a text document format should be downloaded. |
| 3     | Open the file with an appropriate software. | The file should contain the same content there is in the report you have exported. |