package stepDefinition;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestBody.Post_Patient;
import requestBody.Put_PatientAddNewReport;
import testContext.TestContext;
import utilities.APIResources;
import utilities.ExcelUtilities;
import utilities.ReqResSpec;
import utilities.ResourceBundleReader;

public class AminTokenStepDef extends ReqResSpec {

//	String adminToken="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJUZWFtMTAuYWRtaW5AZ21haWwuY29tIiwiaWF0IjoxNzI0MjcyMDE5LCJleHAiOjE3MjQzMDA4MTl9.kaWohIDPAMypk3pE2Z1z1olxMJ8saTh3HLPew9cd2GCe9QiplPkHBSFKgrXrGIX2S5fBQHbEESfOIP4-yU4BPw";
	RequestSpecification request;
	RequestSpecification res;
	 Response response;
	 APIResources resourceApiPut = APIResources.newReportsEndpoint;
	  APIResources resourceApiGet = APIResources.patientMorbiditiesEndpoint;
	  APIResources resourceApiGetFile = APIResources.RetrievePatientFileEndpoint;
	  APIResources resourceApiDelete = APIResources.DeletePatientEndpoint;
	  APIResources resourceApiPost = APIResources.patientEndpoint;
	  String putendpoint = resourceApiPut.getResource() + PatientPostStepDef.patientIDs.get(0);
	    String GetIDendpoint = resourceApiGet.getResource();
	    String getfileIDendpoint=resourceApiGetFile.getResource();
	    String deleteendpoint=resourceApiDelete.getResource();
	
	  TestContext testContext;
	  ReqResSpec reqres;
	   ResourceBundleReader resource;
	   

	  public AminTokenStepDef(TestContext testcontext) {
	  	  this.testContext = testcontext;
	  	  reqres = testcontext.getReqResSpec();
	  	  resource = testcontext.getResourceBundleReader();
	  	  this.postPatient = new Post_Patient();
	  	this.pReport=new Put_PatientAddNewReport();
	  	  
	  }
	    
	    
	 
	 
	 Put_PatientAddNewReport pReport=new Put_PatientAddNewReport();
	  Post_Patient postPatient = new Post_Patient();
	  
	  String body;
	  String body1;
	  int exp_status_code;
	
	@Given("Set admin token")
	public void set_admin_token() throws FileNotFoundException {
		request= RestAssured
			    .given()
			    	.spec(ReqSpec()).header("Authorization", "Bearer "+AdminLoginStepDef.adminToken);
	    
	}

	@Given("Admin creates POST request by entering valid data into the form-data key and value fields.")
	public void admin_creates_post_request_by_entering_valid_data_into_the_form_data_key_and_value_fields() throws Exception {
		

		List<Map<String, String>> testData = ExcelUtilities.getTestDataInMap(resource.getExcelFilePath(), "PatientPost", "ValidOne"
);
		
		for(Map<String, String> data : testData) {
			
			body = postPatient.getPatientReqBody(data); 
			exp_status_code = Integer.parseInt(data.get("StatusCode"));
			String filePath =resource.getPDFFile1();
            File file = new File(filePath);
			res = request
		                .multiPart("patientInfo", body)
		                .multiPart("file", file, "application/pdf");
		}
	}

	@When("Admin sends POST http request with endpoint with admin token")
	public void admin_sends_post_http_req_with_endpoint_admin_token() {
		
		response = res
                .when()
                .post(resourceApiPost.getResource())
                .then()
                .log().all()
                .extract()
                .response();
	}
	

	@Then("Admin recieves {int} forbidden")
	public void admin_recieves_forbidden(int int1) {
		
	}

	@Given("Admin creates PUT request by entering valid data into the form-data key and value fields and valid patient ID")
	public void admin_creates_put_request_by_entering_valid_data_into_the_form_data_key_and_value_fields_and_valid_patient_id() throws Exception {
	   
		List<Map<String, String>> testData = ExcelUtilities.getTestDataInMap(resource.getExcelFilePath(), "PatientPutVitals", "Valid");
		//List<Map<String, String>> testData1 = ExcelUtilities.getTestDataInMap("src/test/resources/Data/Team2_APIDiet_Data.xlsx", "PatientPutVitals", "Valid");
		
		for(Map<String, String> data : testData) {
			
			body = pReport.getPatientPutReqBody(data) ;
			exp_status_code = Integer.parseInt(data.get("StatusCode"));
		}
		for(Map<String, String> data : testData)
		{
			body1= pReport.getPatientPutvitals(data);
		}
			
			
			System.out.println("Body: " + body);
			System.out.println("Body1: " + body1);
		                
		              
	}
	
	

	@When("Admin sends PUT http request with endpoint")
	public void admin_sends_put_http_request_with_endpoint() {
		 String filePath =resource.getPDFFile1();
		  File file = new File(filePath);
	    
		res=	 request.contentType("multipart/form-data").multiPart("patientInfo", body, "application/json")
			      
		        .multiPart("file", file, "application/json")
		        .multiPart("vitals", body1, "application/json");
	    
		 
		 response = res
		            .when()
		            .put(putendpoint)
		            .then()
		            .log().all()
		            .extract()
		            .response();
	   
	}

	@Given("Admin creates GET request")
	public void admin_creates_get_request() {
	    
		res=request.pathParam("patientId",PatientPostStepDef.patientIDs.get(0));
	}

	@When("Admin send GET http request with endpoint")
	public void admin_send_get_http_request_with_endpoint() {
	 
		response = res
                .when()
                .get(GetIDendpoint)
                .then()
                .log().all()
                .extract()
                .response();
	}

	@Given("Admin create GET request by fileId")
	public void admin_create_get_request_no_auth_by_file_id() {
	   
		res=request.pathParam("fileId", PatientPostStepDef.patientFileIds.get(0));
		
		
	}

	@When("Admin send GET http request with endpoint for fileID")
	public void admin_send_get_http_request_with_endpoint_for_file_id() {
	   
		response = res
                .when()
                .get(getfileIDendpoint)
                .then()
                .log().all()
                .extract()
                .response();
		
	}

	@Given("Admin create DELETE request")
	public void admin_create_delete_request() {
		res=request.pathParam("patientId",PatientPostStepDef.patientIDs.get(0)); 
		
	}

	@When("Admin send DELETE http request with endpoint")
	public void admin_send_delete_http_request_with_endpoint() {
		response = res
                .when()
                .get(GetIDendpoint)
                .then()
                .log().all()
                .extract()
                .response();
		
	}

	
}
