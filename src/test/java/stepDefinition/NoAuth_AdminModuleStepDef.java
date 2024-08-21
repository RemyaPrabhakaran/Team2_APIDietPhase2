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

public class NoAuth_AdminModuleStepDef {
	
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
	 
	 public NoAuth_AdminModuleStepDef(TestContext testcontext) {
		  this.testContext = testcontext;
		  reqres = testcontext.getReqResSpec();
		  resource = testcontext.getResourceBundleReader();
		  this.loginStep = new AdminLoginStepDef(testcontext);
		  this.reqBody = new InvalidScenariosreqBody();
		  
	  }
	 @Given("Admin creates request with valid data with no auth")
	 public void admin_creates_request_with_valid_data_with_no_auth()throws FileNotFoundException {
		request= RestAssured
			    .given()
			    	.spec(reqres.ReqSpec());
			    	
	}

	@When("Admin send POST http request with endpoint with no auth")
	public void admin_send_post_http_request_with_endpoint_with_no_auth() {
		APIResources resourceApi = APIResources.dieticianEndpoint;
		response = request.body(reqBody.reqBody()).when().post(resourceApi.getResource());
	}

	@Then("Admin recieves {int} unauthorized")
	public void admin_recieves_unauthorized(Integer exp_statusCode) {
		response.then()
		.assertThat().statusCode(exp_statusCode);
	}

	

	@When("Admin send GET http request with endpoint")
	public void admin_send_get_http_request_with_endpoint() {
		APIResources resourceApi = APIResources.dieticianEndpoint;
		response = request.when().get(resourceApi.getResource());
	}

	

	@When("Admin send PUT http request with endpoint")
	public void admin_send_put_http_request_with_endpoint() {
		APIResources resourceApi = APIResources.dietcianPutEndpoint;
		String dieticianID = DieticianPostStepDef.dieticianIDs.get(0);
		response = request.pathParam("dieticianId", dieticianID).body(reqBody.reqBody()).when().put(resourceApi.getResource());
	}

	

	@When("Admin send DELETE http request with endpoint with no auth")
	public void admin_send_delete_http_request_with_endpoint_with_no_auth() {
		APIResources resourceApi = APIResources.dietcianPutEndpoint;
		String dieticianID = DieticianPostStepDef.dieticianIDs.get(0);
		response = request.pathParam("dieticianId", dieticianID).when().delete(resourceApi.getResource());
	}



}
