
Feature: Get Operation [Get all Patients]
Background: Set dietician token


Scenario: Check dietician able to retrieve all patients
Given Dietician create GET request 
When Dietician send GET http request with endpoint
Then Dietician get 200 with response body

Scenario: Check dietician able to retrieve all patient with invalid method
Given Dietician create PUT request 
When Dietician send PUT http request with invalid method with endpoint
Then Dietician get 405 with response body


Scenario: Check dietician able to retrieve all patient with invalid endpoint
Given Dietician create GET request
When Dietician send GET http request with invalid endpoint
Then Dietician get 404 with response body