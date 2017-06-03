Feature: Show All Purchasing Orders
  As Admin
  I want to show all purchasing orders
  So that i can manage gamma airlines purchased orders

  Scenario: Login admin try to access home page
    Given logged in user with role "ADMIN"
    And the following purchasing orders had been recorded
      | id   | from city | to city | ticket price | currency | number of tickets | total amount |
      | 1001 | cairo     | dubia   |          100 | USD      |                 1 |          100 |
      | 1002 | dubia     | cairo   |          100 | USD      |                 2 |          200 |
    When try to access "/admin/orders" page
    Then user should be able to access the page
    And view "admin/purchasing_orders" should be display
    And purchasing orders should be fetched
    And model with attribute "orders" should be exist with the following values
      | order id | from  | to    | ticket price | price currency | number of tickets | total amount |
      |     1001 | cairo | dubia |          100 | USD            |                 1 |          100 |
      |     1002 | dubia | cairo |          100 | USD            |                 2 |          200 |
