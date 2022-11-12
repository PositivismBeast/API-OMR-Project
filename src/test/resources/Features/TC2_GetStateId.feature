@GetStateId
Feature: Get the StateId of TN

  Scenario: Get User StateId from stateList endpoint
  Given User Add Header to get StateList Details
  When User Send "GET" request for stateList endpoint
  Then User verify the statusCode is 200
  Then User verify the stateList response body StateName present as "Tamil Nadu" and get the StateId Saved
