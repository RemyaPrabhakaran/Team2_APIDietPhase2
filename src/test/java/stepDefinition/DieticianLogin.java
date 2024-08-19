package stepDefinition;

import java.io.FileNotFoundException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ReqResSpec;


public class DieticianLogin extends ReqResSpec {
	
	RequestSpecification request;
	 Response response;
	public static String dtoken;
	public static void dieticianLogin () throws FileNotFoundException, JsonMappingException, JsonProcessingException
	{
		String User="Teamnm.amin@gmail.com";
		String Password="Growth76";
		String t="";
		
		 
	/*		response= RestAssured
					    .given()
					    	.spec(ReqSpec()).header("Authorization", "Bearer "+ t).when().post().then()
					    	
					    	.assertThat().statusCode(201)
					    	.log().all().extract().response();
		
		 
		 String responseBody= response.body().asString();*/
			
		 ObjectMapper objectMapper = new ObjectMapper();
	       
	       //    com.fasterxml.jackson.databind.JsonNode jsonNode = objectMapper.readTree(responseBody);
	         // dtoken = jsonNode.get("token").asText();
	           System.out.println("Dietician Token: " + dtoken);
		 
		
	}

}
