Feature: Search in google

  Scenario: Search phrase in google
    Given Google page is open
    When I search for "xd"
    Then Search results should appear

#  Scenario: Open search result
#    Given Google page is open
#    When I search for "google"
#    And I click on second link
#    Then Google main page should open