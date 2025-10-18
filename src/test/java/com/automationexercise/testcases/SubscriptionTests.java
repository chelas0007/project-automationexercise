package com.automationexercise.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.base.Base;
import com.automationexercise.pages.HomePage;
import com.automationexercise.utils.DataProviders;

public class SubscriptionTests extends Base {
	
	@Test(dataProvider="email",dataProviderClass=DataProviders.class)
	public void subscribe(String email) {
		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.isHomePageVisible(),"Home Page is not visible");
		
		hp.checkForSubscription(email);
		Assert.assertTrue(hp.isSubcribedMessageVisisble(),"Subscription is not successful");
	}
	
	@Test(dataProvider="email",dataProviderClass=DataProviders.class)
	public void subscriptionfromcartpage(String email) {
		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.isHomePageVisible(),"Home Page is not visible");
		
		hp.clickCartbutton();
		hp.checkForSubscription(email);
		Assert.assertTrue(hp.isSubcribedMessageVisisble(),"Subscription is not successful");
	}

}
