package requestBody;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import payload.User_Login;
import utilities.ExcelUtilities;

public class Post_Login {
	 Response response;
	public String UserLoginPost() throws Exception {
		List<Map<String, String>> testData;
		testData = ExcelUtilities.getTestDataInMap("src/test/resources/Data/Team2_APIDiet_Data.xlsx", "Sheet1", "UserLoginPost");
		String reqBody = null;
		for (Map<String, String> data : testData) {
           
            User_Login login = new User_Login(data.get("password"), data.get("userLoginEmail"));

            // Handling expected status code if needed later
            int exp_status_code = Integer.parseInt(data.get("StatusCode"));
            System.out.println(data.get("password"));
            

            // Converting User_Login object to JSON string
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(login);
                
            
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                throw new Exception("Error while processing JSON", e);
            }

            
        }
		return reqBody;
	}

}
