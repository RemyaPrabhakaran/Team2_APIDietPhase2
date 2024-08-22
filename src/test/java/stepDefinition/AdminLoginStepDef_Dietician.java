package stepDefinition;


import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;


import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;
import requestBody.Post_Login_Dietician;
import testContext.TestContext;
import utilities.APIResources;
import utilities.ExcelUtilities;
import utilities.JsonSchemaValidation;
import utilities.ReqResSpec;
import utilities.ResourceBundleReader;

public class AdminLoginStepDef_Dietician   {
	
	Post_Login_Dietician postLogin = new Post_Login_Dietician();
	 Response response = null;
	  String body;
	  int actual_Status_Code;
	  int exp_status_code;
	  RequestSpecification request;
	  TestContext testContext;
	  ReqResSpec reqres;
	  ResourceBundleReader resource;
	 
	  public static String adminToken;
	  public static String dieticianToken;
	  public static String patientToken;
	  String res;
	  
	  public AdminLoginStepDef_Dietician(TestContext testcontext) {
		  this.testContext = testcontext;
		  reqres = testcontext.getReqResSpec();
		  resource = testcontext.getResourceBundleReader();
		  
	  }

@Given("Admin sets the Authorization to no auth")
public void admin_sets_the_authorization_to_no_auth() throws FileNotFoundException {
	System.out.println("Admin sets no Auth");
}


@Given("User creates Post request with request body.")
public void user_creates_post_request_with_request_body() throws Exception {

	  request= RestAssured
	    .given()
	    	.spec(reqres.ReqSpec());
	
   
}

@When("User send login POST HTTP request with endpoint")
public void user_send_login_post_http_request_with_endpoint() throws Exception {
	
	APIResources resourceApi = APIResources.loginEndpoint;
	
	List<Map<String, String>> testData = ExcelUtilities.getTestDataInMap(resource.getExcelFilePath(), "AdminLogin", "UserLoginPost");
	for(Map<String, String> data : testData) {
		body = postLogin.getLoginReqBody(data);
		System.out.println(body);
		exp_status_code = Integer.parseInt(data.get("StatusCode"));
	System.out.println(body);
	response =  request
    	.body(body)
    .when()
    	.post(resourceApi.getResource());
    	
	res = response .then()
    	.assertThat().statusCode(exp_status_code)
    	.log().all().extract().response().asString();

	
	}
	
	JsonPath js = new JsonPath(res);
	adminToken = js.getString("token");
	System.out.println(adminToken);
	

}

@Then("User recieves {int} created with response body")
public void user_recieves_created_with_response_body(Integer exp_status_code) throws JsonMappingException, JsonProcessingException {
	Assert.assertEquals(response.getStatusCode(), exp_status_code);
	
}

}