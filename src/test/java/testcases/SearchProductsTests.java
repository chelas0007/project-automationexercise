package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupTeardown;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;
import pages.SignupLoginPage;
import utils.DataProviders;

public class SearchProductsTests extends SetupTeardown {
	
	@Test(dataProvider="search products",dataProviderClass=DataProviders.class,priority=1)
	public void searchforProducts(String s1) {
		HomePage hp = new HomePage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);
		
		hp.clickProductsButton();
		
		Assert.assertTrue(pp.areAllProductsTitleVisible(),"User is not navigated to all Products");
		pp.searchProducts(s1);
		int i = pp.getProductCount();
		
		Assert.assertTrue(pp.isSearchedProductHeaderVisible(),"Searched Products Page is not visible");
		Assert.assertTrue(pp.areSearchedProductsVisible(),"Searched Products is not visible");
		pp.addingAllSearchedProductsToCart();
		
		Assert.assertEquals(i, cp.getProductsCount(),"Cart size doesnt match with the products that are added");
	}

	@Test(dataProvider="validLoginCredentials",dataProviderClass=DataProviders.class,priority=2)
	public void loginusingvalidcredentials(String email, String password) {
		
		HomePage hp = new HomePage(driver);
		SignupLoginPage slp = new SignupLoginPage(driver);
		
		hp.clickSignupLoginButton();
		Assert.assertTrue(slp.isLoginVisible(),"Login is not visible");
		slp.enterLoginDetails(email, password);	
		
		Assert.assertTrue(hp.isLoggedInAsUserVisible(),"Login is failed");
		hp.clickCartbutton();
	}
	
	@Test(priority=3)
	public void cartvaliadtion() {
		CartPage cp = new CartPage(driver);
		
		if(cp.getProductsCount()==0) 
			Assert.fail();	
	}
}
