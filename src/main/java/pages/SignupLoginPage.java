package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupLoginPage {

	WebDriver driver;
	
	public SignupLoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[normalize-space()='New User Signup!']")WebElement SignupHeading;
	@FindBy(xpath="//input[@placeholder='Name']")WebElement SignupName ;
	@FindBy(xpath="//input[@data-qa='signup-email']")WebElement Signupemail;
	@FindBy(xpath="//button[normalize-space()='Signup']") WebElement Signupbutton;
	@FindBy(xpath="//h2[normalize-space()='Login to your account']")  WebElement Loginheading;
	@FindBy(xpath="//input[@data-qa='login-email']") WebElement loginemail;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement loginpassword;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement loginbutton;
	@FindBy(xpath="//p[normalize-space()='Your email or password is incorrect!']") WebElement invalidcredentialsmessage;
	@FindBy(xpath="//a[normalize-space()='Home']") WebElement Homebutton;
	@FindBy(xpath="//p[normalize-space()='Email Address already exist!']")WebElement emailexists;
	
	public boolean issignupvisible() {
		return SignupHeading.isDisplayed();
	}
	
	public void signingin(String name, String email) {
		SignupName.sendKeys(name);
		Signupemail.sendKeys(email);
		Signupbutton.click();
	}
	public boolean isloginvisible() {
		return Loginheading.isDisplayed();
	}
	
	public void loggingin(String email, String password) {
		loginemail.sendKeys(email);
		loginpassword.sendKeys(password);
		loginbutton.click();
	}
	
	public boolean logininvalidmessage() {
		return invalidcredentialsmessage.isDisplayed();
	}
	
	public void homebuttonclick() {
		Homebutton.click();
	}
	
	public boolean isemailalreadyexists() {
		return emailexists.isDisplayed();
	}
		
}
