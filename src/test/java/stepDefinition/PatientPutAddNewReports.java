package stepDefinition;

import java.io.File;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ExcelUtilities;
import utilities.ReqResSpec;
import utilities.ResourceBundleReader;
import requestBody.Put_PatientAddNewReport;
public class PatientPutAddNewReports extends ReqResSpec {
	
    
    
	  String body;
	  String body1;
	  int exp_status_code;
	  RequestSpecification res;
	  RequestSpecification request;
		 Response response;
		 Put_PatientAddNewReport pReport=new Put_PatientAddNewReport();
		  String dieticiantoken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJUZWFtbm0uYW1pbkBnbWFpbC5jb20iLCJpYXQiOjE3MjQxMDY2MTAsImV4cCI6MTcyNDEzNTQxMH0.xdHR7ILm0tkEaX9TlwTYOmcPx_1i5TcJ0HoVWEt-TaCaYarmtxf_99RxS10pKffqqRuLagyMag-9DYtbklqX8w";
		  String endpoint = "/patient/newReports/" + PatientPostStepDef.patientIDs.get(0);
		  String invalid= "/patient/neReports/"+ PatientPostStepDef.patientIDs.get(0);
		  ResourceBundleReader reader = new ResourceBundleReader();
		  String filePath =reader.getPDFFile2();
		  File file = new File(filePath);
		  
	@Given("Dietician creates PUT request by entering  data for the {string} from the {string}")
	public void dietician_creates_put_request_by_entering_data_for_the_from_the(String scenario, String sheet) throws Exception {
		request= RestAssured
			    .given()
			    	.spec(ReqSpec()).header("Authorization", "Bearer "+dieticiantoken);
		
		
		List<Map<String, String>> testData = ExcelUtilities.getTestDataInMap(reader.getExcelFilePath(), sheet, scenario);
		//List<Map<String, String>> testData1 = ExcelUtilities.getTestDataInMap(reader.getExcelFilePath(), sheet, scenario);
		
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

	@When("Dietician send PUT http request with endpoint")
	public void dietician_send_put_http_request_with_endpoint() {
		
		
		res=	 request.contentType("multipart/form-data").multiPart("patientInfo", body, "application/json")
			      
		        .multiPart("file", file, "application/json")
		        .multiPart("vitals", body1, "application/json");
	    
		 
		 response = res
		            .when()
		            .put(endpoint)
		            .then()
		            .log().all()
		            .extract()
		            .response();
		 
	}

	@Then("Dietician recieves response for the respective {string} for add New Reports with or without Vitals")
	public void dietician_recieves_response_for_the_respective_for_add_new_reports_with_without_vitals(String string) {
		response.then().log().all().assertThat().statusCode(exp_status_code);
		
		if(response.statusCode()==200)
		{
			response.then().log().all()
			.contentType(ContentType.JSON)
	        .and().body(JsonSchemaValidator.matchesJsonSchema(getClass()
	              .getClassLoader()
	              .getResourceAsStream("PutPatientReportSchema.json")));
		}
	}

	@When("Dietician send  http request with endpoint and invalid method for Add New Reports with or without Vitals")
	public void dietician_send_http_request_with_endpoint_and_invalid_method_for_add_new_reports_with_without_vitals() {

		res=	 request.contentType("multipart/form-data").multiPart("patientInfo", body, "application/json")
			      
		        .multiPart("file", file, "application/json")
		        .multiPart("vitals", body1, "application/json"); 
		response = res
		            .when()
		            .post(endpoint)
		            .then()
		            .log().all()
		            .extract()
		            .response();
		 
	}

	@Then("Dietician recieves {int} statuscode for Add New Reports with or without Vitals")
	public void dietician_recieves_statuscode_for_add_new_reports_with_without_vitals(Integer int1) {
		response.then().log().all().assertThat().statusCode(exp_status_code);
	}

	@When("Dietician send  http request with endpoint and invalid endpoint for Add New Reports with or without Vitals")
	public void dietician_send_http_request_with_endpoint_and_invalid_endpoint_for_add_new_reports_with_without_vitals() {

		res=	 request.contentType("multipart/form-data").multiPart("patientInfo", body, "application/json")
			      
		        .multiPart("file", file, "application/json")
		        .multiPart("vitals", body1, "application/json");
		response = res
		            .when()
		            .put(invalid)
		            .then()
		            .log().all()
		            .extract()
		            .response();
		 
	}

	@When("Dietician send  http request with endpoint and invalid content type for Add New Reports with or without Vitals")
	public void dietician_send_http_request_with_endpoint_and_invalid_content_type_for_add_new_reports_with_without_vitals() {
		res=	 request.contentType("multipart/form-data").multiPart("patientInfo", body, "appl/json")
			      
		        .multiPart("file", file, "text/json")
		        .multiPart("vitals", body1, "application/json");
		response = res
		            .when()
		            .put(endpoint)
		            .then()
		            .log().all()
		            .extract()
		            .response();
		
	}
	

	@When("Dietician send PUT http request with endpoint with invalid vitals and nofile")
	public void dietician_send_put_http_request_with_endpoint_with_nofile() {
	    
		res=	 request.contentType("multipart/form-data").multiPart("patientInfo", body, "application/json")
			      
		        
		        .multiPart("vitals", body1, "application/json");
		response = res
		            .when()
		            .put(endpoint)
		            .then()
		            .log().all()
		            .extract()
		            .response();
	}

	
}
