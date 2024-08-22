@tag
Feature: Get Logout

  Scenario Outline: Validate logout functionality for different user roles with token
    When User sends a GET request to fetch logout details  with "<request_type>" "<sheet>" <row>
    Then the response status code should be  with "<sheet>" <row>

    Examples: 
      | request_type                     | sheet  | row |
      | get request                      | sheet3 |   0 |
      | get request                      | sheet3 |   1 |
      | post request with invalid method | sheet3 |   2 |
      | get request                      | sheet3 |   3 |
      | post request with invalid method | sheet3 |   4 |
      | get request                      | sheet3 |   5 |
      | post request with invalid method | sheet3 |   6 |