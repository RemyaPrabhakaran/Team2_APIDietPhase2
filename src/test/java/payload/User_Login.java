package payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User_Login {
	static public String adminBearerToken;
	static public String dieticianBearerToken;
	static public String patientBearerToken;
	public static class Request {
		private String userLoginEmail; 
		private String password;       
    
		@JsonIgnore
		private String baseUrl;        
		@JsonIgnore
		private String endpoint;       
		@JsonIgnore
		private String contentType;    

		// Constructor
		public Request(String userLoginEmail, String password) {
			this.userLoginEmail = userLoginEmail;
			this.password = password;
		}
		

		// Getters and Setters
		public String getUserLoginEmail() {
			return userLoginEmail;
		}

		public void setUserLoginEmail(String userLoginEmail) {
			this.userLoginEmail = userLoginEmail;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getBaseUrl() {
			return baseUrl;
		}

		public void setBaseUrl(String baseUrl) {
			this.baseUrl = baseUrl;
		}

		public String getEndpoint() {
			return endpoint;
		}

		public void setEndpoint(String endpoint) {
			this.endpoint = endpoint;
		}

		public String getContentType() {
			return contentType;
		}

		public void setContentType(String contentType) {
			this.contentType = contentType;
		}
	}
	public static class Response {
		private String token;
	    private String type;
	    private int userId;
	    private String loginUserEmail;
	    private List<String> roles;
	    
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getLoginUserEmail() {
			return loginUserEmail;
		}
		public void setLoginUserEmail(String loginUserEmail) {
			this.loginUserEmail = loginUserEmail;
		}
		public List<String> getRoles() {
			return roles;
		}
		public void setRoles(List<String> roles) {
			this.roles = roles;
		}
	}
}
