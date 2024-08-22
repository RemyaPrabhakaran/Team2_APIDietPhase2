package stepDefinition;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.Patient_Post;
import requestBody.Post_Patient;
import utilities.APIResources;
import utilities.ExcelUtilities;
import utilities.ReqResSpec;
import utilities.ResourceBundleReader;
import response.PatientResponse;
import testContext.TestContext;


public class PatientPostStepDef {
	
TestContext testContext;
ReqResSpec reqres;
 ResourceBundleReader resource;
public static List<String> patientFileIds =  new ArrayList<>();
public static List<Integer> patientIDs = new ArrayList<>();
RequestSpecification res;
Response response;
 String body;
int exp_status_code;
PatientResponse pResponse;
//String dieticiantoken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJUZWFtbm0uYW1pbkBnbWFpbC5jb20iLCJpYXQiOjE3MjQyNjY4NDcsImV4cCI6MTcyNDI5NTY0N30.SzEGGUC99E8nZKMyqrj9cBgx36tthxbaY3gtaLpttKeDgnnBMHpH3Rd4nYH8kXyE50mmlh6EbQ_NZ6tC60oANw";
	 


      Post_Patient postPatient;
	  public static RequestSpecification request;
	  APIResources resourceApi = APIResources.patientEndpoint;
	  APIResources resourceApiinvalid = APIResources.patientInvalidEndpoint;
	  
	  public PatientPostStepDef(TestContext testcontext)
	  {
		 
		  this.testContext = testcontext;
		  reqres = testcontext.getReqResSpec();
		  resource = testcontext.getResourceBundleReader();
		  this.postPatient = new Post_Patient();
	  }
	  
	@Given("Set dietician bearer token")
	public void set_dietician_bearer_token() throws IOException {
	
	
		
	 request= RestAssured
				    .given()
				    	.spec(reqres.ReqSpec()).header("Authorization", "Bearer "+AdminLoginStepDef_Dietician.dieticianToken);;
	
	}

	
		@Given("Dietician creates POST request by entering  data for the {string} from the {string}")
		public void dietician_creates_post_request_by_entering_data_for_the_from_the(String scenario, String sheet) throws Exception {
		   
			System.out.println("Dietician send post request for the scenario "+scenario);
		
			List<Map<String, String>> testData = ExcelUtilities.getTestDataInMap(resource.getExcelFilePath(), sheet, scenario);
		
			for(Map<String, String> data : testData) {
				
				body = postPatient.getPatientReqBody(data); 
				exp_status_code = Integer.parseInt(data.get("StatusCode"));
				 String filePath = resource.getPDFFile1();
	            File file = new File(filePath);
				res = request
			                .multiPart("patientInfo", body)
			                .multiPart("file", file, "application/pdf");
			                
			
							
		}

		
		
	}

	@When("Dietician send POST http request with endpoint")
	public void dietician_send_post_http_request_with_endpoint() throws Exception {
		            
		 response = res.body(body).when().post(resourceApi.getResource());
	}

	@Then("Dietician recieves response for the respective {string}")
	public void dietician_recieves_response_for_the_respective(String scenario) {
		
		response.then().assertThat().statusCode(exp_status_code);
		 
		 switch(scenario)
			{
			
		case "ValidOne":
		case "ValidTwo":
			response.then().log().all().assertThat().statusCode(exp_status_code)
				.contentType(ContentType.JSON)
		        .and().body(JsonSchemaValidator.matchesJsonSchema(getClass()
		              .getClassLoader()
		              .getResourceAsStream("PostPatientSchema.json")));
			 pResponse= response.getBody().as(PatientResponse.class);
			
		
		int PatientId= pResponse.patientId;
		patientIDs.add(PatientId);
		
			System.out.println("Patient Id 1  :"+ patientIDs);
			
			for (Map.Entry<String, Map<String, String>> entry : pResponse.FileMorbidity.entrySet()) {
			     String fileId = entry.getKey();
			    
			    patientFileIds.add(fileId);
			    System.out.println("File ID: " + patientFileIds);
			    
			    Map<String, String> morbidityDetails = entry.getValue();
			    for (Map.Entry<String, String> detail : morbidityDetails.entrySet()) {
			        System.out.println(detail.getKey() + ": " + detail.getValue());
			    }
			}
			
			
			break;
			
		case "ValidAdditional":
			
		case "InvalidData":
			
		case "InvalidAdditional":
			
		case "Duplicate":
			response.then().log().all().assertThat().statusCode(exp_status_code);
			break;
		default:
			Assert.assertTrue(false);
			break;
			
			
			}
			}
	
	

	@When("Dietician send  http request with endpoint and invalid method")
	public void dietician_send_http_request_with_endpoint_and_invalid_method() {
	  try {
		 response = res
                 .when()
                 .put(resourceApi.getResource())
                 .then()
                 .log().all()
                 .extract()
                 .response();}
	 catch (AssertionError e) {
        System.out.println("Assertion failed: " + e.getMessage());
	 }
	}

	@Then("Dietician recieves {int} statuscode")
	public void dietician_recieves_statuscode(int int1) {
	   
		Assert.assertEquals(response.statusCode(), int1);
	}

	@When("Dietician send  http request with endpoint and invalid endpoint")
	public void dietician_send_http_request_with_endpoint_and_invalid_endpoint() {
		 response = res
                 .when()
                 .post(resourceApiinvalid.getResource())
                 .then()
                 .log().all()
                 .extract()
                 .response();
	}

	@When("Dietician send  http request with endpoint and invalid content type")
	public void dietician_send_http_request_with_endpoint_and_invalid_content_type() {
	  try { 
		 response = res.contentType("text/Json")
                 .when()
                 .post(resourceApi.getResource())
                 .then()
                 .log().all()
                 .extract()
                 .response();
	  } catch (AssertionError e) {
          System.out.println("Assertion failed: " + e.getMessage());
	  }
	}
	
	
	}

	
	


