Feature: register

  Scenario: Fail to register with email only
    Given I set email for registration - "challenge@automation.com"
    Then I validate my register response is incorrect