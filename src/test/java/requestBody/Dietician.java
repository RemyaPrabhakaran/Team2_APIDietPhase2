package requestBody;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import payload.Dietician_Post;


public class Dietician {
	
	Dietician_Post dietcianPut;
	String reqBody;

	public String getDieticianReqBody(Map<String, String> testdata) throws Exception {
        
		 
		dietcianPut = new Dietician_Post(testdata.get("ContactNumber"), testdata.get("DateOfBirth"), testdata.get("Education"), 
				testdata.get("Email"), testdata.get("FirstName"), testdata.get("HospitalCity"), testdata.get("HospitalName"),
				testdata.get("HospitalPincode"), testdata.get("HospitalStreet"), testdata.get("LastName"));
       

       ObjectMapper objectMapper = new ObjectMapper();
       try {
           reqBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dietcianPut);
           
       
       } catch (JsonProcessingException e) {
           e.printStackTrace();
           throw new Exception("Error while processing JSON", e);
       }
	 
	return reqBody;
}
}
