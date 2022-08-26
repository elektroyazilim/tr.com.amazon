Feature: The user controls some components on the main page.
  @hata
  Scenario: TC_001 User checks components on the menu on the header
    Given the user navigates to "/"
    Then the user checks if the url contains "amazon.com"
    Then the user checks if the logo link contains "amazon.com"
    Then the user checks if Orders link is enable
    When the user accepts the cookie
    And the the user hover Accounts section
    Then the user checks the if Sign in popup is open
    Then the user checks if links on the popup are enabled