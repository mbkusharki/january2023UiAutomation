Feature: Hover unto a main menu and select a submenu to get to the menu page
  @next
  Scenario: navigate to home furnishing Page
    Given I am on the next Landing  page
    When I navigate to the Home Furnishing Link
    Then the Home Furnishing page should be displayed