package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import requestBody.Patient_Put;
import utilities.ExcelUtilities;
import utilities.Routes;

public class PatientPut_Operation_Steps 

{
	Response response;
	String dtoToken;
	/// first need to login as a admin
	// with admin bearer token create dietician(in response  i will get logi)
	//dietician login i will get one more bearer token
	// with bearer token will perform put operation(before that i need to create one patient)

	
	
//	create dietician   {
//	    "id": 235,
//	    "loginPassword": "Viper33",
//	    "Firstname": "shan",
//	    "Lastname": "sharma",
//	    "ContactNumber": "1234567890",
//	    "DateOfBirth": "2001-09-11T00:00:00.000+00:00",
//	    "Email": "sanuu.u@gmail.com",
//	    "HospitalName": "baptist",
//	    "HospitalStreet": "cordova",
//	    "HospitalCity": "dallas",
//	    "HospitalPincode": "123456",
//	    "Education": "MCA"
//	}
//	--------------   {"password":"Viper33","userLoginEmail":"sanuu.u@gmail.com"}
//	login dietician   {
//	    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYW51dS51QGdtYWlsLmNvbSIsImlhdCI6MTcyMzgwNTEzMSwiZXhwIjoxNzIzODMzOTMxfQ.8L-QFSSV0JTFzvakiuGoStoHhvFdqXn7eiAHfwnADiZtlyj4kMeZ-TGoisNjQFYD-hYuf8wODvrwdpqjq50q5A",
//	    "type": "Bearer ",
//	    "userId": 337,
//	    "loginUserEmail": "sanuu.u@gmail.com",
//	    "roles": [
//	        "ROLE_DIETICIAN"
//	    ]
//	}
	

	
	@Given("Dietician creates PUT request by entering valid data. \\( Mandatory and additional details) into the form-data key and value fields.")
	public void dietician_creates_put_request_by_entering_valid_data_mandatory_and_additional_details_into_the_form_data_key_and_value_fields() throws Exception {
	
//		Login lg=new Login();
//		response=lg.userlogin("Team10.admin@gmail.com","test");
//		String authToken = response.jsonPath().getString("token");
//		dtoToken=response.jsonPath().getString("token");
//		
//		response=	lg.createDietician(dtoToken);
//	
//	
//	String email=response.jsonPath().getString("Email");
//	String pasword=response.jsonPath().getString("loginPassword");
//	
//	response=lg.dieticianLogin(email,pasword);
//		String dietician_TKN = response.jsonPath().getString("token");
////		
//		Util.dieticianid=email;
//		Util.dieticianLoginpassword=pasword;
//		//lg.createPatient(dietician_TKN);
//		
//		
//		Patient_Put p_put=new Patient_Put();
		//
		Patient_Put p_put=new Patient_Put();
		//p_put.createPatient(dietician_TKN);
		//
		//Patient_Put p_put=new Patient_Put();
//		List<Map<String, String>> testData = 
//ExcelUtilities.getTestDataInMap("C:\\Users\\mayan\\git\\Team2_APIRestAssured\\Team2_APIDietPhase2\\src\\test\\resources\\Data\\Team2_APIDiet_Data .xlsx", "update_Patient","update");
//								
//						
//						for(Map<String, String> data : testData) 
//								{
//							p_put.updatePatient(data);
//								}
		
		
		
		
		
		
	}

	@When("Dietician send PUT http request with endpoint")
	public void dietician_send_put_http_request_with_endpoint() throws Exception 
	
	{
		Patient_Put p_put=new Patient_Put();
		List<Map<String, String>> testData = 
ExcelUtilities.getTestDataInMap("C:\\Users\\mayan\\git\\Team2_APIRestAssured\\Team2_APIDietPhase2\\src\\test\\resources\\Data\\Team2_APIDiet_Data .xlsx", "update_Patient","update");
						
		
						
						for(Map<String, String> data : testData) 
								{
						response=	p_put.updatePatient(data);
								}
	}

	@Then("Dietician recieves {int} ok and with updated response body.")
	public void dietician_recieves_ok_and_with_updated_response_body(Integer statuscode_200) 
	{
		assertEquals(response.getStatusCode(), statuscode_200);
		System.out.println("status code "+response.getStatusCode() );
	}

