
Feature: PUT (by dietician )
  Admin logs in to the API without authorization
  
  Background:
  Given Admin is logged in with valid credentials
  Then Admin sets the bearer admin token


  Scenario: Check admin able to update dietician with valid data , dietician id and token 
	Given Admin creates PUT request with valid data. ( Mandatory and additional details)
	When Admin send PUT http request with endpoint
	Then Admin recieves 200 ok and with updated response body. 
	
	Scenario: Check admin able to update dietician only with valid mandatory details and dietician id
	Given Admin creates PUT request only with valid mandatory details
	When Admin send PUT http request with endpoint
	Then Admin recieves 200 ok and with updated response body. 
	
		Scenario: Check admin able to update dietician only with valid additional details
	Given Admin creates PUT request only with valid additional details
	When Admin send PUT http request with endpoint
	Then Admin recieves 400 Bad request
	
		Scenario: Check admin able to update dietician with invalid data and dietician id
	Given Admin creates PUT request only with invalid additional details
	When Admin send PUT http request with endpoint
	Then Admin recieves 400 Bad request
	
	Scenario: Check admin able to update dietician with valid data and invalid dietician id
	Given Admin creates PUT request only with valid mandatory details
	When Admin send PUT http request with endpoint
	Then Admin recieves 400 Bad request
	
		Scenario: Check admin able to update dietician with valid data, dietician id and invalid method
	Given Admin creates POST request only with valid details
	When Admin send POST http request with endpoint
	Then Admin recieves 405 method not allowed
	
		Scenario: Check admin able to update dietician with valid data, dietician id and invalid endpoint
	Given Admin creates PUT request with valid data
	When Admin sent PUT http request with invalid endpoint
	Then Admin recieves 404 not found
	
	Scenario: Check admin able to update dietician with valid data, dietician id and invalid content type
	Given Admin creates PUT request with valid data and invalid content type
	When Admin send PUT http request with endpoint
	Then Admin recieves 415 unsupported media type
	