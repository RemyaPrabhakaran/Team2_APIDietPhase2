package requestBody;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import payload.User_Login;
import payload.User_Login.Request;
import utilities.ExcelUtilities;

public class Post_Login {
	 public static Response response;
	 public static User_Login.Request request;
	 public static User_Login.Request UserLoginPostBody(String sheet, int rowNo) throws Exception {
		List<Map<String, String>> testData;
		testData = ExcelUtilities.getTestDataInMap("C:\\Users\\kundu\\Documents\\Testdatafiles\\Team2_APIDiet_Data.xlsx", sheet, "UserLoginPost");
		System.out.println("Test Data: " + testData);
		System.out.println("row: " + rowNo);
		Map<String, String> rowData = testData.get(rowNo);
        System.out.println("Row Data: " + rowData);
        //Initialize class object and call constructor
		request = new User_Login.Request(rowData.get("userLoginEmail"),rowData.get("password"));
		System.out.println("Request after initialization: " + request);
		request.setBaseUrl(rowData.get("BaseUrl"));
	    request.setEndpoint(rowData.get("Endpoint"));
	    request.setContentType(rowData.get("ContentType"));
	    System.out.println("content: " + request.getContentType());
	    System.out.println("Final Request Object: " + request);
		return request;	
	}
	 
	public static String getStatusCode(String sheet, Integer row) {
		List<Map<String, String>> testData;
		testData = ExcelUtilities.getTestDataInMap("C:\\Users\\kundu\\Documents\\Testdatafiles\\Team2_APIDiet_Data.xlsx", sheet, "UserLoginPost");
		System.out.println("Test Data: " + testData);
		System.out.println("row: " + row);
		Map<String, String> rowData = testData.get(row);
		
		return(rowData.get("StatusCode"));
	}
}
