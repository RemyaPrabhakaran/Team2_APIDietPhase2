
Feature: Get Operation [Retrieve Morbidity condition by Test name ]
Background: Set admin token


Scenario: admin login and set token 
Given admin create GET request 
When admin send GET http request with endpoint
Then admin recieves 200  



Scenario Outline:  Check admin able to retrieve morbidity condition by test name
Given admin create GET request 
When admin checks "<morbidityTestname>" and send GET http request with endpoint
Then admin recieves 200 ok with details of the patient id

 Examples:
      | morbidityTestname |
            | Fasting Glucose |  
          |  Average Glucose  |
          | Plasma Glucose |     
          | TSH |               
            | T3 |               
           | T4 |                 
           | HBA1C |              
           
           
 Scenario Outline:  Check admin able to retrieve morbidity condition by test name  with invalid method
Given admin create POST request instead Get Request
When admin send POST http request for  "<morbidityTestname>" name instead Get Request with endpoint
Then admin recieves 405 method not allowed         


 Examples:
      | morbidityTestname |
            | Fasting Glucose |  
          |  Average Glucose  |
          | Plasma Glucose |     
          | TSH |               
            | T3 |               
           | T4 |                 
           | HBA1C | 

 Scenario Outline: Check admin able to retrieve morbidity condition by invalid test name 
Given admin create GET request
When admin send http GET request "<morbidityTestname>" with invalid test name 
Then admin recieves 404 not found



Examples:
      | morbidityTestname |
            | fever|  
          |  cold   |
          | cough |     
          | covid |               
            | pcos |               
           | headech|                 
           | Jaundice | 


Scenario Outline: Check admin able to retrieve morbidity condition by test name with invalid endpoint 
Given admin create GET request 
When admin send GET http request "<morbidityTestname>" with invalid endpoint
Then admin recieves 404 not found


Examples:
      | morbidityTestname |
            | Fasting Glucose |  
          |  Average Glucose  |
          | Plasma Glucose |     
          | TSH |               
            | T3 |               
           | T4 |                 
           | HBA1C |
