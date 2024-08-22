
Feature: PUT (by dietician )
  Admin logs in to the API without authorization
  
  Background:
  Given User creates Post request with request body.
  When User send login POST HTTP request with endpoint
  Then Admin sets the bearer admin token


  Scenario Outline: Check admin able to update dietician with valid data , dietician id and token 
	Given Admin creates PUT request for the "<scenario>" 
	When Admin sends dietician PUT http request with endpoint for the "<scenario>" from the "<sheetName>" 
	Then Admin recieves the response with the "<StatusCode>"
	
	Examples:
	
	|scenario 						|	sheetName				| StatusCode	|
	|	WithallFields				| UpdateDietician	| 200					|
	| MandatoryFieldsOnly	|	UpdateDietician	| 200					|
	| InvalidData					|	UpdateDietician	|	400					|