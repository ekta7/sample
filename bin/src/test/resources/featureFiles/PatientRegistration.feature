Feature: Register Patient

  As a Patient
  I want to register
  So that I can access various Health services

  Background: The user navigates to Home Page
    Given user navigates to "https://gentle-mountain-53237.herokuapp.com/"

  @register_1
  Scenario: Register patient with valid data
    When user enters First Name as 'Ashish'
    And user enters Last name as 'Goel'
    And user enters Email as 'abc@gmail.com'
    And user enters Phone as '0757412563'
    And User enters Password as 'Password123'
    And User Confirms Password as  'Password123'
    And User clicks Register button
    Then user is directed to his/her dashboard
    And user can see his/her name on dashboard
