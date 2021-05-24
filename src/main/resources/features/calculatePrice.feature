Feature: calculatePrice

  Scenario: Calculate the price of a full special support plan for 6 months
    Given I open Chrome and launch the application
    When I select type "Special"
    When I select support plan "Full"
    When I write monthly duration of "6"
    When I click on calculate price button
    Then I validate price is "2299.10 $"