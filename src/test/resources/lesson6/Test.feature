Feature: Simple Cucumber test

  Scenario: Login verification
    Given I open EPAM JDI site
    When I login as user 'epam' with password '1234'
    Then User name should be 'PITER CHAILOVSKII'