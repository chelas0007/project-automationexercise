package com.automationexercise.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationexercise.utils.ScrollNWaitUtils;

public class ContactUsFormPage {
	
	private WebDriver driver;
	
	public ContactUsFormPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[normalize-space()='Get In Touch']")private WebElement getInTouchMessage;
	@FindBy(xpath="//input[@placeholder='Name']")private WebElement nameInputField;
	@FindBy(xpath="//input[@placeholder='Email']")private WebElement emailInputField;
	@FindBy(xpath="//input[@placeholder='Subject']")private WebElement subjectInputField;
	@FindBy(xpath="//textarea[@id='message']")private WebElement messageInputField;
	@FindBy(xpath="//input[@name='submit']")private WebElement submitButton;
	@FindBy(xpath="//div[@class='status alert alert-success']")private WebElement successMessage;
	@FindBy(xpath="//span[normalize-space()='Home']")private WebElement homeButton;
	@FindBy(xpath="//input[@name='upload_file']")private WebElement uploadFileButton;
	
	
	
	public boolean isGetInTouchMessageVisible() {
		return getInTouchMessage.isDisplayed();
	}
	
	public boolean isSuccessMessageVisible() {
		return successMessage.isDisplayed();
	}
	
	public void enterContactDetails(String name, String email, String subject, String message) {
		nameInputField.sendKeys(name);
		emailInputField.sendKeys(email);
		ScrollNWaitUtils.scroll(driver, subjectInputField);
		subjectInputField.sendKeys(subject);
		ScrollNWaitUtils.scroll(driver, messageInputField);
		messageInputField.sendKeys(message);
	}
	
	public void uploadFile(String filepath) {
		File f = new File(System.getProperty("user.dir")+filepath);
		ScrollNWaitUtils.scroll(driver, uploadFileButton);
		uploadFileButton.sendKeys(f.getAbsolutePath());
	}
	
	public void clickSubmitButton()  {
		ScrollNWaitUtils.scroll(driver, submitButton);
		submitButton.click();
		ScrollNWaitUtils.waitForAlert(driver);
		driver.switchTo().alert().accept();
	}
	
	public void navigateTohomePage() {
		homeButton.click();
	}
	
}
