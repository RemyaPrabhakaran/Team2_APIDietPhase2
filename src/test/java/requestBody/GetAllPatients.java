package requestBody;

import io.restassured.response.Response;
import utilities.APIResources;
import utilities.ReqResSpec;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
public class GetAllPatients {

	
	static Response response;
	static ReqResSpec reqrs=new ReqResSpec();
	static APIResources resourceApi = APIResources.patientEndpoint;
	
	public static Response retrieveAllPatients(String dietician_tkn) throws FileNotFoundException 
	
	{
		
		
      response=given().spec(reqrs.ReqSpec()).
      header("Authorization", "Bearer " + dietician_tkn)
      .when()

  .get(resourceApi.getResource());
      
      System.out.println("get all patients "+response.getBody().asPrettyString());
	return response;
      
		
	}


	public Response sendRequestWithInavalidMethod(String dietician_tkn) throws FileNotFoundException {
	//	APIResources resourceApi = APIResources.patientEndpoint;
		response=given().spec(reqrs.ReqSpec()).
			      header("Authorization", "Bearer " + dietician_tkn)
			      .when().delete(resourceApi.getResource());

			 // .delete("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/patient");
			      
			      System.out.println("get all patients "+response.getBody().asPrettyString());
				return response;
	}


	public Response sendRequestWithInavalidEndPoint(String dietician_tkn) throws FileNotFoundException 
	{
		
		 APIResources resourceApi1 = APIResources.invalidEndpoint;
		response=given().spec(reqrs.ReqSpec()).
			      header("Authorization", "Bearer " + dietician_tkn , "application/json")
			      .when()

			  .post(resourceApi1.getResource());
			      
			      System.out.println("get all patients "+response.getBody().asPrettyString());
				return response;
		
	}

}
