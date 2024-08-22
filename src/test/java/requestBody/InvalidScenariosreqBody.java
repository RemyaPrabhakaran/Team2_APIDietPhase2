package requestBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import payload.Dietician_Post;

public class InvalidScenariosreqBody {

	public String reqBody() {
		Dietician_Post Body = new Dietician_Post("8729759873", "1950-09-23", "MBBS",
				"dummy@gmail.com", "Dummy", "Chennai", "NewLife", "913670", "Velachery Main Road", "Test");
		ObjectMapper objectmapper = new ObjectMapper();

	
			String requestbody = null;
			try {
				requestbody = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(Body);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return requestbody;
	}
}

