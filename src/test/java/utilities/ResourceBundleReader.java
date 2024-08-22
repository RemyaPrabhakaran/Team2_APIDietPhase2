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


	
	public String getLoginJsonSchemaFile() {
		return getProperty("LoginSchema");
		
	}
	public String getDieticianSchemaFile() {
		return getProperty("DieticianSchema");
		
	}

}
