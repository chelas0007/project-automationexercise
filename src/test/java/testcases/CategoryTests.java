package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupTeardown;
import pages.CategoryPage;
import pages.HomePage;

public class CategoryTests extends SetupTeardown{
	
	@Test
	public void category() {
		HomePage hp = new HomePage(driver);
		CategoryPage cp =new CategoryPage(driver);
		
		Assert.assertTrue(hp.isCategoryVisible(), "Category is not visible");
		hp.chooseWomenCategory();
		
		Assert.assertTrue(cp.isWomenCategoryPageDisplayed(), "Woman CategoryPage is not visible");
		cp.chooseMenCategory();
		
		Assert.assertTrue(cp.IsMenCategoryPageVisible(), "Men CategoryPage is not visible");
		
	}

}
