@AUT
Feature: Verify Users Rest API Responses

  @positive @api @sanity
  Scenario: Add Test Result
    When user executes post call to add test result
    Then user should be able to receive a valid response