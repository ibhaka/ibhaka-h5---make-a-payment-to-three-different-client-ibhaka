
Feature: make a payment to three different client

  @payment
  Scenario Outline: make a payment
    Given  User login with username and password
    When   User makes payment with "<phone>" "<name>" "<amount>" "<client>"
    And User should see balance by "<amount>"
    Then User will logout
    Examples:

      | phone      | name | amount | client  |
      | 5555555555 | James| 10     | Iceland |
      | 5555555555 | Lars | 20     | USA     |
      | 5555555555 | Kirk | 30     | Norway  |




