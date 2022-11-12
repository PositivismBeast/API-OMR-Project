@Address
Feature: Address Module API automation

  Scenario Outline: Verify add user address to the application through API
    Given User Add Header and bearer authorization for accessing Address endpoints
    When User add request body for add new address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<address_type>"
    And User Send "POST" request for addUserAddress endpoint
    Then User verify the statusCode is 200
    Then User verify the addUserAddress response body message matches "Address added successfully" and get the AddressId Saved

    Examples: 
      | first_name  | last_name  | mobile     | apartment | state | city | country | zipcode | address | address_type |
      | Prabhakaran | Muthukumar | 9843588932 | Nest      |    35 | 3912 |     101 |  625107 | Madurai | TamilNadu    |

  Scenario Outline: Verify Update user address to the application through API
    Given User Add Header and bearer authorization for accessing Address endpoints
    When User add request body for Update user address "<address_id>", "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<address_type>"
    And User Send "PUT" request for updateUserAddress endpoint
    Then User verify the statusCode is 200
    Then User verify the updateUserAddress response body message matches "Address updated successfully"

    Examples: 
      | address_id | first_name  | last_name  | mobile     | apartment | state | city | country | zipcode | address | address_type |
      |      12345 | Prabhakaran | Muthukumar | 9843588932 | Nest      |    35 | 3912 |     101 |  625107 | Madurai | TamilNadu    |

  Scenario Outline: Verify Get user address from the application through API
    Given User Add Header and bearer authorization for accessing Address endpoints
    And User Send "GET" request for getUserAddress endpoint
    Then User verify the statusCode is 200
    Then User verify the getUserAddress response body message matches "OK"

  Scenario Outline: Verify delete user address from the application through API
    Given User Add Header and bearer authorization for accessing Address endpoints
    When User add request body for deleteAddress "<address_id>"
    And User Send "DELETE" request for deleteAddress endpoint
    Then User verify the statusCode is 200
    Then User verify the deleteAddress response body message matches "Address deleted successfully"

    Examples: 
      | address_id |
      |      12345 |
