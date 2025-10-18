package com.automationexercise.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollNWaitUtils {
	
	public static void scroll(WebDriver driver, WebElement wb1) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", wb1);
	}
	
	public static void scrollToBottom(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scrollToTop(WebDriver driver) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,0)");
	}
	
	public static WebElement waitUntilClickable(WebDriver driver,WebElement wb1) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(wb1));	
	}
	
	public static Alert waitForAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.alertIsPresent());	
	}
	
	 public static void waitAndClick(WebDriver driver, WebElement wb1) {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(wb1)).click();; 
	 }
}
