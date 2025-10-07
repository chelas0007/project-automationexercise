package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupTeardown;
import pages.AccountCreatedDeletedPage;
import pages.AccountCreationPage;
import pages.HomePage;
import pages.SignupLoginPage;
import utils.DataProviders;

public class RegisterNLoginTests extends SetupTeardown {
	
	
	@Test(priority = 0)
	public void homepagevalidation(){
		HomePage hp = new HomePage(driver);
		Boolean b = hp.isHomePageVisible();
		Assert.assertTrue(b,"Home page is not visible");
		hp.clickSignupLoginButton();
	}
	
	//@Test(dataProvider="loginsignup",dataProviderClass=DataProviderClass.class,priority = 1)
	public void loginpagevalidation(String name, String email) {
		SignupLoginPage lp = new SignupLoginPage(driver);
		Assert.assertTrue(lp.isSignupVisible(),"Signup is not visible");
		lp.enterSignInDetails(name,email);
	}
	
	//@Test(priority = 2, dataProvider ="accountdetails", dataProviderClass=DataProviderClass.class)
	public void accountcreationpagevalidation(String pass,String day,String month,String year, String fname,String lname,String cname,
			String addr1, String addr2,String state, String city,String pin,String mobile,String country) {
		AccountCreationPage ac = new AccountCreationPage(driver);
		Assert.assertTrue(ac.isEnterAccountInfoMessageVisible(), "Enter Account info meassage is not dispalyed");
		ac.fillAccountDetails(pass,fname,lname,cname,addr1,addr2,state,city,pin,mobile);
		ac.selectDropDownValue(day, month, year,country);
		ac.clickCreateAccountButton();
		
	}
	
	//@Test(priority=3)
	public void accountcreatedsuccessfully() {
		AccountCreatedDeletedPage acp = new AccountCreatedDeletedPage(driver);
		Assert.assertTrue(acp.isAccountCreatedMessageDisplayed(),"account not created successfully");
		acp.clickContinueButton();
		
	}
	
	//@Test(priority=4)
	 public void loginedinverification() {
		HomePage hm = new HomePage(driver);
		Assert.assertTrue(hm.isLoggedInAsUserVisible(),"user not logged in successfully");
	}
	
	//@Test(priority=5)
	public void deleteaccount() {
		HomePage hm = new HomePage(driver);
		AccountCreatedDeletedPage acp = new AccountCreatedDeletedPage(driver);
		hm.clickDeleteAccountButton();
		Assert.assertTrue(acp.isAccountDeletedMessageDisplayed(),"Account is not deleted");
	}
		
	@Test(dataProvider = "loginsignup",dataProviderClass = DataProviders.class,  priority=2)
	public void registerusingexistingmail(String name, String email) {
		SignupLoginPage slp = new SignupLoginPage(driver);
		slp.enterSignInDetails(name, email);
		Assert.assertTrue(slp.isEmailAlreadyExistsMessageVisible(),"emailexists message is not visible");
	}

}
