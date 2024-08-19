Feature: Get all morbidities
  @tag1
  Scenario Outline: User not able to retrive all morbidities
    When User sends a Get request to fetch all morbidities with "<sheet>" <row>
    Then Admin receives invalid Status Code with "<sheet>" <row>

    Examples: 
      | sheet      | row     |
      | sheet2     | 0       |
      | sheet2     | 1       |
  
  @tag2
  Scenario Outline: User able to retrive all morbidities with token
    When User create and send request using "<request_type" "<sheet>" <row>
    Then Admin receives invalid Status Code with "<sheet>" <row>

    Examples: 
      | request_type                      | sheet  | row |
      | get request                       | sheet2 |   2 |
      | post request                      | sheet2 |   3 |
      | get request with invalid endpoint | sheet2 |   4 |
      | get request                       | sheet2 |   5 |
      | post request                      | sheet2 |   6 |
      | get request with invalid endpoint | sheet2 |   7 |

  
