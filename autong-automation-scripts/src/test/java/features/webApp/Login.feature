@login
Feature: Verify login and dashboard scenarios

  Background: login to application
    Given user is redirected to login url

  @positive @web @sanity
  Scenario: Check login functionality
    When user enters username "Admin" and password "admin123"
    And user clicks on login button
    Then user should be logged in successfully