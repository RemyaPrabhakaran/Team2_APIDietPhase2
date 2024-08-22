package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testContext.TestContext;
import utilities.APIResources;
import utilities.ReqResSpec;
import utilities.ResourceBundleReader;

public class PatientGetRetrievePatientFile extends ReqResSpec {
	
	 RequestSpecification res;
	 Response response;
	
	 
	 APIResources resourceApi = APIResources.RetrievePatientFileEndpoint;
	 APIResources resourceApiinvalid = APIResources.RetrievePatientFileInvalidEndpoint;
	 String endpoint=resourceApi.getResource();
	 String invalidEndpoint=resourceApiinvalid.getResource();
	 TestContext testContext;
	 ReqResSpec reqres;
	  ResourceBundleReader resource;

	 public PatientGetRetrievePatientFile(TestContext testcontext) {
	 	  this.testContext = testcontext;
	 	  reqres = testcontext.getReqResSpec();
	 	  resource = testcontext.getResourceBundleReader();
	 	  
	 }
	 
	
	@Given("Dietician create requests to retrieve patients by field")
	public void dietician_create_get_request_to_retrieve_patients_by_field() {
		res=PatientPostStepDef.request.pathParam("fileId", PatientPostStepDef.patientFileIds.get(0));
	}

	@When("Dietician send GET http request with endpointto retrieve patients by field")
	public void dietician_send_get_http_request_with_endpointto_retrieve_patients_by_field() {
		 response = res
	                .when()
	                .get(endpoint)
	                .then()
	                .log().all()
	                .extract()
	                .response();
	}

	@Then("Dietician recieves {int} for Retrieve Patient file by FileId")
	public void dietician_recieves_ok_with_details_of_the_patient_id(int int1) {
		Assert.assertEquals(response.statusCode(), int1);
	}


	@When("Dietician send  http request with invalid method")
	public void dietician_send_http_request_with_invalid_method() {
		 response = res
	                .when()
	                .post(endpoint)
	                .then()
	                .log().all()
	                .extract()
	                .response();
		
	}

	@Given("Dietician create requests to retrieve patients by invalid field")
	public void dietician_create_requests_to_retrieve_patients_by_invalid_field() {
	 
		res=PatientPostStepDef.request.pathParam("fileId",PatientPostStepDef.patientFileIds.get(0));

	}

	@When("Dietician send GET http request with invalid endpoint to retrive patient")
	public void dietician_send_get_http_request_with_invalid_endpoint_to_retrive_patient() {
	 
		 response = res
	                .when()
	                .get(invalidEndpoint)
	                .then()
	                .log().all()
	                .extract()
	                .response();
	}

}
