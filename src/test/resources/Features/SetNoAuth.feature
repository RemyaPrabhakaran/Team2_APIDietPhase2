Feature: Post Operation  Put Operation 
Get Operation [Get all Patients ]Get Operation [Retrieve Patient file by FileId ]
DELETE ( by patient)
Background: Set no auth

#Scenario: Check dietician able to create,update,delete,add patient with valid data
#
#Given Dietician creates POST request by entering valid data into the form-data key and value fields.
#Given Dietician creates PUT request by entering valid data into the form-data key and value fields.
#Given Dietician creates PUT request by entering valid data into the form-data key and value fields and valid patient ID
#Given Dietician create GET request 
#Given Dietician create GET request 
#Given Dietician create GET request 
#Given Dietician create DELETE request 
#
#When Dietician send POST http request with endpoint
#When Dietician send POST http request with endpoin
#When Dietician send PUT http request with endpoint without authprization 
#When Dietician send GET http request with endpoint
#When Dietician send GET http request with endpoint
#When Dietician send GET http request with endpoint
#
#When  Dietician send DELETE http request with endpoint
#Then Dietician recieves 401 unauthorized


Scenario: Check dietician able to create patient with valid data	
Given Dietician creates POST request  by entering valid data into the form-data key and value fields without token.	
When Dietician send POST http request without token with endpoint	
Then Dietician recieves 401 unauthorized

Scenario: Check dietician able to update patient with valid data	
Given Dietician creates PUT request by entering valid data into the form-data key and value fields without token.
When Dietician send PUT http request without token with endpoint	
Then Dietician recieves 401 unauthorized


Scenario: Check dietician able to add new reports for existing patient with valid data	
Given Dietician creates PUT request by entering valid data into the form-data key and value fields and valid patient ID without token
When Dietician send PUT http request without token with endpoint	
Then Dietician recieves 401 unauthorized


Scenario: Check dietician able to retrieve all patients	
Given Dietician create GET request without token	
When Dietician send GET http request without token with endpoint	
Then Dietician recieves 401 unauthorized


Scenario: Check dietician able to retrieve patients morbidity details by patient ID	
Given Dietician create GET request 	
When Dietician send GET http request without token with endpoint	
Then Dietician recieves 401 unauthorized


Scenario: Check dietician able to retrieve patients by field	
Given Dietician create GET request 	
When Dietician send GET http request without token with endpoint	
Then Dietician recieves 401 unauthorized


Scenario: Check dietician able to delete patient by ID	
Given Dietician create DELETE request without token	
When Dietician send DELETE http request without token with endpoint	
Then Dietician recieves 401 unauthorized




