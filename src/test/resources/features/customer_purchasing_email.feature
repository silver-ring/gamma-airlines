Feature: email purchasing order
  
  As customer 
  I want to be able to be able to send my purchasing order to my email
  So I can keep a email copy from my order

  Scenario: send purchasing order to email
    Given logged in user with role "CUSTOMER"
    And customer with the following data
      | full name     | paypallets account id | email     |
      | test customer | account               | test@test |
    And customer has purchasing order as following
      | id   | number of tickets | from city | to city | ticket price | currency | total amount | email     | full name     |
      | 1001 |                 2 | cairo     | riyadh  |        100.0 | EUR      |        200.0 | test@test | test customer |
    When try to access "/customer/purchase/email/1001" page
    Then user should be able to access the page with no content    
		And email should be sended
    
    