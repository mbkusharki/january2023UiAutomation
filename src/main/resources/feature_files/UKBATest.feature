Feature: UKBATest

  Scenario Outline:  Country and Study using Scenario Outline
    Given I am on "https://www.gov.uk/check-uk-visa/y"
    When I provide nationality of "<CountryName>"
    And I click on Continue button
    And I select reason as "Study"
    And I click on Continue button
    And I state that I intend to stay for more than 6 months
    And I click on Continue button
    Then I should be informed that "<Decision>"
    Examples:
      |CountryName  |Decision|
    |Japan        |You’ll need a visa to study in the UK|
    |Ukraine      |You’ll need a visa to study in the UK|
    |Morocco      |You’ll need a visa to study in the UK|
    |USA          |You’ll need a visa to study in the UK|
    |Canada       |You’ll need a visa to study in the UK|
    |Australia    |You’ll need a visa to study in the UK|

  Scenario Outline:Country (A) and Tourism
    Given I am on "https://www.gov.uk/check-uk-visa/y"
    When I provide nationality of "<cName>"
    And I click on Continue button
    And I select reason for travel as "<Reason>"
    And I click on Continue button
    Then I should get the message as that "<DecisionTaken>"
    Examples:
      |cName  |DecisionTaken|Reason|
      |Japan        |You will not need a visa to come to the UK|Tourism|
      |USA          |You will not need a visa to come to the UK |Tourism|
      |Malaysia     |You will not need a visa to come to the UK|Tourism|
      |Canada       |You will not need a visa to come to the UK|Tourism|
      |Australia    |You will not need a visa to come to the UK |Tourism|
      |South Korea  |You will not need a visa to come to the UK |Tourism|

  @UKBATest
  Scenario Outline:Country (B) and Tourism
    Given I am on "https://www.gov.uk/check-uk-visa/y"
    When I provide nationality of "<NameofCountry>"
    And I click on Continue button
    And I select reason for travel as "<ReasonTrip>"
    And I click on Continue button
    And I state I am not travelling or visiting a partner or family
    And I click on Continue button
    Then I should get informed that "<DecisionT>"
    Examples:
      |NameofCountry  |DecisionT|ReasonTrip|
      |Russia        |You’ll need a visa to come to the UK|Tourism|
      |Cuba          |You’ll need a visa to come to the UK |Tourism|
      |Belarus     |You’ll need a visa to come to the UK|Tourism|
      |Albania       |You’ll need a visa to come to the UK|Tourism|
      |Nigeria    |You’ll need a visa to come to the UK |Tourism|
      |Angola  |You’ll need a visa to come to the UK |Tourism|
