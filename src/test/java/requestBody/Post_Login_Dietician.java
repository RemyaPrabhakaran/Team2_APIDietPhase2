package requestBody;



import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import io.restassured.response.Response;

import payload.User_Login.Request;
import payload.loginBody;


public class Post_Login_Dietician {
	

		 Response response;
		 loginBody login;
		 String reqBody;
		 
		 

		public String getLoginReqBody(Map<String, String> testdata) throws Exception {
	         
			 
	             login = new loginBody(testdata.get("password"), testdata.get("userLoginEmail"));
	            System.out.println(testdata);

	            System.out.println(testdata.get("password"));
	            

	            // Converting User_Login object to JSON string
	            ObjectMapper objectMapper = new ObjectMapper();
	            try {
	                reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(login);
	                
	            
	            } catch (JsonProcessingException e) {
	                e.printStackTrace();
	                throw new Exception("Error while processing JSON", e);
	            }
			 
			return reqBody;
		 }

	}


