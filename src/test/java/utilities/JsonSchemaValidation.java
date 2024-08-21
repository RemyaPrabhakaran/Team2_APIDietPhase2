package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import io.qameta.allure.internal.shadowed.jackson.core.json.WriterBasedJsonGenerator;

public class JsonSchemaValidation {

	
	public String getJsonSchema(String jsonFile) throws IOException {
		System.out.println(jsonFile);
		return FileUtils.readFileToString(new File(jsonFile), "UTF-8");
	}
}
