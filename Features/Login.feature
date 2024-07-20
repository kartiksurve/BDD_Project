Feature: Login Feature for Sauce Demo

Scenario: To verify successful login to Login Feature.
Given Open chrome browser
And Search the Url in Browser as "https://www.saucedemo.com/"
And Verify the title of page as "Swag Labs"
When Enter the emailaddress as "standard_user" and password as "secret_sauce"
And Click on the Login Button
Then Verify the title of page as "Swag Labs"

@Sanity
Scenario Outline: To verify successful login to Login Feature via multiple users.
Given Open chrome browser
And Search the Url in Browser as "https://www.saucedemo.com/"
And Verify the title of page as "Swag Labs"
When Enter the emailaddress as "<username>" and password as "<password>"
And Click on the Login Button
Then Verify the title of page as "Swag Labs"
Examples:
  |username     |password    |
  |standaaa_user|secret_sauce|
  |standard_user|secret_saucc|