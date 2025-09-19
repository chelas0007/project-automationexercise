package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupTeardown;
import dataprovider.DataProviderClass;
import pages.AccountCreatedDeletedPage;
import pages.AccountCreationPage;
import pages.HomePage;
import pages.SignupLoginPage;

public class RegisterLoginUser extends SetupTeardown {
	
	
	@Test(priority = 0)
	public void homepagevalidation(){
		HomePage hp = new HomePage(driver);
		Boolean b = hp.ishomepagevisible();
		Assert.assertTrue(b,"Home page is not visible");
		hp.signuploginbutton();
	}
	
	//@Test(dataProvider="loginsignup",dataProviderClass=DataProviderClass.class,priority = 1)
	public void loginpagevalidation(String name, String email) {
		SignupLoginPage lp = new SignupLoginPage(driver);
		Assert.assertTrue(lp.issignupvisible(),"Signup is not visible");
		lp.signingin(name,email);
	}
	
	//@Test(priority = 2, dataProvider ="accountdetails", dataProviderClass=DataProviderClass.class)
	public void accountcreationpagevalidation(String pass,String day,String month,String year, String fname,String lname,String cname,
			String addr1, String addr2,String state, String city,String pin,String mobile,String country) {
		AccountCreationPage ac = new AccountCreationPage(driver);
		Assert.assertTrue(ac.enteraccountinfomessage(), "Enter Account info meassage is not dispalyed");
		ac.enterngvalue(pass,fname,lname,cname,addr1,addr2,state,city,pin,mobile);
		ac.dpselection(day, month, year,country);
		ac.clickbutton();
		
	}
	
	//@Test(priority=3)
	public void accountcreatedsuccessfully() {
		AccountCreatedDeletedPage acp = new AccountCreatedDeletedPage(driver);
		Assert.assertTrue(acp.accountcreatedmessageverify(),"account not created successfully");
		acp.continuebtn();
		
	}
	
	//@Test(priority=4)
	 public void loginedinverification() {
		HomePage hm = new HomePage(driver);
		Assert.assertTrue(hm.loggedinasuservisible(),"user not logged in successfully");
	}
	
	//@Test(priority=5)
	public void deleteaccount() {
		HomePage hm = new HomePage(driver);
		AccountCreatedDeletedPage acp = new AccountCreatedDeletedPage(driver);
		hm.deleteaccount();
		Assert.assertTrue(acp.accountdeletedmessageverify(),"Account is not deleted");
	}
		
	@Test(dataProvider = "loginsignup",dataProviderClass = DataProviderClass.class,  priority=2)
	public void registerusingexistingmail(String name, String email) {
		SignupLoginPage slp = new SignupLoginPage(driver);
		slp.signingin(name, email);
		Assert.assertTrue(slp.isemailalreadyexists(),"emailexists message is not visible");
	}

}
