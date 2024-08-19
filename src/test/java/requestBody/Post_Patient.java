package requestBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import payload.Patient_Post;



public class Post_Patient {

	//Response response;
	Patient_Post Patient;
	 String reqBody;
	 public static String endpoint;
	 public static String contentType;
	 public static String FirstName;
	 public static String LastName;
	 
	 public String getPatientReqBody(Map<String, String> testdata) throws Exception {
	//	 testdata.put("DateOfBirth", "1989-02-14");
		 String dateOfBirth = testdata.get("DateOfBirth");
		 endpoint= testdata.get("Endpoint");
		 contentType=testdata.get("ContentType");
		 
		
	        String formattedDateOfBirth = convertDateFormat(dateOfBirth);
      //   Patient = new Patient_Post(testdata.get("FirstName"), testdata.get("LastName"), testdata.get("ContactNumber"),testdata.get("Email"),testdata.get("Allergy"), testdata.get("FoodCategory"), testdata.get("DateOfBirth"));
		 // public String getPatientReqBody(Map<String, String> testdata) throws Exception {
		        // Creating a new Patient_Post object using the map data
		        
		        
		       Patient = new Patient_Post(
			            testdata.get("FirstName"),
			            testdata.get("LastName"),
			            testdata.get("ContactNumber"),
			            testdata.get("Email"),
			            testdata.get("Allergy"),
			            testdata.get("FoodPreference"),
			           // testdata.get("DateOfBirth"),
			           // testdata.put("DateOfBirth", "1989-02-14"),
			            formattedDateOfBirth,
			            testdata.get("CuisineCategory")
			        );
		 System.out.println(testdata);
		 
	/*	 Patient_Post p=new Patient_Post();
		 p.Allergy= testdata.get("Allergy");
		 p.DateOfBirth=formattedDateOfBirth;
		 p.CuisineCategory=testdata.get("FoodPreference");
		 p.ContactNumber=testdata.get("ContactNumber");
		 p.FirstName=testdata.get("FirstName");
        p.LastName= testdata.get("LastName");
        p.Email= testdata.get("Email");
        p.Allergy= testdata.get("Allergy");
       p.CuisineCategory=  testdata.get("CuisineCategory");*/
		 
     

        // Converting User_Login object to JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(Patient);
            
        
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
		
}}
