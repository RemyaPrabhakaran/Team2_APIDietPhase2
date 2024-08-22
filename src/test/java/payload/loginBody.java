package payload;

public class loginBody {

	private String userLoginEmail; 
	private String password; 
	
	
	public loginBody(String passwrd, String email) {
		setPassword(passwrd);
		setUserLoginEmail(email);
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserLoginEmail() {
		return userLoginEmail;
	}
	public void setUserLoginEmail(String userLoginEmail) {
		this.userLoginEmail = userLoginEmail;
	}

}
