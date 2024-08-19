Feature: Get Operation [Get all Patients]
Background: Set dietician token


Scenario: Check dietician able to retrieve patients morbidity details by patient ID
Given Dietician create GET request 
When Dietician send GET http request with morbidity details by patient ID endpoint
Then Dietician gets 200 with response body

Scenario: Check dietician able to retrieve patients morbidity details by patient ID with invalid method
Given Dietician create POST request 
When Dietician send POST http request with endpoint
Then Dietician recieves 405 method not allowed

Scenario: Check dietician able to retrieve patients morbidity details by invalid patient ID
Given Dietician create GET request 
When Dietician send GET http request with morbidity details by invalid patient ID endpoint
Then Dietician gets 404 not found


Scenario: Check dietician able to retrieve patients morbidity details by patient ID with invalid endpoint
Given Dietician create GET request
When Dietician send Get http request with invalid endpoint
Then Dietician gets 404 not found