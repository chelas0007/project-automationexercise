package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrandPage {
	WebDriver driver;
	
	public BrandPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[@class='title text-center']") WebElement hmBrandheading;
	@FindBy(xpath="//a[@href='/brand_products/Mast & Harbour']") WebElement mhBrandheading;
	@FindBy(xpath="//div[@class='col-sm-4']") List<WebElement> Products;
	
	
	public boolean isHMbrandproductspresent() {
		return hmBrandheading.isDisplayed();
	}
	
	public boolean isMHbrandproductspresent() {
		return mhBrandheading.isDisplayed();
	}
	
	public boolean productcount() {
		return Products.isEmpty();	
	}

}
