package com.automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.base.Base;
import com.automationexercise.pages.ContactUsFormPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.utils.DataProviders;

public class ContactUsTests extends Base {
	
	@Test(dataProvider="contactUsForm",dataProviderClass=DataProviders.class)
	public void contactUsformvalidation(String name, String email, String subject, String message,String filepath) throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.clickContactUsFormButton();
		
		ContactUsFormPage cufp = new ContactUsFormPage(driver);
		Assert.assertTrue(cufp.isGetInTouchMessageVisible(),"Get in touch message is not visible");
		cufp.enterContactDetails(name, email, subject, message);
		cufp.uploadFile(filepath);
		cufp.clickSubmitButton();
		Assert.assertTrue(cufp.isSuccessMessageVisible(), "Contact US form is not submitted successfully");
	}

}
