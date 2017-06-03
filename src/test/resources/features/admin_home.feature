Feature: Access Admin Home Page 
  As Admin
  I want to access my home page
  So that i can manage gamma airlines portal

  Scenario: Login admin try to access home page
    Given logged in user with role "ADMIN"
    When try to access "/admin/home" page
    Then user should be able to access the page
    And view "admin/home" should be display
