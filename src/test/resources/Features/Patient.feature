


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
      #| InvalidMethod          | PatientPost  |     
      #| InvalidEndPoint        | PatientPost  |     
      #|InvalidContent          | PatientPost  |
