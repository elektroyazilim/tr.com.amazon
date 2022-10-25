Feature: The user controls some components on the main page.

  Background: Amazon homepage should be accesable.
    Given the user navigates to "/"
    Then the user verifies if the url contains "amazon.com"
    Then the user verifies if the logo link contains "amazon.com"
    Then the user checks if Orders link is enable
    When the user accepts the cookie

  @US001_TC_001
  Scenario: TC_001 User checks components on the menu on the header
    And the the user hover Accounts section
    Then the user verifies if Sign in popup is open
    Then the user verifies if links on the popup are enabled

# 1. US_Kullanıcı anasayfa üzerinde bazı kontrolleri test eder
#

#
#
#TC_001 User checks components on the menu on the header
#    Given the user navigates to "/"
#    Then the user checks if the url contains "amazon.com"
#    Then the user checks if the logo link contains "amazon.com"
#    Then the user checks if Orders link is enable
#    When the the user hover Accounts section
#    # nav-al-container :
#    Then the user checks the if Sign in popup is open
#    Then the user checks if links on the popup are enabled