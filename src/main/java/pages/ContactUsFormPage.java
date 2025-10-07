package pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ScrollNWaitUtils;

public class ContactUsFormPage {
	
	private WebDriver driver;
	
	public ContactUsFormPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[normalize-space()='Get In Touch']")private WebElement getintouchmessage;
	@FindBy(xpath="//input[@placeholder='Name']")private WebElement entername;
	@FindBy(xpath="//input[@placeholder='Email']")private WebElement enteremail;
	@FindBy(xpath="//input[@placeholder='Subject']")private WebElement entersubject;
	@FindBy(xpath="//textarea[@id='message']")private WebElement entermessage;
	@FindBy(xpath="//input[@name='submit']")private WebElement submitbutton;
	@FindBy(xpath="//div[@class='status alert alert-success']")private WebElement successmessage;
	@FindBy(xpath="//span[normalize-space()='Home']")private WebElement homebutton;
	@FindBy(xpath="//input[@name='upload_file']")private WebElement uploadfile;
	
	
	
	public boolean isGetInTouchMessageVisible() {
		return getintouchmessage.isDisplayed();
	}
	
	public boolean isSuccessMessageVisible() {
		return successmessage.isDisplayed();
	}
	
	public void enterContactDetails(String name, String email, String subject, String message) {
		entername.sendKeys(name);
		enteremail.sendKeys(email);
		entersubject.sendKeys(subject);
		entermessage.sendKeys(message);
	}
	
	public void uploadFile(String filepath) {
		File f = new File(System.getProperty("user.dir")+filepath);
		uploadfile.sendKeys(f.getAbsolutePath());
	}
	
	public void clickSubmitButton()  {
		submitbutton.click();
		ScrollNWaitUtils.waitForAlert(driver);
		driver.switchTo().alert().accept();
	}
	
	public void navigateTohomePage() {
		homebutton.click();
	}
	
}
