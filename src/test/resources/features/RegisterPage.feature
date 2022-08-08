Feature: Validate Register page

  Scenario: Validate Register of user with valid data
    Given user is on 'Register Page'
    Then all required elements are present on Register page
    When user populates fields with following data on Register page
      | firstName   | lastName    | email                 | password  | subscription |
      | testAvartic | testAvartic | testAvartic@test.test | Password1 | false        |
    And user click on Submit button from Register page
    Then user is redirected to 'Register Page'
    And user is saved in DB
