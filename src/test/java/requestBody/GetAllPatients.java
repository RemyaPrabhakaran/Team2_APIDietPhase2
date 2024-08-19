package requestBody;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class GetAllPatients {

	
	static Response response;
	
	
	public static Response retrieveAllPatients(String dietician_tkn) 
	
	{
		
      response=given().
      header("Authorization", "Bearer " + dietician_tkn , "application/json")
      .when()

  .get("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/patient");
      
      System.out.println("get all patients "+response.getBody().asPrettyString());
	return response;
      
		
	}


	public Response sendRequestWithInavalidMethod(String dietician_tkn) {
		
		response=given().
			      header("Authorization", "Bearer " + dietician_tkn , "application/json")
			      .when()

			  .delete("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/patient");
			      
			      System.out.println("get all patients "+response.getBody().asPrettyString());
				return response;
	}


	public Response sendRequestWithInavalidEndPoint(String dietician_tkn) {
		response=given().
			      header("Authorization", "Bearer " + dietician_tkn , "application/json")
			      .when()

			  .post("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/invalidendpoind");
			      
			      System.out.println("get all patients "+response.getBody().asPrettyString());
				return response;
		
	}

}
