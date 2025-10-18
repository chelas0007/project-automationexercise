package com.automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.base.Base;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.TestCasesPage;

public class TestCaseTests extends Base {

	@Test
	public void valiadteTestcasePage() {
		HomePage hp = new HomePage(driver);
		TestCasesPage tcp = new TestCasesPage(driver);
		
		Assert.assertTrue(hp.isHomePageVisible(),"Homepage is not visible");
		hp.clickTestcasesButton();
		
		Assert.assertTrue(tcp.isTestcaseTitleVisible(),"Testcsae title is not visible");
	}
	
}
