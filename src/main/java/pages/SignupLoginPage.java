package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupLoginPage {

	private WebDriver driver;
	
	public SignupLoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[normalize-space()='New User Signup!']")private WebElement SignupHeading;
	@FindBy(xpath="//input[@placeholder='Name']")private WebElement SignupName ;
	@FindBy(xpath="//input[@data-qa='signup-email']")private WebElement Signupemail;
	@FindBy(xpath="//button[normalize-space()='Signup']") private WebElement Signupbutton;
	@FindBy(xpath="//h2[normalize-space()='Login to your account']")  private WebElement Loginheading;
	@FindBy(xpath="//input[@data-qa='login-email']") private WebElement loginemail;
	@FindBy(xpath="//input[@placeholder='Password']") private WebElement loginpassword;
	@FindBy(xpath="//button[normalize-space()='Login']") private WebElement loginbutton;
	@FindBy(xpath="//p[normalize-space()='Your email or password is incorrect!']")private WebElement invalidcredentialsmessage;
	@FindBy(xpath="//a[normalize-space()='Home']") private WebElement Homebutton;
	@FindBy(xpath="//p[normalize-space()='Email Address already exist!']")private WebElement emailexists;
	
	public boolean isSignupVisible() {
		return SignupHeading.isDisplayed();
	}
	
	public void enterSignInDetails(String name, String email) {
		SignupName.sendKeys(name);
		Signupemail.sendKeys(email);
		Signupbutton.click();
	}
	public boolean isLoginVisible() {
		return Loginheading.isDisplayed();
	}
	
	public void enterLoginDetails(String email, String password) {
		loginemail.sendKeys(email);
		loginpassword.sendKeys(password);
		loginbutton.click();
	}
	
	public boolean isInvalidLoginMessageVisible() {
		return invalidcredentialsmessage.isDisplayed();
	}
	
	public void clickHomeButton() {
		Homebutton.click();
	}
	
	public boolean isEmailAlreadyExistsMessageVisible() {
		return emailexists.isDisplayed();
	}
		
}
