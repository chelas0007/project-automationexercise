package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage {

	private WebDriver driver;
	
	public TestCasesPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//b[normalize-space()='Test Cases']")private WebElement testcaseheading;
	
	public boolean isTestcaseTitleVisible() {
		return testcaseheading.isDisplayed();
	}
	
}
