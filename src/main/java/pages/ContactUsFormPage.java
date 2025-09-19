package pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsFormPage {
	
	WebDriver driver;
	
	public ContactUsFormPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[normalize-space()='Get In Touch']")WebElement getintouchmessage;
	@FindBy(xpath="//input[@placeholder='Name']")WebElement entername;
	@FindBy(xpath="//input[@placeholder='Email']")WebElement enteremail;
	@FindBy(xpath="//input[@placeholder='Subject']")WebElement entersubject;
	@FindBy(xpath="//textarea[@id='message']")WebElement entermessage;
	@FindBy(xpath="//input[@name='submit']")WebElement submitbutton;
	@FindBy(xpath="//div[@class='status alert alert-success']")WebElement successmessage;
	@FindBy(xpath="//span[normalize-space()='Home']")WebElement homebutton;
	@FindBy(xpath="//input[@name='upload_file']")WebElement uploadfile;
	
	
	
	public boolean isgetintouchmessagevisible() {
		return getintouchmessage.isDisplayed();
	}
	
	public void enterdetails(String name, String email, String subject, String message) {
		entername.sendKeys(name);
		enteremail.sendKeys(email);
		entersubject.sendKeys(subject);
		entermessage.sendKeys(message);
	}
	
	public void uploadingfile() {
		File fr = new File((System.getProperty("user.dir"))+ "/src/main/resources/Job Description - QA Manual Engineer - AirFi.docx.pdf");
		uploadfile.sendKeys(fr.getAbsolutePath());
	}
	
	public void submitting() throws InterruptedException {
		submitbutton.click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}
	
	public boolean issuccessmessagevisible() {
		return successmessage.isDisplayed();
	}
	
	public void homepagenavigation() {
		homebutton.click();
		}
	
	
}
