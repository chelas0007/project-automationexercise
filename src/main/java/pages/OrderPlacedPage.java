package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPlacedPage {
	
	WebDriver driver;
	
	public OrderPlacedPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//b[normalize-space()='Order Placed!']") WebElement orderplacedmessage;
	@FindBy(xpath="//a[normalize-space()='Delete Account']") WebElement deleteacctbtn;
	
	public boolean isordersuccess() {
		return orderplacedmessage.isDisplayed();
	}
	
	public void deleteaccount() {
		deleteacctbtn.click();
	}
}
