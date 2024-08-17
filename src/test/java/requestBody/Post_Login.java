package requestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import payload.User_Login;
import utilities.ExcelUtilities;

public class Post_Login {
	 Response response;
	 User_Login login;
	 String reqBody;
	 
	 

	public String getLoginReqBody(Map<String, String> testdata) throws Exception {
         
		 
             login = new User_Login(testdata.get("password"), testdata.get("userLoginEmail"));
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