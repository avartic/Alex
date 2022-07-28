Feature: Validate Login page

  Scenario: Validate login page with valid data
    Given user is on 'Login Page'
    Then all required elements are present on Login page
    When user populates fields with following data on Login page
      | Email Input    | testAvartic@test.test |
      | Password Input | Password1             |
    And user click on Submit button from Login page
    Then user is redirected to 'Login Page'
