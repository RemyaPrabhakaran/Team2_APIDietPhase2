Feature: Patient Post, Patient put add new reports, Get morbidity details, Get retrievePatient, delete
Background:
Given Set admin token
Scenario: Check admin able to create patient with valid data	

Given Admin creates POST request by entering valid data into the form-data key and value fields.	
When Admin sends POST http request with endpoint with admin token
Then Admin recieves 403 forbidden

Scenario: Check admin able to add new reports for existing patient with valid data

Given Admin creates PUT request by entering valid data into the form-data key and value fields and valid patient ID
When Admin sends PUT http request with endpoint
Then Admin recieves 403 forbidden

Scenario: Check admin able to retrieve patients morbidity details by patient ID
Given Admin creates GET request
When Admin send GET http request with endpoint
Then Admin recieves 403 forbidden

Scenario: Check admin able to retrieve patients by field
Given Admin create GET request by fileId
When Admin send GET http request with endpoint for fileID
Then Admin recieves 403 forbidden


Scenario: Check admin able to delete patient by ID
Given Admin create DELETE request
When Admin send DELETE http request with endpoint
Then Admin recieves 403 forbidden