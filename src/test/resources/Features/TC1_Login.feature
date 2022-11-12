@Login
Feature: Login Module API automation

  Scenario: Get User logtoken from login endpoint
  Given User Add Header
  When User Add Basic Authentication for login
  And User Send "POST" request for login endpoint
  Then User verify the statusCode is 200
  Then User verify the login response body First Name present as "Prabhakaran" and get the logtoken saved 
