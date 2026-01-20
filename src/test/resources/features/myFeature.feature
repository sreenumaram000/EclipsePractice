 Feature: Login functionality
 
 

@Smoke
Scenario Outline: Successful login with valid credentials
 Given user is on the login page
    When user enters valid "<username>" and "<password>"
    And clicks on the login button
    Then user should be redirected to the dashboard
    And a welcome message should be displayed "<status>"
    
    Examples:
      | username  | password   | status  |
      | rahulshettyacademy     | learning   | ProtoCommerce |
      | rahulshettyacademy     | learning   | ProtoCommerce |
      | rahulshettyacademy     | learning    | ProtoCommerce1 |
      
      
    @ExcelData  
      Scenario Outline: Dynamic ScenarioOutline      
		Given user data "<userName>" and "<password>"
    Examples:
| userName | password |