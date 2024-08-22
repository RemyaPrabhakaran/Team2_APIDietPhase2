package stepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testContext.TestContext;
import utilities.APIResources;
import utilities.JsonSchemaValidation;
import utilities.ReqResSpec;
import utilities.ResourceBundleReader;

public class GetAllDieticianStepDef {
	
	RequestSpecification request;
	TestContext testContext;
	  ReqResSpec reqres;
	  ResourceBundleReader resource;
	  JsonSchemaValidation jsonSchema;
	  AdminLoginStepDef loginStep;	
	  Response response = null;
	  
	  public GetAllDieticianStepDef(TestContext testcontext) {
		  this.testContext = testcontext;
		  reqres = testcontext.getReqResSpec();
		  resource = testcontext.getResourceBundleReader();
		  this.jsonSchema = new JsonSchemaValidation();
		  this.loginStep = new AdminLoginStepDef(testcontext);
	  }


	@Given("Admin create GET request")
	public void admin_create_get_request() throws FileNotFoundException {
	  request = RestAssured
			  .given()
			  	.spec(reqres.ReqSpec())
			  	.header("Authorization", "Bearer " +AdminLoginStepDef.adminToken);
	}

	@When("Admin sends the GET http request with endpoint")
	public void admin_sends_the_get_http_request_with_endpoint() {
		APIResources  resourceAPI = APIResources.dieticianEndpoint;
	   response = request.when().get(resourceAPI.getResource());
			   
	}

	@Then("Admin recieves the response with the status code {int} for the get dietician")
	public void admin_recieves_the_response_with_the_status_code_for_the_get_dietician(Integer exp_statusCode) throws IOException {
		 response.then()
				.assertThat().statusCode(exp_statusCode)
				.header("Content-Type", "application/json");
		int actual_Status_Code = response.getStatusCode();
         Assert.assertEquals(actual_Status_Code, exp_statusCode);
	}

	@Given("Admin create PUT request for get HTTP request")
	public void admin_create_put_request_for_get_http_request() throws FileNotFoundException {
		 request = RestAssured
				  .given()
				  	.spec(reqres.ReqSpec())
				  	.header("Authorization", "Bearer " +AdminLoginStepDef.adminToken);
	}

	@When("Admin send PUT http request with get request endpoint")
	public void admin_send_put_http_request_with_get_request_endpoint() {
		APIResources  resourceAPI = APIResources.dieticianEndpoint;
		   response = request.when().put(resourceAPI.getResource());
	}

	@Then("Admin recieves {int} method not allowed")
	public void admin_recieves_method_not_allowed(Integer exp_statusCode) throws IOException {
		response.then()
		.assertThat().statusCode(exp_statusCode)
		.header("Content-Type", "application/json");
		int actual_Status_Code = response.getStatusCode();
		Assert.assertEquals(actual_Status_Code, exp_statusCode);
	}

	@When("Admin send GET http request with invalid endpoint for get dietician")
	public void admin_send_get_http_request_with_invalid_endpoint_for_get_dietician() {
		
		   response = request.when().get();
	}

	@Then("Admin recieves {int} not found")
	public void admin_recieves_not_found(Integer exp_statusCode) throws IOException {
		response.then()
		.assertThat().statusCode(exp_statusCode)
		.header("Content-Type", "application/json");
		int actual_Status_Code = response.getStatusCode();
		Assert.assertEquals(actual_Status_Code, exp_statusCode);
	}
}
