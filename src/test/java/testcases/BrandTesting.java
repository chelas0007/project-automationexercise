package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupTeardown;
import pages.BrandPage;
import pages.HomePage;
import pages.ProductsPage;

public class BrandTesting extends SetupTeardown {
	
	@Test
	public void validateBrands() {
		HomePage hp = new HomePage(driver);
		ProductsPage pp = new ProductsPage(driver);
		BrandPage bp = new BrandPage(driver);
		
		hp.productsicon();
		
		Assert.assertTrue(pp.isbrandvisible(),"Brand is not visible");
		pp.HMbrandselection();
		Assert.assertTrue(bp.isHMbrandproductspresent(),"HM Brand page is not visible");
		Assert.assertFalse(bp.productcount(),"HM Brand products are not visible");
		pp.MHbrandselection();
		Assert.assertTrue(bp.isMHbrandproductspresent(),"MH Brand page is not visible");
		Assert.assertFalse(bp.productcount(),"MH Brand products are not visible");	
	}

}
