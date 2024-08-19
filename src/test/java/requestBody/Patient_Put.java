package requestBody;
import static io.restassured.RestAssured.given;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import payload.UpdateUser;
import stepDefinition.Login;
import utilities.ExcelUtilities;
import utilities.Routes;


public class Patient_Put 
 {
	 
	
	public static  JSONObject request=new JSONObject();
	static Response response;
	static Response	response1;
	static String filepath = System.getProperty("user.dir")+"src/test/resources/TestReports/Hypo Thyroid-Report.pdf.pdf";

	public static void createPatient(String dietician_TKN)
	 {

		request.put("FirstName","twikki");
		request.put("LastName","khanna");
		request.put("ContactNumber","1064787811");
		request.put("Email","twinkkki@gmail.com");
		request.put("FoodPreference","Vegetarian");
		request.put("Allergy","ALMOND");
		request.put("CuisineCategory","Indian");
		request.put("DateOfBirth","2000-09-21");
		
		System.out.println("--------------   "+request.toJSONString());
		String filepath = System.getProperty("user.dir")+"src/test/resources/TestReports/Hypo Thyroid-Report.pdf.pdf";
		
		System.out.println("Bearer   "+ dietician_TKN);
		
		response= given() 
				//.baseUri(baseURI)
				//  .header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + dietician_TKN , "application/json")
				.when()
				.multiPart("patientInfo", request)
				.multiPart("file",filepath)
				.post("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/patient");
		 System.out.println("Response Body: " + response.getBody().asString());
	//	System.out.println("Response Message:   "+response+"payload:   " +request);
		   System.out.println("create patient   "+response.asPrettyString());
				
				
		
		
		
	 }
	
	
	public static Response updatePatient(Map<String, String> data) throws Exception 
	{
	
		//"loginPassword": "Faith79","Email": "sanu0.up@gmail.com",
			Login pl=new Login();
			System.out.println("Util.dieticianid  "+ Routes.dieticianid);
				response1=	pl.userlogin("sanu0.up@gmail.com","Faith79");
				Routes.dieticianToken = response1.jsonPath().getString("token");
				// UpdateUser up_user;
			//System.out.println("dietician_TKN    "+dietician_TKN);
					 
				
			 String reqBody = " ";
						UpdateUser up_user = new UpdateUser(data.get("FirstName"), data.get("LastName"),data.get("ContactNumber"),data.get("DateOfBirth"),data.get("Email")
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
				 		//resquest.put("CuisineCategory", data.get("CuisineCategory"));
				 		
				// 		String date=data.get("DateOfBirth");
//				 		
//				 		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//				        String dateOfBirth = dateFormat.format(date);
				 		
				 		//resquest.put("DateOfBirth", data.get("DateOfBirth"));
						
						
						
						
						System.out.println(data);
				            System.out.println(data.get("Firstname"));
				            
				            System.out.println(data.get("Lastname"));


							
							 System.out.println("resquest body "+resquest);
							
							response= given() 
									//.baseUri(baseURI)
									//  .header("Content-Type", "application/json")
									.header("Authorization", "Bearer " + Routes.dieticianToken , "application/json")
									.pathParam("patientId","246")
									.when()
									.multiPart("patientInfo", resquest)
									
									.multiPart("file",filepath)
									//"patientId": 246,
									
									//Put_URL = Base_URL + "/updateuser/{userId}";
									.put("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/patient/{patientId}");
							 System.out.println("Response Body: " + response.getBody().asString());
						//	System.out.println("Response Message:   "+response+"payload:   " +request);
							   System.out.println("create patient   "+response.asPrettyString());
						//	return reqBody;
						//	return;
							return response;
						
						//return reqBody;
					 }
		//return reqBody;


	public Response updatePatientWithInvalid_PatientID(Map<String, String> data) {
				 
			
		 String reqBody = " ";
					UpdateUser up_user = new UpdateUser(data.get("FirstName"), data.get("LastName"),data.get("ContactNumber"),data.get("DateOfBirth"),data.get("Email")
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

					
					
					
					
					System.out.println(data);
			            System.out.println(data.get("Firstname"));
			            
			            System.out.println(data.get("Lastname"));

			           
						
						 System.out.println("resquest body "+resquest);
						
						response= given() 
								//.baseUri(baseURI)
								//  .header("Content-Type", "application/json")
								.header("Authorization", "Bearer " + Routes.dieticianToken , "application/json")
								.pathParam("patientId","111111")
								.when()
								.multiPart("patientInfo", resquest)
								
								.multiPart("file",filepath)
								//"patientId": 246,
								
								//Put_URL = Base_URL + "/updateuser/{userId}";
								.put("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/patient/{patientId}");
						 System.out.println("Response Body: " + response.getBody().asString());
					//	System.out.println("Response Message:   "+response+"payload:   " +request);
						   System.out.println("create patient   "+response.asPrettyString());
			
						return response;
					
					
				 }


	public Response updatePatient_WithoutAttachingFile(Map<String, String> data) {
		// TODO Auto-generated method stub
//		Login pl=new Login();
//		System.out.println("Util.dieticianid  "+ Routes.dieticianid);
//			response1=	pl.userlogin("sanu0.up@gmail.com","Faith79");
//		String dietician_TKN = response1.jsonPath().getString("token");
//			// UpdateUser up_user;
		
		System.out.println("dietician_TKN    "+Routes.dieticianToken);
				 
			
		 String reqBody = " ";
					UpdateUser up_user = new UpdateUser(data.get("FirstName"), data.get("LastName"),data.get("ContactNumber"),data.get("DateOfBirth"),data.get("Email")
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

					
					
					
					
					System.out.println(data);
			            System.out.println(data.get("Firstname"));
			            
			            System.out.println(data.get("Lastname"));

			           
						
						 System.out.println("resquest body "+resquest);
						
						response= given() 
								//.baseUri(baseURI)
								//  .header("Content-Type", "application/json")
								.header("Authorization", "Bearer " + Routes.dieticianToken , "application/json")
								.pathParam("patientId","246")
								.when()
								.multiPart("patientInfo", resquest)
								
								.multiPart("file","")
								//"patientId": 246,
								
								//Put_URL = Base_URL + "/updateuser/{userId}";
								.put("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/patient/{patientId}");
						 System.out.println("Response Body: " + response.getBody().asString());
					//	System.out.println("Response Message:   "+response+"payload:   " +request);
						   System.out.println("create patient   "+response.asPrettyString());
			
						return response;
	}


	public Response updatePatient_methodNotAllowed(Map<String, String> data) {
	
		 String reqBody = " ";
					UpdateUser up_user = new UpdateUser(data.get("FirstName"), data.get("LastName"),data.get("ContactNumber"),data.get("DateOfBirth"),data.get("Email")
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
			
					
					
					System.out.println(data);
			            System.out.println(data.get("Firstname"));
			            
			            System.out.println(data.get("Lastname"));

			           
						
						 System.out.println("resquest body "+resquest);
						
						response= given() 
								//.baseUri(baseURI)
								//  .header("Content-Type", "application/json")
								.header("Authorization", "Bearer " + Routes.dieticianToken , "application/json")
								.pathParam("patientId","246")
								.when()
								.multiPart("patientInfo", resquest)
								
								.multiPart("file",filepath)
								//"patientId": 246,
								
								//Put_URL = Base_URL + "/updateuser/{userId}";
								.get("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/patient/{patientId}");
						 System.out.println("Response Body: " + response.getBody().asString());
					//	System.out.println("Response Message:   "+response+"payload:   " +request);
						   System.out.println("create patient   "+response.asPrettyString());
					//	return reqBody;
					//	return;
						return response;
	}


	public Response updatePatient_WithInvaliEndPoint(Map<String, String> data) {

		System.out.println("dietician_TKN    "+Routes.dieticianToken);
				 
			
		 String reqBody = " ";
					UpdateUser up_user = new UpdateUser(data.get("FirstName"), data.get("LastName"),data.get("ContactNumber"),data.get("DateOfBirth"),data.get("Email")
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
			
					
					
					System.out.println(data);
			            System.out.println(data.get("Firstname"));
			            
			            System.out.println(data.get("Lastname"));

			           
						
						 System.out.println("resquest body "+resquest);
						
						response= given() 
								//.baseUri(baseURI)
								//  .header("Content-Type", "application/json")
								.header("Authorization", "Bearer " + Routes.dieticianToken , "application/json")
								.pathParam("patientId","246")
								.when()
								.multiPart("patientInfo", resquest)
								
								.multiPart("file",filepath)
								//"patientId": 246,
								
								//Put_URL = Base_URL + "/updateuser/{userId}";
								.put("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/invalidendpoint/{patientId}");
						 System.out.println("Response Body: " + response.getBody().asString());
					//	System.out.println("Response Message:   "+response+"payload:   " +request);
						   System.out.println("create patient   "+response.asPrettyString());
					//	return reqBody;
					//	return;
						return response;
	}


	public Response updatePatient_WithInvalidContentType(Map<String, String> data) {
		// TODO Auto-generated method stub
//		Login pl=new Login();
//		System.out.println("Util.dieticianid  "+ Routes.dieticianid);
//			response1=	pl.userlogin("sanu0.up@gmail.com","Faith79");
//		String dietician_TKN = response1.jsonPath().getString("token");
			// UpdateUser up_user;
		System.out.println("dietician_TKN    "+Routes.dieticianToken);
				 
			
		 String reqBody = " ";
					UpdateUser up_user = new UpdateUser(data.get("FirstName"), data.get("LastName"),data.get("ContactNumber"),data.get("DateOfBirth"),data.get("Email")
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
			
					
					
					System.out.println(data);
			            System.out.println(data.get("Firstname"));
			            
			            System.out.println(data.get("Lastname"));

			           
						
						 System.out.println("resquest body "+resquest);
						
						response= given() 
								//.baseUri(baseURI)
								//  .header("Content-Type", "application/json")
								.header("Authorization", "Bearer " + Routes.dieticianToken , "application/invalid_content_type")
								.pathParam("patientId","246")
								.when()
								.multiPart("patientInfo", resquest)
								
								.multiPart("file",filepath)
								//"patientId": 246,
								
								//Put_URL = Base_URL + "/updateuser/{userId}";
								.put("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/invalidendpoint/{patientId}");
						 System.out.println("Response Body: " + response.getBody().asString());
					//	System.out.println("Response Message:   "+response+"payload:   " +request);
						   System.out.println("create patient   "+response.asPrettyString());
					//	return reqBody;
					//	return;
						return response;
	}
	}
				
	
				
					
					

	
	
	
	

 
