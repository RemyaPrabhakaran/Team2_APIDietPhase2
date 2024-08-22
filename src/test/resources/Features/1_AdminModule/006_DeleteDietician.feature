
Feature: DELETE ( by dietician)
  Admin deletes dietician by ID with admin token
  
  Background:
 	Given User creates Post request with request body.
	When User send login POST HTTP request with endpoint
	Then User recieves 200 created with response body


  Scenario: Check admin able to delete dietician by ID	
	Given Admin create DELETE request for deleting the dietician
	When Admin send DELETE http request with delete endpoint
	Then Admin recieves 200 ok message with successful delete message

	
	 Scenario: Check admin able to delete dietician by id with invalid method
	Given Admin create POST request for deleting the dietician
	When Admin send POST http request with endpoint
	Then Admin recieves 405 method not allowed for the delete request
	
	Scenario Outline: Check admin able to delete dietician by invalid id
	Given Admin create DELETE request for deleting the dietician
	When Admin send Delete http request with endpoint for deleting the dietician by "<InvaliDieticianID>"
	Then Admin recieves 404 not found for the the delete request
	
	Examples:
	| InvaliDieticianID |
	| 0850384|
	| Reshma |
	| 9834*$ |

	
	
	 Scenario: Check admin able to delete dietician by id with invalid endpoint
	Given Admin create DELETE request for deleting the dietician
	When Admin send DELETE http request with invalid endpoint
	Then Admin recieves 404 not found for the the delete request