package testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/Features"
		},
        glue = {"stepDefinition"},
        		// tags = "@tag1 or @tag2 or @tag3 or @tag4 or @tag5",
        		   plugin = {"pretty","html:HtmlReport/report.html",
        		    		"json:JSONReport/report.json",
        		    		
        		    		"timeline:test-output-thread/"})     
			

public class TestRunner extends AbstractTestNGCucumberTests {

}
