
Feature: Checking all the requests with no auth
  Admin check all the requests with no Auth in the header
  
  Background:Set no auth
 
  Scenario: Check admin able to create dietician with valid data
	Given Admin creates request with valid data with no auth
	When Admin send POST http request with endpoint with no auth
	Then Admin recieves 401 unauthorized

	
	 Scenario: Check admin able to retrieve all dietician in get all request
	Given Admin creates request with valid data with no auth
	When Admin send GET http request with get endpoint
	Then Admin recieves 401 unauthorized
	
	Scenario: Check admin able to retrieve dietician by ID with no auth
	Given Admin creates request with valid data with no auth
	When Admin send GET http request with endpoint
	Then Admin recieves 401 unauthorized
	
	
	 Scenario: Check admin able to update dietician with valid data and dietician id without authorization
	Given Admin creates request with valid data with no auth
	When Admin send PUT http request with endpoint
	Then Admin recieves 401 unauthorized
	
	 Scenario: Check admin able to delete dietician by ID without authorization
	Given Admin creates request with valid data with no auth
	When Admin send DELETE http request with endpoint with no auth
	Then Admin recieves 401 unauthorized
	