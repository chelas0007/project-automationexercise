package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupTeardown {
	
	public WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser","url"})
	public void setup(String br,String url) {
		
		switch(br.toLowerCase()) {
		case "chrome": 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
		default:
			System.out.println("Invalid Browser");
			return;	
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	
	
	

}
