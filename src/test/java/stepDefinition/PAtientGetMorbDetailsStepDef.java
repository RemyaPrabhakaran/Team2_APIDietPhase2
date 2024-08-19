package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestBody.Post_Patient;
import utilities.ReqResSpec;

public class PAtientGetMorbDetailsStepDef extends ReqResSpec {
	 RequestSpecification res;
 Response response;
	@Given("Dietician create request")
	public void dietician_create_get_request() {
	   
		res=PatientPostStepDef.request.pathParam("patientId",182);
		
	}

	@When("Dietician send GET http request with endpoint")
	public void dietician_send_get_http_request_with_endpoint() {
	 

		 response = res
                .when()
                .get("/patient/testReports/{patientId}")
                .then()
                .log().all()
                .extract()
                .response();
	}

	

	
	@When("Dietician send POST http request with endpoint for the patients morbidity")
	public void dietician_send_post_http_request_with_endpoint_for_the_patients_morbidity() {
	    

		 response = res
               .when()
               .post("/patient/testReports/{patientId}")
               .then()
               .log().all()
               .extract()
               .response();
	}

	

	
	
	@Then("Dietician recieves {int} code")
	public void dietician_recieves_code(int int1) {
		Assert.assertEquals(response.statusCode(), int1);
	}

	@Given("Dietician create request for invalid patient ID")
	public void dietician_create_request_for_invalid_patient_id() {
		res=PatientPostStepDef.request.pathParam("patientId",989000000);
	}
	
	@When("Dietician send GET http request with invalid endpoint")
	public void dietician_send_get_http_request_with_invalid_endpoint() {
		 response = res
	               .when()
	               .post("/patient/testRepots/{patientId}")
	               .then()
	               .log().all()
	               .extract()
	               .response();
	}
}
