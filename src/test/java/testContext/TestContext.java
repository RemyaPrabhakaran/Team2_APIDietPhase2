package testContext;


import stepDefinition.AdminLoginStepDef;
import utilities.ReqResSpec;
import utilities.ResourceBundleReader;

public class TestContext {
	
	private ReqResSpec reqResSpec;
	private AdminLoginStepDef adminLoginStepDef;
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
	public AdminLoginStepDef getAdminLoginStepDef() {
        if (adminLoginStepDef == null) {
            adminLoginStepDef = new AdminLoginStepDef(this); 
        }
        return adminLoginStepDef;
    }

		
}
