package utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ReqResSpec {

	RequestSpecification request;
	ResponseSpecification response;

	int exp_status_code;
	ResourceBundleReader reader = new ResourceBundleReader();
	String baseURI = reader.getBaseURI();

	public RequestSpecification ReqSpec() throws FileNotFoundException {
		PrintStream log = new PrintStream(new FileOutputStream("log.txt"));

		request = new RequestSpecBuilder().setBaseUri(baseURI).addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				// .setContentType(ContentType.JSON)
				.build();

		return request;
	}

	public ResponseSpecification ResSpec() {
		return response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	}

}
