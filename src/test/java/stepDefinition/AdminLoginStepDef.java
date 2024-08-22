package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.User_Login;
import requestBody.Post_Login;
import testContext.TestContext;
import utilities.APIResources;
import utilities.ExcelUtilities;
import utilities.JsonSchemaValidation;
import utilities.ReqResSpec;
import utilities.ResourceBundleReader;

public class AdminLoginStepDef {
	private Response response;
	private User_Login.Request request;
	private User_Login.Response res;
	private ReqResSpec reqres;
	private RequestSpecification request1;
	private TestContext testContext;
	private ResourceBundleReader resource;
	static public String dieticianToken;
	static public String patientToken;
	static public String adminToken;
	
	
	public AdminLoginStepDef(TestContext testcontext) 
	{
		this.testContext=testcontext;
		reqres=testcontext.getReqResSpec();
		resource=testcontext.getResourceBundleReader();
	}

	@Given("User create a Post Request body using credentials {string} {string} {int}")
	public void user_create_a_post_request_body_using_credentials(String string, String sheet, Integer row) throws Exception {
		request = Post_Login.UserLoginPostBody(sheet, row);
		request1= RestAssured
			    .given()
			    .spec(reqres.ReqSpec());
	}
	
	@When("User sends Post Request")
	public void user_sends_post_request() {
		//response = RestAssured.given().contentType(request.getContentType()).body(request).log().all().when().post(request.getEndpoint());
		APIResources  resourceAPI = APIResources.loginEndpoint;
		response=request1.body(request).when().post(resourceAPI.getResource());
		System.out.println("Response Body: " + response.getBody().asString());
	    if (response.statusCode() == 200) {
	       res = response.getBody().as(User_Login.Response.class);
	       System.out.println("TOKEN: " + res.getToken());
	    }
	}

	@Then("the User receives status for scenario {string} {string} {int}")
	public void the_user_receives_status_for_scenario(String string, String sheet, Integer row) {
	    String status_code = Post_Login.getStatusCode(sheet, row);
	    assertEquals(Integer.parseInt(status_code), response.getStatusCode());
	    System.out.println("status: " + response.getStatusCode());
	    System.out.println("expected status: " + status_code);
	    if (string.contentEquals("Valid Credentials") ||
	    	(string.contentEquals("Valid Dietician Credentials")) ||
	    	(string.contentEquals("Valid Patient Credentials"))) {
	    	assertEquals("Bearer ", res.getType());
			if (res.getUserId() > 0) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
			assertEquals(request.getUserLoginEmail(), res.getLoginUserEmail());
			if (res.getToken().isEmpty()) {
				assertTrue(false);
			}
			if((res.getRoles().contains("ROLE_ADMIN")) ||
				(res.getRoles().contains("ROLE_DIETICIAN")) ||
				(res.getRoles().contains("ROLE_PATIENT"))) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
			
			if (string.contentEquals("Valid Credentials")) {
			    User_Login.adminBearerToken = res.getToken();
			    adminToken = res.getToken();
			    System.out.println("admin token:" + User_Login.adminBearerToken);
			}
			
			if (string.contentEquals("Valid Dietician Credentials")) {
			    User_Login.dieticianBearerToken = res.getToken();
			    dieticianToken = res.getToken();
			    System.out.println("dietician token:" + User_Login.dieticianBearerToken);
			}
			
			if (string.contentEquals("Valid Patient Credentials")) {
			    User_Login.patientBearerToken = res.getToken();
			    patientToken = res.getToken();
			    System.out.println("patient token:" + User_Login.patientBearerToken);
			}
	    }
	}
}
	

