package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.ScrollNWaitUtils;

public class AccountCreationPage {
	
	private WebDriver driver;
	
	public AccountCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//b[normalize-space()='Enter Account Information']") private WebElement enteraccountinfo;
	@FindBy(xpath="//div[@id='uniform-id_gender1']") private WebElement radioMr;
	@FindBy(xpath="//input[@id='password']") private WebElement password;
	@FindBy(xpath="//select[@id='days']") private WebElement Day;
	@FindBy(xpath="//select[@id='months']") private WebElement Month;
	@FindBy(xpath="//select[@id='years']") private WebElement Year;
	@FindBy(xpath="//input[@id='newsletter']") private WebElement newsletter;
	@FindBy(xpath="//input[@id='optin']") private WebElement optin;
	@FindBy(xpath="//input[@id='first_name']") private WebElement firstname;
	@FindBy(xpath="//input[@id='last_name']") private WebElement lastname;
	@FindBy(xpath="//input[@id='company']") private WebElement compname;
	@FindBy(xpath="//input[@id='address1']") private WebElement address1;
	@FindBy(xpath="//input[@id='address2']") private WebElement address2;
	@FindBy(xpath="//input[@id='state']") private WebElement stateinput;
	@FindBy(xpath="//input[@id='city']") private WebElement cityinput;
	@FindBy(xpath="//input[@id='zipcode']") private WebElement zipcode;
	@FindBy(xpath="//input[@id='mobile_number']") private WebElement mobileno;
	@FindBy(xpath="//select[@id='country']") private WebElement countryselection;
	@FindBy(xpath="//button[normalize-space()='Create Account']") private WebElement createaccountbutton;
	
	public boolean isEnterAccountInfoMessageVisible() {
		return enteraccountinfo.isDisplayed();
		
	}
	
	public void fillAccountDetails(String pass,String fname,String lname,String cname,
			String addr1, String addr2,String state, String city,String pin,String mobile) {
		
		radioMr.click();
		password.sendKeys(pass);		
		ScrollNWaitUtils.scroll(driver, newsletter);
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
	
	public void selectDropDownValue(String day, String month,String year,String country) {
		
		new Select(Day).selectByValue(day);
		new Select(Month).selectByVisibleText(month);
		new Select(Year).selectByValue(year);
		new Select(countryselection).selectByValue(country);
		
	}
	
	public void clickCreateAccountButton() {
		ScrollNWaitUtils.scroll(driver, createaccountbutton);
		createaccountbutton.click();
	}
	
}
