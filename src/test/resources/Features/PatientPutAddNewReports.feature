Feature: Put Operation [Add New Reports with/without Vitals for existing Patient

  Background: 
    Given Set dietician bearer token

  Scenario Outline: Update patient Add New Reports with/without Vitals for existing Patient
    Given Dietician creates PUT request by entering  data for the "<scenario>" from the "<sheet>"
    When Dietician send PUT http request with endpoint
    Then Dietician recieves response for the respective "<scenario>" for add New Reports with or without Vitals

    Examples: 
      | scenario            | sheet            |
     | Valid              | PatientPutVitals |
    | InValidvitals       | PatientPutVitals |
    # | Nofile              | PatientPutVitals |
     # | InvalidVitalsNoFile | PatientPutVitals |

  Scenario: Creation of patient with invalid method
    Given Dietician creates PUT request by entering  data for the "InvalidMethod" from the "PatientPutVitals"
    When Dietician send  http request with endpoint and invalid method for Add New Reports with or without Vitals
    Then Dietician recieves 405 statuscode for Add New Reports with or without Vitals

  Scenario: Creation of patient with invalid endpoint
    Given Dietician creates PUT request by entering  data for the "InvalidEndPoint" from the "PatientPutVitals"
    When Dietician send  http request with endpoint and invalid endpoint for Add New Reports with or without Vitals
    Then Dietician recieves 404 statuscode for Add New Reports with or without Vitals

  Scenario: Creation of patient with invalid content type
    Given Dietician creates PUT request by entering  data for the "InvalidContent" from the "PatientPutVitals" 
    When Dietician send  http request with endpoint and invalid content type for Add New Reports with or without Vitals
    Then Dietician recieves 415 statuscode for Add New Reports with or without Vitals

Scenario: Creation of patient with  nofile
Given Dietician creates PUT request by entering  data for the "Nofile" from the "PatientPutVitals"
When Dietician send PUT http request with endpoint with invalid vitals and nofile
    Then Dietician recieves 400 statuscode for Add New Reports with or without Vitals
    
    
Scenario: Creation of patient with  nofile
Given Dietician creates PUT request by entering  data for the "InvalidVitalsNoFile" from the "PatientPutVitals"
When Dietician send PUT http request with endpoint with invalid vitals and nofile
  Then Dietician recieves 400 statuscode for Add New Reports with or without Vitals
    
    
    
 
    