package response;

import java.util.Map;

public class PatientResponse {
	

	public int patientId;
    public String FirstName;
    public String LastName;
    public String ContactNumber;
    public String Email;
    public String Allergy;
    public String FoodPreference;
    public String CuisineCategory;
    public String DateOfBirth;
    public int DieticianId;
    public Map<String, Map<String, String>> FileMorbidity;
    public Map<String, String> FileMorbidityCondition;
    public Map<String, Map<String, String>> Vitals;
    public String LastVisitDate;

}
