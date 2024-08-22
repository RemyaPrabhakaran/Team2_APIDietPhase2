
Feature: Patient Post, Patient put add new reports, Get morbidity details, Get retrievePatient, delete
Background:
Given Set patient token
Scenario: Check patient able to create patient with valid data	

Given Patient creates POST request by entering valid data into the form-data key and value fields.	
When Patient sends POST http request with endpoint
Then Patient recieves 403 

Scenario: Check Patient able to add new reports for existing patient with valid data

Given Patient creates PUT request by entering valid data into the form-data key and value fields and valid patient ID
When Patient send PUT http request with endpoint
Then Paitent recieves 403 

Scenario: Check Patient able to retrieve patients morbidity details by patient ID
Given Patient create GET request
When Patient send GET http request with endpoint 
Then Patient recieves 200 

Scenario: Check Patient able to retrieve patients by field
Given Patient creates GET request no auth by fileId
When Patient send GET http request with endpoint for fileID
Then Patient recieves 200 


Scenario: Check Patient able to delete patient by ID
Given Patient create DELETE request
When Patient send DELETE http request with endpoint
Then Patient recieves 403 