package hooks;




import io.cucumber.java.AfterAll;

import stepDefinition.DieticianPostStepDef;


public class Hooks { 

	@AfterAll
	public static void listCleanUp() {
		System.out.println("+++++++++Before+++++++"+DieticianPostStepDef.dieticianIDs);
		 	DieticianPostStepDef.dieticianIDs.clear();
		 	DieticianPostStepDef.dieticianEmails.clear();
		 	DieticianPostStepDef.dieticianPasswords.clear();
		 	System.out.println("##########AFter@@@@@@@@@@@"+DieticianPostStepDef.dieticianIDs);
	}

}
