
Feature: Admin does all the operations patient bearer token
  Admin tries to do all the operations with patient token
  
  Background:
  Given User creates Post request with request body.
	When User send login POST HTTP request with endpoint
	Then User recieves 200 created with response body and sets patient bearer token
 
  
  Scenario: Check admin able to create dietician with valid data and dietician token
  Given Admin creates POST request with valid data 
  When Admin send POST http request with patient token
  Then Admin recieves a 403 forbidden
  
  Scenario: Check admin able to update dietician with valid data , dietician id and patient token
  Given Admin creates PUT request with valid data
  When Admin send PUT http request with endpoint with patient token
  Then Admin recieves a 403 forbidden
  
  