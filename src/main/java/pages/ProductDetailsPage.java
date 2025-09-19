package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.UtilityClass;

public class ProductDetailsPage {
	
	WebDriver driver;
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[normalize-space()='Winter Top']") WebElement productdetail;
	@FindBy(xpath="//input[@id='quantity']") WebElement productquantity;
	@FindBy(xpath="//button[normalize-space()='Add to cart']") WebElement addtocartbtn;
	@FindBy(xpath="//u[normalize-space()='View Cart']") WebElement viewcartlink;
	
	public boolean productisvisible() {
		return productdetail.isDisplayed();
	}
	
	public void addingquantity() {
		productquantity.sendKeys(Keys.ARROW_UP,Keys.ARROW_UP,Keys.ARROW_UP);
		addtocartbtn.click();
		UtilityClass.waituntilclickable(driver, viewcartlink);
		viewcartlink.click();
	}
	
}
