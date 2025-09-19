package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupTeardown;
import pages.CategoryPage;
import pages.HomePage;

public class CategoryTesting extends SetupTeardown{
	
	@Test
	public void category() {
		HomePage hp = new HomePage(driver);
		CategoryPage cp =new CategoryPage(driver);
		
		Assert.assertTrue(hp.iscategoryvisible(), "Category is not visible");
		hp.choosecategory();
		
		Assert.assertTrue(cp.categorypagevaliadtion(), "Woman CategoryPage is not visible");
		cp.menselection();
		
		Assert.assertTrue(cp.mencategorypagevaliadtion(), "Men CategoryPage is not visible");
		
	}

}
