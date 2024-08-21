package requestBody;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.response.Response;
import payload.UpdateUser;
import stepDefinition.Login;
import utilities.APIResources;
import utilities.ReqResSpec;
import utilities.Routes;

public class SetNoAuth 
{
	
	public static  JSONObject request=new JSONObject();
	static Response response;
	static Response	response1;
	static ReqResSpec reqrs=new ReqResSpec();
	static APIResources resourceApi = APIResources.patientEndpoint;
	public Response post_pu_delete_PatientRequest(Map<String, String> data, String req) throws Exception 
	
	{
//		Login pl=new Login();
//		//System.out.println("Util.dieticianid  "+ Routes.dieticianid);
//			response1=	pl.userlogin("sanu0.up@gmail.com","Faith79");
//			Routes.dieticianToken = response1.jsonPath().getString("token");
//			// UpdateUser up_user;
//		//System.out.println("dietician_TKN    "+dietician_TKN);
				 
			
		 String reqBody = " ";
					UpdateUser up_user = new UpdateUser(data.get("FirstName"),
							data.get("LastName"),data.get("ContactNumber")
							,data.get("DateOfBirth"),data.get("Email")
									,data.get("Allergy"),data.get("CuisineCategory"), data.get("FoodPreference"));
			           
					
					JSONObject resquest=new JSONObject();
			 		resquest.put("FirstName",data.get("FirstName"));
			 		resquest.put("LastName", data.get("LastName"));
			 		resquest.put("ContactNumber", data.get("ContactNumber"));
			 		resquest.put("Email", data.get("Email"));
			 		resquest.put("Allergy", data.get("Allergy"));
			 		resquest.put("CuisineCategory", data.get("CuisineCategory"));
			 		resquest.put("FoodPreference", data.get("FoodPreference"));
			 		
//			 		
			 		resquest.put("DateOfBirth", "2014-07-12");
						
						 System.out.println("resquest body "+resquest);
						 
						 
						 
						 if(req=="POST") 
						 
						 {
							 System.out.println("post operation called");
							 
							 
						response= given() 
								.header("Authorization", "Bearer " + " ", "application/json")
								.when()
								.multiPart("patientInfo", resquest)
								
						.post("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/patient");
						 System.out.println("Response Body: " + response.getBody().asString());
					//	System.out.println("Response Message:   "+response+"payload:   " +request);
						   System.out.println("create patient   "+response.asPrettyString());
						//return 		response;
						 }
						 
						 
						 if(req=="PUT") {
							 System.out.println("put operation called");
								
								response= given() 
										.header("Authorization", "Bearer " + " ", "application/json")
										.when()
										.pathParams("patientId","246")
										.multiPart("patientInfo", resquest)
										
								.put("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/patient/{patientId}");
								 System.out.println("Response Body: " + response.getBody().asString());
							//	System.out.println("Response Message:   "+response+"payload:   " +request);
								   System.out.println("create patient   "+response.asPrettyString());
								
								 }
						 
						 if(req=="DELETE") {
							 System.out.println("delete operation called");
								response= given() 
										.header("Authorization", "Bearer " + " ", "application/json")
										.when()
										.pathParam("patientId", "246")
									//	.multiPart("patientInfo", resquest)
										
								.delete("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/patient/patient/{patientId}");
								 System.out.println("Response Body: " + response.getBody().asString());
							//	System.out.println("Response Message:   "+response+"payload:   " +request);
								   System.out.println("create patient   "+response.asPrettyString());
								
								 }
						return response;

					
	}
	public Response getAllPatient() {
		response= given() 
				.when()
				.header("Content-Type", "application/json")	
				
		.get("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/patient");
		 System.out.println("Response Body: " + response.getBody().asString());
		   System.out.println("create patient   "+response.asPrettyString());
		return response;
	}

}
