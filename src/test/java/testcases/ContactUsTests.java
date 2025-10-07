package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupTeardown;
import pages.ContactUsFormPage;
import pages.HomePage;
import utils.DataProviders;

public class ContactUsTests extends SetupTeardown {
	
	@Test(dataProvider="contactusform",dataProviderClass=DataProviders.class)
	public void contactUsformvalidation(String name, String email, String subject, String message,String filepath) throws InterruptedException {
		HomePage hp = new HomePage(driver);
		ContactUsFormPage cp = new ContactUsFormPage(driver);
		
		Assert.assertTrue(hp.isHomePageVisible(), "HomePage is not visible");
		hp.clickContactUsFormButton();
		
		Assert.assertTrue(cp.isGetInTouchMessageVisible(),"Get in touch message is not visible");
		cp.enterContactDetails(name, email, subject, message);
		cp.uploadFile(filepath);
		cp.clickSubmitButton();
		Assert.assertTrue(cp.isSuccessMessageVisible(), "Contact US form is not submitted successfully");
		cp.navigateTohomePage();
		
		Assert.assertTrue(hp.isHomePageVisible(), "HomePage is not visible");
	}
	
	

}
