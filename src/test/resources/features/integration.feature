Feature: integrate with external system
  As gamma airline portal
  I want to be able to integrate with external system
  So i can be able to serve portal users

  Scenario: Buy two tickets from london to madrid
    Given clean api
    And tickets with the following data
      | account id | number of tickets | from   | to     |
      | account1   |                 2 | London | Madrid |
    When try to call buy ticket service
    Then should recive the follwoing data
      | from   | to     | number of tickets | price | currency |
      | London | Madrid |                 2 | 100.0 | EUR      |
