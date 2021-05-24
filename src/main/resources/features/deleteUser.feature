Feature: deleteUser

  Scenario: Delete user 2
    Given I set user for deletion - "2"
    Then I validate my DELETE response is correct