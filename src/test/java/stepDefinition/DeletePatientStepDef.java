package stepDefinition;

import java.io.FileNotFoundException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestBody.Put_PatientAddNewReport;
import testContext.TestContext;
import utilities.APIResources;
import utilities.ReqResSpec;
import utilities.ResourceBundleReader;

public class DeletePatientStepDef extends ReqResSpec {
	RequestSpecification res;
	RequestSpecification res1;
	Response response;

APIResources resourceApi = APIResources.DeletePatientEndpoint;
APIResources resourceApiinvalid = APIResources.DeletePatientInvalidEndpoint;
APIResources resourceApiGet= APIResources.patientMorbiditiesEndpoint;
String endpoint=resourceApi.getResource();
String invalidEndpoint=resourceApiinvalid.getResource();
String getendpoint=resourceApiGet.getResource();
TestContext testContext;
ReqResSpec reqres;
 ResourceBundleReader resource;
String dieticiantoken="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJUZWFtbm0uYW1pbkBnbWFpbC5jb20iLCJpYXQiOjE3MjQyNTg4NTYsImV4cCI6MTcyNDI4NzY1Nn0.kf9xaJOGqVTUiyrp0XrbRduwaVvKI_03hUdIygDdHHvf99VoqatrKb22Vo-xm3-H2BpWmIHk2StkimEHXWfn_Q";
public DeletePatientStepDef(TestContext testcontext) {
	  this.testContext = testcontext;
	  reqres = testcontext.getReqResSpec();
	  resource = testcontext.getResourceBundleReader();
	  
}
@Given("Set dietician bearer token for delete")
public void Set_dietician_bearer_token_for_delete() throws FileNotFoundException
{
	
	 res= RestAssured
				    .given()
				    	.spec(reqres.ReqSpec()).header("Authorization", "Bearer "+dieticiantoken);;
	
	
	
}

	@Given("Dietician create DELETE request")
	public void dietician_create_delete_request() {
		res1=res.pathParam("patientId",PatientPostStepDef.patientIDs.get(0));  
	}

	@When("Dietician send DELETE http request with endpoint")
	public void dietician_send_delete_http_request_with_endpoint() {
		response = res1
                .when().delete
                (endpoint)
                .then()
                .log().all()
                .extract()
                .response();
	}
	
	
	
	@Then("Dietician recieves {int} for deletion")
	public void dietician_recieves_for_deletion(int int1) throws FileNotFoundException {
		Assert.assertEquals(response.statusCode(), int1);
		if (response.statusCode()==200)
		{
			response = RestAssured
	                .given()
	                .spec(reqres.ReqSpec())
	                .header("Authorization", "Bearer " + dieticiantoken)
	                .pathParam("patientId", PatientPostStepDef.patientIDs.get(0))
	                .when()
	                .get(getendpoint)
	                .then()
	                .log().all()
	                .extract()
	                .response();
			Assert.assertEquals(response.statusCode(), 404);
		}
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
