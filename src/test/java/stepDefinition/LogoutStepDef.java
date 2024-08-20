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

public class LogoutStepDef {
	Response response;
	Logout.Request request;
	Logout.Response res;

	@When("User sends a GET request to fetch logout details  with {string} {string} {int}")
	public void user_sends_a_get_request_to_fetch_logout_details_with(String scenario, String sheet, Integer row)
			throws Exception {
		request = Get_Logout.Get_LogoutRequestBody(sheet, row);

		RequestSpecification requestSpec = RestAssured.given();

		if (request.getToken() != null) {
			requestSpec.header("Authorization", "Bearer " + request.getToken());
		}

		if (scenario.contains("post request")) {
			response = requestSpec.baseUri(request.getBaseUrl()).basePath(request.getEndpoint())
					.contentType(request.getContentType()).when().post();
		} else {
			response = requestSpec.baseUri(request.getBaseUrl()).basePath(request.getEndpoint())
					.contentType(request.getContentType()).when().get();
		}
	}

	@Then("the response status code should be  with {string} {int}")
	public void the_response_status_code_should_be_with(String sheet, Integer row) {
		String status_code = Get_Logout.getStatusCode(sheet, row);
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
