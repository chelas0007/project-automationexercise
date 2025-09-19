package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedDeletedPage {
	
	WebDriver driver;
	
	public AccountCreatedDeletedPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//b[normalize-space()='Account Created!']") WebElement acctcreatedmessage;
	@FindBy(xpath="//a[@class='btn btn-primary']") WebElement continuebutton;
	@FindBy(xpath="//b[normalize-space()='Account Deleted!']") WebElement acctdeletedmessage;
	
	public boolean accountcreatedmessageverify() {
		 return acctcreatedmessage.isDisplayed();
	}
	
	public void continuebtn() {
		continuebutton.click();
	}
	
	public boolean accountdeletedmessageverify() {
		return acctdeletedmessage.isDisplayed();
	}
	
	
	

}
