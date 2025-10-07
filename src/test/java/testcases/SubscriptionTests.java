package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupTeardown;
import pages.HomePage;
import utils.DataProviders;

public class SubscriptionTests extends SetupTeardown {
	
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
