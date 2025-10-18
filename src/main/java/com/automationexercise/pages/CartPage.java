package com.automationexercise.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationexercise.utils.ScrollNWaitUtils;

public class CartPage {
	
	private WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//td[@class='cart_product']") private List<WebElement> productlist;
	@FindBy(xpath="//td[@class='cart_price']") private List<WebElement> productsprice;
	@FindBy(xpath="//td[@class='cart_quantity']") private List<WebElement> productsquantity;
	@FindBy(xpath="//td[@class='cart_total']") private List<WebElement> productstotalprice;
	@FindBy(xpath="//li[@class='active']") private WebElement cartpagetitle;
	@FindBy(xpath="//a[normalize-space()='Proceed To Checkout']") private WebElement proceedtocheckoutbtn;
	@FindBy(xpath="//u[normalize-space()='Register / Login']") private WebElement registerloginbtn;
	@FindBy(xpath="//i[@class='fa fa-times']") private WebElement removefromcart;
	
	public boolean isCartVisible() {
		return cartpagetitle.isDisplayed();
	}
	
	public boolean hasExpectedProductInCart() {
		return productlist.size()==2; 
	}
	
	public int product3PriceCompare() {
		int i1 =Integer.parseInt(productsprice.getFirst().getText().replaceAll("[^0-9]", "")) ;
		return i1;
	}
	
	public boolean productsTotalPriceCheck() {
		
		for(int i=0;i<productlist.size();i++) {
			int a = Integer.parseInt(productsprice.get(i).getText().replaceAll("[^0-9]", ""));
			int b = Integer.parseInt(productsquantity.get(i).getText().replaceAll("[^0-9]", ""));
			int c = Integer.parseInt(productstotalprice.get(i).getText().replaceAll("[^0-9]", ""));
			if(a*b!=c)return false;
		}
		return true;
	}
	
	public boolean quantityCheck() {
		if (productsquantity.get(0).getText().trim().equals("4")) 
			return true;
		else
			return false;
	}
	
	public void clickCheckoutButton() {
		proceedtocheckoutbtn.click();
	}
	
	public void clickCheckoutAndRegister() {
		ScrollNWaitUtils.waitAndClick(driver, registerloginbtn);
	}
	
	public void removeProductFromCart() {
		removefromcart.click();
	}
	
	public boolean isCartEmpty() {
		return productlist.isEmpty();
	}
	
	public int getProductsCount() {
		return productlist.size();
	}

}
