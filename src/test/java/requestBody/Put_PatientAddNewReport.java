package requestBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import payload.Patient_Put_AddNewReports;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import payload.Patient_Vitals;
import payload.Patient_Post;

public class Put_PatientAddNewReport {

	//Response response;
	Patient_Vitals PVitals;
	Patient_Put_AddNewReports Patient;
		 String reqBody;
		 String reqBody1;
		 public static String endpoint;
		 public static String contentType;
		 public static String FirstName;
		 public static String LastName;
		 
		 public String getPatientPutReqBody(Map<String, String> testdata) throws Exception {
		//	 testdata.put("DateOfBirth", "1989-02-14");
			 String dateOfBirth = testdata.get("DateOfBirth");
			 endpoint= testdata.get("Endpoint");
			 contentType=testdata.get("ContentType");
			 
			
		        String formattedDateOfBirth = convertDateFormat(dateOfBirth);
	      //   Patient = new Patient_Post(testdata.get("FirstName"), testdata.get("LastName"), testdata.get("ContactNumber"),testdata.get("Email"),testdata.get("Allergy"), testdata.get("FoodCategory"), testdata.get("DateOfBirth"));
			 // public String getPatientReqBody(Map<String, String> testdata) throws Exception {
			        // Creating a new Patient_Post object using the map data
			        
			        
			       Patient = new Patient_Put_AddNewReports(
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
			
	}
		 
		 public String getPatientPutvitals(Map<String, String> testdata1) throws Exception {
				
					 
			 float height = Float.parseFloat(testdata1.get("Height"));
		        float weight = Float.parseFloat(testdata1.get("Weight"));
		        float temperature = Float.parseFloat(testdata1.get("Temperature"));
		        int sp = Integer.parseInt(testdata1.get("sp"));
		        int dp = Integer.parseInt(testdata1.get("dp"));
		        
		        // Create Patient_Vitals object
		         PVitals = new Patient_Vitals(weight, height, temperature, sp, dp);
				       
					        
					     
					 System.out.println(testdata1);
					 
				
			        // Converting User_Login object to JSON string
			        ObjectMapper objectMapper = new ObjectMapper();
			        try {
			            reqBody1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(PVitals);
			            
			        
			        } catch (JsonProcessingException e) {
			            e.printStackTrace();
			            throw new Exception("Error while processing JSON", e);
			        }
				 
				return reqBody1;
			 }
}
