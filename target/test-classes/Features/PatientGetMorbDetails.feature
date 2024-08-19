Feature: Get Operation [Get Patients Morbidity Details ]

Background: 
    Given Set dietician bearer token

   Scenario: Check dietician able to retrieve patients morbidity details by patient id
  
    Given Dietician create request 
    When Dietician send GET http request with endpoint
    Then Dietician recieves 200 code
    
   
Scenario: Check dietician able to retrieve patients morbidity details by patient ID with invalid method

 Given Dietician create request 
    When Dietician send POST http request with endpoint for the patients morbidity
    Then Dietician recieves 405 code
    
Scenario: Check dietician able to retrieve patients morbidity details by invalid patient ID
Given Dietician create request for invalid patient ID
    When Dietician send GET http request with endpoint
    Then Dietician recieves 404 code
    
 Scenario:   Check dietician able to retrieve patients morbidity details by patient ID with invalid endpoint
 
 Given Dietician create request 
    When Dietician send GET http request with invalid endpoint
    Then Dietician recieves 404 code