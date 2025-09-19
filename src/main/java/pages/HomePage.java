package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.UtilityClass;


public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		
	}
	
	@FindBy(xpath="//img[@alt='Website for automation practice']") WebElement titleimage;
	@FindBy(xpath="//a[normalize-space()='Signup / Login']") WebElement signuploginbutton;
	@FindBy(xpath="//li/a[contains(text(),\"Logged in as\")]") WebElement loggedinasuser;
	@FindBy(xpath="//a[normalize-space()='Delete Account']") WebElement deleteaccount;
	@FindBy(xpath="//a[normalize-space()='Logout']") WebElement logoutbutton;
	@FindBy(xpath="//a[normalize-space()='Contact us']") WebElement ContactUsForm;
	@FindBy(xpath="//a[contains(text(),'Test Cases')]") WebElement TestCases;
	@FindBy(xpath="//a[@href='/products']")WebElement Products;
	@FindBy(xpath="//input[@id='susbscribe_email']")WebElement subcribetext;
	@FindBy(xpath="//i[@class='fa fa-arrow-circle-o-right']")WebElement sunscribebutton;
	@FindBy(xpath="//div[@id='success-subscribe']")WebElement subscribedmessage;
	@FindBy(xpath="//a[normalize-space()='Cart']")WebElement cartbutton;
	@FindBy(xpath="//div//a[@href='/product_details/5']") WebElement product5view;
	@FindBy(xpath="(//div[@class='product-image-wrapper'])[3]") WebElement product5hover;
	@FindBy(xpath="(//div[@class='product-overlay'])[3]//a[@class='btn btn-default add-to-cart']") WebElement product3addtocart;
	@FindBy(xpath="//u[normalize-space()='View Cart']") WebElement viewcart;
	@FindBy(xpath="//h2[normalize-space()='Category']") WebElement Category;
	@FindBy(xpath="//a[normalize-space()='Women']") WebElement womencategory;
	@FindBy(xpath="//div[@id='Women']//a[contains(text(),'Dress')]") WebElement dressinwomencategory;
	//@FindBy(xpath="//u[normalize-space()='View Cart']") WebElement viewcart;
	//@FindBy(xpath="//u[normalize-space()='View Cart']") WebElement viewcart;
	
	
	public boolean ishomepagevisible() {
		return titleimage.isDisplayed();
	}
	
	public void signuploginbutton() {
		signuploginbutton.click();
	}
	
	public boolean loggedinasuservisible() {
		return loggedinasuser.isDisplayed();
	}
	
	public void deleteaccount() {
		deleteaccount.click();
	}
	
	public void logoutaccount() {
		logoutbutton.click();
	}
	
	public void contactusform() {
		ContactUsForm.click();
	}
	
	public void testcases() {
		TestCases.click();
	}
	
	public void productsicon() {
		Products.click();
	}
	
	public void subscriptioncheck(String email) {
		UtilityClass.scrollbottom(driver);
		subcribetext.sendKeys(email);
		sunscribebutton.click();
	}
	
	public boolean issubcribedmessagevisisble() {
		return subscribedmessage.isDisplayed();
	}
	
	public void cartbuttonnavigate() {
		cartbutton.click();
	}
	
	public void viewproduct5() {
		UtilityClass.scroll(driver, product5view);
		product5view.click();
	}
	
	public void addtocartproduct5() {
		UtilityClass.scroll(driver, product5hover);
		Actions a = new Actions(driver);
		a.moveToElement(product5hover).build().perform();
		UtilityClass.waituntilclickable(driver, product3addtocart);
		product3addtocart.click();
		UtilityClass.waituntilclickable(driver, viewcart);
		viewcart.click();
	}
	
	public boolean iscategoryvisible() {
		UtilityClass.scroll(driver, Category);
		return Category.isDisplayed();
	}
	
	public void choosecategory() {
		womencategory.click();
		UtilityClass.waituntilclickable(driver, dressinwomencategory);
		dressinwomencategory.click();
	}
	

}
