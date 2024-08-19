package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ReqResSpec;

public class PatientGetRetrievePatientFile extends ReqResSpec {
	
	 RequestSpecification res;
	 Response response;
	@Given("Dietician create GET request to retrieve patients by field")
	public void dietician_create_get_request_to_retrieve_patients_by_field() {
		res=PatientPostStepDef.request.pathParam("fileId","66c13d5ce30dde112fb8ff51");
	}

	@When("Dietician send GET http request with endpointto retrieve patients by field")
	public void dietician_send_get_http_request_with_endpointto_retrieve_patients_by_field() {
		 response = res
	                .when()
	                .get("/patient/testReports/viewFile/{fileId}")
	                .then()
	                .log().all()
	                .extract()
	                .response();
	}

	@Then("Dietician recieves {int} ok with details of the patient id")
	public void dietician_recieves_ok_with_details_of_the_patient_id(int int1, io.cucumber.datatable.DataTable dataTable) {
		Assert.assertEquals(response.statusCode(), int1);
	}




}
