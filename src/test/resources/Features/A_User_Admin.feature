Feature: User Login Module
  @tag1
  Scenario Outline: User Login as Admin with Credentials
    Given User create a Post Request body using credentials "<scenario>" "<sheetno>" <rowno>
    When User sends Post Request
    Then the User receives status for scenario "<scenario>" "<sheetno>" <rowno>

    Examples: 
      | scenario               | sheetno | rowno |
      | Valid Credentials      | sheet1  |     0 |
      | Invalid userLoginEmail | sheet1  |     1 |
      | Invalid URL            | sheet1  |     2 |
      | Invalid Endpoint       | sheet1  |     3 |
      | Invalid Content        | sheet1  |     4 |
      | Invalid Password       | sheet1  |     5 |
  @tag2
  Scenario Outline: User Login as Dietician with Credentials
    Given User create a Post Request body using credentials "<scenario>" "<sheetno>" <rowno>
    When User sends Post Request
    Then the User receives status for scenario "<scenario>" "<sheetno>" <rowno>

    Examples: 
      | scenario                    | sheetno | rowno |
      | Valid Dietician Credentials | sheet1  |     6 |
      | Invalid userLoginEmail      | sheet1  |     7 |
  @tag3
  Scenario Outline: User Login as Patient with Credentials
    Given User create a Post Request body using credentials "<scenario>" "<sheetno>" <rowno>
    When User sends Post Request
    Then the User receives status for scenario "<scenario>" "<sheetno>" <rowno>

    Examples: 
      | scenario                  | sheetno | rowno |
      | Valid Patient Credentials | sheet1  |     6 |
      | Invalid userLoginEmail    | sheet1  |     7 |
