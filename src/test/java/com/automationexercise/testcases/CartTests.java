package com.automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.base.Base;
import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailsPage;
import com.automationexercise.pages.ProductsPage;

public class CartTests extends Base {
	
	//@Test
	public void addProducts() {
		
		HomePage hp = new HomePage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CartPage cp= new CartPage(driver);
		
		Assert.assertTrue(hp.isHomePageVisible(), "Home Page is not visible");
		hp.clickProductsButton();
		
		int str1 = pp.product3PriceComparison();
		pp.addProductsToCart();
		
		Assert.assertTrue(cp.hasExpectedProductInCart(), "Products are not added to cart properly");
		int str2 = cp.product3PriceCompare();
		Assert.assertEquals(str1, str2,"Product price vary from product page to cart page");
		Assert.assertTrue(cp.productsTotalPriceCheck(),"Product Total price is not calculated properly");
		
	}
	
	//@Test
	public void productquantityTest() {
		
		HomePage hp = new HomePage(driver);
		ProductDetailsPage pdp = new ProductDetailsPage(driver);
		CartPage cp = new CartPage(driver);
		
		Assert.assertTrue(hp.isHomePageVisible(), "Home Page is not visible");
		hp.viewProduct5();
		
		String str= driver.getCurrentUrl();
		Assert.assertTrue(str.contains("/product_details/5"),"url is not loaded properly");
		Assert.assertTrue(pdp.isProductVisible(),"Product is not visible");
		pdp.addProductQuantity();
		
		Assert.assertTrue(cp.quantityCheck(),"Quantity is not displayed correctly");
	}
	
	@Test
	public void removeProducts() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		CartPage cp = new CartPage(driver);
		
		Assert.assertTrue(hp.isHomePageVisible(), "Home Page is not visible");
		hp.addToCartProduct5();
		
		Assert.assertTrue(cp.isCartVisible(), "Cart Page is not visible");
		cp.removeProductFromCart();
		Thread.sleep(5000);
		Assert.assertTrue(cp.isCartEmpty(), "Product is not removed");

	}

}
