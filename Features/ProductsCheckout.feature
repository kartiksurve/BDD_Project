Feature: Product Shopping plus checkout

Background: Common initial steps for Scenarios 1 and 2
Given Open chrome browser
And Search the Url in Browser as "https://www.saucedemo.com/"
And Verify the title of page as "Swag Labs"
When Enter the emailaddress as "standard_user" and password as "secret_sauce"
And Click on the Login Button

@Regression
Scenario: 1. To add the products to basket and verify the page
And Verify the title of page as "Swag Labs"
And Add the products to basket
And Navigate to basket page
And Verify the title of page as "Swag Labs"

@Regression
Scenario: 2.  To add the products to basket and remove them from basket
And Verify the title of page as "Swag Labs"
And Add the products to basket
And Navigate to basket page
And Verify the title of page as "Swag Labs"
Then Remove the products from basket
Then Navigate to Products page via Continue Shopping option
And Verify the title of page as "Swag Labs"

