package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupTeardown;
import dataprovider.DataProviderClass;
import pages.AccountCreatedDeletedPage;
import pages.AccountCreationPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.OrderPlacedPage;
import pages.PaymentPage;
import pages.ProductsPage;
import pages.SignupLoginPage;

public class CheckoutTesting extends SetupTeardown {
	
	//@Test(dataProvider="accountdetails", dataProviderClass=DataProviderClass.class,priority=1)
	public void registerWhileCheckout(String email, String password, String date, String month, String year, String fname,String lname,
			 String company, String addr1, String addr2, String city, String state, String pin, String mob, String country, String message) {
		HomePage hp = new HomePage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);
		SignupLoginPage slp = new SignupLoginPage(driver);
		AccountCreationPage acp = new AccountCreationPage(driver);
		AccountCreatedDeletedPage acdp = new AccountCreatedDeletedPage(driver);
		CheckoutPage ck = new CheckoutPage(driver);
		
		Assert.assertTrue(hp.ishomepagevisible(),"Homepage is not visible");
		hp.productsicon();
		
		pp.productaddition();
		
		Assert.assertTrue(cp.iscartvisible(),"Cart page is not visible");
		cp.checkout();
		cp.checkoutandregister();
		
		slp.signingin(fname, email);
		acp.enterngvalue(password, fname, lname, company, addr1, addr2, city, state, pin, mob);
		acp.dpselection(date, month, year, country);
		acp.clickbutton();
		
		Assert.assertTrue(acdp.accountcreatedmessageverify(),"Account is not created successfully");
		acdp.continuebtn();
		
		Assert.assertTrue(hp.loggedinasuservisible(), "Login failed");
		hp.cartbuttonnavigate();
		
		cp.checkout();
		Assert.assertTrue(ck.deladdresspresent(), "Delivery address is not displayed");
		Assert.assertTrue(ck.billingaddress(), "Billing address is not displayed");
		Assert.assertTrue(ck.productdetails(), "Product address is not displayed");
		ck.placingorder(message);
	}
	
	@Test(dataProvider="carddetails",dataProviderClass=DataProviderClass.class,priority=2)
	public void payment(String cname, String cnum, String ccvv, String cexpm, String cexpy) {
		PaymentPage pp = new PaymentPage(driver);
		OrderPlacedPage opp = new OrderPlacedPage(driver);
		AccountCreatedDeletedPage acdp = new AccountCreatedDeletedPage(driver);
		
		pp.entercarddetails(cname, cnum, ccvv, cexpm, cexpy);
		Assert.assertTrue(opp.isordersuccess(), "Order is not success");
		opp.deleteaccount();
		Assert.assertTrue(acdp.accountdeletedmessageverify(), "Account is not deleted");
		acdp.continuebtn();
	}
	
	
	//@Test(dataProvider="accountdetails",dataProviderClass=DataProviderClass.class,priority=1)
	public void registerBeforeCheckout(String email, String password,String date, String month, String year,String fname, String lname, String cname,
			String addr1, String addr2, String city, String state, String pin,String mob, String country, String message) {
		HomePage hp = new HomePage(driver);
		SignupLoginPage slp = new SignupLoginPage(driver);
		AccountCreationPage acp = new AccountCreationPage(driver);
		AccountCreatedDeletedPage acdp = new AccountCreatedDeletedPage(driver);
		CartPage cp = new CartPage(driver);
		CheckoutPage c = new CheckoutPage(driver);
		
		Assert.assertTrue(hp.ishomepagevisible(),"Home Page is not visible");
		hp.signuploginbutton();
		
		slp.signingin(fname, email);
		
		acp.enterngvalue(password, fname, lname, cname, addr1, addr2, city, state, pin, mob);
		acp.dpselection(date, month, year, country);
		acp.clickbutton();
		
		Assert.assertTrue(acdp.accountcreatedmessageverify(),"Account is not created successfully");
		acdp.continuebtn();
		
		Assert.assertTrue(hp.loggedinasuservisible(),"Login is not successful");
		hp.addtocartproduct5();
		
		Assert.assertTrue(cp.iscartvisible(),"Cart page is not visible");
		cp.checkout();
		
		Assert.assertTrue(c.deladdresspresent(), "Delivery address is not present");		
		Assert.assertTrue(c.billingaddress(), "Billing address is not present");		
		Assert.assertTrue(c.productdetails(), "Product is not visible in the cart");
		c.placingorder(message);
	}
	
	@Test(dataProvider="accountdetails",dataProviderClass=DataProviderClass.class,priority=1)
	public void loginbeforecheckout(String email, String password,String date, String month, String year,String fname, String lname, String cname,
			String addr1, String addr2, String city, String state, String pin,String mob, String country, String message) {
		HomePage hp = new HomePage(driver);
		SignupLoginPage slp = new SignupLoginPage(driver);
		CartPage cp = new CartPage(driver);
		CheckoutPage c = new CheckoutPage(driver);
		
		Assert.assertTrue(hp.ishomepagevisible(),"Home Page is not visible");
		hp.signuploginbutton();
		
		slp.loggingin(email, password);
		
		Assert.assertTrue(hp.loggedinasuservisible(),"Login is not successful");
		hp.addtocartproduct5();
		
		Assert.assertTrue(cp.iscartvisible(),"Cart page is not visible");
		cp.checkout();
		
		Assert.assertTrue(c.deladdresspresent(), "Delivery address is not present");		
		Assert.assertTrue(c.billingaddress(), "Billing address is not present");		
		Assert.assertTrue(c.productdetails(), "Product is not visible in the cart");
		c.placingorder(message);
	}

}
