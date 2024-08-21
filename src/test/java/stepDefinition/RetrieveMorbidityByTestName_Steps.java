package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import requestBody.Patient_Put;
import requestBody.RetrieveMorbidityByTestName;
import utilities.ExcelUtilities;
import utilities.Routes;

public class RetrieveMorbidityByTestName_Steps 

{
	Login log=new Login();
	Response response;
	
	RetrieveMorbidityByTestName morbiditytestname=new RetrieveMorbidityByTestName();
	@Given("admin create GET request")
	public void admin_create_get_request() 
	{
		
	  System.out.println("admon cfreadte get requests");
	}
	
	@When("admin send GET http request with endpoint")
	public void admin_send_get_http_request_with_endpoint() 
	{
		
		String dieticianEmails = DieticianPostStepDef.dieticianEmails.get(0);
		String dieticianpassword = DieticianPostStepDef.dieticianPasswords.get(0);
		response=	log.userlogin(dieticianEmails,dieticianpassword);
		Routes.dieticianToken=response.jsonPath().getString("token");
		System.out.println("admin token "+Routes.adminToken);
	}
	
	
	@When("admin checks {string} and send GET http request with endpoint")
	public void admin_checks_and_send_get_http_request_with_endpoint(String morbidityTestname) throws FileNotFoundException {
		response=morbiditytestname.retrieveTestname(morbidityTestname,Routes.dieticianToken);
	}

	@Then("admin recieves {int} ok with details of the patient id")
	public void admin_recieves_ok_with_details_of_the_patient_id(Integer statuscode) 
	{
	   assertEquals(response.getStatusCode(), statuscode);
	}
	@Then("admin recieves {int}")
	public void admin_recieves(Integer statuscode) {
		assertEquals(response.getStatusCode(), statuscode);
	}



	@Given("admin create POST request instead Get Request")
	public void admin_create_post_request_instead_get_request() {
	    
	}
	
	@When("admin send POST http request for  {string} name instead Get Request with endpoint")
	public void admin_send_post_http_request_for_name_instead_get_request_with_endpoint(String morbidityTestname) throws FileNotFoundException {
		response=morbiditytestname.methodNotAllowed(morbidityTestname,Routes.dieticianToken);

	}

	@When("admin send http GET request {string} with invalid test name")
	public void admin_send_http_get_request_with_invalid_test_name(String invalidmorbidityTestname) throws FileNotFoundException {
		response=morbiditytestname.retrieveMorbidity_WithInvalidTestName(invalidmorbidityTestname,Routes.dieticianToken);

	}


	@Then("admin recieves {int} method not allowed")
	public void admin_recieves_method_not_allowed(Integer statuscode) 
	{
		assertEquals(response.getStatusCode(), statuscode);
		System.out.println("response.getStatusLine()    "+response.getStatusLine());
		
	}
	
	@Then("admin recieves {int} not found")
	public void admin_recieves_not_found(Integer statuscode) {
		assertEquals(response.getStatusCode(), statuscode);
	}


@When("admin send GET http request {string} with invalid endpoint")
public void admin_send_get_http_request_with_invalid_endpoint(String morbidityTestname) throws FileNotFoundException {
	response=morbiditytestname.retrieveMorbidity_WithInvalid_END_Point(morbidityTestname,Routes.dieticianToken);

}
}
