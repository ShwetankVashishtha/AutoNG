@AUT
Feature: Verify Admin panel scenarios

  Background: login to application
    Given user is redirected to login url
    When user enters username "Admin" and password "admin123"
    And user clicks on login button

  @positive @web @sanity
  Scenario: Check role search functionality
    And user redirects to Admin from side nav menu
    And user selects user role as admin

  @positive @web @sanity
  Scenario: Check footer text and link
    And user redirects to Admin from side nav menu
    And user scrolls down to the bottom of the page
    Then user should be able to view copyright text on footer note
    And user should be able to click on web link on footer note

  @positive @web @sanity
  Scenario: Check context click & hover functionality
    And user redirects to Admin from side nav menu
    And user mouse hover search button
    And user right click on mouse to open context menu
