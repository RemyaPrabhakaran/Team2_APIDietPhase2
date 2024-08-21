package utilities;

public enum APIResources {
	loginEndpoint("/login"),
	logoutEndpoint("/logoutdietician"),
	dieticianEndpoint("/dietician"),
	dietcianPutEndpoint("/dietician/{dieticianId}"),
	patientEndpoint("/patient"),
	newReportsEndpoint("/patient/newReports/"),
	patientMorbiditiesEndpoint("/patient/testReports/{patientId}"),
	RetrievePatientFileEndpoint("/patient/testReports/viewFile/{fileId}"),
	DeletePatientEndpoint("/patient/{patientId}"),
	MorbidityEndpoint("/morbidity"),
	
	patientInvalidEndpoint("/ptient"),
	newReportsInvalidEndpoint("/ptient/newReports/{patientId}"),
	DeletePatientInvalidEndpoint("/ptient/{patientId}"),
	patientMorbiditiesInvalidEndpoint("/ptient/testReports/{patientId}"),
	RetrievePatientFileInvalidEndpoint("/ptient/testReports/viewFile/{fileId}");
	
	private String resource;

	APIResources(String resource) {
		this.resource = resource;
	}
	public String getResource() {
		return resource;
	}			

}
