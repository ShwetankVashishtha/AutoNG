@AUT
Feature: Verify application launch, sign up and login

  @positive @mobile @sanity
  Scenario: Check app launch
    Given User launch app by tapping on app icon
    Then Application should be launched

  @positive @mobile @sanity
  Scenario: Check Accept and Continue button
    Given User launch app by tapping on app icon
    When User clicks on "AGREE AND CONTINUE" button
    Then User should be navigated to "Enter your phone number" screen