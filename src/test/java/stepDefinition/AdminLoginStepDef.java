package stepDefinition;


import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;


import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;

import requestBody.Post_Login;
import utilities.ExcelUtilities;
import utilities.ReqResSpec;

public class AdminLoginStepDef extends ReqResSpec {
	
	Post_Login postLogin = new Post_Login();
	 Response response = null;
	  String body;
	  int actual_Status_Code;
	  int exp_status_code;
	  RequestSpecification request;
	  
	  
	   
		

@Given("Admin sets the Authorization to no auth")
public void admin_sets_the_authorization_to_no_auth() throws FileNotFoundException {
	System.out.println("Admin sets no Auth");
}


@Given("User creates Post request with request body.")
public void user_creates_post_request_with_request_body() throws Exception {

	  request= RestAssured
	    .given()
	    	.spec(ReqSpec());
	
   
}

@When("User send POST HTTP request with endpoint")
public void user_send_post_http_request_with_endpoint() throws Exception {
	List<Map<String, String>> testData = ExcelUtilities.getTestDataInMap("D:\\Rathna\\Hackathons\\Team2_APIDiet_RestAssured\\Team2_APIDiet_Data.xlsx", "AdminLogin", "UserLoginPost");
	for(Map<String, String> data : testData) {
		body = postLogin.getLoginReqBody(data);
		
		exp_status_code = Integer.parseInt(data.get("StatusCode"));
	System.out.println(body);
	response =  request
    	.body(body)
    .when()
    	.post("/login");
    	
	response .then()
    	.assertThat().statusCode(exp_status_code)
    	.log().all().extract().response();
	}
}

@Then("User recieves {int} created with response body")
public void user_recieves_created_with_response_body(Integer exp_status_code) {
	Assert.assertEquals(response.getStatusCode(), exp_status_code, "correct status code returned");
}

}