
@check_of_checkbox_with_cucumber_data_table
  Feature: Check of the website clickability parts with Cucumber Data Table





    Scenario: Task2 is solving with Data Table
      Given user goes to "mainPageUrl"
      When user clicks on checkbox and verifies_checkbox is selected

      |checkbox_location|verifies_checkbox|
      |cbTV             |TV               |
      |cbConsole        |Console          |
      |cbSmartPhone     |Smart Phone      |

