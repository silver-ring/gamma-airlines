Feature: Access my tickets page
  
  As customer 
  I want to be able to access my tickets page
  So I see my purchased tickets

  Scenario: access my tickets page
    Given logged in user with role "CUSTOMER"
    And customer has tickets as following
      | id   | number of tickets | from city | to city | ticket price | currency | total amount |
      | 1001 |                 2 | cairo     | riyadh  |        100.0 | EUR      |        200.0 |
      | 1002 |                 1 | cairo     | dubai   |        200.0 | USD      |        200.0 |
    When try to access "/customer/mytickets" page
    Then user should be able to access the page
    And view "customer/my_tickets" should be display    
    And model with attribute "tickets" should be exist with the following values
      | order id | number of tickets | from  | to     | ticket price | price currency | total amount |
      |     1001 |                 2 | cairo | riyadh |        100.0 | EUR            |        200.0 |
      |     1002 |                 1 | cairo | dubai  |        200.0 | USD            |        200.0 |
