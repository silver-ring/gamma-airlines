Feature: Show All Registered Customers
  As Admin user
  I want to be able to list all registered customers
  So that i can manage the customers

  Scenario: Login admin try to access customers page
    Given there is registered customers as following
      | username | email | full name      | paypallets account id |
      | user1    | test1 | test customer1 | account1              |
      | user2    | test2 | test customer2 | account2              |
    And logged in user with role "ADMIN"
    When try to access "/admin/customers" page
    Then user should be able to access the page
    And view "admin/customers" should be display
    And customers should be fetched
    And model with attribute "customers" should be exist with the following values
      | email | full name      | paypallets account id |
      | test1 | test customer1 | account1              |
      | test2 | test customer2 | account2              |      
