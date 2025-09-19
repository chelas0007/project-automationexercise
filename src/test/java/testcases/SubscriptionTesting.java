package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.SetupTeardown;
import dataprovider.DataProviderClass;
import pages.HomePage;

public class SubscriptionTesting extends SetupTeardown {
	
	@Test(dataProvider="email",dataProviderClass=DataProviderClass.class)
	public void subscribe(String email) {
		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.ishomepagevisible(),"Home Page is not visible");
		
		hp.subscriptioncheck(email);
		Assert.assertTrue(hp.issubcribedmessagevisisble(),"Subscription is not successful");
	}
	
	@Test(dataProvider="email",dataProviderClass=DataProviderClass.class)
	public void subscriptionfromcartpage(String email) {
		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.ishomepagevisible(),"Home Page is not visible");
		
		hp.cartbuttonnavigate();
		hp.subscriptioncheck(email);
		Assert.assertTrue(hp.issubcribedmessagevisisble(),"Subscription is not successful");
	}

}
