package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedDeletedPage {
	
	private WebDriver driver;
	
	public AccountCreatedDeletedPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//b[normalize-space()='Account Created!']") private WebElement acctcreatedmessage;
	@FindBy(xpath="//a[@class='btn btn-primary']") private WebElement continuebutton;
	@FindBy(xpath="//b[normalize-space()='Account Deleted!']") private WebElement acctdeletedmessage;
	
	public boolean isAccountCreatedMessageDisplayed() {
		 return acctcreatedmessage.isDisplayed();
	}
	
	public void clickContinueButton() {
		continuebutton.click();
	}
	
	public boolean isAccountDeletedMessageDisplayed() {
		return acctdeletedmessage.isDisplayed();
	}
	
}
