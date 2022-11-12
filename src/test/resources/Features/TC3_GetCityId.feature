@GetCityId
Feature: Get the CityId of Madurai

  Scenario Outline: Get User CityId from CityList endpoint
    Given User Add Header to get CityList Details
    When User add request body for add "<state_id>"
    And User Send "POST" request for CityList endpoint
    Then User verify the statusCode is 200
    Then User verify the CityList response body CityName present as "Madurai" and get the CityId Saved

    Examples: 
      | state_id |
      |       35 |