	@Given("Dietician creates PUT request by entering only valid mandatory details into the form-data key and value fields.")
	public void dietician_creates_put_request_by_entering_only_valid_mandatory_details_into_the_form_data_key_and_value_fields() 
	{
	  
	}
	
	
	@When("Dietician send PUT http  request for madatory field only with endpoint")
	public void dietician_send_put_http_request_for_madatory_field_only_with_endpoint() throws Exception 
	{
		
		Patient_Put p_put=new Patient_Put();
		List<Map<String, String>> testData = 
ExcelUtilities.getTestDataInMap("C:\\Users\\mayan\\git\\Team2_APIRestAssured\\Team2_APIDietPhase2\\src\\test\\resources\\Data\\Team2_APIDiet_Data .xlsx", "update_WithMandatoryFields","updateMandotoryfield");
						
		
						
						for(Map<String, String> data : testData) 
								{
						response=	p_put.updatePatient(data);
								}
	}
	
	
	
	@When("Dietician send PUT http request with valid data and invalid patient id with endpoint")
	public void dietician_send_put_http_request_with_valid_data_and_invalid_patient_id_with_endpoint() 
	{
		
		Patient_Put p_put=new Patient_Put();
		List<Map<String, String>> testData = 
ExcelUtilities.getTestDataInMap("C:\\Users\\mayan\\git\\Team2_APIRestAssured\\Team2_APIDietPhase2\\src\\test\\resources\\Data\\Team2_APIDiet_Data .xlsx", "update_Patient","update");
						
		for(Map<String, String> data : testData) 
		{
response=	p_put.updatePatientWithInvalid_PatientID(data);
		}
	}


	   
	
	
	@Given("Dietician creates PUT request by entering only valid additional details into the form-data key and value fields.")
	public void dietician_creates_put_request_by_entering_only_valid_additional_details_into_the_form_data_key_and_value_fields() {
	    
	}
	
	
	@When("Dietician send  http PUT request with mandatory fields empty and only with valid additional details with endpoint")
	public void dietician_send_http_put_request_with_mandatory_fields_empty_and_only_with_valid_additional_details_with_endpoint() throws Exception 
	{
		Patient_Put p_put=new Patient_Put();
		List<Map<String, String>> testData = 
ExcelUtilities.getTestDataInMap("C:\\Users\\mayan\\git\\Team2_APIRestAssured\\Team2_APIDietPhase2\\src\\test\\resources\\Data\\Team2_APIDiet_Data .xlsx", "emptyMandatoryFields","emptyFields");
						
		
						
						for(Map<String, String> data : testData) 
								{
						response=	p_put.updatePatient(data);
	}}

	@Then("Dietician recieves {int} Bad request")
	public void dietician_recieves_bad_request(Integer statuscode) 
	{
		assertEquals(response.getStatusCode(), statuscode);
		System.out.println("status code "+response.getStatusCode() );
	}

	@Given("Dietician creates PUT request by entering only invalid additional details into the form-data key and value fields.")
	public void dietician_creates_put_request_by_entering_only_invalid_additional_details_into_the_form_data_key_and_value_fields() {
	    
	}
	
	@When("Dietician send PUT http request with invalid data with endpoint")
	public void dietician_send_put_http_request_with_invalid_data_with_endpoint() throws Exception 
	{
		Patient_Put p_put=new Patient_Put();
		List<Map<String, String>> testData = 
ExcelUtilities.getTestDataInMap("C:\\Users\\mayan\\git\\Team2_APIRestAssured\\Team2_APIDietPhase2\\src\\test\\resources\\Data\\Team2_APIDiet_Data .xlsx", "invaliddata","invalid_data");
						
		
						
						for(Map<String, String> data : testData) 
								{
						response=	p_put.updatePatient(data);
	}}

	@Then("Dietician recieves {int} not found")
	public void dietician_recieves_not_found(Integer statuscode) {
		assertEquals(response.getStatusCode(), statuscode);
		System.out.println("status code "+response.getStatusCode() );
	}

