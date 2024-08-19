package stepDefinition;

import java.io.PrintStream;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import requestBody.Post_Login;

public class AdminLoginStepDef {
	
	Post_Login postLogin = new Post_Login();
	  Response response;
	 
	   
		

@Given("Admin sets the Authorization to no auth")
public void admin_sets_the_authorization_to_no_auth() {
   
}

@Given("User creates Post request with request body.")
public void user_creates_post_request_with_request_body() throws Exception {
	 
	String body =  postLogin.UserLoginPost();
	System.out.println(body);
response = RestAssured
    .given()
    	.baseUri("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/login")
    	.header("Content-Type", "application/json")
    	.body(body)
    .when()
    	.post()
    .then()
    	.assertThat().statusCode(200)
    	.log().ifStatusCodeIsEqualTo(200).extract().response();
  int status_code = response.getStatusCode();
  Assert.assertEquals(status_code, 200, "correct status code returned");
   
}

@When("User send POST HTTP request with endpoint")
public void user_send_post_http_request_with_endpoint() {
   
}

@Then("User recieves {int} created with response body")
public void user_recieves_created_with_response_body(Integer int1) {
   
}

}
