
Feature: Set Admin bearer
Background: Set admin bearer token

Scenario: Check admin able to create patient with valid data and admin token	
Given Admin creates POST request by entering valid data into the form-data key and value fields.	
When  Admin send POST http request with admin token with endpoint	
Then  Admin recieves 403 forbidden

Scenario: Check admin able to update patient with valid data and admin token	
Given Admin creates PUT request by entering valid data into the form-data key and value fields.	
When  Admin send PUT http request with admin token with endpoint	
Then  Admin recieves 403 forbidden

Scenario: Check admin able to add new reports for existing patient with valid data and admin token
Given Admin creates PUT request by entering valid data into the form-data key and value fields and valid patient ID
When  Admin send PUT http request with admin token with endpoint
Then  Admin recieves 403 forbidden

#	Scenario: Check admin is able to retrieve patients morbidity details by patient ID
#Given Admin creates PUT request by entering valid data into the form-data key and value fields and valid patient ID
#When  Admin send Put http request with admin token with endpoint
#Then  Admin recieves 403 Forbidden

#	Scenario: Check admin is able to retrieve patients morbidity details by patient ID
#Given Admin create GET request
#When  Admin send GET http request with admin token with endpoint
#Then  Admin recieves 403 Forbidden 
 

	Scenario: Check admin is able to retrieve patients morbidity details by patient ID
Given Admin create GET request 
When  admin send GET http request with admin token with endpoint
Then  Admin recieves 403 forbidden

	



	 		

				 		
			
