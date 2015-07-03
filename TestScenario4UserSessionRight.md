

# Introduction #

This scenario is based on the 1.2 demo data.


# Test cases #

## USR1 ##
### _Title:_ User signing in ###

| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | Enter 'demo@sigmah.org' as email, and 'sigmah' as password, and click on 'Sign in'. | The dashboard opens up as home page, and the 'demo@sigmah.org' email address is visible on top of the page. |

## USR2 ##
### _Title:_ User logging out ###

| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | Once in the application, click on the "Logout" hyperlink. | The sign in page should replace the current page left in the application. |

## USR3 ##
### _Title:_ Recovering lost password ###

| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | From the "Sign in" page, click on the "Have you forgotten your password?" hyperlink. | A window pops up asking you to enter your e-mail address. |
| 2 | Enter a valid email address which is also the email address of a user already registered in the Sigmah version you're testing, and click on the "OK" button. | After a couple of seconds, you should receive an email containing a temporary URL to change your password. |
| 3 | From the email you've received in your mailbox from Sigmah, click on the URL. | A new page opens up in your web browser with 3 fields: your email address (locked field), a new password field, and a confirmation password field. |
| 4 | Enter a new password and its confirmation, and click on "Save" | You get a confirmation message informing you that your password has been changed. |
| 5 | Log in with your new password and the email address used for the password recovery procedure | You should be able to enter the application with this new password. |

## USR4 ##
### _Title:_ Unreachable pages if no user is logged in ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | When you are logged in into the application, copy any URL different from the welcome page. Then, log out.| You should be redirected to the sign in page. |
| 2 | Paste the copied URL into your brother's address bar and try to access the page of the URL. | You should be redirected to the sign in page.|

## USR5 ##
### _Title:_ Display of user's NGO 's information ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | Open the "Administration " tab, then click on the link "Settings". | A page where you can modify tour NGO's information is displayed. |
| 2 | In the section "Organization management", change the logo end the name of the connected user's NGO, click on the "Save Changes" button and logout.|                     |
| 3 | Log in back.           | The logo of the NGO, in the upper-left, has been modified.|

## USR6 ##
### _Title:_ Pop-up help (#82) ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | On two different pages of the application, click on the link "Help" on the upper-right of each page. | A pop-up help should open each time on the help section about the page you're on. |


## USR7 ##
### _Title:_ Pop-up credits (#91) ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 |  From any page of the application, except the sign in page, click on the link "Credits". | A pop up appears informing you about the project's version, developers, financial supports...|

## USR8 ##
### _Title:_ Create a user (#105) ###
| # | **Steps to reproduce** | **Result expected** |
|:--|:-----------------------|:--------------------|
| 1 | On the main page, click on « Administration ». | The administration page should be displayed. |
| 2 | Click on the « Users ». | The list of the existing users should be display on the right-hand panel. |
| 3 | Click on the « Add User » button. |  A pop-up should open letting you enter the information of the new user. |
| 4 | Fill the different fields as you want but provide a valid email address and click on « Save ». | The user you have created should soon receive an email, giving him his login and password as well as the URL of the application. |
| 5 | Click on the URL.      | You should be brought back to the application. |
| 6 | Sign in with the login and password given. | The main dashboard page should be displayed. |