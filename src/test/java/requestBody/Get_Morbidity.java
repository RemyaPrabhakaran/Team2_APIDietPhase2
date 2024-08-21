package requestBody;

import java.util.List;
import java.util.Map;

import payload.GetallMorbidities;
import payload.User_Login;
import utilities.ExcelUtilities;

public class Get_Morbidity {
	public static GetallMorbidities.Request request;
	public static GetallMorbidities.Request GetMobidityRequestBody(String sheet, int rowNo) throws Exception {
		List<Map<String, String>> testData;
		testData = ExcelUtilities.getTestDataInMap("src/test/resources/Data/Team2_APIDiet_Data.xlsx", sheet, "getMorbidity");
		System.out.println("Test Data: " + testData);
		System.out.println("row: " + rowNo);
		Map<String, String> rowData = testData.get(rowNo);
        System.out.println("Row Data: " + rowData);
        //Initialize class object and call constructor
		request = new GetallMorbidities.Request();
		System.out.println("Request after initialization: " + request);
		//request.setBaseUrl(rowData.get("BaseUrl"));
	    //request.setEndpoint(rowData.get("Endpoint"));
	    //request.setContentType(rowData.get("ContentType"));
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
	    
	    String invalidEndpoint = rowData.get("Invalid Endpoint");

	    if (invalidEndpoint != null && !invalidEndpoint.isEmpty()) {
	        request.setInvalidUrl(rowData.get("Invalid Endpoint"));
	        System.out.println("Invalid EP:" + request.getInvalidUrl());
	    }
	    
	    System.out.println("content: " + request.getContentType());
	    System.out.println("Final Request Object: " + request);
	    
		return request;	
	}
	
	public static String getStatusCode(String sheet, Integer row) {
		List<Map<String, String>> testData;
		testData = ExcelUtilities.getTestDataInMap("src/test/resources/Data/Team2_APIDiet_Data.xlsx", sheet, "getMorbidity");
		System.out.println("Test Data: " + testData);
		System.out.println("row: " + row);
		Map<String, String> rowData = testData.get(row);
		
		return(rowData.get("StatusCode"));
	}

}
