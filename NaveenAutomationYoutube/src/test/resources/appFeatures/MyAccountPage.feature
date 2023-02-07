Feature: My Account Page Feature

Background:
Given user has already logged in to application
|username|password|
|don.piet2008@gmail.com|Raj12345!|


Scenario: My Accounts page title
Given user is on My Accounts page
When user gets the title of the My Accounts page
Then page title should be "My Account – Automation Practice Site"


Scenario: Accounts section count
Given user is on My Accounts page
Then user gets accounts section
|Dashboard|
|Orders|
|Downloads|
|Addresses|
|Account Details|
|Logout|
And accounts section count should be 6