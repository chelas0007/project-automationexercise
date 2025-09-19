package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.UtilityClass;

public class PaymentPage {
	
	WebDriver driver;
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='name_on_card']") WebElement cardname;
	@FindBy(xpath="//input[@name='card_number']") WebElement cardnum;
	@FindBy(xpath="//input[@placeholder='ex. 311']") WebElement cardcvv;
	@FindBy(xpath="//input[@placeholder='MM']") WebElement expmm;
	@FindBy(xpath="//input[@placeholder='YYYY']") WebElement expyyyy;
	@FindBy(xpath="//button[@id='submit']") WebElement orderbtn;

	
	public void entercarddetails(String cname, String cnum, String ccvv, String cexpm, String cexpy) {
		UtilityClass.scroll(driver, cardname);
		cardname.sendKeys(cname);
		cardnum.sendKeys(cnum);
		cardcvv.sendKeys(ccvv);
		expmm.sendKeys(cexpm);
		expyyyy.sendKeys(cexpy);
		orderbtn.click();
	}
	
	

	
	
	
	
	
	
	
	
	

}
