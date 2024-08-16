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
	 
	 
//	 public List<Map<String, String>>  getLoginData() {
//		 List<Map<String, String>> testData;
//			testData = ExcelUtilities.getTestDataInMap("D:\\Rathna\\Hackathons\\Team2_APIDiet_RestAssured\\Team2_APIDiet_Data.xlsx", "Sheet1", "UserLoginPost");
//			return testData;
//	 }
	 @Test
	public String getLoginReqBody(Map<String, String> testdata) throws Exception {
         
		 
             login = new User_Login(testdata.get("password"), testdata.get("userLoginEmail"));
            System.out.println(testdata);
            // Handling expected status code if needed later
//             exp_status_code = Integer.parseInt(testdata.get("StatusCode"));
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