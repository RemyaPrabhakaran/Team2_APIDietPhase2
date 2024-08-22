package requestBody;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.util.Map;

import io.restassured.response.Response;
import payload.UpdateUser;
import utilities.APIResources;
import utilities.ReqResSpec;
import utilities.Routes;

public class RetrieveMorbidityByTestName 
{
Response response;

static ReqResSpec reqrs=new ReqResSpec();
static APIResources resourceApi = APIResources.MorbidityEndpoint;
	public Response retrieveTestname(String morbiditytestname, String dieticianToken) throws FileNotFoundException {
		response=given().spec(reqrs.ReqSpec()).
			      header("Authorization", "Bearer " + dieticianToken , "application/json")
			      .when()

			  .get(resourceApi.getResource());
			      
			      System.out.println("Morbidity testname "+response.getBody().asPrettyString());
				return response;
	}
	
	
	public Response methodNotAllowed(String morbiditytestname, String dieticianToken) throws FileNotFoundException {
		response=given().spec(reqrs.ReqSpec()).
			      header("Authorization", "Bearer " + dieticianToken , "application/json")
			      .when()

			  .post(resourceApi.getResource());
			      
			      System.out.println("Morbidity testname "+response.getBody().asPrettyString());
			      
				return response;
	}
	public Response retrieveMorbidity_WithInvalidTestName(String invalidmorbidityTestname, String dieticianToken) throws FileNotFoundException {

						
		response=given().spec(reqrs.ReqSpec()).
			      header("Authorization", "Bearer " + dieticianToken , "application/json")
			      .when()

			  .get(resourceApi.getResource()+invalidmorbidityTestname);
			      
			      System.out.println("Morbidity testname "+response.getBody().asPrettyString());
			      
				return response;
	}
	
	
	public Response retrieveMorbidity_WithInvalid_END_Point(String invalidmorbidityTestname, String dieticianToken) throws FileNotFoundException {

		 APIResources resourceApi1 = APIResources.invalidEndpoint;
		response=given().spec(reqrs.ReqSpec()).
			      header("Authorization", "Bearer " + dieticianToken , "application/json")
			      .when()

			  .get(resourceApi1.getResource()+invalidmorbidityTestname);
			      
			      System.out.println("Morbidity testname "+response.getBody().asPrettyString());
			      
				return response;
	}

}