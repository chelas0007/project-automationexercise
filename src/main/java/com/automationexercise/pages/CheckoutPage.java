package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationexercise.utils.ScrollNWaitUtils;

public class CheckoutPage {
	
	private WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@id='address_invoice']") private WebElement deladdress;
	@FindBy(xpath="//ul[@id='address_delivery']")private WebElement billingaddress;
	@FindBy(xpath="//tr[@id='product-3']") private WebElement productvisible;
	@FindBy(xpath="//textarea[@name='message']") private WebElement commentbox;
	@FindBy(xpath="//a[normalize-space()='Place Order']") private WebElement placeorderbtn;
	
	public boolean isDeliveryAddressVisible() {
		ScrollNWaitUtils.scroll(driver, deladdress);
		return deladdress.isDisplayed();
	}
	
	public boolean isBillingAddressVisible() {
		ScrollNWaitUtils.scroll(driver, billingaddress);
		return billingaddress.isDisplayed();
	}

	public boolean areProductDetailsVisible() {
		ScrollNWaitUtils.scroll(driver, productvisible);
		return productvisible.isDisplayed();
	}
	
	public void placeOrder(String message) {
		ScrollNWaitUtils.scroll(driver, commentbox);
		commentbox.sendKeys(message);
		placeorderbtn.click();
		
	}

}
