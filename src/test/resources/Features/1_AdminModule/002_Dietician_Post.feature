
Feature: PUT (by dietician )
  Admin logs in to the API without authorization
  
  Background:
  Given User creates Post request with request body.
	 When User send login POST HTTP request with endpoint
  Then Admin sets the bearer admin token for the Post request


  Scenario Outline: Check admin able to create dietician with the valid data and  valid token
	Given Admin creates Post request for the "<scenario>" 
	When Admin sends dietician POST http request with endpoint for the "<scenario>" from the "<sheetName>" 
	Then Admin recieves the response with the "<statusCode>"
	
	Examples:
	
	|scenario 												|	sheetName				| statusCode|
	|PostDieticianInvalidData1				|PostDietician		| 400				|
	|PostDieticianPositive						|PostDietician		|	201				|
	