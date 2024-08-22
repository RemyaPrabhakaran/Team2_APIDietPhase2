
package payload;

public class UpdateUser {

	
String Firstname;
String Lastname;
String ContactNumber;
String DateOfBirth;
String Email;
String Allergy;
String FoodPreference;
String CuisineCategory; 


  public UpdateUser(String Firstname,String  Lastname,String ContactNumber,String DateOfBirth,String Email,
		  String Allergy,String FoodPreference,String CuisineCategory)
  
  {
	  this.Firstname=Firstname;
	  this.Lastname=Lastname;
	  this.ContactNumber=ContactNumber;
	  this.DateOfBirth=DateOfBirth;
	  this.Email=Email;
	  this.Allergy=Allergy;
	  this.FoodPreference=FoodPreference;
	  this.CuisineCategory=CuisineCategory;
  }


public String getFirstname() {
	return Firstname;
}
public void setFirstname(String firstname) {
	Firstname = firstname;
}
public String getLastname() {
	return Lastname;
}
public void setLastname(String lastname) {
	Lastname = lastname;
}
public String getContactNumber() {
	return ContactNumber;
}
public void setContactNumber(String contactNumber) {
	ContactNumber = contactNumber;
}
public String getDateOfBirth() {
	return DateOfBirth;
}
public void setDateOfBirth(String dateOfBirth) {
	DateOfBirth = dateOfBirth;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getAllergy() {
	return Allergy;
}
public void setAllergy(String allergy) {
	Allergy = allergy;
}
public String getFoodPreference() {
	return FoodPreference;
}
public void setFoodPreference(String foodPreference) {
	FoodPreference = foodPreference;
}
public String getCuisineCategory() {
	return CuisineCategory;
}
public void setCuisineCategory(String cuisineCategory) {
	CuisineCategory = cuisineCategory;
}



}