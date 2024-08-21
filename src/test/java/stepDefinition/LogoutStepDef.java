package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.Logout;
import requestBody.Get_Logout;
import requestBody.Get_Morbidity;
import testContext.TestContext;
import utilities.APIResources;
import utilities.ReqResSpec;
import utilities.ResourceBundleReader;

public class LogoutStepDef {
	Response response;
	Logout.Request request;
	Logout.Response res;
	APIResources resourceAPI = APIResources.logoutEndpoint;
	private RequestSpecification request1;
	private ReqResSpec reqres;
	private TestContext testContext;
	private ResourceBundleReader resource;
	
	public LogoutStepDef(TestContext testcontext) 
	{
		this.testContext=testcontext;
		reqres=testcontext.getReqResSpec();
		resource=testcontext.getResourceBundleReader();
	}
	
	@When("User sends a GET request to fetch logout details  with {string} {string} {int}")
	public void user_sends_a_get_request_to_fetch_logout_details_with(String scenario, String sheet, Integer row)
			throws Exception {
		

		request = Get_Logout.Get_LogoutRequestBody(sheet, row);
		request1 = RestAssured.given().spec(reqres.ReqSpec());
		

		if (request.getToken() != null) {
			request1.header("Authorization", "Bearer " + request.getToken());
		}

		if (scenario.contains("post request")) {
			response = request1.basePath(resourceAPI.getResource()).when().post();
		} else {
			response = request1.basePath(resourceAPI.getResource()).when().get();
		}
	}

	@Then("the response status code should be  with {string} {int}")
	public void the_response_status_code_should_be_with(String sheet, Integer row) {
		
		String status_code = Get_Logout.getStatusCode(sheet, row);
		
		System.out.println("Expected Code: " + status_code);
		System.out.println("Received Code: " + response.getStatusCode());
		assertEquals(Integer.parseInt(status_code), response.getStatusCode());
		if (response.getStatusCode() == 200) {
			String message = response.body().asString();
			if (message.contains("Logout successful")) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}
		}
	}

}
