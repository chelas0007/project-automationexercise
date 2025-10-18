package com.automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.base.Base;
import com.automationexercise.pages.AccountCreatedDeletedPage;
import com.automationexercise.pages.AccountCreationPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignupLoginPage;
import com.automationexercise.utils.DataProviders;

public class RegisterNLoginTests extends Base {
	
	
	@Test(dataProvider="registerAccountDetails",dataProviderClass=DataProviders.class,priority=0)
	public void registeringNewUserTest(String name, String email,String pass,String day,String month,String year, String fname,String lname,String cname,
			String addr1, String addr2,String state, String city,String pin,String mobile,String country) {
		
		HomePage hp = new HomePage(driver);
		hp.clickSignupLoginButton();
		
		SignupLoginPage slp = new SignupLoginPage(driver);
		Assert.assertTrue(slp.isSignupHeadingVisible(),"Sign Up Page is not visible");
		slp.enterSignUpDetails(name, email);
		
		AccountCreationPage acp = new AccountCreationPage(driver);
		Assert.assertTrue(acp.isEnterAccountInfoMessageVisible(), "Account Info Page is not visible");
		acp.fillAccountDetails(pass, fname, lname, cname, addr1, addr2, state, city, pin, mobile);
		acp.selectDropDownValues(day, month, year, country);
		acp.clickCreateAccountButton();
		
		AccountCreatedDeletedPage acdp = new AccountCreatedDeletedPage(driver);
		Assert.assertTrue(acdp.isAccountCreatedMessageDisplayed(), "Account is not created Successfully");
		acdp.clickContinueButton();
		
		Assert.assertTrue(hp.isLoggedInAsUserVisible(), "User is not logged in successfully");
		hp.clickLogoutAccountButton();
	}
	
	@Test(dataProvider="validLoginCredentials",dataProviderClass=DataProviders.class,priority=1)
	public void signInUserTest(String email, String pass) {
		
		SignupLoginPage slp = new SignupLoginPage(driver);
		Assert.assertTrue(slp.isLoginVisible(),"Log In Page is not visible");
		slp.enterLoginDetails(email, pass);
		
		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.isLoggedInAsUserVisible(), "User is not logged in successfully");
		hp.clickLogoutAccountButton();
	}
	
	@Test(dataProvider = "registerUsingExistingUser",dataProviderClass = DataProviders.class,  priority=2)
	public void registerUsingExistingMailTest(String name, String email) {
		
		SignupLoginPage slp = new SignupLoginPage(driver);
		Assert.assertTrue(slp.isSignupHeadingVisible(),"Sign Up Page is not visible");
		slp.enterSignUpDetails(name, email);
		Assert.assertTrue(slp.isEmailAlreadyExistsMessageVisible(),"emailexists message is not visible");
	}
	
	@Test(dataProvider="validLoginCredentials",dataProviderClass=DataProviders.class,priority=3)
	public void deleteAccountTest(String email, String pass) {
		
		SignupLoginPage slp = new SignupLoginPage(driver);
		Assert.assertTrue(slp.isLoginVisible(),"Log In Page is not visible");
		slp.enterLoginDetails(email, pass);
		
		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.isLoggedInAsUserVisible(), "User is not logged in successfully");
		
		hp.clickDeleteAccountButton();
			
		AccountCreatedDeletedPage acdp = new AccountCreatedDeletedPage(driver);
		Assert.assertTrue(acdp.isAccountDeletedMessageDisplayed(),"Account is not deleted");
		acdp.clickContinueButton();
	}
	
	
	@Test(dataProvider="invalidLoginCredentials",dataProviderClass=DataProviders.class,priority=4)
	public void loginUsingInvalidValueTest(String email, String pass) {
		
		HomePage hp = new HomePage(driver);
		hp.clickSignupLoginButton();
		
		SignupLoginPage slp = new SignupLoginPage(driver);
		Assert.assertTrue(slp.isLoginVisible(),"Log In Page is not visible");
		slp.enterLoginDetails(email, pass);
		Assert.assertTrue(slp.isInvalidLoginMessageVisible(), "User is able to login using false credentials");
	}
	
	
	//@Test(priority = 10)
	public void homepageValidation(){
		
		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.isHomePageVisible(),"Home page is not visible");
	}

}
