@tag @patient
Feature: Get Operation [Retrieve Patient file by FileId ]

 
Background: 
    Given Set dietician bearer token 

  @tag4
  Scenario: Check dietician able to retrieve patients by field
    Given Dietician create requests to retrieve patients by field
   
    When Dietician send GET http request with endpointto retrieve patients by field
  
    Then Dietician recieves 200 for Retrieve Patient file by FileId
  
  Scenario: Check dietician able to retrieve patients by field with invalid method
  Given Dietician create requests to retrieve patients by field
  When Dietician send  http request with invalid method
  Then Dietician recieves 405 for Retrieve Patient file by FileId
  
  Scenario: Check dietician able to retrieve patients by invalid field
   # Given Dietician create requests to retrieve patients by invalid field 
    # When Dietician send GET http request with endpointto retrieve patients by field
  
    #Then Dietician recieves 404 for Retrieve Patient file by FileId
  
  Scenario: Check dietician able to retrieve patients by field with invalid endpoint
  
  Given Dietician create requests to retrieve patients by field
 
  When Dietician send GET http request with invalid endpoint to retrive patient
  Then Dietician recieves 404 for Retrieve Patient file by FileId

