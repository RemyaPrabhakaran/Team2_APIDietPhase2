package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import requestBody.SetAdminToken_NegtaiveScenario;
import utilities.ExcelUtilities;
import utilities.Routes;

public class SetAdminToken_Steps_NegtaiveScenario 
{
	
	Response response;
	//String admintkn;
	
	SetAdminToken_NegtaiveScenario settoke=new SetAdminToken_NegtaiveScenario();
	
	@Given("Admin creates POST request by entering valid data into the form-data key and value fields.")
	public void admin_creates_post_request_by_entering_valid_data_into_the_form_data_key_and_value_fields() 
	{
		Login log=new Login();
		String dieticianEmails = DieticianPostStepDef.dieticianEmails.get(0);
		String dieticianpassword = DieticianPostStepDef.dieticianPasswords.get(0);
		response=	log.userlogin(dieticianEmails,dieticianpassword);
		
	}

	@When("Admin send POST http request with admin token with endpoint")
	public void admin_send_post_http_request_with_admin_token_with_endpoint() throws FileNotFoundException 
	{
		response=settoke.createPatient(Routes.adminToken);
	}

	@Then("Admin recieves {int} forbidden")
	public void admin_recieves_forbidden(Integer statuscode) 
	{
	   assertEquals(response.statusCode(), statuscode);
	}

	@Given("Admin creates PUT request by entering valid data into the form-data key and value fields.")
	public void admin_creates_put_request_by_entering_valid_data_into_the_form_data_key_and_value_fields() throws Exception 
	{
		List<Map<String, String>> testData = 
				ExcelUtilities.getTestDataInMap(System.getProperty("user.dir")+"\\src\\test\\resources\\Data\\Team2_APIDiet_Data .xlsx", "update_WithMandatoryFields","updateMandotoryfield");
										
						
										
										for(Map<String, String> data : testData) 
												{
										response=	settoke.updatePatient(data,Routes.adminToken);
												}
	}

	@When("Admin send PUT http request with admin token with endpoint")
	public void admin_send_put_http_request_with_admin_token_with_endpoint() 
	{
		List<Map<String, String>> testData = 
				ExcelUtilities.getTestDataInMap(System.getProperty("user.dir")+"\\src\\test\\resources\\Data\\Team2_APIDiet_Data .xlsx", "update_Patient","update");
										
						
										
										for(Map<String, String> data : testData) 
												{
										response=	settoke.addNewReportForExistingPatient(data,Routes.adminToken);
												}
	}

	@Given("Admin creates PUT request by entering valid data into the form-data key and value fields and valid patient ID")
	public void admin_creates_put_request_by_entering_valid_data_into_the_form_data_key_and_value_fields_and_valid_patient_id() {
	   
	}

//	@When("Admin send GET http request with admin token with endpoint")
//	public void admin_send_get_http_request_with_admin_token_with_endpoint() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

//	@Then("Admin recieves {int} Forbidden")
//	public void admin_recieves_forbidden(Integer int1) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

	@Given("Admin create GET request")
	public void admin_create_get_request() {
	   
	}

	@When("admin send GET http request with admin token with endpoint")
	public void admin_send_get_http_request_with_admin_token_with_endpoint() 
	{
	response=settoke.retrieveTestname("HBA1C", Routes.adminToken);
	}



}
