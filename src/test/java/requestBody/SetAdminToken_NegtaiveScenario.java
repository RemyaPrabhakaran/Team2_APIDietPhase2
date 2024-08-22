//package requestBody;
//
//import static io.restassured.RestAssured.given;
//
//import java.util.Map;
//
//import org.json.JSONObject;
//
//import io.restassured.response.Response;
//import payload.UpdateUser;
//import stepDefinition.Login;
//import utilities.Routes;
//
//public class SetAdminToken_NegtaiveScenario 
//
//{
//	static Response response;
//	public static  JSONObject request=new JSONObject();
//	
//	static Response	response1;
//	static String filepath = System.getProperty("user.dir")+"src/test/resources/TestReports/Hypo Thyroid-Report.pdf.pdf";
//
//	public static Response createPatient(String admintoken)
//	 {
//		request.put("FirstName","Kia");
//		request.put("LastName","khanna");
//		request.put("ContactNumber","1264787811");
//		request.put("Email","twi@gmail.com");
//		request.put("FoodPreference","Vegetarian");
//		request.put("Allergy","ALMOND");
//		request.put("CuisineCategory","Indian");
//		request.put("DateOfBirth","2000-09-23");
//		
//		System.out.println("--------------   "+request.toString());
//		
//		//System.out.println("Bearer   "+ dietician_TKN);
//		
//		response= given() 
//				//.baseUri(baseURI)
//				//  .header("Content-Type", "application/json")
//				.header("Authorization", "Bearer " + admintoken , "application/json")
//				.when()
//				.multiPart("patientInfo", request)
//				.multiPart("file",filepath)
//				.post("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/patient");
//		 System.out.println("Response Body: " + response.getBody().asString());
//	//	System.out.println("Response Message:   "+response+"payload:   " +request);
//		   System.out.println("create patient   "+response.asPrettyString());
//		return response;
//				
//				
//		
//		
//		
//	 }
//	
//	public static Response updatePatient(Map<String, String> data, String adminToken) throws Exception 
//	{
//	
//		//"loginPassword": "Faith79","Email": "sanu0.up@gmail.com",
//			//Login pl=new Login();
//		//	System.out.println("Util.dieticianid  "+ Routes.dieticianid);
//				//response1=	pl.userlogin("sanu0.up@gmail.com","Faith79");
//				//Routes.dieticianToken = response1.jsonPath().getString("token");
//				// UpdateUser up_user;
//			//System.out.println("dietician_TKN    "+dietician_TKN);
//					 
//				
//			 String reqBody = " ";
//						UpdateUser up_user = new UpdateUser(data.get("FirstName"),
//								data.get("LastName"),data.get("ContactNumber")
//								,data.get("DateOfBirth"),data.get("Email")
//										,data.get("Allergy"),data.get("CuisineCategory"), data.get("FoodPreference"));
//				           
//						
//						JSONObject resquest=new JSONObject();
//				 		resquest.put("FirstName",data.get("FirstName"));
//				 		resquest.put("LastName", data.get("LastName"));
//				 		resquest.put("ContactNumber", data.get("ContactNumber"));
//				 		resquest.put("Email", data.get("Email"));
//				 		resquest.put("Allergy", data.get("Allergy"));
//				 		resquest.put("CuisineCategory", data.get("CuisineCategory"));
//				 		resquest.put("FoodPreference", data.get("FoodPreference"));
//				 		
////				 		
//				 		resquest.put("DateOfBirth", "2014-07-12");
//							
//						System.out.println(data);
//				          					
//							 System.out.println("resquest body "+resquest);
//							
//							response= given() 
//									//.baseUri(baseURI)
//									//  .header("Content-Type", "application/json")
//									.header("Authorization", "Bearer " + adminToken , "application/json")
//									.pathParam("patientId","246")
//									.when()
//									.multiPart("patientInfo", resquest)
//									
//									.multiPart("file",filepath)
//									//"patientId": 246,
//									
//									//Put_URL = Base_URL + "/updateuser/{userId}";
//									.put(Routes.baseUri+Routes.updatepatientEndpoint+"{patientId}");
//							 System.out.println("Response Body: " + response.getBody().asString());
//						//	System.out.println("Response Message:   "+response+"payload:   " +request);
//							   System.out.println("create patient   "+response.asPrettyString());
//						//	return reqBody;
//						//	return;
//							return response;
//						
//						//return reqBody;
//					 }
//	
//	public Response retrieveTestname(String morbiditytestname, String admintoken) {
//		response=given().
//			      header("Authorization", "Bearer " + admintoken , "application/json")
//			      .when()
//			      ///patient/testReports/{patientId}
//
//			  .get("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/patient/"+246);
//			      
//			      System.out.println("Morbidity testname "+response.getBody().asPrettyString());
//				return response;
//	}
//	
//	public Response addNewReportForExistingPatient(Map<String, String> data,String admintoken) {
//		String filepath = System.getProperty("user.dir")+"/src/test/resources/TestReports/HyperThyroid_Report_final.pdf";
//		
//		String reqBody = " ";
//		UpdateUser up_user = new UpdateUser(data.get("FirstName"),
//				data.get("LastName"),data.get("ContactNumber")
//				,data.get("DateOfBirth"),data.get("Email")
//						,data.get("Allergy"),data.get("CuisineCategory"), data.get("FoodPreference"));
//           
//		
//		JSONObject resquest=new JSONObject();
// 		resquest.put("FirstName",data.get("FirstName"));
// 		resquest.put("LastName", data.get("LastName"));
// 		resquest.put("ContactNumber", data.get("ContactNumber"));
// 		resquest.put("Email", data.get("Email"));
// 		resquest.put("Allergy", data.get("Allergy"));
// 		resquest.put("CuisineCategory", data.get("CuisineCategory"));
// 		resquest.put("FoodPreference", data.get("FoodPreference"));
// 		
//// 		
// 		resquest.put("DateOfBirth", "2014-07-12");
//		response=given().
//			      header("Authorization", "Bearer " + admintoken , "application/json")
//			      .pathParam("patientId","246")
//			      .when()
//			      .multiPart("file",filepath)
//			      ///patient/testReports/{patientId}
//			      
//			  .put("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/patient/newReports/{patientId}");
//			      
//			      System.out.println("add new report "+response.getBody().asPrettyString());
//				return response;
//	}
//	
//	
//}