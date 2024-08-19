package stepDefinition;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;

import io.restassured.response.Response;

public class Login 

{
	
	public static String loginEndpoint = "/login";
	public static String logoutEndPoint = "/logoutdietician";
    public static Response response;
    public static JSONObject request1 = new JSONObject();
   // private static String email = "";
   // private static String pasword = "";

    public static Response	userlogin(String userlogin, String password)
	{
    	request1.put("password", password);
		request1.put("userLoginEmail", userlogin);
		//System.out.println(request1.toJSONString());
		
		
		baseURI="https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician";
		response = given()
			    .baseUri(baseURI)
			    .header("Content-Type", "application/json")
			    .body(request1.toJSONString())
			    .when()
			    .post(loginEndpoint);
		//String authToken = response.jsonPath().getString("token");
		
		//System.out.println("authToken------- "+authToken);
		return response;
	}

	public Response createDietician(String dtoToken) 
	
	{
		
//		Bearer   eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYW51LnVwQGdtYWlsLmNvbSIsImlhdCI6MTcyMzg4NDkyMywiZXhwIjoxNzIzOTEzNzIzfQ.wuKQaCwD41-uN8QDAKstLlAYaOWphriGeoGJof73ZfQ4-mn1akk_AGiiS4xHblggN7EmTi4Pl0eBaps0wHJTFw
//		Response Body: {"patientId":123,"FirstName":"Supriya","LastName":"khanna","ContactNumber":"1234567890","Email":"Supriya@gmail.com","Allergy":"ALMOND","FoodPreference":"Vegetarian","CuisineCategory":"Indian","DateOfBirth":"2000-09-21","DieticianId":378}
//		create patient   {
//		    "patientId": 123,
//		    "FirstName": "Supriya",
//		    "LastName": "khanna",
//		    "ContactNumber": "1234567890",
//		    "Email": "Supriya@gmail.com",
//		    "Allergy": "ALMOND",
//		    "FoodPreference": "Vegetarian",
//		    "CuisineCategory": "Indian",
//		    "DateOfBirth": "2000-09-21",
//		    "DieticianId": 378
		
		

		//"password":"Song88","userLoginEmail":"sanu.up@gmail.com"
	JSONObject request = new JSONObject();
	
		request.put("ContactNumber","1229669820");
		request.put("DateOfBirth","2017-08-10");
		request.put("Education", "MCA");
		request.put("Email","sanu0.up@gmail.com");
		request.put("Firstname", "shan");
		request.put("HospitalCity", "dallas");
		request.put("HospitalName", "baptist");
		request.put("HospitalPincode", "123456");
		request.put("HospitalStreet", "cordova");
		request.put("Lastname", "sharma");
		
		System.out.println("***********      "+request.toString());
		
		baseURI="https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/dietician";
		
	Response	 response1=given()//.baseUri(baseURI)
				.header("Content-Type", "application/json")
				
				.header("Authorization", "Bearer "+dtoToken)
				
				 .body(request)
				.when()
                      
                .post("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/dietician");
	
		// email=response1.jsonPath().getString("Email");
		// pasword=response1.jsonPath().getString("loginPassword");
		
		//System.setProperty("token", response.jsonPath().getString("access_token"));
	
	
	System.out.println("create dietician   "+response1.asPrettyString());
	//return new createDietician(email, pasword);
	return response1;
		
	}

	public Response dieticianLogin(String email, String pasword) {
		request1.put("password", pasword);
		request1.put("userLoginEmail", email);
		System.out.println("--------------   "+request1.toJSONString());
		
		
		baseURI="https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician";
		response = given()
			    .baseUri(baseURI)
			    .header("Content-Type", "application/json")
			    .body(request1)
			    .when()
			    .post("/login");
		System.out.println("login dietician   "+response.asPrettyString());
		return response;
		
	}

	


	
}
