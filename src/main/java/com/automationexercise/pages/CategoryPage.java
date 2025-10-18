package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	
	private WebDriver driver;
	
	public CategoryPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[contains(text(),'Women -')]")private WebElement womancategoryheading;
	@FindBy(xpath="//a[normalize-space()='Men']")private WebElement mencategory;
	@FindBy(xpath="//a[normalize-space()='Jeans']")private WebElement jeans;
	@FindBy(xpath="//h2[normalize-space()='Men - Jeans Products']")private WebElement mencategorypage;
	
	public boolean isWomenCategoryPageDisplayed() {
		return womancategoryheading.isDisplayed();
	}
	
	public boolean IsMenCategoryPageVisible() {
		return mencategorypage.isDisplayed();
	}

	public void chooseMenCategory() {
		mencategory.click();
		jeans.click();
	}

}
