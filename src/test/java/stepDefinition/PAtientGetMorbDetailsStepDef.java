package stepDefinition;

import java.io.FileNotFoundException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestBody.Post_Patient;
import testContext.TestContext;
import utilities.APIResources;
import utilities.ReqResSpec;
import utilities.ResourceBundleReader;

public class PAtientGetMorbDetailsStepDef {
	 RequestSpecification res;
 Response response;
 //String endpoint = "/patient/testReports/{patientId}";
 
 APIResources resourceApi = APIResources.patientMorbiditiesEndpoint;
 APIResources resourceApiinvalid = APIResources.patientMorbiditiesInvalidEndpoint;
 String endpoint=resourceApi.getResource();
 String invalidEndpoint=resourceApiinvalid.getResource();
 TestContext testContext;
 ReqResSpec reqres;
  ResourceBundleReader resource;
  String dieticiantoken="";

 public PAtientGetMorbDetailsStepDef(TestContext testcontext) {
 	  this.testContext = testcontext;
 	  reqres = testcontext.getReqResSpec();
 	  resource = testcontext.getResourceBundleReader();
 	  
 }
 
	@Given("Dietician create request")
	public void dietician_create_get_request() throws FileNotFoundException {
	//	res= RestAssured
			  //  .given()
			    //	.spec(reqres.ReqSpec()).header("Authorization", "Bearer "+dieticiantoken).pathParam("patientId",PatientPostStepDef.patientIDs.get(0));;
	   
		res=PatientPostStepDef.request.pathParam("patientId",PatientPostStepDef.patientIDs.get(0));
		
	}

	@When("Dietician send GET http request with endpoint")
	public void dietician_send_get_http_request_with_endpoint() {
	 

		 response = res
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
	}

	

	
	@When("Dietician send POST http request with endpoint for the patients morbidity")
	public void dietician_send_post_http_request_with_endpoint_for_the_patients_morbidity() {
	    

		 response = res
               .when()
               .post(endpoint)
               .then()
               .log().all()
               .extract()
               .response();
	}

	

	
	
	@Then("Dietician recieves {int} code")
	public void dietician_recieves_code(int int1) {
		Assert.assertEquals(response.statusCode(), int1);
		if(response.statusCode()==200)
		{
			response.then().log().all()
			.contentType(ContentType.JSON)
	        .and().body(JsonSchemaValidator.matchesJsonSchema(getClass()
	              .getClassLoader()
	              .getResourceAsStream("GetPatientMorbDetails.json")));
		}
	}

	@Given("Dietician create request for invalid patient ID")
	public void dietician_create_request_for_invalid_patient_id() {
		res=PatientPostStepDef.request.pathParam("patientId",989000000);
	}
	
	@When("Dietician send a GET http request with invalid endpoint")
	public void dietician_send_get_http_request_with_invalid_endpoint() {
		 response = res
	               .when()
	               .post(endpoint)
	               .then()
	               .log().all()
	               .extract()
	               .response();
	}
}
