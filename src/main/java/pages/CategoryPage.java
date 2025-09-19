package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	
	WebDriver driver;
	
	public CategoryPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[contains(text(),'Women -')]")WebElement womancategoryheading;
	@FindBy(xpath="//a[normalize-space()='Men']")WebElement mencategory;
	@FindBy(xpath="//a[normalize-space()='Jeans']")WebElement jeans;
	@FindBy(xpath="//h2[normalize-space()='Men - Jeans Products']")WebElement mencategorypage;
	//@FindBy(xpath="")WebElement wb1;
	
	public boolean categorypagevaliadtion() {
		return womancategoryheading.isDisplayed();
	}
	
	public void menselection() {
		mencategory.click();
		jeans.click();
	}
	
	public boolean mencategorypagevaliadtion() {
		return mencategorypage.isDisplayed();
	}


}
