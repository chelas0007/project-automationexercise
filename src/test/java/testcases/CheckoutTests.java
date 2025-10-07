package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupTeardown;
import pages.AccountCreatedDeletedPage;
import pages.AccountCreationPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.OrderPlacedPage;
import pages.PaymentPage;
import pages.ProductsPage;
import pages.SignupLoginPage;
import utils.DataProviders;

public class CheckoutTests extends SetupTeardown {
	
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
		
		Assert.assertTrue(hp.isHomePageVisible(),"Homepage is not visible");
		hp.clickProductsButton();
		
		pp.addProductsToCart();
		
		Assert.assertTrue(cp.isCartEmpty(),"Cart page is not visible");
		cp.clickCheckoutButton();
		cp.clickCheckoutAndRegister();
		
		slp.enterSignInDetails(fname, email);
		acp.fillAccountDetails(password, fname, lname, company, addr1, addr2, city, state, pin, mob);
		acp.selectDropDownValue(date, month, year, country);
		acp.clickCreateAccountButton();
		
		Assert.assertTrue(acdp.isAccountCreatedMessageDisplayed(),"Account is not created successfully");
		acdp.clickContinueButton();
		
		Assert.assertTrue(hp.isLoggedInAsUserVisible(), "Login failed");
		hp.clickCartbutton();
		
		cp.clickCheckoutButton();
		Assert.assertTrue(ck.isDeliveryAddressVisible(), "Delivery address is not displayed");
		Assert.assertTrue(ck.isBillingAddressVisible(), "Billing address is not displayed");
		Assert.assertTrue(ck.areProductDetailsVisible(), "Product address is not displayed");
		ck.placeOrder(message);
	}
	
	@Test(dataProvider="carddetails",dataProviderClass=DataProviders.class,priority=2)
	public void payment(String cname, String cnum, String ccvv, String cexpm, String cexpy) {
		PaymentPage pp = new PaymentPage(driver);
		OrderPlacedPage opp = new OrderPlacedPage(driver);
		AccountCreatedDeletedPage acdp = new AccountCreatedDeletedPage(driver);
		
		pp.enterCardDetails(cname, cnum, ccvv, cexpm, cexpy);
		Assert.assertTrue(opp.isOrderPlacedSuccessfully(), "Order is not success");
		opp.clickDeleteAccountButton();
		Assert.assertTrue(acdp.isAccountDeletedMessageDisplayed(), "Account is not deleted");
		acdp.clickContinueButton();
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
		
		Assert.assertTrue(hp.isHomePageVisible(),"Home Page is not visible");
		hp.clickSignupLoginButton();
		
		slp.enterSignInDetails(fname, email);
		
		acp.fillAccountDetails(password, fname, lname, cname, addr1, addr2, city, state, pin, mob);
		acp.selectDropDownValue(date, month, year, country);
		acp.clickCreateAccountButton();
		
		Assert.assertTrue(acdp.isAccountCreatedMessageDisplayed(),"Account is not created successfully");
		acdp.clickContinueButton();
		
		Assert.assertTrue(hp.isLoggedInAsUserVisible(),"Login is not successful");
		hp.addToCartProduct5();
		
		Assert.assertTrue(cp.isCartEmpty(),"Cart page is not visible");
		cp.clickCheckoutButton();
		
		Assert.assertTrue(c.isDeliveryAddressVisible(), "Delivery address is not present");		
		Assert.assertTrue(c.isBillingAddressVisible(), "Billing address is not present");		
		Assert.assertTrue(c.areProductDetailsVisible(), "Product is not visible in the cart");
		c.placeOrder(message);
	}
	
	@Test(dataProvider="accountdetails",dataProviderClass=DataProviders.class,priority=1)
	public void loginbeforecheckout(String email, String password,String date, String month, String year,String fname, String lname, String cname,
			String addr1, String addr2, String city, String state, String pin,String mob, String country, String message) {
		HomePage hp = new HomePage(driver);
		SignupLoginPage slp = new SignupLoginPage(driver);
		CartPage cp = new CartPage(driver);
		CheckoutPage c = new CheckoutPage(driver);
		
		Assert.assertTrue(hp.isHomePageVisible(),"Home Page is not visible");
		hp.clickSignupLoginButton();
		
		slp.enterLoginDetails(email, password);
		
		Assert.assertTrue(hp.isLoggedInAsUserVisible(),"Login is not successful");
		hp.addToCartProduct5();
		
		Assert.assertTrue(cp.isCartEmpty(),"Cart page is not visible");
		cp.clickCheckoutButton();
		
		Assert.assertTrue(c.isDeliveryAddressVisible(), "Delivery address is not present");		
		Assert.assertTrue(c.isBillingAddressVisible(), "Billing address is not present");		
		Assert.assertTrue(c.areProductDetailsVisible(), "Product is not visible in the cart");
		c.placeOrder(message);
	}

}
