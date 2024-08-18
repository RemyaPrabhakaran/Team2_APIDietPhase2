package testContext;

import utilities.ReqResSpec;
import utilities.ResourceBundleReader;

public class TestContext {
	
	private ReqResSpec reqResSpec;
	
	private ResourceBundleReader resourceBundleReader;
	public TestContext() {
		reqResSpec = new ReqResSpec();
		resourceBundleReader = new ResourceBundleReader();
	}
		
		public ReqResSpec getReqResSpec() {
			return reqResSpec;
		}
		public ResourceBundleReader getResourceBundleReader() {
			return resourceBundleReader;

	}
	
}
