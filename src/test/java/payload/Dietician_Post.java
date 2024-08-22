package payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dietician_Post {
	 public  long ContactNumber;
	 public  String  DateOfBirth;
	 public  String  Education;
	 public  String Email;
	 public  String Firstname;
	 public  String HospitalCity;
	 public  String HospitalName;
	 public  String HospitalPincode;
	 public  String HospitalStreet;
	 public  String Lastname;
	 
	 public Dietician_Post(String firstName, String lastName, String contactNumber,
			 String email, String education, String hospitalCity, String dateOfBirth, 
			 String hospitalName, String hospitalPin, String hospitalst
			 ) {
			         this.Firstname = firstName;
			         this.Lastname = lastName;
			         this.ContactNumber = Long.parseLong(contactNumber); // Convert String to long
			         this.Email = email;
			         this.Education = education;
			         this.HospitalName = hospitalName;
			         this.DateOfBirth = dateOfBirth;
			         this.HospitalStreet= hospitalst;
			         this.HospitalCity= hospitalCity;
			         this.HospitalPincode= hospitalPin;

			     }
			     
	 



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
	
//	public String getFirstName() {
//		return FirstName;
//	}
//	public void setFirstName(String firstName) {
//		FirstName = firstName;
//	}
//	public String getLastName() {
//		return LastName;
//	}
//	public void setLastName(String lastName) {
//		LastName = lastName;
//	}
//	public String getContactNumber() {
//		return ContactNumber;
//	}
//	public void setContactNumber(String contactNumber) {
//		ContactNumber = contactNumber;
//	}
//	public String getEmail() {
//		return Email;
//	}
//	public void setEmail(String email) {
//		Email = email;
//	}
//	public String getDateOfBirth() {
//		return DateOfBirth;
//	}
//	public void setDateOfBirth(String dateOfBirth) {
//		DateOfBirth = dateOfBirth;
//	}
//	public String getHospitalCity() {
//		return HospitalCity;
//	}
//	public void setHospitalCity(String hospitalCity) {
//		HospitalCity = hospitalCity;
//	}
//	public String getHospitalName() {
//		return HospitalName;
//	}
//	public void setHospitalName(String hospitalName) {
//		HospitalName = hospitalName;
//	}
//	public String getHospitalPincode() {
//		return HospitalPincode;
//	}
//	public void setHospitalPincode(String hospitalPincode) {
//		HospitalPincode = hospitalPincode;
//	}
//	public String getHospitalStreet() {
//		return HospitalStreet;
//	}
//	public void setHospitalStreet(String hospitalStreet) {
//		HospitalStreet = hospitalStreet;
//	}
//	public String getEducation() {
//		return Education;
//	}
//	public void setEducation(String education) {
//		Education = education;
//	}
//	
//}
}