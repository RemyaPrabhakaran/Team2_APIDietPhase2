package payload;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GetallMorbidities {
	public static class Request {
		private String baseUrl;        
		private String endpoint;       
		private String contentType;
		private String token;
		
		// Constructor
		public Request() {
		}
		
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
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
		private int morbidityId;
		private int morbidityMarkerMinVal;
		private int morbidityMarkerMaxVal;
		private String morbidityTestId;
		private String morbidityNameRegex;
		private String morbidityTestName;
		private String morbidityTestUnit;
		
		public int getMorbidityId() {
			return morbidityId;
		}
		public void setMorbidityId(int morbidityId) {
			this.morbidityId = morbidityId;
		}
		public int getMorbidityMarkerMinVal() {
			return morbidityMarkerMinVal;
		}
		public void setMorbidityMarkerMinVal(int morbidityMarkerMinVal) {
			this.morbidityMarkerMinVal = morbidityMarkerMinVal;
		}
		public int getMorbidityMarkerMaxVal() {
			return morbidityMarkerMaxVal;
		}
		public void setMorbidityMarkerMaxVal(int morbidityMarkerMaxVal) {
			this.morbidityMarkerMaxVal = morbidityMarkerMaxVal;
		}
		public String getMorbidityTestId() {
			return morbidityTestId;
		}
		public void setMorbidityTestId(String morbidityTestId) {
			this.morbidityTestId = morbidityTestId;
		}
		public String getMorbidityNameRegex() {
			return morbidityNameRegex;
		}
		public void setMorbidityNameRegex(String morbidityNameRegex) {
			this.morbidityNameRegex = morbidityNameRegex;
		}
		public String getMorbidityTestName() {
			return morbidityTestName;
		}
		public void setMorbidityTestName(String morbidityTestName) {
			this.morbidityTestName = morbidityTestName;
		}
		public String getMorbidityTestUnit() {
			return morbidityTestUnit;
		}
		public void setMorbidityTestUnit(String morbidityTestUnit) {
			this.morbidityTestUnit = morbidityTestUnit;
		}
	}
}
