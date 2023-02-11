@NopReg
  Feature: NopCommerceLogin
    Background:
      Given I am on the NopCommerce home page
      And I have no item in the shopping cart
      And I click on login link

    Scenario:  2-Login with incorrect credentials to display appropriate error message
      When I attempt to login using incorrect credentials with email as "bello@gmail.com" and password as "123456"
      And I click login button
      Then I should get the appropriate error message displayed

    Scenario: 3-email field validation on the login page
      When I enter email in invalid format as "bello.gmail.com" and password as "1235674"
      And I click login button
      Then I should get error message displayed

    Scenario: 4-Blank email field validation error message
      When I enter valid password as "123456"
      And I leave the Email field blank as " "
      And I click login button
      Then I should get the appropriate error message
