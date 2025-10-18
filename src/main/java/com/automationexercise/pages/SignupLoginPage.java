package com.automationexercise.pages;

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
	
	@FindBy(xpath="//h2[normalize-space()='New User Signup!']")private WebElement signUpHeading;
	@FindBy(xpath="//input[@placeholder='Name']")private WebElement signUpNameInputField;
	@FindBy(xpath="//input[@data-qa='signup-email']")private WebElement signUpemailInputField;
	@FindBy(xpath="//button[normalize-space()='Signup']") private WebElement signUpButton;
	@FindBy(xpath="//h2[normalize-space()='Login to your account']")  private WebElement logInHeading;
	@FindBy(xpath="//input[@data-qa='login-email']") private WebElement logInEmailInputField;
	@FindBy(xpath="//input[@placeholder='Password']") private WebElement logInPasswordInputField;
	@FindBy(xpath="//button[normalize-space()='Login']") private WebElement logInButton;
	@FindBy(xpath="//p[normalize-space()='Your email or password is incorrect!']")private WebElement invalidCredentialsMessage;
	@FindBy(xpath="//a[normalize-space()='Home']") private WebElement Homebutton;
	@FindBy(xpath="//p[normalize-space()='Email Address already exist!']")private WebElement emailAlreadyExistsMessage;
	
	public boolean isSignupHeadingVisible() {
		return signUpHeading.isDisplayed();
	}
	
	public void enterSignUpDetails(String name, String email) {
		signUpNameInputField.sendKeys(name);
		signUpemailInputField.sendKeys(email);
		signUpButton.click();
	}
	public boolean isLoginVisible() {
		return logInHeading.isDisplayed();
	}
	
	public void enterLoginDetails(String email, String password) {
		logInEmailInputField.sendKeys(email);
		logInPasswordInputField.sendKeys(password);
		logInButton.click();
	}
	
	public boolean isInvalidLoginMessageVisible() {
		return invalidCredentialsMessage.isDisplayed();
	}
	
	public void clickHomeButton() {
		Homebutton.click();
	}
	
	public boolean isEmailAlreadyExistsMessageVisible() {
		return emailAlreadyExistsMessage.isDisplayed();
	}
		
}
