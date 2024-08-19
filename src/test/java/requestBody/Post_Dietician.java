package requestBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import payload.Dietician_Post;
import payload.Patient_Post;

public class Post_Dietician {
	Dietician_Post Dietician;
	 String reqBody;
	 public static String endpoint;
	 public static String contentType;
	 public static String FirstName;
	 public static String LastName;
	 
	 public String getDieticanReqBody(Map<String, String> testdata) throws Exception {
	//	 testdata.put("DateOfBirth", "1989-02-14");
		 String dateOfBirth = testdata.get("DateOfBirth");
		 endpoint= testdata.get("Endpoint");
		 contentType=testdata.get("ContentType");
		 
		
	        String formattedDateOfBirth = convertDateFormat(dateOfBirth);
     //   Patient = new Patient_Post(testdata.get("FirstName"), testdata.get("LastName"), testdata.get("ContactNumber"),testdata.get("Email"),testdata.get("Allergy"), testdata.get("FoodCategory"), testdata.get("DateOfBirth"));
		 // public String getPatientReqBody(Map<String, String> testdata) throws Exception {
		        // Creating a new Patient_Post object using the map data
		        
		        
	        Dietician = new Dietician_Post(
			            testdata.get("FirstName"),
			            testdata.get("LastName"),
			            testdata.get("ContactNumber"),
			            testdata.get("Email"),
			            testdata.get("HospitalName"),
			            testdata.get("HospitalStreet"),
			           // testdata.get("DateOfBirth"),
			           // testdata.put("DateOfBirth", "1989-02-14"),
			            formattedDateOfBirth,
			            testdata.get("HospitalCity"),
			            testdata.get("HospitalPinCode"),
			            testdata.get("Education")
			            
			        );
		 System.out.println(testdata);
		 
	
    

       // Converting Dietician Login object to JSON string
       ObjectMapper objectMapper = new ObjectMapper();
       try {
           reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(Dietician);
           
       
       } catch (JsonProcessingException e) {
           e.printStackTrace();
           throw new Exception("Error while processing JSON", e);
       }
	 
	return reqBody;
}
	 private String convertDateFormat(String dateStr) throws Exception {
		 if (dateStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
		        return dateStr; 
	    } 
		 SimpleDateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy");
	        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = inputFormat.parse(dateStr);
	        return outputFormat.format(date);
		
}
}
