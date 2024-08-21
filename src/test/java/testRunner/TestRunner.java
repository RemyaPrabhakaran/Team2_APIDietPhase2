package testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"C:\\Users\\rashm\\git\\Team2_APIDietPhase2RestAssured\\src\\test\\resources\\Features\\Patient.feature",
				"C:\\Users\\rashm\\git\\Team2_APIDietPhase2RestAssured\\src\\test\\resources\\Features\\PatientGetMorbDetails.feature",
				"C:\\Users\\rashm\\git\\Team2_APIDietPhase2RestAssured\\src\\test\\resources\\Features\\PatientGetRetrivePatientFile.feature"
		},
        glue = {"stepDefinition"},
        		   plugin = {"pretty","html:HtmlReport/report.html",
        		    		"json:JSONReport/report.json",
        		    		
        		    		"timeline:test-output-thread/"})     
			

public class TestRunner extends AbstractTestNGCucumberTests {

}
