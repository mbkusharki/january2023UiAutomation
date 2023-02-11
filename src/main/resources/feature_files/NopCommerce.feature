@NopCom
Feature: NopCommerce
Background:
  Given I am on NopCommerce home page

  Scenario: 1-Registration using only mandatory input fields
    When I click on Register link
    And I populate only the mandatory fields firstname as "Inaam", lastname as "Muhammad", and email as "inaam@gmail.com", password and ConfirmPassword as "123456"
    And I click on register button
    Then registration is successful


  Scenario: 2-Registration using all input fields
    When I click on Register link
    And I populate only the mandatory fields firstname as "Inaam", lastname as "Muhammad", and email as "inaam@gmail.com", password and ConfirmPassword as "123456"
    And I populate day as "3", month as "February", year as "1980", and company as "Malashe"
    And I click on register button
    Then registration is successful