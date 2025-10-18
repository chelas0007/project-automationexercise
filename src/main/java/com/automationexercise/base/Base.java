package com.automationexercise.base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.automationexercise.pages.HomePage;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	protected WebDriver driver;
	protected Properties p;
	
	@BeforeTest
	//@Parameters({"browser","url"})
	public void setup() throws IOException {
		
		p=new Properties();
		try(FileReader fr= new FileReader(System.getProperty("user.dir")+"/src/main/resources/config-files/config.properties")){
		p.load(fr);
		}
		
		String browser = p.getProperty("browser").toLowerCase();
		
		switch(browser) {
		case "chrome": 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
		default:
			throw new IllegalArgumentException("Invalid Browser");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		
	}
	
	//@AfterTest
	public void afterClassMethod() {
		try {
		HomePage hp = new HomePage(driver);
		hp.navigateToHomePage();
		}
		catch(Exception e) {
			System.out.println("Navigation to Home Page is failed after class:"+this.getClass().getSimpleName());
		}
	}
	
	@AfterTest
	public void teardown() {
		if(driver!=null)
		driver.quit();
	}

}
