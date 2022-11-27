@regression
Feature: ApiDemos app usage
  As a mobile user,
  I want to use the app,
  So I can have a great experience.

  Scenario: Add Log/TextBox successfully
    Given I open the Log-TextBox screen
    When I click the Add button
    Then the Log view display "This is a test"