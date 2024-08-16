package stepDefinition;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import requestBody.Post_Login;
import utilities.ExcelUtilities;

public class AdminLoginStepDef {
	
	Post_Login postLogin = new Post_Login();
	  Response response;
	  String body;
	  int exp_status_code;
	 
	   
		

@Given("Admin sets the Authorization to no auth")
public void admin_sets_the_authorization_to_no_auth() {
   
}

@Given("User creates Post request with request body.")
public void user_creates_post_request_with_request_body() throws Exception {
	
	List<Map<String, String>> testData = ExcelUtilities.getTestDataInMap("D:\\Rathna\\Hackathons\\Team2_APIDiet_RestAssured\\Team2_APIDiet_Data.xlsx", "Sheet1", "UserLoginPost");
	for(Map<String, String> data : testData) {
		body = postLogin.getLoginReqBody(data);
		 exp_status_code = Integer.parseInt(data.get("StatusCode"));
	System.out.println(body);
response = RestAssured
    .given()
    	.baseUri("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/login")
    	.header("Content-Type", "application/json")
    	.body(body)
    .when()
    	.post()
    .then()
    	.assertThat().statusCode(exp_status_code)
    	.log().all().extract().response();
	}
  int status_code = response.getStatusCode();
  Assert.assertEquals(status_code, exp_status_code, "correct status code returned");
   
}

@When("User send POST HTTP request with endpoint")
public void user_send_post_http_request_with_endpoint() {
   
}

@Then("User recieves {int} created with response body")
public void user_recieves_created_with_response_body(Integer int1) {
   
}

}