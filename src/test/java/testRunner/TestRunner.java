package testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features =
//		 {
//				 "src/test/resources/Features/Patient_PutOperation.feature",
//	"src/test/resources/Features/getOperation_GetAllPatient.feature",
//			"src/test/resources/Features/RetrieveMorbidity_byTest name.feature",
//		"src/test/resources/Features/SetNoAuth.feature",
				"src/test/resources/Features/setAdminBearer.feature",
				
        glue = {"stepDefinition"},
        		monochrome=true,  
        		   plugin = {"pretty","html:HtmlReport/report.html",
        		    		"json:JSONReport/report.json",
        		    		
        		    		"timeline:test-output-thread/"})     
			

public class TestRunner extends AbstractTestNGCucumberTests {

}
