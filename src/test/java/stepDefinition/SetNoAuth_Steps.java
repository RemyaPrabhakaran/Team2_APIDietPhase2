package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import requestBody.SetNoAuth;
import utilities.ExcelUtilities;

public class SetNoAuth_Steps {

	
	SetNoAuth set_na=new SetNoAuth();
	String POST="POST",PUT ="PUT",DELETE="DELETE";
	Response response;
	@Given("Dietician creates POST request  by entering valid data into the form-data key and value fields without token.")
	public void dietician_creates_post_request_by_entering_valid_data_into_the_form_data_key_and_value_fields_without_token() {

  
	}

	@When("Dietician send POST http request without token with endpoint")
	public void dietician_send_post_http_request_without_token_with_endpoint() throws Exception {

		List<Map<String, String>> testData = 
				ExcelUtilities.getTestDataInMap(System.getProperty("user.dir")+"\\src\\test\\resources\\Data\\Team2_APIDiet_Data .xlsx","update_Patient","update");
		
		for(Map<String, String> data : testData) 
				{
		response=set_na.post_pu_delete_PatientRequest(data,POST);
		
				}
	}

	@Given("Dietician creates PUT request by entering valid data into the form-data key and value fields without token.")
	public void dietician_creates_put_request_by_entering_valid_data_into_the_form_data_key_and_value_fields_without_token() {


	}

	@When("Dietician send PUT http request without token with endpoint")
	public void dietician_send_put_http_request_without_token_with_endpoint() throws Exception {

		List<Map<String, String>> testData = 
				ExcelUtilities.getTestDataInMap(System.getProperty("user.dir")+"\\src\\test\\resources\\Data\\Team2_APIDiet_Data .xlsx","update_Patient","update");
		
		for(Map<String, String> data : testData) 
				{
		response=set_na.post_pu_delete_PatientRequest(data,PUT);
				}
	}

	@Given("Dietician creates PUT request by entering valid data into the form-data key and value fields and valid patient ID without token")
	public void dietician_creates_put_request_by_entering_valid_data_into_the_form_data_key_and_value_fields_and_valid_patient_id_without_token() {


	}

	@Given("Dietician create GET request without token")
	public void dietician_create_get_request_without_token() {
	    
	}

	@When("Dietician send GET http request without token with endpoint")
	public void dietician_send_get_http_request_without_token_with_endpoint() {

		response=set_na.getAllPatient();
	}

	@Given("Dietician create DELETE request without token")
	public void dietician_create_delete_request_without_token() throws Exception 
	{
		

	}

	@When("Dietician send DELETE http request without token with endpoint")
	public void dietician_send_delete_http_request_without_token_with_endpoint() throws Exception 
	
		{
		List<Map<String, String>> testData = 
				ExcelUtilities.getTestDataInMap(System.getProperty("user.dir")+"\\src\\test\\resources\\Data\\Team2_APIDiet_Data .xlsx","update_Patient","update");
		
		for(Map<String, String> data : testData) 
		{
     response=set_na.post_pu_delete_PatientRequest(data,DELETE);
		}

	}
	
 @Then("Dietician recieves {int} unauthorized")
	public void dietician_recieves_unauthorized(Integer statucode) 
	{
	   assertEquals(response.getStatusCode(), statucode);
	}

}
