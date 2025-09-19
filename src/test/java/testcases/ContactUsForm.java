package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupTeardown;
import dataprovider.DataProviderClass;
import pages.ContactUsFormPage;
import pages.HomePage;

public class ContactUsForm extends SetupTeardown {
	
	@Test(dataProvider="contactusform",dataProviderClass=DataProviderClass.class)
	public void contactUsformvalidation(String name, String email, String subject, String message) throws InterruptedException {
		HomePage hp = new HomePage(driver);
		ContactUsFormPage cp = new ContactUsFormPage(driver);
		
		Assert.assertTrue(hp.ishomepagevisible(), "HomePage is not visible");
		hp.contactusform();
		
		Assert.assertTrue(cp.isgetintouchmessagevisible(),"Get in touch message is not visible");
		cp.enterdetails(name, email, subject, message);
		cp.uploadingfile();
		cp.submitting();
		Assert.assertTrue(cp.issuccessmessagevisible(), "Contact US form is not submitted successfully");
		cp.homepagenavigation();
		
		Assert.assertTrue(hp.ishomepagevisible(), "HomePage is not visible");
	}
	
	

}
