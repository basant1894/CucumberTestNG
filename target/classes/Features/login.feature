Feature: Free CRM Login Feature
Scenario Outline: Free CRM Login Test Scenario

Given user is already on Login Page
When title of Login page is Free CRM
Then user enters username and password
Then user clicks on login button
Then user is on home page




Examples:
    |username | password |
    |basant1894  | kuku0011 |