Feature: Register Patient

  As a Patient
  I want to register
  So that I can access various Health services

  Background: The user navigates to Home Page
    Given user navigates to "https://gentle-mountain-53237.herokuapp.com/"

  @register_1
  Scenario: Register patient with valid data
    When user enters First Name as 'test'
    And user enters Last name as 'tester'
    And user enters Email as 'tester@gmail.com'
    And user enters Phone as '0757412563'
    And User enters Password as 'password123'
    And User Confirms Password as  'password123'
    And User clicks Register button
    Then user is directed to his/her dashboard

@register_2
  Scenario Outline: Check Mandatory fields validations
    When user enters First Name as '<first_name>'
    And user enters Last name as '<last_name>'
    And user enters Email as '<E-mail>'
    And user enters Phone as '<Phone>'
    And User enters Password as '<Password>'
    And User Confirms Password as  '<confirm Password>'
    And User clicks Register button
    Then user should see error message as '<error message>'

    Examples:
      |first_name|last_name|E-mail       |Phone     |Password |confirm Password|error message|
      |          |Jhonson  |abc@gmail.com|1234567890|c!ssj1123|c!ssj1123       |Please fill in this field|
      |Simon     |         |abc@gmail.com|1234567890|c!ssj1123|c!ssj1123       |Please fill in this field|
      |Simon     |Jhonson  |             |1234567890|c!ssj1123|c!ssj1123       |Please fill in this field|
      |Simon     |Jhonson  |abc@gmail.com|1234567890|         |c!ssj1123       |Password must be at least 6 characters long. Try again!|
      |Simon     |Jhonson  |abc@gmail.com|1234567890|c!ssj1123|                |Password must be at least 6 characters long. Try again!|

