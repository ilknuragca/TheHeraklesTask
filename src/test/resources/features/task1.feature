
@check_of_the_list
  Feature: Give List of Integers and remove all values greater than 100

    Scenario Outline: Remove all values greater than 100 from a List
      Given user gives "<list>"
      When removes elements greater than 100 using
      Then then verifies check the list of Integer

      Examples:
      |list|
      |5,10,200,55,214|
      |15,459,78,145,568,20,96|
      |123,98,987,45,85,12,321,147|
