@login
Feature: Sauce Demo E-commerce Login Functionality

@Regression
  Scenario Outline: Login with invalid credentials
    Given I am on the SauceDemo login page
    When I enter "<username_scenario>" username "<username>" and "<password_scenario>" password "<password>"
    And I click the login button
    Then I should see an error message with error message is "<Message>"



    Examples:
      | username | password | username_scenario |password_scenario| Message |
      | locked_out_user| secret_sauce  |  locked user name    | valid Password    |Epic sadface: Sorry, this user has been locked out.|
      | invalid_user   | invalid_pass  |  invalid user name   | invalid Password  |Epic sadface: Username and password do not match any user in this service|
      | standard_user  | invalid_pass  |  valid user name     | invalid Password  |Epic sadface: Username and password do not match any user in this service|
      | problem_user   | invalid_pass  |  valid user name     | invalid Password  |Epic sadface: Username and password do not match any user in this service|



  @Regression
  @Smoke
  Scenario Outline: Login with valid credentials
    Given I am on the SauceDemo login page
    When I enter valid username "<username>" and valid password "<password>"
    And I click the login button
    Then I should be logged in successfully and navigated to the products page

    Examples:
      | username       | password |
      | standard_user  | secret_sauce  |

