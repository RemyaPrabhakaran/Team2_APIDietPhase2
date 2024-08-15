package baseTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import io.cucumber.java.Before;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class BaseTest { 
	public PrintStream log;
	RequestLoggingFilter requestLoggingFilter;
	ResponseLoggingFilter responseLoggingFilter;
	
	@Before
	public void Logging() throws FileNotFoundException {
		
		log = new PrintStream(new FileOutputStream("log.txt"));
		requestLoggingFilter = new RequestLoggingFilter(log);
		responseLoggingFilter =  new ResponseLoggingFilter(log);
	}
}
