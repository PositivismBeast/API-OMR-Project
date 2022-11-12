@ChangeProfilePic
Feature: Change Profile Picture Api automation

  Scenario Outline: Verify Change Profile Picture for the application through API
    Given User Add Header for change profile picture
    When User add formData to insert Picture 
    And User send "POST" request for changeProfilePic endPoint
    Then User verify the statusCode is 200
    Then User verify the changeProfilePic response message matches "Profile updated Successfully"
    
