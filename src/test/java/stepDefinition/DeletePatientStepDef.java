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

	RequestSpecification res1;
	RequestSpecification res2;
	Response response1;
	Response response2;
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
String dieticiantoken="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJUZWFtbm0uYW1pbkBnbWFpbC5jb20iLCJpYXQiOjE3MjQyNjY4NDcsImV4cCI6MTcyNDI5NTY0N30.SzEGGUC99E8nZKMyqrj9cBgx36tthxbaY3gtaLpttKeDgnnBMHpH3Rd4nYH8kXyE50mmlh6EbQ_NZ6tC60oANw";
public DeletePatientStepDef(TestContext testcontext) {
	  this.testContext = testcontext;
	  reqres = testcontext.getReqResSpec();
	  resource = testcontext.getResourceBundleReader();
	  
}
@Given("Set dietician bearer token for delete")
public void Set_dietician_bearer_token_for_delete() throws FileNotFoundException
{
	
	 res1= RestAssured
				    .given()
				    	.spec(reqres.ReqSpec()).header("Authorization", "Bearer "+dieticiantoken);;
	
				    	res2= RestAssured
							    .given()
							    	.spec(reqres.ReqSpec()).header("Authorization", "Bearer "+dieticiantoken);;
	
}

	@Given("Dietician create DELETE request")
	public void dietician_create_delete_request() {
		System.out.println("Pateient 1:"+ PatientPostStepDef.patientIDs.get(0));
		System.out.println("Pateient 2:"+ PatientPostStepDef.patientIDs.get(1));

		res1=res1.pathParam("patientId",PatientPostStepDef.patientIDs.get(0));  
		res2 = res2.pathParam("patientId", PatientPostStepDef.patientIDs.get(1));
	}

	@When("Dietician send DELETE http request with endpoint")
	public void dietician_send_delete_http_request_with_endpoint() {
		response1 = res1
                .when().delete
                (endpoint)
                .then()
                .log().all()
                .extract()
                .response();
		response2 = res2
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
	}
	
	
	
	@Then("Dietician recieves {int} for deletion")
	public void dietician_recieves_for_deletion(int int1) throws FileNotFoundException {
	/*	Assert.assertEquals(response1.statusCode(), int1);
		if (response1.statusCode()==200)
		{
			response1 = RestAssured
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
			Assert.assertEquals(response1.statusCode(), 404);
			
			
		}*/
		
		
		Assert.assertEquals(response1.statusCode(), int1);
	    Assert.assertEquals(response2.statusCode(), int1);

	    if (response1.statusCode() == 200 && response2.statusCode() == 200) {
	        // Validate that the patients are indeed deleted
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

	        response = RestAssured
	                    .given()
	                    .spec(reqres.ReqSpec())
	                    .header("Authorization", "Bearer " + dieticiantoken)
	                    .pathParam("patientId", PatientPostStepDef.patientIDs.get(1))
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
	    
		response1 = res1
                .when().get
                (endpoint)
                .then()
                .log().all()
                .extract()
                .response();
	}

	@Given("Dietician create DELETE request invalid Id")
	public void dietician_create_delete_request_invalid_id() {
		res1=res1.pathParam("patientId",PatientPostStepDef.patientIDs.get(0));
	   
	}

	@When("Dietician send DELETE http request with invalid endpoint")
	public void dietician_send_delete_http_request_with_invalid_endpoint() {
		response1 = res1
                .when().get
                (invalidEndpoint)
                .then()
                .log().all()
                .extract()
                .response();
	}

	
	@Then("Dietician recieves {int} for patient deletion")
	public void dietician_recieves_for_patient_deletion(int int1) {
		Assert.assertEquals(response1.statusCode(), int1);
	}
}
