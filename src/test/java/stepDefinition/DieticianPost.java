package stepDefinition;

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
import utilities.ExcelUtilities;
import utilities.ReqResSpec;
import requestBody.Post_Dietician;
public class DieticianPost extends ReqResSpec {
	RequestSpecification request;
	Post_Dietician d = new Post_Dietician();
	RequestSpecification res;
	 Response response;
	  String body;
	  int exp_status_code;
	  public static int DieticianId;
	  public static String DieticianEmail;
	  public static String  DieticianPassword;
	  
	public void dieticianpost() throws FileNotFoundException
	{
		String tok="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJUZWFtMTAuYWRtaW5AZ21haWwuY29tIiwiaWF0IjoxNzIzOTg5NTAxLCJleHAiOjE3MjQwMTgzMDF9.LPEf7OuHp6obomcRhfHlr05KIS2V181qOqfnAWg6ThjEnViY3xt9v3w589mGN3fTD_FHkHVxrugvZNiCccQmJQ";
	request= RestAssured
		    .given()
		    	.spec(ReqSpec()).header("Authorization", "Bearer "+ tok);
	
	/*List<Map<String, String>> testData = ExcelUtilities.getTestDataInMap("src/test/resources/Data/Team2_APIDiet_Data.xlsx", sheet, scenario);
	
	for(Map<String, String> data : testData) {
		
		body = postPatient.getPatientReqBody(data); 
		//exp_status_code = Integer.parseInt(data.get("StatusCode"));
		*/
	}
	
	
	
	@Given("Set admin bearer token")
	public void set_admin_bearer_token() throws FileNotFoundException {
		
		String tok="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJUZWFtMTAuYWRtaW5AZ21haWwuY29tIiwiaWF0IjoxNzIzOTg5NTAxLCJleHAiOjE3MjQwMTgzMDF9.LPEf7OuHp6obomcRhfHlr05KIS2V181qOqfnAWg6ThjEnViY3xt9v3w589mGN3fTD_FHkHVxrugvZNiCccQmJQ";
		
		request= RestAssured
			    .given()
			    	.spec(ReqSpec()).header("Authorization", "Bearer "+ tok);
		
	}

	@Given("Admin creates POST request by entering  data for  {string} from the {string} sheet")
	public void admin_creates_post_request_by_entering_data_for_from_the_sheet(String valid, String sheet) throws Exception {
		List<Map<String, String>> testData = ExcelUtilities.getTestDataInMap("src/test/resources/Data/Team2_APIDiet_Data.xlsx", "DieticianPost", "valid");
		
		for(Map<String, String> data : testData) {
			
			body = d.getDieticanReqBody(data);
			exp_status_code = Integer.parseInt(data.get("StatusCode")); 
			res=request.header("Content-Type", "application/json")
	    	.body(body);
		
	}
		}

	@When("Admin sends POST http request with endpoint")
	public void admin_sends_post_http_request_with_endpoint() {
		
	  response= res.when().post("/dietician").then()
    	
    	.log().all().extract().response();
	    
	}

	@Then("Dietician created with status code {int}")
	public void dietician_created_with_status_code(Integer int1) {
		
		 int status_code = response.getStatusCode();
		  Assert.assertEquals(status_code, exp_status_code, "correct status code returned");
		  DieticianId = response.jsonPath().getInt("id");
		  DieticianEmail = response.jsonPath().getString("Email");
	      DieticianPassword =	response.jsonPath().getString("loginPassword");
	      System.out.println("DieticianEmail   :"+DieticianEmail);
	      System.out.println("DieticianPassword   :"+DieticianPassword);
		
	}

	}

