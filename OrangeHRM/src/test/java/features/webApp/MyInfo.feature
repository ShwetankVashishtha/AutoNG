@AUT
Feature: Verify profile scenarios

  Background: login to application
    Given user is redirected to login url
    When user enters username "Admin" and password "admin123"
    And user clicks on login button

  @positive @web @sanity
  Scenario: Check login functionality
    Then user should be logged in successfully

  @positive @web @sanity
  Scenario: Check upload attachment functionality
    And user redirects to My Info from side nav menu
    And user clicks on Add attachment button
    And user uploads an attachment successfully