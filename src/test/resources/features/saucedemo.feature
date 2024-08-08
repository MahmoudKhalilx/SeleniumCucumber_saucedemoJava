#Feature: Sauce Demo E-commerce Functionality
#
#@login @Regression
#  Scenario Outline: Login with invalid credentials
#    Given I am on the SauceDemo login page
#    When I enter "<username_scenario>" username "<username>" and "<password_scenario>" password "<password>"
#    And I click the login button
#    Then I should see an error message with error message is "<Message>"
#
#
#
#    Examples:
#      | username | password | username_scenario |password_scenario| Message |
#      | locked_out_user| secret_sauce  |  locked user name    | valid Password    |Epic sadface: Sorry, this user has been locked out.|
#      | invalid_user   | invalid_pass  |  invalid user name   | invalid Password  |Epic sadface: Username and password do not match any user in this service|
#      | standard_user  | invalid_pass  |  valid user name     | invalid Password  |Epic sadface: Username and password do not match any user in this service|
#      | problem_user   | invalid_pass  |  valid user name     | invalid Password  |Epic sadface: Username and password do not match any user in this service|
#
#
#
#  @login @Regression
#@Smoke
#  Scenario Outline: Login with valid credentials
#    Given I am on the SauceDemo login page
#    When I enter valid username "<username>" and valid password "<password>"
#    And I click the login button
#    Then I should be logged in successfully and navigated to the products page
#
#    Examples:
#      | username       | password |
#      | standard_user  | secret_sauce  |
#
#
#
#
##  ====================================================
#
#  @Regression
#  @Smoke @PlaceOrder
#  Scenario: Successful login and checkout process
#    Given I am on the SauceDemo login page
#    When I enter valid username "standard_user" and valid password "secret_sauce"
#    And I click the login button
#    Then I should be logged in successfully and navigated to the products page
#    When I add the two most expensive products to my cart
#    And I click on the cart button
#    Then I should be navigated to the cart page
#    And I should see the previously selected products in the cart
#    When I click on the checkout button
#    Then I should be navigated to the checkout page
#    When I fill in the checkout form with:
#      | First Name | Last Name | Postal Code |
#      | Mahmoud       | Khalil       | 11111       |
#    And I click the continue button
#
#    Then I should be navigated to the overview page
#    And I should see the correct items total amount
#    And I should see the correct items total amount before taxes
#    And the URL should match "https://www.saucedemo.com/checkout-step-two.html"
#    When I click the finish button
#    Then I should see the thank you message
#    And I should see the order dispatched message
#
