Feature: Get Operation [Get Patients Morbidity Details ]

Background: 
    Given Set dietician bearer token for delete
@tag5
   Scenario: Check dietician able to delete patient by ID
  
    Given Dietician create DELETE request  
    When Dietician send DELETE http request with endpoint
    Then Dietician recieves 200 for deletion
    
    Scenario: Check dietician able to delete patient by id with invalid method
    
     Given Dietician create DELETE request 
    When Dietician send POST http request with endpoint with invalid method
    Then Dietician recieves 405 for deletion
    
    Scenario: Check dietician able to delete patient by invalid id
    
    Given Dietician create DELETE request invalid Id 
    When Dietician send DELETE http request with endpoint
    Then Dietician recieves 404 for deletion
    
    Scenario: Check dietician able to delete patient by id with invalid endpoint
    
    Given Dietician create DELETE request 
    When Dietician send DELETE http request with invalid endpoint
    Then Dietician recieves 404 for deletion
    
    
    