Feature: export purchasing order
  
  As customer 
  I want to be able to be able to export my purchasing order in pdf format
  So I can keep a pdf copy from my order

  Scenario: access my tickets page
    Given logged in user with role "CUSTOMER"
    And customer has purchasing order as following
      | id   | number of tickets | from city | to city | ticket price | currency | total amount | email     | full name     |
      | 1001 |                 2 | cairo     | riyadh  |        100.0 | EUR      |        200.0 | test@test | test customer |
    When try to access "/customer/purchase/export/pdf/1001" page
    Then user should be able to access the page
    And view "customer/purchsing_order_pdf" should be display
    And model with attribute "datasource" should be exist with the following values
      | order id | number of tickets | from  | to     | ticket price | currency | total amount | email     | full name     |
      |     1001 |                 2 | cairo | riyadh |        100.0 | EUR      |        200.0 | test@test | test customer |
    And should be exported in "pdf" format      
