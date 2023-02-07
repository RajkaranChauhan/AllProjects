Feature: Login inot web application

Scenario Outline: Login for valid user
Given use the URL and navigate to the home page of the application
When user login with credentials using username "<username>" and password "<password>"
Then user will be logged in successfully

Examples: 
|username|password|
|rajkaran|456|
|rajkaranchauhan|456789|


Scenario: Login for invalid user
Given use the URL and navigate to the home page of the application
When user login with credentials using username "raja" and password "1234" 
Then user will be NOT logged in successfully


