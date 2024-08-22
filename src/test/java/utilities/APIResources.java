package utilities;

public enum APIResources {
	loginEndpoint("/login"),
	logoutEndpoint("/logoutdietician"),
	dieticianEndpoint("/dietician"),
	dietcianPutEndpoint("/dietician/{dieticianId}"),
	patientEndpoint("/patient"),
	newReportsEndpoint("/patient/newReports"),
	patientMorbiditiesEndpoint("/patient/testReports"),
	RetrievePatientFileEndpoint("/patient/testReports/viewFile"),
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
