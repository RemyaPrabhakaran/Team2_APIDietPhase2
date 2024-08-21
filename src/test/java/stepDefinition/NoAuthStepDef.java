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

public class NoAuthStepDef extends  ReqResSpec{
	RequestSpecification request1;
	RequestSpecification res;
	 Response response;
	
	    
	    
	
	
	  
	 Put_PatientAddNewReport pReport;
	  Post_Patient postPatient;
	  
	  String body;
	  String body1;
	  int exp_status_code;
	  
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
	   

	  public NoAuthStepDef(TestContext testcontext) {
	  	  this.testContext = testcontext;
	  	  reqres = testcontext.getReqResSpec();
	  	  resource = testcontext.getResourceBundleReader();
	  	  this.postPatient = new Post_Patient();
	  	this.pReport=new Put_PatientAddNewReport();
	  	  
	  }
	  
	@Given("Set no auth")
	public void set_no_auth() throws FileNotFoundException {
		 request1= RestAssured
				    .given()
				    	.spec(ReqSpec());
	   
	}

	@Given("Dietician creates POST request by entering valid data into the form-data key and value fields.")
	public void dietician_creates_post_request_by_entering_valid_data_into_the_form_data_key_and_value_fields() throws Exception {
	   
		List<Map<String, String>> testData = ExcelUtilities.getTestDataInMap(resource.getExcelFilePath(), "PatientPost", "ValidOne"
);
		
		for(Map<String, String> data : testData) {
			
			body = postPatient.getPatientReqBody(data); 
			exp_status_code = Integer.parseInt(data.get("StatusCode"));
			String filePath =resource.getPDFFile1();
			  File file = new File(filePath);
			res = request1
		                .multiPart("patientInfo", body)
		                .multiPart("file", file, "application/pdf");
		}
	}

	@Then("Dietician recieves {int} unauthorized")
	public void dietician_recieves_unauthorized(int int1) {
	  
		Assert.assertEquals(response.statusCode(), int1);
	}

	@Given("Dietician creates PUT request by entering valid data into the form-data key and value fields and valid patient ID")
	public void dietician_creates_put_request_by_entering_valid_data_into_the_form_data_key_and_value_fields_and_valid_patient_id() throws Exception {
		List<Map<String, String>> testData = ExcelUtilities.getTestDataInMap(resource.getExcelFilePath(), "PatientPutVitals", "Valid");
	//	List<Map<String, String>> testData1 = ExcelUtilities.getTestDataInMap("src/test/resources/Data/Team2_APIDiet_Data.xlsx", "PatientPutVitals", "Valid");
		
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
	@When("Dietician send POST http request with endpoint	no auth")
	public void dietician_send_post_http_request_with_endpoint_no_auth() {
		 response = res
                 .when()
                 .post(resourceApiPost.getResource())
                 .then()
                 .log().all()
                 .extract()
                 .response();
		 
	}

	@When("Dietician send PUT http request with endpoint no auth")
	public void dietician_send_put_http_request_with_endpoint_no_auth() {
		String filePath =resource.getPDFFile1();
		  File file = new File(filePath);
		res=	 request1.contentType("multipart/form-data").multiPart("patientInfo", body, "application/json")
			      
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

	@Given("Dietician create GET request no auth")
	public void dietician_create_get_request_no_auth() {
	    
		
		res=request1.pathParam("patientId",PatientPostStepDef.patientIDs.get(0));
		
		
	}

	@When("Dietician send GET http request with endpoint no auth")
	public void dietician_send_get_http_request_with_endpoint_no_auth() {
		
		response = res
                .when()
                .get(GetIDendpoint)
                .then()
                .log().all()
                .extract()
                .response();
	   
	}

	@When("Dietician send DELETE http request with endpoint no auth")
	public void dietician_send_delete_http_request_with_endpoint_no_auth() {
		response = res
                .when().delete
                (deleteendpoint)
                .then()
                .log().all()
                .extract()
                .response();
	   
	}
	@Given("Dietician create GET request no auth by fileId")
	public void dietician_create_get_request_no_auth_by_file_id() {
		res=request1.pathParam("fileId", PatientPostStepDef.patientFileIds.get(0));
		
	}

	@When("Dietician send GET http request with endpoint no auth for fileID")
	public void dietician_send_get_http_request_with_endpoint_no_auth_for_file_id() {
	   
		response = res
                .when()
                .get(getfileIDendpoint)
                .then()
                .log().all()
                .extract()
                .response();
	}

	@Given("Dietician create DELETE request for no auth")
	public void dietician_create_delete_request_for_no_auth() {
	   
		res=request1.pathParam("patientId",PatientPostStepDef.patientIDs.get(0)); 
		
	}

	
}
