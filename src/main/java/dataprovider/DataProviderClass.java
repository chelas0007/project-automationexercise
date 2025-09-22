package dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name="loginsignup")
	public Object[][] dp1(){
		return new Object[][] {
			
			{"Rudra200","rudra200@gmail.com"}
		};
	}
	
	@DataProvider(name="accountdetails")
	public Object[][] dp2(){
		return new Object[][] {
			
			{"rudra200@gmail.com","newpassword123","12","October","1997","Rudra500","Chelas","Riskit",
				"Whitefield","Bengaluru","Karnataka","Bengaluru","560066","1234567890","United States",
				"You are doing amazing. 1.5L/month job is on your lap by oct 2025"}
		};
	}
	
	@DataProvider(name ="validLoginCredentials")
	public Object[][] dp3(){
		return new Object[][] {
			
			{"rudra300@gmail.com","newpassword123"}
		};
		
	}
	
	@DataProvider(name ="invalidLoginCredentials")
	public Object[][] dp4(){
		return new Object[][] {
			
			{"rudra2020@gmail.com","newpassword123"}
		};
		
	}
	
	@DataProvider(name="contactusform")
	public Object[][] contactusformdata(){
		return new Object[][] {
			{"Rudra","rudra@gmail.com","QuickReminder",
				"You are doing amazing. 1.5L/month job is on your lap by oct 2025. Not just that but several offers are on your "
				+ "lap by then"}
		};
		
	}
	
	@DataProvider(name="search products")
	public Object[][] searchproducts(){
		return new Object[][] {
			{"green"}
		};
	}
	
	@DataProvider(name="email")
	public Object[][] dpemail(){
		return new Object[][] {
			{"rudra@gmail.com"}	
		};
	}
	
	@DataProvider(name="carddetails")
	public Object[][] carddp(){
		return new Object[][] {
			
			{"Rudra","1234567890123456","999","12","2025"}
		};	
	}
	
}
