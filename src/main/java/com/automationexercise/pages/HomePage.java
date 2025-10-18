package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationexercise.utils.ScrollNWaitUtils;


public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		
	}
	
	@FindBy(xpath="//img[@alt='Website for automation practice']") private WebElement titleimage;
	@FindBy(xpath="//a[normalize-space()='Signup / Login']") private WebElement signupLoginButton;
	@FindBy(xpath="//li/a[contains(text(),\"Logged in as\")]") private WebElement loggedInAsUserIcon;
	@FindBy(xpath="//a[normalize-space()='Delete Account']") private WebElement deleteAccountIcon;
	@FindBy(xpath="//a[normalize-space()='Logout']") private WebElement logOutButton;
	@FindBy(xpath="//a[normalize-space()='Contact us']") private WebElement contactUsFormIcon;
	@FindBy(xpath="//a[contains(text(),'Test Cases')]") private WebElement TestCases;
	@FindBy(xpath="//a[@href='/products']")private WebElement Products;
	@FindBy(xpath="//input[@id='susbscribe_email']")private WebElement subcribetext;
	@FindBy(xpath="//i[@class='fa fa-arrow-circle-o-right']")private WebElement sunscribebutton;
	@FindBy(xpath="//div[@id='success-subscribe']")private WebElement subscribedmessage;
	@FindBy(xpath="//a[normalize-space()='Cart']")private WebElement cartbutton;
	@FindBy(xpath="//div//a[@href='/product_details/5']") private WebElement product5view;
	@FindBy(xpath="(//div[@class='product-image-wrapper'])[3]") private WebElement product5hover;
	@FindBy(xpath="(//div[@class='product-overlay'])[3]//a[@class='btn btn-default add-to-cart']") private WebElement product3addtocart;
	@FindBy(xpath="//u[normalize-space()='View Cart']") private WebElement viewcart;
	@FindBy(xpath="//h2[normalize-space()='Category']") private WebElement Category;
	@FindBy(xpath="//a[normalize-space()='Women']") private WebElement womencategory;
	@FindBy(xpath="//div[@id='Women']//a[contains(text(),'Dress')]") private WebElement dressinwomencategory;
	@FindBy(xpath="//a//i[@class='fa fa-home']") private WebElement homeIcon;	
	
	public boolean isHomePageVisible() {
		return titleimage.isDisplayed();
	}
	
	public void clickSignupLoginButton() {
		signupLoginButton.click();
	}
	
	public boolean isLoggedInAsUserVisible() {
		return loggedInAsUserIcon.isDisplayed();
	}
	
	public void clickDeleteAccountButton() {
		deleteAccountIcon.click();
	}
	
	public void clickLogoutAccountButton() {
		logOutButton.click();
	}
	
	public void clickContactUsFormButton() {
		contactUsFormIcon.click();
	}
	
	public void clickTestcasesButton() {
		TestCases.click();
	}
	
	public void clickProductsButton() {
		Products.click();
	}
	
	public void checkForSubscription(String email) {
		ScrollNWaitUtils.scrollToBottom(driver);
		subcribetext.sendKeys(email);
		sunscribebutton.click();
	}
	
	public boolean isSubcribedMessageVisisble() {
		return subscribedmessage.isDisplayed();
	}
	
	public void clickCartbutton() {
		cartbutton.click();
	}
	
	public void viewProduct5() {
		ScrollNWaitUtils.scroll(driver, product5view);
		product5view.click();
	}
	
	public void addToCartProduct5() {
		ScrollNWaitUtils.scroll(driver, product5hover);
		Actions a = new Actions(driver);
		a.moveToElement(product5hover).build().perform();
		ScrollNWaitUtils.waitAndClick(driver, product3addtocart);
		ScrollNWaitUtils.waitAndClick(driver, viewcart);
	}
	
	public boolean isCategoryVisible() {
		ScrollNWaitUtils.scroll(driver, Category);
		return Category.isDisplayed();
	}
	
	public void chooseWomenCategory() {
		womencategory.click();
		ScrollNWaitUtils.waitAndClick(driver, dressinwomencategory);
	}
	
	public void navigateToHomePage() {
		homeIcon.click();
	}
	

}
