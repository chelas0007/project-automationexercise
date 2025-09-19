package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupTeardown;
import dataprovider.DataProviderClass;
import pages.HomePage;
import pages.ProductsPage;

public class ProductTesting extends SetupTeardown {

	//@Test
	public void verifyproductdetails() {
		
		HomePage hp = new HomePage(driver);
		ProductsPage pp= new ProductsPage(driver);
		
		Assert.assertTrue(hp.ishomepagevisible(),"Home Page is not visible");
		hp.productsicon();
		
		Assert.assertTrue(pp.allproducttitleisvisible(),"All Product title is not visible");
		pp.viewproduct2();
		Assert.assertTrue(pp.isproductnameviewed(),"Product name is not visible");
		Assert.assertTrue(pp.isproductcategoryviewed(),"Product category is not visible");
		Assert.assertTrue(pp.isproductpriceviewed(),"Product price is not visible");
		Assert.assertTrue(pp.isproductavailabilityviewed(),"Product availability is not visible");
		Assert.assertTrue(pp.isproductconditionviewed(),"Product condition is not visible");
		Assert.assertTrue(pp.isproductbrandviewed(),"Product brand is not visible");
		
	}
	
	@Test(dataProvider="serach products",dataProviderClass=DataProviderClass.class)
	public void serachproducts(String s1) {
		HomePage hp = new HomePage(driver);
		ProductsPage pp= new ProductsPage(driver);
		
		Assert.assertTrue(hp.ishomepagevisible(),"Home Page is not visible");
		hp.productsicon();
		
		pp.searchforproducts(s1);
		Assert.assertTrue(pp.issearchedproductsheadervisible(),"searched product header is not visible");
		Assert.assertTrue(pp.issearchedproductsvisible(),"Not all searched products visible");
	}
	
}
