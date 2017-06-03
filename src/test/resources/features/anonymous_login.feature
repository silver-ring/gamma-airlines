Feature: Access Portal Home Page
  
  As a portal user 
  I want to be able to access gamma airlines portal
  So I can use the portal

  Scenario: access portal as anonymous
    Given logged in user with role "ANONYMOUS"
    When try to access "/home" page
    Then view "/anonymous/login" should be display

  Scenario: access portal as customer
    Given logged in user with role "CUSTOMER"
    When try to access "/home" page    
    Then should be redirected to "/customer/home"
    And url should be found

  Scenario: access portal as admin
    Given logged in user with role "ADMIN"
    When try to access "/home" page    
    Then should be redirected to "/admin/home"
    And url should be found
