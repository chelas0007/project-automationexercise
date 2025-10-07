package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupTeardown;
import pages.HomePage;
import pages.ProductsPage;
import utils.DataProviders;

public class ProductTests extends SetupTeardown {

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
