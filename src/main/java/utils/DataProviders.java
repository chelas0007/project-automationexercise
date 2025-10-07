package utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

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
				+ "lap by then","/src/main/resources/Sample1.pdf"}
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
	
	@DataProvider(name="exceldata")
	public Object[][] excellogindata() throws IOException{
		
		String filepath = System.getProperty("user.dir")+"/test-data/data1.xlsx";
		
		ExcelUtils e = new ExcelUtils(filepath);
		
		//String sheetname = "Sheet1";
		
		int lastrowindex= e.getRowcount();
		int totalcell= 3;
		
		Object[][] data = new Object[lastrowindex-1][totalcell];
		
		 for (int i=2;i<=lastrowindex; i++) {
			 
			 for (int j=0;j<totalcell;j++) {
				 data[i-2][j] = e.readingDatafromExcel( i, j);
			 }
			 
		 }
		// Debug print
		    System.out.println("Rows: " + data.length + ", Columns: " + data[0].length);
		    for (int r = 0; r < data.length; r++) {
		        for (int c = 0; c < data[r].length; c++) {
		            System.out.print("[" + data[r][c] + "] ");
		        }
		        System.out.println();
		    }

		 
		e.closeWorkbook();
		return data;
	}
	
	
}
