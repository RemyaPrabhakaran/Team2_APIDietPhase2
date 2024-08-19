package payload;

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
			     
	 


}
