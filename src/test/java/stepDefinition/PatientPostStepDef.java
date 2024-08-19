package stepDefinition;


import java.io.File;
import java.io.IOException;
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
import utilities.ExcelUtilities;

import utilities.ReqResSpec;
import response.PatientResponse;


public class PatientPostStepDef extends ReqResSpec {
	RequestSpecification res;
	 Response response;
	  String body;
	  int exp_status_code;
	  public static int PatientId1;
	  public static String fileId1;
	  public static int PatientId2;
	  public static String fileId2;
	  PatientResponse pResponse;
	  String dieticiantoken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJUZWFtbm0uYW1pbkBnbWFpbC5jb20iLCJpYXQiOjE3MjQwMzI2MjksImV4cCI6MTcyNDA2MTQyOX0.hZXlCUJAQRNes2oDaqImamLgjl5254x5rXgl30e0UCfb5m5K92j7RaRfJeoUdUcRoKLzZ4orTFp71G9-J-SLVA";

	  Post_Patient postPatient = new Post_Patient();
	  public static RequestSpecification request;
	  
	@Given("Set dietician bearer token")
	public void set_dietician_bearer_token() throws IOException {
	
		DieticianLogin.dieticianLogin();
		
	 request= RestAssured
				    .given()
				    	.spec(ReqSpec()).header("Authorization", "Bearer "+dieticiantoken);;
	
	}

	
		@Given("Dietician creates POST request by entering  data for the {string} from the {string}")
		public void dietician_creates_post_request_by_entering_data_for_the_from_the(String scenario, String sheet) throws Exception {
		   
			 
		//	List<Map<String, String>> testData = ExcelUtilities.getTestDataInMap("C:\\Users\\rashm\\git\\Team2_APIDietPhase2RestAssured\\src\\test\\resources\\Data\\Team2_APIDiet_Data.xlsx", sheet, scenario);
			List<Map<String, String>> testData = ExcelUtilities.getTestDataInMap("src/test/resources/Data/Team2_APIDiet_Data.xlsx", sheet, scenario);
		
			for(Map<String, String> data : testData) {
				
				body = postPatient.getPatientReqBody(data); 
				exp_status_code = Integer.parseInt(data.get("StatusCode"));
				String filePath ="src/test/resources/Data/HyperThyroid_Report_final.pdf";
	            File file = new File(filePath);
				res = request
			                .multiPart("patientInfo", body)
			                .multiPart("file", file, "application/pdf");
			
				
			
		}

		



		
	}

	@When("Dietician send POST http request with endpoint")
	public void dietician_send_post_http_request_with_endpoint() throws Exception {
		 
		
		            
	    
		 response = res
                 .when()
                 .post(Post_Patient.endpoint)
                 .then()
                 .log().all()
                 .extract()
                 .response();
		 
		
	}

	@Then("Dietician recieves response for the respective {string}")
	public void dietician_recieves_response_for_the_respective(String scenario) {
		 response.then().assertThat().statusCode(exp_status_code);
		 
		 switch(scenario)
			{
			
		case "ValidOne":
			response.then().log().all().assertThat().statusCode(exp_status_code)
				.contentType(ContentType.JSON)
		        .and().body(JsonSchemaValidator.matchesJsonSchema(getClass()
		              .getClassLoader()
		              .getResourceAsStream("PostPatientSchema.json")));
			 pResponse= response.getBody().as(PatientResponse.class);
			//  Assert.assertEquals(pResponse.Email, Patient_Post.Email);
			 // Assert.assertEquals(pResponse.FirstName, Patient_Post.FirstName);
			  //Assert.assertEquals(pResponse.LastName, Patient_Post.LastName);
			//  Assert.assertEquals(pResponse.ContactNumber, Patient_Post.ContactNumber);
			 // Assert.assertEquals(pResponse.Allergy, Patient_Post.Allergy);
			 // Assert.assertEquals(pResponse.FoodPreference, Patient_Post.FoodPreference);
			  //Assert.assertEquals(pResponse.CuisineCategory, Patient_Post.CuisineCategory);
			  
			//PatientId = response.jsonPath().getInt("patientId");
		
		PatientId1= pResponse.patientId;
		
		
			System.out.println("Patient Id 1  :"+PatientId1);
			
			for (Map.Entry<String, Map<String, String>> entry : pResponse.FileMorbidity.entrySet()) {
			     fileId1 = entry.getKey();
			   
             
			   System.out.println("File ID: " + fileId1);
			    Map<String, String> morbidityDetails = entry.getValue();
			    for (Map.Entry<String, String> detail : morbidityDetails.entrySet()) {
			        System.out.println(detail.getKey() + ": " + detail.getValue());
			    }
			}
			
			
			break;
			
		
			
		case "ValidTwo":
			response.then().log().all().assertThat().statusCode(exp_status_code)
				.contentType(ContentType.JSON)
		        .and().body(JsonSchemaValidator.matchesJsonSchema(getClass()
		              .getClassLoader()
		              .getResourceAsStream("PostPatientSchema.json")));
			 pResponse= response.getBody().as(PatientResponse.class);
			
		
		PatientId2= pResponse.patientId;
		
		
			System.out.println("Patient Id 2   :"+PatientId2);
			
			for (Map.Entry<String, Map<String, String>> entry : pResponse.FileMorbidity.entrySet()) {
			     fileId2 = entry.getKey();
			   
             
			   System.out.println("File ID: " + fileId2);
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
	
	}


