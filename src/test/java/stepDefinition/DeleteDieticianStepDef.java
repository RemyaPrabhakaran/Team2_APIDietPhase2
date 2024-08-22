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
import utilities.ReqResSpec;
import utilities.ResourceBundleReader;

public class DeleteDieticianStepDef {

	RequestSpecification request;
	TestContext testContext;
	  ReqResSpec reqres;
	  ResourceBundleReader resource;
	  AdminLoginStepDef loginStep;	
	  Response response = null;
	  
	  public DeleteDieticianStepDef(TestContext testcontext) {
		  this.testContext = testcontext;
		  reqres = testcontext.getReqResSpec();
		  resource = testcontext.getResourceBundleReader();
		  this.loginStep = new AdminLoginStepDef(testcontext);
	  }

	
	@Given("Admin create DELETE request for deleting the dietician")
	public void admin_create_delete_request_for_deleting_the_dietician() throws FileNotFoundException {
		 request = RestAssured
				  .given()
				  	.spec(reqres.ReqSpec())
				  	.header("Authorization", "Bearer " +AdminLoginStepDef_Dietician.adminToken);
	}

	@When("Admin send DELETE http request with delete endpoint")
	public void admin_send_delete_http_request_with_delete_endpoint() {
		String dieticianID = DieticianPostStepDef.dieticianIDs.get(1);
		APIResources  resourceAPI = APIResources.dietcianPutEndpoint;
		   response = request
				   .pathParam("dieticianId", dieticianID).delete(resourceAPI.getResource());	
	}

	@Then("Admin recieves {int} ok message with successful delete message")
	public void admin_recieves_ok_message_with_successful_delete_message(Integer exp_statusCode) {
	    response.then()
		.assertThat().statusCode(exp_statusCode);
		int actual_Status_Code = response.getStatusCode();
		Assert.assertEquals(actual_Status_Code, exp_statusCode);
	}

	@Given("Admin create POST request for deleting the dietician")
	public void admin_create_post_request_for_deleting_the_dietician() throws FileNotFoundException {
		request = RestAssured
				  .given()
				  	.spec(reqres.ReqSpec())
				  	.header("Authorization", "Bearer " +AdminLoginStepDef.adminToken);
	}

	@When("Admin send POST http request with endpoint")
	public void admin_send_post_http_request_with_endpoint() {
		String dieticianID = DieticianPostStepDef.dieticianIDs.get(1);
		APIResources  resourceAPI = APIResources.dietcianPutEndpoint;
		   		response =	request
				   .pathParam("dieticianId", dieticianID)
				   .when().post(resourceAPI.getResource());
	}

	@Then("Admin recieves {int} method not allowed for the delete request")
	public void admin_recieves_method_not_allowed_for_the_delete_request(Integer exp_statusCode) {
		   response.then()
			.assertThat().statusCode(exp_statusCode);
			int actual_Status_Code = response.getStatusCode();
			Assert.assertEquals(actual_Status_Code, exp_statusCode);
	}

	@When("Admin send Delete http request with endpoint for deleting the dietician by {string}")
	public void admin_send_delete_http_request_with_endpoint_for_deleting_the_dietician_by(String InvaliDieticianID) {
		APIResources  resourceAPI = APIResources.dietcianPutEndpoint;
		   response = request
				   .pathParam("dieticianId", InvaliDieticianID)
				   .when().delete(resourceAPI.getResource());
	}

	@Then("Admin recieves {int} not found for the the delete request")
	public void admin_recieves_not_found_for_the_the_delete_request(Integer exp_statusCode) {
		response.then()
		.assertThat().statusCode(exp_statusCode);
		int actual_Status_Code = response.getStatusCode();
		Assert.assertEquals(actual_Status_Code, exp_statusCode);
	}

	@When("Admin send DELETE http request with invalid endpoint")
	public void admin_send_delete_http_request_with_invalid_endpoint() {
		APIResources  resourceAPI = APIResources.invalidEndpoint;
		   response = request
				   .when().delete(resourceAPI.getResource());
	}



}
