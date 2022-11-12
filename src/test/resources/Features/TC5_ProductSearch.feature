@ProductSearch
Feature: Search Prouduct Api automation

  Scenario Outline: Verify Product Search from the application through API
    Given User Add Header for search product
    When User add request body for searchProduct "<text>"
    And User Send "POST" request for searchProduct endpoint
    Then User verify the statusCode is 200
    Then User verify the searchProduct response body message matches "OK"

    Examples: 
      | text |
      | nuts |
