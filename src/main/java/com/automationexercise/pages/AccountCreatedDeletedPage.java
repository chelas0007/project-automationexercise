package com.automationexercise.pages;

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
	
	@FindBy(xpath="//b[normalize-space()='Account Created!']") private WebElement accounttCreatedMessage;
	@FindBy(xpath="//a[@class='btn btn-primary']") private WebElement continueButton;
	@FindBy(xpath="//b[normalize-space()='Account Deleted!']") private WebElement accounttDeletedMessage;
	
	public boolean isAccountCreatedMessageDisplayed() {
		 return accounttCreatedMessage.isDisplayed();
	}
	
	public void clickContinueButton() {
		continueButton.click();
	}
	
	public boolean isAccountDeletedMessageDisplayed() {
		return accounttDeletedMessage.isDisplayed();
	}
	
}
