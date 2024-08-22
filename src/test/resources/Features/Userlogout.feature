@tag
Feature: Get Logout

  Scenario Outline: Validate logout functionality for different user roles with token
    When User sends a GET request to fetch logout details  with "<request_type>" "<sheet>" <row>
    Then the response status code should be  with "<sheet>" <row>

    Examples: 
      | request_type                     | sheet  | row |
      | get request                      | Logout |   0 |
      | get request                      | Logout |   1 |
      | post request with invalid method | Logout |   2 |
      | get request                      | Logout |   3 |
      | post request with invalid method | Logout |   4 |
      | get request                      | Logout |   5 |
      | post request with invalid method | Logout |   6 |