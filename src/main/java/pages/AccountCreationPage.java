package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.UtilityClass;

public class AccountCreationPage {
	WebDriver driver;
	
	public AccountCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//b[normalize-space()='Enter Account Information']") WebElement enteraccountinfo;
	@FindBy(xpath="//div[@id='uniform-id_gender1']") WebElement radioMr;
	@FindBy(xpath="//input[@id='password']") WebElement password;
	@FindBy(xpath="//select[@id='days']") WebElement Day;
	@FindBy(xpath="//select[@id='months']") WebElement Month;
	@FindBy(xpath="//select[@id='years']") WebElement Year;
	@FindBy(xpath="//input[@id='newsletter']") WebElement newsletter;
	@FindBy(xpath="//input[@id='optin']") WebElement optin;
	@FindBy(xpath="//input[@id='first_name']") WebElement firstname;
	@FindBy(xpath="//input[@id='last_name']") WebElement lastname;
	@FindBy(xpath="//input[@id='company']") WebElement compname;
	@FindBy(xpath="//input[@id='address1']") WebElement address1;
	@FindBy(xpath="//input[@id='address2']") WebElement address2;
	@FindBy(xpath="//input[@id='state']") WebElement stateinput;
	@FindBy(xpath="//input[@id='city']") WebElement cityinput;
	@FindBy(xpath="//input[@id='zipcode']") WebElement zipcode;
	@FindBy(xpath="//input[@id='mobile_number']") WebElement mobileno;
	@FindBy(xpath="//select[@id='country']") WebElement countryselection;
	@FindBy(xpath="//button[normalize-space()='Create Account']") WebElement createaccountbutton;
	
	public boolean enteraccountinfomessage() {
		return enteraccountinfo.isDisplayed();
		
	}
	
	public void enterngvalue(String pass,String fname,String lname,String cname,
			String addr1, String addr2,String state, String city,String pin,String mobile) {
		
		radioMr.click();
		password.sendKeys(pass);		
		UtilityClass.scroll(driver, newsletter);
		newsletter.click();
		optin.click();
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		compname.sendKeys(cname);
		address1.sendKeys(addr1);
		address2.sendKeys(addr2);
		stateinput.sendKeys(state);
		cityinput.sendKeys(city);
		zipcode.sendKeys(pin);
		mobileno.sendKeys(mobile);	
	}
	
	public void dpselection(String day, String month,String year,String country) {
		
		new Select(Day).selectByValue(day);
		new Select(Month).selectByVisibleText(month);
		new Select(Year).selectByValue(year);
		new Select(countryselection).selectByValue(country);
		
	}
	
	public void clickbutton() {
		UtilityClass.scroll(driver, createaccountbutton);
		createaccountbutton.click();
	}
	
}
