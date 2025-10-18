package com.automationexercise.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrandPage {
	private WebDriver driver;
	
	public BrandPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[@class='title text-center']") private WebElement hmBrandheading;
	@FindBy(xpath="//a[@href='/brand_products/Mast & Harbour']") private WebElement mhBrandheading;
	@FindBy(xpath="//div[@class='col-sm-4']") private List<WebElement> Products;
	
	
	public boolean isHMBrandProductsVisible() {
		return hmBrandheading.isDisplayed();
	}
	
	public boolean isMHBrandProductsVisible() {
		return mhBrandheading.isDisplayed();
	}
	
	public boolean areProductsPresent() {
		return !Products.isEmpty();	
	}

}
