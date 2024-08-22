Feature: User Login Module

  @tag1
  Scenario Outline: User Login as Admin with Credentials
    Given User create a Post Request body using credentials "<scenario>" "<sheetno>" <rowno>
    When User sends Post Request
    Then the User receives status for scenario "<scenario>" "<sheetno>" <rowno>

    Examples: 
      | scenario               | sheetno | rowno |
      | Valid Credentials      | Login  |     0 |
      | Invalid userLoginEmail | Login  |     1 |
      | Invalid URL            | Login  |     2 |
      | Invalid Endpoint       | Login  |     3 |
      | Invalid Content        | Login  |     4 |
      | Invalid Password       | Login  |     5 |

  @tag2
  Scenario Outline: User Login as Dietician with Credentials
    Given User create a Post Request body using credentials "<scenario>" "<sheetno>" <rowno>
    When User sends Post Request
    Then the User receives status for scenario "<scenario>" "<sheetno>" <rowno>

    Examples: 
      | scenario                    | sheetno | rowno |
      | Valid Dietician Credentials | Login  |     6 |
      | Invalid userLoginEmail      | Login  |     7 |

  @tag3
  Scenario Outline: User Login as Patient with Credentials
    Given User create a Post Request body using credentials "<scenario>" "<sheetno>" <rowno>
    When User sends Post Request
    Then the User receives status for scenario "<scenario>" "<sheetno>" <rowno>

    Examples: 
      | scenario                  | sheetno | rowno |
      | Valid Patient Credentials | Login  |     8 |
      | Invalid userLoginEmail    | Login  |     9 |
