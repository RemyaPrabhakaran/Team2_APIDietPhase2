package requestBody;

import java.util.List;
import java.util.Map;

import payload.GetallMorbidities;
import payload.Logout;
import payload.User_Login;
import utilities.ExcelUtilities;

public class Get_Logout {
	public static Logout.Request request;
	public static Logout.Request Get_LogoutRequestBody(String sheet, int rowNo) throws Exception {
		List<Map<String, String>> testData;
		testData = ExcelUtilities.getTestDataInMap("C:\\Users\\kundu\\Documents\\Testdatafiles\\Team2_APIDiet_Data.xlsx", sheet, "getLogout");
		System.out.println("Test Data: " + testData);
		System.out.println("row: " + rowNo);
		Map<String, String> rowData = testData.get(rowNo);
        System.out.println("Row Data: " + rowData);
        //Initialize class object and call constructor
		request = new Logout.Request();
		System.out.println("Request after initialization: " + request);
		request.setBaseUrl(rowData.get("BaseUrl"));
	    request.setEndpoint(rowData.get("Endpoint"));
	    request.setContentType(rowData.get("ContentType"));
	    if(rowData.get("token_type").contains("admin")) {
	    	request.setToken(User_Login.adminBearerToken);
	    	System.out.println("admin token:" + User_Login.adminBearerToken);
	    } else if (rowData.get("token_type").contains("dietician")) {
	    	request.setToken(User_Login.dieticianBearerToken);
	    	System.out.println("dietician token:" + User_Login.dieticianBearerToken);
	    } else if (rowData.get("token_type").contains("patient")) {
	    	request.setToken(User_Login.patientBearerToken);
	    	System.out.println("patient token:" + User_Login.patientBearerToken);
	    }
	    System.out.println("content: " + request.getContentType());
	    System.out.println("Final Request Object: " + request);
		return request;	
	}
	
	public static String getStatusCode(String sheet, Integer row) {
		List<Map<String, String>> testData;
		testData = ExcelUtilities.getTestDataInMap("C:\\Users\\kundu\\Documents\\Testdatafiles\\Team2_APIDiet_Data.xlsx", sheet, "getlogout");
		System.out.println("Test Data: " + testData);
		System.out.println("row: " + row);
		Map<String, String> rowData = testData.get(row);
		System.out.println("status :" + rowData.get("StatusCode"));
		return(rowData.get("StatusCode"));
	}

}
