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
	patientInvalidEndpoint("/ptient"),
	newReportsInvalidEndpoint("/ptient/newReports/"),
	DeletePatientInvalidEndpoint("/ptient/{patientId}"),
	patientMorbiditiesInvalidEndpoint("/ptient/testReports/{patientId}"),
	RetrievePatientFileInvalidEndpoint("/ptient/testReports/viewFile/{fileId}"),
	MorbidityEndpoint("/morbidity"),
	invalidEndpoint("/dietican");
	
	private String resource;

	APIResources(String resource) {
		this.resource = resource;
	}
	public String getResource() {
		return resource;
	}			
}
