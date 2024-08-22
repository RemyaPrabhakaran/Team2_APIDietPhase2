package payload;

public class Patient_Post {
	
   
	public String LastName;
    public long ContactNumber;
    public String Email;
    public String Allergy;
    
    public String DateOfBirth;

	public  String FirstName;
	
    public  String FoodPreference;
   
    public  String CuisineCategory;

    
  
    public Patient_Post(String firstName, String lastName, String contactNumber, String email, String allergy, String foodPreference, String dateOfBirth, String cuisineCategory
) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.ContactNumber = Long.parseLong(contactNumber); // Convert String to long
        this.Email = email;
        this.Allergy = allergy;
        this.FoodPreference = foodPreference;
        this.DateOfBirth = dateOfBirth;
        this.CuisineCategory= cuisineCategory;

    }
    

}
