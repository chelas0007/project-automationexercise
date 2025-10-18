package com.automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.base.Base;
import com.automationexercise.pages.AccountCreatedDeletedPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignupLoginPage;
import com.automationexercise.utils.DataProviders;

public class LoginLogoutTests extends Base {
	
	@Test(dataProvider="validLoginCredentials",dataProviderClass=DataProviders.class,priority=0)
	public void loginusingvalidcredentials(String email, String password) {
		
		HomePage hp = new HomePage(driver);
		SignupLoginPage slp = new SignupLoginPage(driver);
		AccountCreatedDeletedPage acdp = new AccountCreatedDeletedPage(driver);
		
		Assert.assertTrue(hp.isHomePageVisible(),"Home page is not visible");
		hp.clickSignupLoginButton();
		
		Assert.assertTrue(slp.isLoginVisible(),"Login is not visible");
		slp.enterLoginDetails(email, password);	
		
		Assert.assertTrue(hp.isLoggedInAsUserVisible(),"Login is failed");
		hp.clickDeleteAccountButton();
		
		Assert.assertTrue(acdp.isAccountDeletedMessageDisplayed(),"account is not deleted");
		acdp.clickContinueButton();
	}
	
	//@Test(dataProvider="invalidLoginCredentials",dataProviderClass=DataProviders.class,priority=1)
	public void loginusinginvalidcredentials(String email, String password) {
		
		HomePage hp = new HomePage(driver);
		SignupLoginPage slp = new SignupLoginPage(driver);
		
		Assert.assertTrue(hp.isHomePageVisible(),"Home page is not visible");
		hp.clickSignupLoginButton();
		
		Assert.assertTrue(slp.isLoginVisible(),"Login is not visible");
		slp.enterLoginDetails(email, password);	
		Assert.assertTrue(slp.isInvalidLoginMessageVisible(),"Invalid Credentials message not received");
		slp.clickHomeButton();
		
	}
	
	//@Test(priority=2)
	public void logout() {
		HomePage hp = new HomePage(driver);
		SignupLoginPage slp = new SignupLoginPage(driver);
		
		hp.clickLogoutAccountButton();
		Assert.assertTrue(slp.isLoginVisible(),"Login is not visible");
	}
	
	//@Test(dataProvider="exceldata",dataProviderClass=DataProviders.class,priority=0)
	public void logincheck(String email,String password, String datavalidity) {
		HomePage hp = new HomePage(driver);
		SignupLoginPage slp = new SignupLoginPage(driver);
		
		hp.clickSignupLoginButton();
		slp.enterLoginDetails(email, password);	
		
		if (datavalidity.equalsIgnoreCase("valid"))
		{
			Assert.assertTrue(slp.isLoginVisible(),"Login is not visible");	
			hp.clickLogoutAccountButton();
			
		}
		if (datavalidity.equalsIgnoreCase("invalid"))
		{
			Assert.assertTrue(slp.isInvalidLoginMessageVisible(),"Invalid Credentials message not received");
			
		}
	}
	
}
