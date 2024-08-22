package requestBody;

import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import payload.D_Login;
import payload.User_Login;
import stepDefinition.DieticianPost;

public class Post_DieticianLogin {
	 Response response;
	 D_Login login;
	 String reqBody;
	 
	 

	public String getDLoginReqBody() throws Exception {
         
		 
             login = new D_Login(DieticianPost.DieticianEmail, DieticianPost.DieticianPassword);
          //  System.out.println(testdata);
            // Handling expected status code if needed later
//             exp_status_code = Integer.parseInt(testdata.get("StatusCode"));
          //  System.out.println(testdata.get("password"));
            

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
