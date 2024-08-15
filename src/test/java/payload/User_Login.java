package payload;

public class User_Login {
	
	private String password;
	private String userLoginEmail;
	
	public User_Login(String passwrd, String email) {
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
