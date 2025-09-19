package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupTeardown;
import dataprovider.DataProviderClass;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;
import pages.SignupLoginPage;

public class SearchingProducts extends SetupTeardown {
	
	@Test(dataProvider="search products",dataProviderClass=DataProviderClass.class,priority=1)
	public void searchforProducts(String s1) {
		HomePage hp = new HomePage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp = new CartPage(driver);
		
		hp.productsicon();
		
		Assert.assertTrue(pp.allproducttitleisvisible(),"User is not navigated to all Products");
		pp.searchforproducts(s1);
		int i = pp.productscount();
		
		Assert.assertTrue(pp.issearchedproductsheadervisible(),"Searched Products Page is not visible");
		Assert.assertTrue(pp.issearchedproductsvisible(),"Searched Products is not visible");
		pp.addingallsearchedproductstocart();
		
		Assert.assertEquals(i, cp.productsincart(),"Cart size doesnt match with the products that are added");
	}

	@Test(dataProvider="validLoginCredentials",dataProviderClass=DataProviderClass.class,priority=2)
	public void loginusingvalidcredentials(String email, String password) {
		
		HomePage hp = new HomePage(driver);
		SignupLoginPage slp = new SignupLoginPage(driver);
		
		hp.signuploginbutton();
		Assert.assertTrue(slp.isloginvisible(),"Login is not visible");
		slp.loggingin(email, password);	
		
		Assert.assertTrue(hp.loggedinasuservisible(),"Login is failed");
		hp.cartbuttonnavigate();
	}
	
	@Test(priority=3)
	public void cartvaliadtion() {
		CartPage cp = new CartPage(driver);
		
		if(cp.productsincart()==0) 
			Assert.fail();	
	}
}