	@Given("Dietician creates PUT request by not attaching any file into the form-data key and value fields.")
	public void dietician_creates_put_request_by_not_attaching_any_file_into_the_form_data_key_and_value_fields() {
	    
	}
	
	
	@When("Dietician send PUT http request by not attaching any file into the form-data with endpoint")
	public void dietician_send_put_http_request_by_not_attaching_any_file_into_the_form_data_with_endpoint() 
	{
		Patient_Put p_put=new Patient_Put();
		List<Map<String, String>> testData = 
ExcelUtilities.getTestDataInMap("C:\\Users\\mayan\\git\\Team2_APIRestAssured\\Team2_APIDietPhase2\\src\\test\\resources\\Data\\Team2_APIDiet_Data .xlsx", "update_Patient","update");
									
		
						
						for(Map<String, String> data : testData) 
								{
						response=	p_put.updatePatient_WithoutAttachingFile(data);
	}}

	@Given("Dietician creates PUT request by entering valid data into the form-data key and value fields.")
	public void dietician_creates_put_request_by_entering_valid_data_into_the_form_data_key_and_value_fields() {
	   
	}
	
	@When("Dietician send POST http request with valid data and invalid method with endpoint")
	public void dietician_send_post_http_request_with_valid_data_and_invalid_method_with_endpoint() 
	{
		Patient_Put p_put=new Patient_Put();
		List<Map<String, String>> testData = 
ExcelUtilities.getTestDataInMap("C:\\Users\\mayan\\git\\Team2_APIRestAssured\\Team2_APIDietPhase2\\src\\test\\resources\\Data\\Team2_APIDiet_Data .xlsx", "update_Patient","update");
									
		
						
						for(Map<String, String> data : testData) 
								{
						response=	p_put.updatePatient_methodNotAllowed(data);
	}}

//	@When("Dietician send POST http request with endpoint")
//	public void dietician_send_post_http_request_with_endpoint() {
//	    
//	}

	@Then("Dietician recieves {int} method not allowed")
	public void dietician_recieves_method_not_allowed(Integer statuscode) 
	{
		assertEquals(response.getStatusCode(), statuscode);
		System.out.println("status code "+response.getStatusCode() );
	}

	@When("Dietician sent PUT http request with invalid endpoint")
	public void dietician_sent_put_http_request_with_invalid_endpoint() 
	{
		Patient_Put p_put=new Patient_Put();
		List<Map<String, String>> testData = 
ExcelUtilities.getTestDataInMap("C:\\Users\\mayan\\git\\Team2_APIRestAssured\\Team2_APIDietPhase2\\src\\test\\resources\\Data\\Team2_APIDiet_Data .xlsx", "update_Patient","update");
									
		
						
						for(Map<String, String> data : testData) 
								{
						response=	p_put.updatePatient_WithInvaliEndPoint(data);
	}}

	@Given("Dietician creates PUT request by entering valid data into the form-data key and value fields and invalid content type")
	public void dietician_creates_put_request_by_entering_valid_data_into_the_form_data_key_and_value_fields_and_invalid_content_type()
	{
 
	}
	
	@When("Dietician send PUT http request valid data, patient id and invalid content type with endpoint")
	public void dietician_send_put_http_request_valid_data_patient_id_and_invalid_content_type_with_endpoint() {
		Patient_Put p_put=new Patient_Put();
		List<Map<String, String>> testData = 
ExcelUtilities.getTestDataInMap("C:\\Users\\mayan\\git\\Team2_APIRestAssured\\Team2_APIDietPhase2\\src\\test\\resources\\Data\\Team2_APIDiet_Data .xlsx", "update_Patient","update");
									
		
						
						for(Map<String, String> data : testData) 
								{
						response=	p_put.updatePatient_WithInvalidContentType(data);
	} 
	}

	@Then("Dietician recieves {int} unsupported media type")
	public void dietician_recieves_unsupported_media_type(Integer statuscode) 
	{
		//assertEquals(response.getStatusCode(), statuscode);
		//System.out.println("status code "+response.getStatusCode() ); 
	}
}
