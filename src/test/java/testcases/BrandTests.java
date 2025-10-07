package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupTeardown;
import pages.BrandPage;
import pages.HomePage;
import pages.ProductsPage;

public class BrandTests extends SetupTeardown {
	
	@Test
	public void validateBrands() {
		HomePage hp = new HomePage(driver);
		ProductsPage pp = new ProductsPage(driver);
		BrandPage bp = new BrandPage(driver);
		
		hp.clickProductsButton();
		
		Assert.assertTrue(pp.isBrandVisible(),"Brand is not visible");
		pp.isBrandVisible();
		Assert.assertTrue(bp.isHMBrandProductsVisible(),"HM Brand page is not visible");
		Assert.assertTrue(bp.areProductsPresent(),"HM Brand products are not visible");
		pp.selectMHbrand();
		Assert.assertTrue(bp.isMHBrandProductsVisible(),"MH Brand page is not visible");
		Assert.assertTrue(bp.areProductsPresent(),"MH Brand products are not visible");	
	}

}
