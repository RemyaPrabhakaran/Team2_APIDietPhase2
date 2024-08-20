package payload;

public class Logout {

	public static class Request {
		private String baseUrl;
		private String endpoint;
		private String contentType;
		private String token;

		public String getBaseUrl() {
			return baseUrl;
		}

		public Request() {
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

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}
	}

	public static class Response {
		private String Message;
		
		public String getMessage() {
			return Message;
		}

		public void setMessage(String message) {
			Message = message;
		}

	}
}
