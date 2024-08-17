Feature: Create dietician with no auth
 Background:
  Given Admin sets the Authorization to no auth
  
 Scenario: Check admin able to create dietician with valid data
 Given Admins creates a POST request with valid data
 When Admin send a POST request
 Then Admin receives a 401 unauthorized response