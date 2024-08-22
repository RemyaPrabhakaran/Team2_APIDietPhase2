package stepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestBody.Dietician;
import testContext.TestContext;
import utilities.APIResources;
import utilities.ExcelUtilities;
import utilities.JsonSchemaValidation;
import utilities.ReqResSpec;
import utilities.ResourceBundleReader;

public class DieticianPostStepDef {
	
	public static List<String> dieticianEmails =  new ArrayList<>();
	public static List<String> dieticianPasswords =  new ArrayList<>();
	public static List<String> dieticianIDs = new ArrayList<>();
	public static String dieticianPassword;
	Response response = null;
	  String body;
	  int actual_Status_Code;
	  int exp_status_code;
	  RequestSpecification request;
	  TestContext testContext;
	  ReqResSpec reqres;
	  ResourceBundleReader resource;
	  JsonSchemaValidation jsonSchema;
	 AdminLoginStepDef loginStep;
	 Dietician dietcian;
	 String res;
	 
	 
	 public DieticianPostStepDef(TestContext testcontext) {
		  this.testContext = testcontext;
		  reqres = testcontext.getReqResSpec();
		  resource = testcontext.getResourceBundleReader();
		  this.loginStep = new AdminLoginStepDef(testcontext);
		  this.dietcian = new Dietician();
		  this.jsonSchema = new JsonSchemaValidation();
	  }

	@Then("Admin sets the bearer admin token for the Post request")
	public void admin_sets_the_bearer_admin_token_for_the_post_request() throws FileNotFoundException {
		request= RestAssured
			    .given()
			    	.spec(reqres.ReqSpec())
			    	.header("Authorization", "Bearer " +AdminLoginStepDef.adminToken);
	}


	@Given("Admin creates Post request for the {string}")
	public void admin_creates_post_request_for_the(String scenario)  throws Exception {
		System.out.println("Admin send post request for the scenario "+scenario);
		
	}

	@When("Admin sends dietician POST http request with endpoint for the {string} from the {string}")
	public void admin_sends_dietician_post_http_request_with_endpoint_for_the_from_the(String scenario, String sheetName) throws IOException {
		APIResources resourceApi = APIResources.dieticianEndpoint;
	    if (this.dietcian == null) {
	        this.dietcian = new Dietician();
	    }
	    
	    List<Map<String, String>> testdata = ExcelUtilities.getTestDataInMap(resource.getExcelFilePath(), sheetName, scenario);
	    for (Map<String, String> data : testdata) {
	        try {
	            body = dietcian.getDieticianReqBody(data);
	            exp_status_code = Integer.parseInt(data.get("StatusCode"));
	            response = request.body(body).when().post(resourceApi.getResource());
	            res = response.then()
	                    .assertThat().statusCode(exp_status_code)
	                    .header("Content-Type", "application/json")
	                    .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema.getJsonSchema(resource.getDieticianSchemaFile())))
	                    .log().all().extract().response().asString();
	            
	            actual_Status_Code = response.getStatusCode();

	    		Assert.assertEquals(actual_Status_Code, exp_status_code);

	            if (actual_Status_Code == 201) {
	                JsonPath js = new JsonPath(res);
	                String dieticianID = js.getString("id");  
	                dieticianIDs.add(dieticianID);
	                String dieticianEmail = js.getString("Email");
	                dieticianEmails.add(dieticianEmail);
	                dieticianPassword = js.getString("loginPassword");
	                dieticianPasswords.add(dieticianPassword);
	                System.out.println(dieticianEmail);
	                System.out.println(dieticianID);
	                System.out.println(dieticianPassword);
	            } else {
	                System.out.println("Validation failed for this data set, continuing with the next...");
	            }
	        } catch (AssertionError e) {
	            System.out.println("Assertion failed: " + e.getMessage());
	            
	        } catch (Exception e) {
	            System.out.println("Exception occurred: " + e.getMessage());
	           
	        }
	    }
		
	}
}
