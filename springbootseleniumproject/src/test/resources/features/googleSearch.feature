Feature: Google Search
  Scenario Outline: I want to search on google sit
    Given I am on the google site
    When I enter "<keyword>" as a keyword
    And And I click on search button
    Then I should see at least <count> results

    Examples:
    | keyword   | count |
    | spring    | 2     |
    | google    | 4     |
