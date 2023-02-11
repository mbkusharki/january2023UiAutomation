@NopIFV
Feature: NopCommerceInputFieldValidation
  Background:
    Given I am on the NopCommerce home page
    When I click on Register link


  Scenario: 1-First name input field validation for Account registration
    And I enter up to maximum of 20xters into the first name input field as "muhammadkusharki67$%"
    And I enter valid details into lastname as "Musa", email as "b@gmail.com", Password and ConfirmPassword as "123456"
    And I populate day as "3", month as "February", year as "1980", and company as "Malashe"
    And I click on register button
    Then registration is successful

  Scenario: 2-Last name input field validation for Account registration
    When I enter up to maximum of 20xters into the Last name input field as "muhammadkusharki67$%"
    And I enter valid details into firstname as "Musa", email as "b@gmail.com", Password and ConfirmPassword as "123456"
    And I populate day as "3", month as "February", year as "1980", and company as "Malashe"
    And I click on register button
    Then registration is successful

  Scenario: 3-Email address input field validation for Account registration
    When I enter email address in an incorrect format into the email address input field as "b.gmail.com"
    And I enter valid details into firstname as "Musa", lastname as "Selina", Password and ConfirmPassword as "123456"
    And I populate day as "3", month as "February", year as "1980", and company as "Malashe"
    And I click on register button
    Then I should get error message “Wrong email”.


  Scenario: 4-Password and Confirm password input fields match validation for Account registration
    When I enter valid password into the Password input field as "123456"
    And I enter non matching password into the Confirm password input field as "123564"
    And I enter valid details into firstname as "Musa", lastname as "Selina", and email as "b@gmail.com"
    And I populate day as "3", month as "February", year as "1980", and company as "Malashe"
    And I click on register button
    Then I should get error message “The password and confirmation password do not match.” as per design (DD05)


  Scenario: 5-Password rule validation- Must have at least 6 characters
    When I enter less than six characters in the Password input field as "12345"
    And I enter valid details into firstname as "Musa", lastname as "Selina", and email as "b@gmail.com"
    And I populate day as "3", month as "February", year as "1980", and company as "Malashe"
    Then I should get a message displayed as per design

  Scenario: 6-Blank mandatory field error message
    When I leave email as " "
    And I enter valid details into firstname as "Musa", lastname as "Selina", Password and ConfirmPassword as "123456"
    And I populate day as "3", month as "February", year as "1980", and company as "Malashe"
    And I click on register button
    Then I should get a message “Mandatory field is Required” displayed as per design (DD07) for the corresponding Mandatory field



