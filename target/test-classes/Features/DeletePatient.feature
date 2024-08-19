
Feature: Get Operation [Get Patients Morbidity Details ]

Background: 
    Given Set dietician bearer token

   Scenario: Check dietician able to delete patient by ID
  
    Given Dietician create DELETE request  
    When Dietician send DELETE http request with endpoint
    Then Dietician recieves 200 ok with details of the patient id
    