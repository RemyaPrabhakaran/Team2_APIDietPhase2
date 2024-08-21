


Feature: Post Operation [create patient]

  Background: 
    Given Set dietician bearer token


  Scenario Outline: Patient creation
    Given Dietician creates POST request by entering  data for the "<scenario>" from the "<sheet>"
    When Dietician send POST http request with endpoint
    Then Dietician recieves response for the respective "<scenario>"

    Examples: 
      | scenario          | sheet       |
      | ValidOne          | PatientPost |
      | ValidTwo          | PatientPost |
      | ValidAdditional   | PatientPost |
      | InvalidData       | PatientPost |
      | InvalidAdditional | PatientPost |
      | Duplicate         | PatientPost |
     

      Scenario: Creation of patient with invalid method
      Given Dietician creates POST request by entering  data for the "InvalidMethod" from the "PatientPost"
      When Dietician send  http request with endpoint and invalid method
      Then Dietician recieves 405 statuscode
      
       Scenario: Creation of patient with invalid endpoint
      Given Dietician creates POST request by entering  data for the "InvalidEndPoint" from the "PatientPost"
      When Dietician send  http request with endpoint and invalid endpoint
      Then Dietician recieves 404 statuscode
      
      Scenario: Creation of patient with invalid content type
       Given Dietician creates POST request by entering  data for the "InvalidContent" from the "PatientPost"
      When Dietician send  http request with endpoint and invalid content type
      Then Dietician recieves 415 statuscode
      