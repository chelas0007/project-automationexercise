package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationexercise.utils.ScrollNWaitUtils;

public class PaymentPage {
	
	private WebDriver driver;
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='name_on_card']") private WebElement cardname;
	@FindBy(xpath="//input[@name='card_number']") private WebElement cardnum;
	@FindBy(xpath="//input[@placeholder='ex. 311']") private WebElement cardcvv;
	@FindBy(xpath="//input[@placeholder='MM']") private WebElement expmm;
	@FindBy(xpath="//input[@placeholder='YYYY']") private WebElement expyyyy;
	@FindBy(xpath="//button[@id='submit']") private WebElement orderbtn;

	
	public void enterCardDetails(String cname, String cnum, String ccvv, String cexpm, String cexpy) {
		ScrollNWaitUtils.scroll(driver, cardname);
		cardname.sendKeys(cname);
		cardnum.sendKeys(cnum);
		cardcvv.sendKeys(ccvv);
		expmm.sendKeys(cexpm);
		expyyyy.sendKeys(cexpy);
		orderbtn.click();
	}

}
