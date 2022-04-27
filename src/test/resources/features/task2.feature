
@check_of_all_checkbox
Feature: Check of the website clickability parts

  Background: User is on the Main Page
    Given user goes to "mainPageUrl"

    @select_tv
Scenario: TC01_selected_tv
      When user clicks on the tv text
      Then user verifies the tv checkbox is selected
      And user clicks on the tv text
      Then user verifies the tv checkbox is deselected

  @select_console
  Scenario: TC02_selected_console
    When user clicks on the console text
    Then user verifies the console checkbox is selected
    And user clicks on the console text
    Then user verifies the console checkbox is deselected

  @select_smartphone
  Scenario: TC03_selected_smartphone
    When user clicks on the smartPhone text
    Then user verifies the smartPhone checkbox is selected
    And user clicks on the smartPhone text
    Then user verifies the smartPhone checkbox is deselected