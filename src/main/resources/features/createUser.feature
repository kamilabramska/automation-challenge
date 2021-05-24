Feature: createUser

  Scenario: Create user Toy with job singer
    Given I use user creation service
    When I set name "Toy"
    When I set job "singer"
    Then I validate my POST response is correct