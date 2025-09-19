package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupTeardown;
import dataprovider.DataProviderClass;
import pages.AccountCreatedDeletedPage;
import pages.HomePage;
import pages.SignupLoginPage;

public class LoginLogoutUser extends SetupTeardown {
	
	@Test(dataProvider="validLoginCredentials",dataProviderClass=DataProviderClass.class,priority=0)
	public void loginusingvalidcredentials(String email, String password) {
		
		HomePage hp = new HomePage(driver);
		SignupLoginPage slp = new SignupLoginPage(driver);
		//AccountCreatedDeletedPage acdp = new AccountCreatedDeletedPage(driver);
		
		//Assert.assertTrue(hp.ishomepagevisible(),"Home page is not visible");
		hp.signuploginbutton();
		
		Assert.assertTrue(slp.isloginvisible(),"Login is not visible");
		slp.loggingin(email, password);	
		
		Assert.assertTrue(hp.loggedinasuservisible(),"Login is failed");
		//hp.deleteaccount();
		
		//Assert.assertTrue(acdp.accountdeletedmessageverify(),"account is not deleted");
		//acdp.continuebtn();
		
		
	}
	
	//@Test(dataProvider="invalidLoginCredentials",dataProviderClass=DataProviderClass.class,priority=1)
	public void loginusinginvalidcredentials(String email, String password) {
		
		HomePage hp = new HomePage(driver);
		SignupLoginPage slp = new SignupLoginPage(driver);
		
		Assert.assertTrue(hp.ishomepagevisible(),"Home page is not visible");
		hp.signuploginbutton();
		
		Assert.assertTrue(slp.isloginvisible(),"Login is not visible");
		slp.loggingin(email, password);	
		Assert.assertTrue(slp.logininvalidmessage(),"Invalid Credentials message not received");
		slp.homebuttonclick();
		
	}
	
	//@Test(priority=2)
	public void logout() {
		HomePage hp = new HomePage(driver);
		SignupLoginPage slp = new SignupLoginPage(driver);
		
		hp.logoutaccount();
		Assert.assertTrue(slp.isloginvisible(),"Login is not visible");
	}
	
	
	
	
}
