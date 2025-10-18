package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationexercise.utils.ScrollNWaitUtils;

public class AccountCreationPage {
	
	private WebDriver driver;
	
	public AccountCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//b[normalize-space()='Enter Account Information']") private WebElement enterAccountInfoMessage;
	@FindBy(xpath="//div[@id='uniform-id_gender1']") private WebElement genderSelectionRadioMr;
	@FindBy(xpath="//input[@id='password']") private WebElement passwordInputField;
	@FindBy(xpath="//select[@id='days']") private WebElement dayDropDown;
	@FindBy(xpath="//select[@id='months']") private WebElement monthDropDown;
	@FindBy(xpath="//select[@id='years']") private WebElement yearDropDown;
	@FindBy(xpath="//input[@id='newsletter']") private WebElement newsLetterCheckBox;
	@FindBy(xpath="//input[@id='optin']") private WebElement optInCheckBox;
	@FindBy(xpath="//input[@id='first_name']") private WebElement firstNameInputField;
	@FindBy(xpath="//input[@id='last_name']") private WebElement lastNameInputField;
	@FindBy(xpath="//input[@id='company']") private WebElement compNameInputField;
	@FindBy(xpath="//input[@id='address1']") private WebElement address1InputField;
	@FindBy(xpath="//input[@id='address2']") private WebElement address2InputField;
	@FindBy(xpath="//input[@id='state']") private WebElement stateInputFiled;
	@FindBy(xpath="//input[@id='city']") private WebElement cityInputField;
	@FindBy(xpath="//input[@id='zipcode']") private WebElement zipCodeInputField;
	@FindBy(xpath="//input[@id='mobile_number']") private WebElement mobileNoInputField;
	@FindBy(xpath="//select[@id='country']") private WebElement countryDropDown;
	@FindBy(xpath="//button[normalize-space()='Create Account']") private WebElement createAccountButton;
	
	public boolean isEnterAccountInfoMessageVisible() {
		return enterAccountInfoMessage.isDisplayed();
		
	}
	
	public void fillAccountDetails(String pass,String fname,String lname,String cname,
			String addr1, String addr2,String state, String city,String pin,String mobile) {
		
		genderSelectionRadioMr.click();
		passwordInputField.sendKeys(pass);		
		ScrollNWaitUtils.scroll(driver, newsLetterCheckBox);
		newsLetterCheckBox.click();
		optInCheckBox.click();
		firstNameInputField.sendKeys(fname);
		lastNameInputField.sendKeys(lname);
		compNameInputField.sendKeys(cname);
		ScrollNWaitUtils.scroll(driver, address1InputField);
		address1InputField.sendKeys(addr1);
		address2InputField.sendKeys(addr2);
		stateInputFiled.sendKeys(state);
		cityInputField.sendKeys(city);
		ScrollNWaitUtils.scroll(driver, zipCodeInputField);
		zipCodeInputField.sendKeys(pin);
		mobileNoInputField.sendKeys(mobile);	
	}
	
	public void selectDropDownValues(String day, String month,String year,String country) {
		
		ScrollNWaitUtils.scroll(driver, dayDropDown);
		new Select(dayDropDown).selectByValue(day);
		new Select(monthDropDown).selectByVisibleText(month);
		new Select(yearDropDown).selectByValue(year);
		ScrollNWaitUtils.scroll(driver, countryDropDown);
		new Select(countryDropDown).selectByValue(country);
		
	}
	
	public void clickCreateAccountButton() {
		ScrollNWaitUtils.scroll(driver, createAccountButton);
		createAccountButton.click();
	}
	
}
