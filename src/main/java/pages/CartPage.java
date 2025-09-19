package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.UtilityClass;

public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//td[@class='cart_product']") List<WebElement> productlist;
	@FindBy(xpath="//td[@class='cart_price']") List<WebElement> productsprice;
	@FindBy(xpath="//td[@class='cart_quantity']") List<WebElement> productsquantity;
	@FindBy(xpath="//td[@class='cart_total']") List<WebElement> productstotalprice;
	@FindBy(xpath="//li[@class='active']") WebElement cartpagetitle;
	@FindBy(xpath="//a[normalize-space()='Proceed To Checkout']") WebElement proceedtocheckoutbtn;
	@FindBy(xpath="//u[normalize-space()='Register / Login']") WebElement registerloginbtn;
	@FindBy(xpath="//i[@class='fa fa-times']") WebElement removefromcart;
	
	public boolean iscartvisible() {
		return cartpagetitle.isDisplayed();
	}
	
	public boolean productincartVerify() {
		return productlist.size()==2; 
	}
	
	public int product3pricecompare() {
		int i1 =Integer.parseInt(productsprice.getFirst().getText().replaceAll("[^0-9]", "")) ;
		return i1;
	}
	
	public boolean productstotalpricecheck() {
		
		for(int i=0;i<productlist.size();i++) {
			int a = Integer.parseInt(productsprice.get(i).getText().replaceAll("[^0-9]", ""));
			int b = Integer.parseInt(productsquantity.get(i).getText().replaceAll("[^0-9]", ""));
			int c = Integer.parseInt(productstotalprice.get(i).getText().replaceAll("[^0-9]", ""));
			if(a*b!=c)return false;
		}
		return true;
	}
	
	public boolean quantitycheck() {
		if (productsquantity.get(0).getText().trim().equals("4")) 
			return true;
		else
			return false;
	}
	
	public void checkout() {
		proceedtocheckoutbtn.click();
	}
	
	public void checkoutandregister() {
		UtilityClass.waituntilclickable(driver, registerloginbtn);
		registerloginbtn.click();
	}
	
	public void remove() {
		removefromcart.click();
	}
	
	public boolean isproductremoved() {
		return productlist.isEmpty();
	}
	
	public int productsincart() {
		return productlist.size();
	}

}
