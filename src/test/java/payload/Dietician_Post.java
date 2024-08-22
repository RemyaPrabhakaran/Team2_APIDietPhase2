package payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dietician_Post {
	
    @JsonProperty("Firstname")
    private String Firstname;

    @JsonProperty("Lastname")
    private String Lastname;

    @JsonProperty("ContactNumber")
    private String ContactNumber;

    @JsonProperty("Email")
    private String Email;

    @JsonProperty("DateOfBirth")
    private String DateOfBirth;

    @JsonProperty("HospitalCity")
    private String HospitalCity;

    @JsonProperty("HospitalName")
    private String HospitalName;

    @JsonProperty("HospitalPincode")
    private String HospitalPincode;

    @JsonProperty("HospitalStreet")
    private String HospitalStreet;

    @JsonProperty("Education")
    private String Education;

	public Dietician_Post(String ContactNumber, String DateOfBirth,String Education, String Email, String Firstname,
			String HospitalCity, String HospitalName, String HospitalPincode, String HospitalStreet, String Lastname ) {
		this.ContactNumber = ContactNumber;
		this.DateOfBirth = DateOfBirth;
		this.Education = Education;
		this.Email = Email;
		this.Firstname = Firstname;
		this.HospitalCity = HospitalCity;
		this.HospitalName = HospitalName;
		this.HospitalPincode = HospitalPincode;
		this.HospitalStreet = HospitalStreet;
		this.Lastname = Lastname;
	}
	

}