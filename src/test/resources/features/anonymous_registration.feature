Feature: Registrer as customer
  
  As anonymous user 
  I want to be able to register as customer
  So I can be able to use the portal

  Scenario: access registration page
    Given logged in user with role "ANONYMOUS"
    When try to access "/registration" page
    Then user should be able to access the page
    And view "anonymous/registration" should be display
    And model with attribute "currencies" should be exist with the following values
      | USD |
      | EUR |
      | AUD |
      | AED |

  Scenario: register new customer
    Given logged in user with role "ANONYMOUS"
    And entered email is not exist
    And entered username is not exist
    And customer will be created with the following data
      | username | password                                                     | email     | full name |
      | test     | $2a$10$teJrCEnsxNT49ZpXU7n22O27aCGbVYYe/RG6/XxdWPJbOLZubLIi2 | test@test | test user |
    And account will be created with id "account" has "0.0" amount in "USD" currency
    And initial deposit should exchange as following
      | amount | currency |
      | 1000.0 | USD      |
    When try to submit to "/registration" with the following data
      | username             | test      |
      | password             |    123456 |
      | passwordConfirmation |    123456 |
      | email                | test@test |
      | fullName             | test user |
      | currency             | USD       |
    Then user should be able to access the page
    And view "anonymous/successful_registration" should be display    
    And Customer should be created with the following data
      | username | password                                                     | email     | full name | enabled | paypallets account id |
      | test     | $2a$10$teJrCEnsxNT49ZpXU7n22O27aCGbVYYe/RG6/XxdWPJbOLZubLIi2 | test@test | test user | true    | account               |
    And with authority "ROLE_CUSTOMER"
    And Account should be created in "USD" currency
    And initial deposit with amount "1000.0" should be exchange from "USD" currency to "USD" currency

  Scenario Outline: register new customer with invalid data
    Given logged in user with role "ANONYMOUS"
    And entered email is not exist
    And entered username is not exist
    When try to submit to "/registration" with the following data
      | username             | <username>              |
      | password             | <password>              |
      | passwordConfirmation | <password confirmation> |
      | email                | <email>                 |
      | fullName             | <full name>             |
      | currency             | <currency>              |
    Then user should be able to access the page
    And view "anonymous/registration" should be display       
    And model with attribute "currencies" should be exist with the following values
      | USD |
      | EUR |
      | AUD |
      | AED |
    But model should has 1 errors

    Examples: 
      | username | password | password confirmation | email     | full name | currency |
      |          |   123456 |                123456 | test@test | test user | USD      |
      | test     |          |                123456 | test@test | test user | USD      |
      | test     |   123456 |                       | test@test | test user | USD      |
      | test     |   123456 |                123456 |           | test user | USD      |
      | test     |   123456 |                123456 | test@test |           | USD      |
      | test     |   123456 |                123456 | test@test | test user |          |

  Scenario: register new customer with exist email
    Given logged in user with role "ANONYMOUS"
    And entered email is not exist
    And entered username is exist
    When try to submit to "/registration" with the following data
      | username             | test      |
      | password             |    123456 |
      | passwordConfirmation |    123456 |
      | email                | test@test |
      | fullName             | test user |
      | currency             | USD       |
    Then user should be able to access the page
    And view "anonymous/registration" should be display
    And model with attribute "currencies" should be exist with the following values
      | USD |
      | EUR |
      | AUD |
      | AED |
    But model should has 1 errors
  Scenario: register new customer with exist username
    Given logged in user with role "ANONYMOUS"
    And entered email is exist
    And entered username is not exist
    When try to submit to "/registration" with the following data
      | username             | test      |
      | password             |    123456 |
      | passwordConfirmation |    123456 |
      | email                | test@test |
      | fullName             | test user |
      | currency             | USD       |
    Then user should be able to access the page
    And view "anonymous/registration" should be display
    And model with attribute "currencies" should be exist with the following values
      | USD |
      | EUR |
      | AUD |
      | AED |
    But model should has 1 errors
