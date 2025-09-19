package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupTeardown;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

public class CartTesting extends SetupTeardown {
	
	//@Test
	public void addProducts() {
		
		HomePage hp = new HomePage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp= new CartPage(driver);
		
		Assert.assertTrue(hp.ishomepagevisible(), "Home Page is not visible");
		hp.productsicon();
		
		int str1 = pp.product3pricecompare();
		pp.productaddition();
		
		Assert.assertTrue(cp.productincartVerify(), "Products are not added to cart properly");
		int str2 = cp.product3pricecompare();
		Assert.assertEquals(str1, str2,"Product price vary from product page to cart page");
		Assert.assertTrue(cp.productstotalpricecheck(),"Product Total price is not calculated properly");
		
	}
	
	//@Test
	public void productquantityTest() {
		
		HomePage hp = new HomePage(driver);
		ProductDetailsPage pdp = new ProductDetailsPage(driver);
		CartPage cp = new CartPage(driver);
		
		Assert.assertTrue(hp.ishomepagevisible(), "Home Page is not visible");
		hp.viewproduct5();
		
		String str= driver.getCurrentUrl();
		Assert.assertTrue(str.contains("/product_details/5"),"url is not loaded properly");
		Assert.assertTrue(pdp.productisvisible(),"Product is not visible");
		pdp.addingquantity();
		
		Assert.assertTrue(cp.quantitycheck(),"Quantity is not displayed correctly");
	}
	
	@Test
	public void removeProducts() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		CartPage cp = new CartPage(driver);
		
		Assert.assertTrue(hp.ishomepagevisible(), "Home Page is not visible");
		hp.addtocartproduct5();
		
		Assert.assertTrue(cp.iscartvisible(), "Cart Page is not visible");
		cp.remove();
		Thread.sleep(5000);
		Assert.assertTrue(cp.isproductremoved(), "Product is not removed");
		
		
		
	}

}
