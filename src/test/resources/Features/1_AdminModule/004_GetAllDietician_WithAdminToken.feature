
Feature: GET (All dietician)
  Admin get the details of all the dieticians
  
  Background:
 	Given User creates Post request with request body.
	When User send login POST HTTP request with endpoint
	Then User recieves 200 created with response body


  Scenario: Check admin able to retrieve all dietician
	Given Admin create GET request 
	When Admin sends the GET http request with endpoint
	Then Admin recieves the response with the status code 200 for the get dietician

	
	 Scenario: Check admin able to retrieve all dietician with invalid method
	Given Admin create PUT request for get HTTP request
	When Admin send PUT http request with get request endpoint
	Then Admin recieves 405 method not allowed
	
		 Scenario: Check admin able to retrieve all dietician with invalid endpoint
	Given Admin create GET request
	When Admin send GET http request with invalid endpoint for get dietician
	Then Admin recieves 404 not found