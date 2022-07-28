Feature: Validate Home page

  Scenario: Validate My Account from home page
    Given user is on 'Home Page'
    When user click on 'My Account'
    Then 'Login' button is displayed
    And 'Register' button is displayed
    When user click on 'Login'
    Then user is redirected to 'Login page'
    When user click on 'My Account'
    When user click on 'Register'
    When user is redirected to 'Register page'
