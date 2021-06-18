Feature: Book Appointment
  As a Registered Patient
  I want to book an appointment

  #Background: The user navigates to Home Page
   # Given user navigates to "https://gentle-mountain-53237.herokuapp.com/"

    @bookAppointment
  Scenario: Book Appointment successfully
    Given  User is on his dashboard
    When user clicks Book appointment link or Book appointment tab
    Then user is directed to create appointment page
    When user selects Specialization from the dropdown
    And  user selects Doctor name from the dropdown
    And user selects future date from the calendar
    And user selects appointment time from dropdown
    And user clicks Create new entry
    Then user receives an alert as 'Your appointment is successfully booked'

  Scenario: View Appointment history
    When user clicks Appointment History tab
    Then details of appointment booked 'Doctor Name', 'Appointment ID', 'Appointment Date','Appointment Time','Diseases','Allergies','Prescriptions','Bill Payment' should be displayed
