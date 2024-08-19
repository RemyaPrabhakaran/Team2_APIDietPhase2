
Feature: Get Operation [Retrieve Patient file by FileId ]

 
Background: 
    Given Set dietician bearer token

  
  Scenario: Check dietician able to retrieve patients by field
    Given Dietician create GET request to retrieve patients by field
   
    When Dietician send GET http request with endpointto retrieve patients by field
  
    Then Dietician recieves 200 ok with details of the patient id
  

 |
