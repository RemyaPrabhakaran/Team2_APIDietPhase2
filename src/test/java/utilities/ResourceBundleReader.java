package utilities;

import java.util.ResourceBundle;

public class ResourceBundleReader {
	private ResourceBundle dataRead;

	public ResourceBundleReader() {
		dataRead = ResourceBundle.getBundle("Config/config");
	}

	private String getProperty(String key) {
		String value = dataRead.getString(key);
		if (value != null) {
			return value;
		} else {
			throw new RuntimeException(key + " not specified in the file.");
		}
	}

	public String getBaseURI() {
		return getProperty("Baseuri");
	}

	public String getExcelFilePath() {
		return getProperty("excelPath");
	}

	public String getLoginEndpoint() {
		return getProperty("loginEndpoint");
	}

	public String getLogoutEndpoint() {
		return getProperty("logoutEndpoint");
	}

	public String getDieticianEndpoint() {
		return getProperty("dieticianEndpoint");
	}

	public String getPatientEndpoint() {
		return getProperty("patientEndpoint");
	}

	public String getNewReportsEndpoint() {
		return getProperty("newReportsEndpoint");
	}

	public String getPatientMorbiditiesEndpoint() {
		return getProperty("patientMorbiditiesEndpoint");
	}

	public String getRetrievePatientFileEndpoint() {
		return getProperty("RetrievePatientFileEndpoint");
	}

	public String getMorbidityEndpoint() {
		return getProperty("MorbidityEndpoint");
	}

}
