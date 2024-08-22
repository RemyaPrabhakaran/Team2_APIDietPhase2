
Feature: User Login 
  Admin logs in to the API without authorization
  
  Background:
  Given Admin sets the Authorization to no auth

  Scenario: Check user able to login as admin with valid data
	Given User creates Post request with request body.
	When User send login POST HTTP request with endpoint
	Then User recieves 200 created with response body
	