
Feature: GET ( by dietician)
  Admin retrieves dietician by ID with admin token
  
  Background:
 	Given User creates Post request with request body.
	When User send login POST HTTP request with endpoint
	Then User recieves 200 created with response body


  Scenario: Check admin able to retrieve dietician by ID
	Given Admin create GET request for get dietician by ID
	When Admin send GET http request with endpoint for get dietician by ID
	Then Admin recieves 200 ok with details of the dietician id

	
	 Scenario: Check admin able to retrieve dietician by id with invalid method
	Given Admin create GET request for get dietician by ID
	When Admin send POST http request with endpoint of the get dietician by ID
	Then Admin recieves 405 method not allowed for the get dietician by ID
	
	Scenario Outline: Check admin able to retrieve dietician by invalid id
	Given Admin create GET request for get dietician by ID
	When Admin send GET http request with endpoint for get dietician by "<InvaliDieticianID>"
	Then Admin recieves 404 not found for the get dietician by ID
	
	Examples:
	| InvaliDieticianID |
	| 0850384|
	| Reshma |
	| 9834*$ |

	
	
	 Scenario: Check admin able to retrieve dietician by id with invalid endpoint
	Given Admin create GET request for get dietician by ID
	When Admin send GET http request with invalid endpoint
	Then Admin recieves 404 not found for the get dietician by ID