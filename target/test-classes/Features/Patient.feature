Feature: Post Operation [create patient
Background: 
Given Set dietician bearer token

Scenario: Check dietician able to create patient with valid data and token 
Given Dietician creates POST request by entering valid data. Mandatory and additional details into the form-data key and value fields.
When Dietician send POST http request with endpoint
Then Dietician recieves 201 created and with response body. Auto created dietician ID and login password




