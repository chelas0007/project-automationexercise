package com.automationexercise.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationexercise.utils.ScrollNWaitUtils;

public class ProductDetailsPage {
	
	private WebDriver driver;
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[normalize-space()='Winter Top']") private WebElement productdetail;
	@FindBy(xpath="//input[@id='quantity']") private WebElement productquantity;
	@FindBy(xpath="//button[normalize-space()='Add to cart']") private WebElement addtocartbtn;
	@FindBy(xpath="//u[normalize-space()='View Cart']") private WebElement viewcartlink;
	
	public boolean isProductVisible() {
		return productdetail.isDisplayed();
	}
	
	public void addProductQuantity() {
		productquantity.sendKeys(Keys.ARROW_UP,Keys.ARROW_UP,Keys.ARROW_UP);
		addtocartbtn.click();
		ScrollNWaitUtils.waitAndClick(driver, viewcartlink);
	}
	
}
