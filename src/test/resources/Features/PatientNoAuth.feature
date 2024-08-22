
Feature: Patient Post, Patient put add new reports, Get morbidity details, Get retrievePatient, delete
Background:
Given Set no auth
Scenario: Check dietician able to create patient with valid data	

Given Dietician creates POST request by entering valid data into the form-data key and value fields.	
When Dietician send POST http request with endpoint	no auth
Then Dietician recieves 401 unauthorized

Scenario: Check dietician able to add new reports for existing patient with valid data

Given Dietician creates PUT request by entering valid data into the form-data key and value fields and valid patient ID
When Dietician send PUT http request with endpoint no auth
Then Dietician recieves 401 unauthorized

Scenario: Check dietician able to retrieve patients morbidity details by patient ID
Given Dietician create GET request no auth
When Dietician send GET http request with endpoint no auth
Then Dietician recieves 401 unauthorized

Scenario: Check dietician able to retrieve patients by field
Given Dietician create GET request no auth by fileId
When Dietician send GET http request with endpoint no auth for fileID
Then Dietician recieves 401 unauthorized


Scenario: Check dietician able to delete patient by ID
Given Dietician create DELETE request for no auth
When Dietician send DELETE http request with endpoint no auth
Then Dietician recieves 401 unauthorized