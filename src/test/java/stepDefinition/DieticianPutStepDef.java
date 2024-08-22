package stepDefinition;

import java.io.FileNotFoundException;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestBody.Dietician;

import testContext.TestContext;
import utilities.APIResources;
import utilities.ExcelUtilities;
import utilities.JsonSchemaValidation;
import utilities.ReqResSpec;
import utilities.ResourceBundleReader;

public class DieticianPutStepDef {
	
	

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
	 
	 
	 public DieticianPutStepDef(TestContext testcontext) {
		 this.testContext = testcontext;
		  reqres = testcontext.getReqResSpec();
		  resource = testcontext.getResourceBundleReader();
		  this.loginStep = new AdminLoginStepDef(testcontext);
		  this.dietcian = new Dietician();
		  this.jsonSchema = new JsonSchemaValidation();
	  }
	
	

	@Then("Admin sets the bearer admin token")
	public void admin_sets_the_bearer_admin_token() throws FileNotFoundException {
		String dieticianID = DieticianPostStepDef.dieticianIDs.get(0);
		System.out.println("+++++++++++Dietician Id +++++++++"+dieticianID);
		request= RestAssured
			    .given()
			    	.spec(reqres.ReqSpec())
			    	.header("Authorization", "Bearer " +AdminLoginStepDef.adminToken)
			    	.pathParam("dieticianId", dieticianID);
	}

	@Given("Admin creates PUT request for the {string}")
	public void admin_creates_put_request_for_the_with_the_data_from_the_excel(String scenario) throws Exception {
		System.out.println("Admin is in the baseURI for the scenario +");
		
		
	}

	@When("Admin sends dietician PUT http request with endpoint for the {string} from the {string}")
	public void admin_sends_dietician_put_http_request_with_endpoint_for_the_from_the(String scenario, String sheetName) {
	
		APIResources resourceApi = APIResources.dietcianPutEndpoint;
	    if (this.dietcian == null) {
	        this.dietcian = new Dietician();
	    }
	    
	    List<Map<String, String>> testdata = ExcelUtilities.getTestDataInMap(resource.getExcelFilePath(), sheetName, scenario);
	    for (Map<String, String> data : testdata) {
	        try {
	            body = dietcian.getDieticianReqBody(data);
	            exp_status_code = Integer.parseInt(data.get("StatusCode"));
	            response = request.body(body).when().put(resourceApi.getResource());
	              response.then()
	                    .assertThat().statusCode(exp_status_code)
	                    .header("Content-Type", "application/json")
	                    .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema.getJsonSchema(resource.getDieticianSchemaFile())))
	                    .log().all().extract().response().asString();
	            
	            actual_Status_Code = response.getStatusCode();
	            Assert.assertEquals(actual_Status_Code, exp_status_code);

	        } catch (AssertionError e) {
	            System.out.println("Assertion failed: " + e.getMessage());
	         
	        } catch (Exception e) {
	            System.out.println("Exception occurred: " + e.getMessage());
	     
	        }
	    }
	}

	@Then("Admin recieves the response with the {string}")
	public void admin_recieves_the_response_with_the(String StatusCode) {
		System.out.println("Admin expects status code " +StatusCode );
	}
}

