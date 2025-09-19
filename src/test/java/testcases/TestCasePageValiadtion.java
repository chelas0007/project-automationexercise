package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupTeardown;
import pages.HomePage;
import pages.TestCasesPage;

public class TestCasePageValiadtion extends SetupTeardown {

	@Test
	public void valiadteTestcasePage() {
		HomePage hp = new HomePage(driver);
		TestCasesPage tcp = new TestCasesPage(driver);
		
		Assert.assertTrue(hp.ishomepagevisible(),"Homepage is not visible");
		hp.testcases();
		
		Assert.assertTrue(tcp.isTestcaseTitlevisible(),"Testcsae title is not visible");
	}
	
}
