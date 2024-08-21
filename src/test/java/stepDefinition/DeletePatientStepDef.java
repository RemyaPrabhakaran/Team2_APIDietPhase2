package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ReqResSpec;

public class DeletePatientStepDef extends ReqResSpec {
	RequestSpecification res;
	Response response;
String endpoint="/patient/{patientId}";
String invalidEndpoint="/patint/{patientId}";

	@Given("Dietician create DELETE request")
	public void dietician_create_delete_request() {
		res=PatientPostStepDef.request.pathParam("patientId",PatientPostStepDef.patientIDs.get(0));  
	}

	@When("Dietician send DELETE http request with endpoint")
	public void dietician_send_delete_http_request_with_endpoint() {
		response = res
                .when().delete
                (endpoint)
                .then()
                .log().all()
                .extract()
                .response();
	}
	
	
	
	@Then("Dietician recieves {int} for deletion")
	public void dietician_recieves_for_deletion(int int1) {
		Assert.assertEquals(response.statusCode(), int1);
	}

	@When("Dietician send POST http request with endpoint with invalid method")
	public void dietician_send_post_http_request_with_endpoint_with_invalid_method() {
	    
		response = res
                .when().get
                (endpoint)
                .then()
                .log().all()
                .extract()
                .response();
	}

	@Given("Dietician create DELETE request invalid Id")
	public void dietician_create_delete_request_invalid_id() {
		res=PatientPostStepDef.request.pathParam("patientId",PatientPostStepDef.patientIDs.get(0));
	   
	}

	@When("Dietician send DELETE http request with invalid endpoint")
	public void dietician_send_delete_http_request_with_invalid_endpoint() {
		response = res
                .when().get
                (invalidEndpoint)
                .then()
                .log().all()
                .extract()
                .response();
	}

}
