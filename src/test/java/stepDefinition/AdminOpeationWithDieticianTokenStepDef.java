package stepDefinition;

import java.io.FileNotFoundException;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestBody.Dietician;
import requestBody.InvalidScenariosreqBody;
import testContext.TestContext;
import utilities.APIResources;

import utilities.JsonSchemaValidation;
import utilities.ReqResSpec;
import utilities.ResourceBundleReader;

public class AdminOpeationWithDieticianTokenStepDef {
	
	
	public static String dieticianPassword;
	Response response = null;
	InvalidScenariosreqBody reqBody;
	  String body;
	  int actual_Status_Code;
	  int exp_status_code;
	  RequestSpecification request;
	  TestContext testContext;
	  ReqResSpec reqres;
	  ResourceBundleReader resource;
	  JsonSchemaValidation jsonSchema;
	 AdminLoginStepDef loginStep;
	 Dietician dietcian;
	 String res;
	
	
	  public AdminOpeationWithDieticianTokenStepDef(TestContext testcontext) {
		  this.testContext = testcontext;
		  reqres = testcontext.getReqResSpec();
		  resource = testcontext.getResourceBundleReader();
		  this.loginStep = new AdminLoginStepDef(testcontext);
		  this.reqBody = new InvalidScenariosreqBody();
		  
	  }
	  
	@Then("User recieves {int} created with response body and sets dietician bearer token")
	public void user_recieves_created_with_response_body_and_sets_dietician_bearer_token(Integer int1) throws FileNotFoundException {
		request= RestAssured
			    .given()
			    	.spec(reqres.ReqSpec())
			    	.header("Authorization", "Bearer " +AdminLoginStepDef.dieticianToken);
	}

	@Given("Admin creates POST request with valid data")
	public void admin_creates_post_request_with_valid_data() throws FileNotFoundException {
		
	}

	@When("Admin send POST http request with endpoint with deitician token")
	public void admin_send_post_http_request_with_endpoint_with_deitician_token() {
		APIResources resourceApi = APIResources.dieticianEndpoint;
		response = request.body(reqBody.reqBody()).when().post(resourceApi.getResource());
	}	
	

	@Then("Admin recieves a {int} forbidden")
	public void admin_recieves_a_forbidden(Integer exp_statusCode) {
		response.then()
		.assertThat().statusCode(exp_statusCode);
	}

	@Given("Admin creates PUT request with valid data")
	public void admin_creates_put_request_with_valid_data() {
		
	}

	@When("Admin send PUT http request with endpoint with dietician token")
	public void admin_send_put_http_request_with_endpoint_with_dietician_token() {
	String dieticianID = DieticianPostStepDef.dieticianIDs.get(0);
		
		APIResources resourceApi = APIResources.dietcianPutEndpoint;
		response = request.pathParam("dieticianId", dieticianID).body(reqBody.reqBody()).when().put(resourceApi.getResource());
	}
	
	@Then("User recieves {int} created with response body and sets patient bearer token")
	public void user_recieves_created_with_response_body_and_sets_patient_bearer_token(Integer int1) throws FileNotFoundException {
		request= RestAssured
			    .given()
			    	.spec(reqres.ReqSpec())
			    	.header("Authorization", "Bearer " +AdminLoginStepDef.patientToken);
	}
	
	@When("Admin send POST http request with patient token")
	public void admin_send_post_http_request_with_patient_token() {
		APIResources resourceApi = APIResources.dieticianEndpoint;
		response = request.body(reqBody.reqBody()).when().post(resourceApi.getResource());
	}

	@When("Admin send PUT http request with endpoint with patient token")
	public void admin_send_put_http_request_with_endpoint_with_patient_token() {
		String dieticianID = DieticianPostStepDef.dieticianIDs.get(0);
		APIResources resourceApi = APIResources.dietcianPutEndpoint;
		response = request.pathParam("dieticianId", dieticianID).body(reqBody.reqBody()).when().put(resourceApi.getResource());
	}

}
