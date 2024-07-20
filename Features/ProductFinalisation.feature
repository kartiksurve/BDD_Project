Feature: To validate the product finalisation

Background: Common initial steps for Scenarios 1 and 2
Given Open chrome browser
And Search the Url in Browser as "https://www.saucedemo.com/"
And Verify the title of page as "Swag Labs"
When Enter the emailaddress as "standard_user" and password as "secret_sauce"
And Click on the Login Button

@Sanity
Scenario: To buy products using the checkoutfeature
And Verify the title of page as "Swag Labs"
And Add the products to basket
And Navigate to basket page
And Verify the title of page as "Swag Labs"
And Navigate to Checkout page
And Fill the Checkout details with name as "kartik" lastname as "surve" and zipcode as "400014"
And Navigate to Final Checkout page
Then Click on Final button
And Valida the success message as "Thank you for your order!"