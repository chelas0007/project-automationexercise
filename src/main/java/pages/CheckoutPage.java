package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.UtilityClass;

public class CheckoutPage {
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@id='address_invoice']") WebElement deladdress;
	@FindBy(xpath="//ul[@id='address_delivery']") WebElement billingaddress;
	@FindBy(xpath="//tr[@id='product-3']") WebElement productvisible;
	@FindBy(xpath="//textarea[@name='message']") WebElement commentbox;
	@FindBy(xpath="//a[normalize-space()='Place Order']") WebElement placeorderbtn;
	
	public boolean deladdresspresent() {
		UtilityClass.scroll(driver, deladdress);
		return deladdress.isDisplayed();
	}
	
	public boolean billingaddress() {
		UtilityClass.scroll(driver, billingaddress);
		return billingaddress.isDisplayed();
	}

	public boolean productdetails() {
		UtilityClass.scroll(driver, productvisible);
		return productvisible.isDisplayed();
	}
	
	public void placingorder(String message) {
		UtilityClass.scroll(driver, commentbox);
		commentbox.sendKeys(message);
		placeorderbtn.click();
		
	}
	

}
