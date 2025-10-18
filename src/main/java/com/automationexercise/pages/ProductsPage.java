package com.automationexercise.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationexercise.utils.ScrollNWaitUtils;

public class ProductsPage {

	private WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[@class='title text-center']")private WebElement allproductstitle;
	@FindBy(css="a[href='/product_details/2']") private WebElement product2;
	@FindBy(xpath="//h2[normalize-space()='Men Tshirt']") private WebElement productname;
	@FindBy(xpath="//p[normalize-space()='Category: Men > Tshirts']") private WebElement productcategory;
	@FindBy(xpath="//span[normalize-space()='Rs. 400']") private WebElement productprice;
	@FindBy(xpath="//div[@class='product-details']//p[2]") private WebElement productavailability;
	@FindBy(xpath="//b[normalize-space()='Condition:']") private WebElement productcondition;
	@FindBy(xpath="//b[normalize-space()='Brand:']") private WebElement productbrand;
	@FindBy(xpath="//input[@id='search_product']") private WebElement searchproductbox;
	@FindBy(xpath="//button[@id='submit_search']") private WebElement searchbutton;
	@FindBy(xpath="//h2[@class='title text-center']") private WebElement searchedproductsheader;
	@FindBy(xpath="//div[@class='product-image-wrapper']") private List<WebElement> searchedproductsdisplayed;
	@FindBy(xpath="(//div[@class='product-image-wrapper'])[3]") private WebElement product3selection;
	@FindBy(xpath="(//div[@class='product-image-wrapper'])[3]//div[@class='product-overlay']//a[@class='btn btn-default add-to-cart']") private WebElement addtocartbutton3;
	@FindBy(xpath="//button[@class='btn btn-success close-modal btn-block']") private WebElement ContinueShopping;
	@FindBy(xpath="(//div[@class='product-image-wrapper'])[1]") private WebElement product1selection;
	@FindBy(xpath="(//div[@class='product-image-wrapper'])[1]//div[@class='product-overlay']//a[@class='btn btn-default add-to-cart']") private WebElement addtocartbutton1;
	@FindBy(xpath="//u[normalize-space()='View Cart']") private WebElement viewcart;
    @FindBy(xpath="(//div[@class='productinfo text-center'])[3]//h2[contains(text(),'Rs. 1000')]") private WebElement product3price;
    @FindBy(xpath="//h2[normalize-space()='Brands']") private WebElement brands;
    @FindBy(xpath="//a[@href='/brand_products/H&M']") private WebElement HMbrand;
    @FindBy(xpath="//a[@href='/brand_products/Mast & Harbour']") private WebElement MHbrand;
    
    @FindBy(xpath="//div[@class='product-overlay']//a[@class='btn btn-default add-to-cart']") private List<WebElement> cartbutton;
    
  
    
    
	public boolean areAllProductsTitleVisible() {
		return allproductstitle.isDisplayed();
	}
	
	public void viewProduct2() {
		ScrollNWaitUtils.scroll(driver, product2);
		product2.click();
	}
	
	public boolean isProductNameVisible() {
		return productname.isDisplayed();
	}
	
	public boolean isProductCategoryVisible() {
		return productcategory.isDisplayed();
	}
	
	public boolean isProductPriceVisible() {
		return productprice.isDisplayed();
	}
	
	public boolean isProductAvailabilityVisible() {
		return productavailability.isDisplayed();
	}
	
	public boolean isProductConditionVisible() {
		return productcondition.isDisplayed();
	}
	
	public boolean isProductBrandVisible() {
		return productbrand.isDisplayed();
	}
	
	public void searchProducts(String s1) {
		searchproductbox.sendKeys(s1);	
		searchbutton.click();
	}
	
	public boolean isSearchedProductHeaderVisible() {
		return searchedproductsheader.isDisplayed();
	}
	
	public boolean areSearchedProductsVisible() {
		
		boolean b = true;
	
		for (WebElement product :searchedproductsdisplayed) {
			ScrollNWaitUtils.scroll(driver, product);
			if(!product.isDisplayed()) {
				b=false;	
			}
		}
		return b;
	}
	
	public void addProductsToCart() {
		ScrollNWaitUtils.scroll(driver, product3selection);
		Actions act= new Actions(driver);
		act.moveToElement(product3selection).build().perform();
		ScrollNWaitUtils.waitAndClick(driver, addtocartbutton3);
		ScrollNWaitUtils.waitAndClick(driver, ContinueShopping);
		act.moveToElement(product1selection).build().perform();
		ScrollNWaitUtils.waitAndClick(driver, addtocartbutton1);
		ScrollNWaitUtils.waitAndClick(driver, viewcart);
	}
	
	public int product3PriceComparison() {
		int i1 = Integer.parseInt(product3price.getText().trim().replaceAll("[^0-9]", "")) ;
		return i1;
	}
	
	public boolean isBrandVisible() {
		ScrollNWaitUtils.scroll(driver, brands);
		return brands.isDisplayed();
	}
	
	public void selectHMBrand() {
		HMbrand.click();
	}
	
	public void selectMHbrand() {
		MHbrand.click();
	}
	
	public void addingAllSearchedProductsToCart() {
		Actions a = new Actions(driver);
		
		for(int i =0 ;i<searchedproductsdisplayed.size();i++) {
			
			WebElement product = searchedproductsdisplayed.get(i);
			WebElement button = cartbutton.get(i);
			
			ScrollNWaitUtils.scroll(driver, product);
			a.moveToElement(product).perform();
			ScrollNWaitUtils.waitAndClick(driver, button);
			if (i<(searchedproductsdisplayed.size())-1) 
				ScrollNWaitUtils.waitAndClick(driver, ContinueShopping);
			else 
				ScrollNWaitUtils.waitAndClick(driver, viewcart);
		}
	}
		
	public int getProductCount() {
		return searchedproductsdisplayed.size();
	}
}
