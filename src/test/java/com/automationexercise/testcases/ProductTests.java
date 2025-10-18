package com.automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.base.Base;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductsPage;
import com.automationexercise.utils.DataProviders;

public class ProductTests extends Base {

	//@Test
	public void verifyproductdetails() {
		
		HomePage hp = new HomePage(driver);
		ProductsPage pp= new ProductsPage(driver);
		
		Assert.assertTrue(hp.isHomePageVisible(),"Home Page is not visible");
		hp.clickProductsButton();
		
		Assert.assertTrue(pp.areAllProductsTitleVisible(),"All Product title is not visible");
		pp.viewProduct2();
		Assert.assertTrue(pp.isProductNameVisible(),"Product name is not visible");
		Assert.assertTrue(pp.isProductCategoryVisible(),"Product category is not visible");
		Assert.assertTrue(pp.isProductPriceVisible(),"Product price is not visible");
		Assert.assertTrue(pp.isProductAvailabilityVisible(),"Product availability is not visible");
		Assert.assertTrue(pp.isProductConditionVisible(),"Product condition is not visible");
		Assert.assertTrue(pp.isProductBrandVisible(),"Product brand is not visible");
		
	}
	
	@Test(dataProvider="serach products",dataProviderClass=DataProviders.class)
	public void serachproducts(String s1) {
		HomePage hp = new HomePage(driver);
		ProductsPage pp= new ProductsPage(driver);
		
		Assert.assertTrue(hp.isHomePageVisible(),"Home Page is not visible");
		hp.clickProductsButton();
		
		pp.searchProducts(s1);
		Assert.assertTrue(pp.isSearchedProductHeaderVisible(),"searched product header is not visible");
		Assert.assertTrue(pp.areSearchedProductsVisible(),"Not all searched products visible");
	}
	
}
