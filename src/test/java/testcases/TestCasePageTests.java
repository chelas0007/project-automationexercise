package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupTeardown;
import pages.HomePage;
import pages.TestCasesPage;

public class TestCasePageTests extends SetupTeardown {

	@Test
	public void valiadteTestcasePage() {
		HomePage hp = new HomePage(driver);
		TestCasesPage tcp = new TestCasesPage(driver);
		
		Assert.assertTrue(hp.isHomePageVisible(),"Homepage is not visible");
		hp.clickTestcasesButton();
		
		Assert.assertTrue(tcp.isTestcaseTitleVisible(),"Testcsae title is not visible");
	}
	
}
