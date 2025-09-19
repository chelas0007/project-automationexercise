package pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.UtilityClass;

public class ProductsPage {

	WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[@class='title text-center']")WebElement allproductstitle;
	@FindBy(css="a[href='/product_details/2']") WebElement product2;
	@FindBy(xpath="//h2[normalize-space()='Men Tshirt']") WebElement productname;
	@FindBy(xpath="//p[normalize-space()='Category: Men > Tshirts']") WebElement productcategory;
	@FindBy(xpath="//span[normalize-space()='Rs. 400']") WebElement productprice;
	@FindBy(xpath="//div[@class='product-details']//p[2]") WebElement productavailability;
	@FindBy(xpath="//b[normalize-space()='Condition:']") WebElement productcondition;
	@FindBy(xpath="//b[normalize-space()='Brand:']") WebElement productbrand;
	@FindBy(xpath="//input[@id='search_product']") WebElement searchproductbox;
	@FindBy(xpath="//button[@id='submit_search']") WebElement searchbutton;
	@FindBy(xpath="//h2[@class='title text-center']") WebElement searchedproductsheader;
	@FindBy(xpath="//div[@class='product-image-wrapper']") List<WebElement> searchedproductsdisplayed;
	@FindBy(xpath="(//div[@class='product-image-wrapper'])[3]") WebElement product3selection;
	@FindBy(xpath="(//div[@class='product-image-wrapper'])[3]//div[@class='product-overlay']//a[@class='btn btn-default add-to-cart']") WebElement addtocartbutton3;
	@FindBy(xpath="//button[@class='btn btn-success close-modal btn-block']") WebElement ContinueShopping;
	@FindBy(xpath="(//div[@class='product-image-wrapper'])[1]") WebElement product1selection;
	@FindBy(xpath="(//div[@class='product-image-wrapper'])[1]//div[@class='product-overlay']//a[@class='btn btn-default add-to-cart']") WebElement addtocartbutton1;
	@FindBy(xpath="//u[normalize-space()='View Cart']") WebElement viewcart;
    @FindBy(xpath="(//div[@class='productinfo text-center'])[3]//h2[contains(text(),'Rs. 1000')]") WebElement product3price;
    @FindBy(xpath="//h2[normalize-space()='Brands']") WebElement brands;
    @FindBy(xpath="//a[@href='/brand_products/H&M']") WebElement HMbrand;
    @FindBy(xpath="//a[@href='/brand_products/Mast & Harbour']") WebElement MHbrand;
    
    @FindBy(xpath="//div[@class='product-overlay']//a[@class='btn btn-default add-to-cart']") List<WebElement> cartbutton;
    
  
    
    
	public boolean allproducttitleisvisible() {
		return allproductstitle.isDisplayed();
	}
	
	public void viewproduct2() {
		UtilityClass.scroll(driver, product2);
		product2.click();
	}
	
	public boolean isproductnameviewed() {
		return productname.isDisplayed();
	}
	
	public boolean isproductcategoryviewed() {
		return productcategory.isDisplayed();
	}
	
	public boolean isproductpriceviewed() {
		return productprice.isDisplayed();
	}
	
	public boolean isproductavailabilityviewed() {
		return productavailability.isDisplayed();
	}
	
	public boolean isproductconditionviewed() {
		return productcondition.isDisplayed();
	}
	
	public boolean isproductbrandviewed() {
		return productbrand.isDisplayed();
	}
	
	public void searchforproducts(String s1) {
		searchproductbox.sendKeys(s1);	
		searchbutton.click();
	}
	
	public boolean issearchedproductsheadervisible() {
		return searchedproductsheader.isDisplayed();
	}
	
	public boolean issearchedproductsvisible() {
		
		boolean b = true;
	
		for (WebElement product :searchedproductsdisplayed) {
			UtilityClass.scroll(driver, product);
			if(!product.isDisplayed()) {
				b=false;	
			}
		}
		return b;
	}
	
	public void productaddition() {
		UtilityClass.scroll(driver, product3selection);
		Actions act= new Actions(driver);
		act.moveToElement(product3selection).build().perform();
		UtilityClass.waituntilclickable(driver, addtocartbutton3);
		addtocartbutton3.click();
		UtilityClass.waituntilclickable(driver, ContinueShopping);
		ContinueShopping.click();
		act.moveToElement(product1selection).build().perform();
		UtilityClass.waituntilclickable(driver, addtocartbutton1);
		addtocartbutton1.click();
		UtilityClass.waituntilclickable(driver, viewcart);
		viewcart.click();
	}
	
	public int product3pricecompare() {
		String raw = product3price.getText().trim();
		System.out.println("DEBUG: '" + raw + "'");
		int i1 = Integer.parseInt(product3price.getText().replaceAll("[^0-9]", "")) ;
		return i1;
	}
	
	public boolean isbrandvisible() {
		UtilityClass.scroll(driver, brands);
		return brands.isDisplayed();
	}
	
	public void HMbrandselection() {
		HMbrand.click();
	}
	
	public void MHbrandselection() {
		MHbrand.click();
	}
	
	public void addingallsearchedproductstocart() {
		Actions a = new Actions(driver);
		
		for(int i =0 ;i<searchedproductsdisplayed.size();i++) {
			
			WebElement product = searchedproductsdisplayed.get(i);
			WebElement button = cartbutton.get(i);
			
			UtilityClass.scroll(driver, product);
			a.moveToElement(product).perform();
			UtilityClass.waituntilclickable(driver, button).click();
			if (i<(searchedproductsdisplayed.size())-1) 
				UtilityClass.waituntilclickable(driver, ContinueShopping).click();
			else 
				UtilityClass.waituntilclickable(driver, viewcart).click();
		}
	}
		
	public int productscount() {
		return searchedproductsdisplayed.size();
	}
}
