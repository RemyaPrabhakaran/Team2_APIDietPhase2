package stepDefinition;


import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;


import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
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

	  public static String admintoken;

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
	

	List<Map<String, String>> testData = ExcelUtilities.getTestDataInMap("C:\\Users\\rashm\\git\\Team2_APIDietPhase2RestAssured\\src\\test\\resources\\Data\\Team2_APIDiet_Data.xlsx", "Sheet1", "UserLoginPost");
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

public void user_recieves_created_with_response_body(Integer int1) throws JsonMappingException, JsonProcessingException {
	String responseBody= response.body().asString();
	
	 ObjectMapper objectMapper = new ObjectMapper();
       
           com.fasterxml.jackson.databind.JsonNode jsonNode = objectMapper.readTree(responseBody);
          admintoken = jsonNode.get("token").asText();
           System.out.println("Token: " + admintoken);
}



}