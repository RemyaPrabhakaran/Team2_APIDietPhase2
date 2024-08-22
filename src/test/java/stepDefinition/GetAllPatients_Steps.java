
package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestBody.GetAllPatients;
import testContext.TestContext;
import utilities.ReqResSpec;
import utilities.Routes;

public class GetAllPatients_Steps 
{
Response response;
RequestSpecification request;
ReqResSpec reqres;
//String dietician_tkn = "";
GetAllPatients  gap=new GetAllPatients();
DieticianPostStepDef dietician;
TestContext testContext;

@Given("Dietician create GET request")

public void dietician_create_get_request() throws FileNotFoundException 
{
	request= RestAssured
		    .given()
		    	.spec(reqres.ReqSpec())
		    	.header("Authorization", "Bearer " +AdminLoginStepDef_Dietician.dieticianToken);
   
}

@When("Dietician send a GET http request with endpoint")
public void dietician_send_a_get_http_request_with_endpoint() throws FileNotFoundException 
{
	 
	
  
  response=gap.retrieveAllPatients(Routes.dieticianToken);
  //dietician_tkn=response.jsonPath().getString("token");
}

@Then("Dietician get {int} with response body")
public void dietician_get_with_response_body(Integer statuscode) 
{
   assertEquals(response.getStatusCode(), statuscode);
   System.out.println("response.getStatusCode()  "+response.getStatusCode());
}

@Given("Dietician create PUT request")
public void dietician_create_put_request() {
   System.out.println("dietician send invalid method");
}

@When("Dietician send PUT http request with invalid method with endpoint")
public void dietician_send_put_http_request_with_invalid_method_with_endpoint() throws FileNotFoundException 
{
	response=gap.sendRequestWithInavalidMethod(Routes.dieticianToken);
}

@When("Dietician sends GET http request with invalid endpoint")
public void dietician_sends_get_http_request_with_invalid_endpoint() throws FileNotFoundException {
	response=gap.sendRequestWithInavalidEndPoint(Routes.dieticianToken);
}
}