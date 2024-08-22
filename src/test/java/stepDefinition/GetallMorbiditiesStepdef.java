package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.io.File;

import org.apache.logging.log4j.core.util.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.GetallMorbidities;
import payload.User_Login;
import requestBody.Get_Morbidity;
import testContext.TestContext;
import utilities.APIResources;
import utilities.ReqResSpec;
import utilities.ResourceBundleReader;

public class GetallMorbiditiesStepdef {
	private Response response;
	private GetallMorbidities.Request request;
	private GetallMorbidities.Response res;
	private RequestSpecification request1;
	private ReqResSpec reqres;
	private TestContext testContext;
	private ResourceBundleReader resource;
	
	APIResources resourceAPI = APIResources.MorbidityEndpoint;
	
	public GetallMorbiditiesStepdef(TestContext testcontext) 
	{
		this.testContext=testcontext;
		reqres=testcontext.getReqResSpec();
		resource=testcontext.getResourceBundleReader();
	}

	@When("User sends a Get request to fetch all morbidities with {string} {int}")
	public void user_sends_a_get_request_to_fetch_all_morbidities_with(String sheet, Integer row) throws Exception {
		// APIResources resourceAPI = APIResources.MorbidityEndpoint;
		request = Get_Morbidity.GetMobidityRequestBody(sheet, row);
		System.out.println("Invalid URL: " + request.getInvalidUrl());
		if (request.getInvalidUrl() == null) {
			request1 = RestAssured.given().spec(reqres.ReqSpec()).basePath(resourceAPI.getResource());
		} else {
			request1 = RestAssured.given().spec(reqres.ReqSpec()).baseUri(request.getInvalidUrl());
		}
		
		if (request.getToken() == null) {
			response = request1.when().get();
		} else {
			response = request1
					.header("Authorization", "Bearer " + request.getToken()).log().all().when().get();
		}

	}

	@Then("Admin receives invalid Status Code with {string} {int}")
	public void admin_receives_invalid_status_code_with(String sheet, Integer row) {
		String status_code = Get_Morbidity.getStatusCode(sheet, row);
		System.out.println("Expected Code: " + status_code);
		System.out.println("Received Code: " + response.getStatusCode());

		assertEquals(Integer.parseInt(status_code), response.getStatusCode());

		/* Validations */
		if (response.getStatusCode() == 200) {
			/* Validate response schema */
			response.then().assertThat().body(JsonSchemaValidator
					.matchesJsonSchema(new File("src/test/resources/schema/GetallMorbiditiesjsonschema.txt")));

			List<GetallMorbidities.Response> responseList = response.jsonPath().getList("",
					GetallMorbidities.Response.class);

			Set<Integer> morbidityIdSet = new HashSet<>();
			for (GetallMorbidities.Response item : responseList) {
				morbidityIdSet.add(item.getMorbidityId());
			}

			if (responseList.size() == morbidityIdSet.size()) {
				assertTrue(true);
			} else {
				assertTrue(false);
			}

			for (GetallMorbidities.Response item : responseList) {
				/* Valid markermin value is < markermax value */
				double minVal = item.getMorbidityMarkerMinVal();
				double maxVal = item.getMorbidityMarkerMaxVal();
				if (minVal > maxVal) {
					throw new AssertionError(
							"morbidityMarkerMinVal (" + minVal + ") is greater than morbidityMarkerMaxVal (" + maxVal
									+ ") for morbidityId " + item.getMorbidityId());
				}

				/* Validate morbidity testnames */
				String testname = item.getMorbidityTestName();
				String[] validTestNames = { "Fasting Glucose", "Average Glucose", "Plasma Glucose", "HbA1c", "TSH",
						"T3", "T4", "Blood Pressure Levels" };
				Set<String> validTestNamesSet = new HashSet<>(List.of(validTestNames));
				if (validTestNamesSet.contains(testname)) {
					assertTrue(true);
				} else {
					assertTrue(false, "testname is not correct:" + item.getMorbidityTestName());
				}
			}
		}
	}

	@When("User create and send request using {string} {string} {int}")
	public void user_create_and_send_request_using(String scenario, String sheet, Integer row) throws Exception {
		request = Get_Morbidity.GetMobidityRequestBody(sheet, row);
		System.out.println("Invalid URL: " + request.getInvalidUrl());
		if (request.getInvalidUrl() == null) {
			request1 = RestAssured.given().spec(reqres.ReqSpec()).basePath(resourceAPI.getResource());
		} else {
			System.out.println("Send Invalid EP");
			request1 = RestAssured.given().spec(reqres.ReqSpec()).baseUri(request.getInvalidUrl());
		}
		
		if (scenario.contains("post request")) {
			response = request1
					.header("Authorization", "Bearer " + request.getToken()).when().post();
		} else {
			response = request1
					.header("Authorization", "Bearer " + request.getToken()).when().get();
		}
	}
}
