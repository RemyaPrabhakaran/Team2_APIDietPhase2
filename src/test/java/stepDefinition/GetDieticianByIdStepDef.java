package stepDefinition;

import java.io.FileNotFoundException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testContext.TestContext;
import utilities.APIResources;
import utilities.JsonSchemaValidation;
import utilities.ReqResSpec;
import utilities.ResourceBundleReader;

public class GetDieticianByIdStepDef {
	
	RequestSpecification request;
	TestContext testContext;
	  ReqResSpec reqres;
	  ResourceBundleReader resource;
	  JsonSchemaValidation jsonSchema;
	  AdminLoginStepDef loginStep;	
	  Response response;
	  
	  public GetDieticianByIdStepDef(TestContext testcontext) {
		  this.testContext = testcontext;
		  reqres = testcontext.getReqResSpec();
		  resource = testcontext.getResourceBundleReader();
		  this.jsonSchema = new JsonSchemaValidation();
		  this.loginStep = new AdminLoginStepDef(testcontext);
	  }


	  @Given("Admin create GET request for get dietician by ID")
	  public void admin_create_get_request_for_get_dietician_by_id() throws FileNotFoundException {
		  
		  request = RestAssured
				  .given()
				  	.spec(reqres.ReqSpec())
				  	.header("Authorization", "Bearer " +AdminLoginStepDef_Dietician.adminToken);
		  			
	  }
	@When("Admin send GET http request with endpoint for get dietician by ID")
	public void admin_send_get_http_request_with_endpoint_for_get_dietician_by_id() {
		String dieticianID = DieticianPostStepDef.dieticianIDs.get(0);
		APIResources  resourceAPI = APIResources.dietcianPutEndpoint;
		   response = request
				   .pathParam("dieticianId", dieticianID).get(resourceAPI.getResource());	   
	}

	@Then("Admin recieves {int} ok with details of the dietician id")
	public void admin_recieves_ok_with_details_of_the_dietician_id(Integer exp_statusCode) {
		response.then()
		.assertThat().statusCode(exp_statusCode)
		.header("Content-Type", "application/json");
		int actual_Status_Code = response.getStatusCode();
		Assert.assertEquals(actual_Status_Code, exp_statusCode);
	}

	@When("Admin send POST http request with endpoint of the get dietician by ID")
	public void admin_send_post_http_request_with_endpoint_of_the_get_dietician_by_id() {
		String dieticianID = DieticianPostStepDef.dieticianIDs.get(0);
		APIResources  resourceAPI = APIResources.dietcianPutEndpoint;
		   response = request
				   .pathParam("dieticianId", dieticianID)
				   .when().post(resourceAPI.getResource());
	}

	@When("Admin send GET http request with endpoint for get dietician by {string}")
	public void admin_send_get_http_request_with_endpoint_for_get_dietician_by(String InvaliDieticianID) {
		APIResources  resourceAPI = APIResources.dietcianPutEndpoint;
		   response = request
				   .pathParam("dieticianId", InvaliDieticianID)
				   .when().get(resourceAPI.getResource());
	}

	@When("Admin send GET http request with invalid endpoint")
	public void admin_send_get_http_request_with_invalid_endpoint() {
		
		APIResources  resourceAPI = APIResources.invalidEndpoint;
		   response = request
				   .when().get(resourceAPI.getResource());
	}
	
	@Then("Admin recieves {int} method not allowed for the get dietician by ID")
	public void admin_recieves_method_not_allowed_for_the_get_dietician_by_id(Integer exp_statusCode) {
		response.then()
		.assertThat().statusCode(exp_statusCode)
		.header("Content-Type", "application/json");
		int actual_Status_Code = response.getStatusCode();
		Assert.assertEquals(actual_Status_Code, exp_statusCode);
	}
	
	@Then("Admin recieves {int} not found for the get dietician by ID")
	public void admin_recieves_not_found_for_the_get_dietician_by_id(Integer exp_statusCode) {
		response.then()
		.assertThat().statusCode(exp_statusCode)
		.header("Content-Type", "application/json");
		int actual_Status_Code = response.getStatusCode();
		Assert.assertEquals(actual_Status_Code, exp_statusCode);
	}
}
