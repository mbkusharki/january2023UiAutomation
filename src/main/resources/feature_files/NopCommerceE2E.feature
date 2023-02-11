@NopE2E
Feature: NopCommerceE2E

  Scenario: Test that you cannot checkout without login in
    Given I am on the NopCommerce home page
    And I am not logged in
    When I Click on Computers link
    And I Click on Desktops link
    And I Click on "Build your own computer" link
    And I select "2 GB" of RAM and "32 GB" of HDD
    And I click on "Add to Cart" button
    And I click "Shopping Cart" link
    And I click on Agree to terms checkbox
    And I click on Checkout button
    Then "Welcome, Please Sign In!" page is displayed