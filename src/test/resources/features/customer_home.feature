Feature: Access customer home page
  
  As customer 
  I want to be able to access my home page
  So I can be able to use the portal

  Scenario: access home page
    Given logged in user with role "CUSTOMER"
    And available airline offers as following
      | from  | to     | amount | currency |
      | cairo | riyadh |  100.0 | EUR      |
      | cairo | dubai  |  200.0 | USD      |
    When try to access "/customer/home" page
    Then user should be able to access the page
    And view "customer/home" should be display
    And airline offers should be fetched
    And model with attribute "offers" should be exist with the following values
      | from  | to     | price | price currency |
      | cairo | riyadh | 100.0 | EUR            |
      | cairo | dubai  | 200.0 | USD            |    
