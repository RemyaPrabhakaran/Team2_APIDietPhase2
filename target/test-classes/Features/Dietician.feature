Feature: Post Operation [create dietician]

  Background: 
    Given Set admin bearer token

  Scenario: Dietician ceation
    Given Admin creates POST request by entering  data for  "valid" from the "DieticianPost" sheet
    When Admin send POST http request with endpoint
    Then Dietician created with status code 200

   