Feature: Validate Register page

  Scenario: Validate Register of user with valid data
    Given user is on 'Register Page'
    Then all required elements are present on Register page
    When user populates fields with following data on Register page
      | First Name Input | testAvartic           |
      | Last Name Input  | testAvartic           |
      | Email Input      | testAvartic@test.test |
      | Password Input   | Password1             |
    And user click on Submit button from Register page
    Then user is redirected to 'Register Page'
