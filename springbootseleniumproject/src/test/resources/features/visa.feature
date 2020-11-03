Feature: User Visa Registration feature
  @visa
    @regression
  Scenario Outline: I should be able to submit visa form
    Given I am on visa registration form
    When I select my from country "<fromCountry>" and to country "<toCountry>"
    And I enter my dob as "<dateOfBirth>"
    And I enter my name as "<firstName>" and "<lastName>"
    And I enter my contact details as "<email>" and "<phone>"
    And I enter the comment as "<comments>"
    And I submit he form
    Then I should get the confirmation number

    Examples:
    | fromCountry | toCountry | dateOfBirth | firstName | lastName  | email           | phone         | comments  |
    |Isle of Man  | Mali      |2011-05-31   |Kraig      |Wiza       |Kraig@nobody.com |1-000-884-1373 | comments 0|
    |Lithuania    |Mexico     |2001-01-01   |Houston    |Kertzmann  |Houston@nobody.com|284.864.6580  | comments 1|