Feature: purchase new ticket
  
  As customer 
  I want to be able to purchase new ticket
  So I can travel

  Scenario: access purchase ticket page
    Given logged in user with role "CUSTOMER"
    And customer with the following data
      | full name     | paypallets account id |
      | test customer | account               |
    And available airline offers as following
      | from  | to     | amount | currency |
      | cairo | riyadh |  100.0 | EUR      |
      | cairo | dubai  |  200.0 | USD      |
    When try to access "/customer/purchase/cairo/riyadh" page
    Then user should be able to access the page
    And view "customer/purchasing" should be display
    And model with attribute "purchasingDetails" should be exist with the following values
      | full name     | from  | to     | ticket price | currency | paypallets account id |
      | test customer | cairo | riyadh |        100.0 | EUR      | account               |

  Scenario: purchase ticket
    Given logged in user with role "CUSTOMER"
    And customer with the following data
      | full name     | paypallets account id |
      | test customer | account               |
    And available airline offers as following
      | from  | to     | amount | currency |
      | cairo | riyadh |  100.0 | EUR      |
      | cairo | dubai  |  200.0 | USD      |
    And created order should be as following
      | number of tickets | from  | to     | price | currency |
      |                 2 | cairo | riyadh | 100.0 | EUR      |
    And created purchasing order for customer named "test customer" as following
      | id   | from  city | to     city | ticket price | currency | number of tickets | total amount |
      | 1001 | cairo      | riyadh      |        100.0 | EUR      |                 2 |        200.0 |
    When try to submit to "/customer/purchase/cairo/riyadh" with the following data
      | numberOfTickets | 2 |
    Then user should be able to access the page
    And view "customer/purchasing_order_summary" should be display
    And model with attribute "purchasingOrderSummary" should be exist with the following values
      | order id | full name     | from  | to     | ticket price | currency | number of tickets | total amount |
      |     1001 | test customer | cairo | riyadh |        100.0 | EUR      |                 2 |        200.0 |

  Scenario: purchase ticket when there is no fund
    Given logged in user with role "CUSTOMER"
    And customer with the following data
      | full name     | paypallets account id |
      | test customer | account               |
    And available airline offers as following
      | from  | to     | amount | currency |
      | cairo | riyadh |  100.0 | EUR      |
      | cairo | dubai  |  200.0 | USD      |
    And created order should be as following will return error
    When try to submit to "/customer/purchase/cairo/riyadh" with the following data
      | numberOfTickets | 2 |
    Then user should be able to access the page with bad request
    And view "/error" should be display
    But model should have error message "You do not have enough funds in your account"
