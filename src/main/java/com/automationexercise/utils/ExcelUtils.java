package com.automationexercise.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private XSSFWorkbook Workbook;
	
	public ExcelUtils(String filepath) throws IOException {
		
		FileInputStream fis = new FileInputStream(filepath);
		Workbook = new XSSFWorkbook(fis);
		fis.close();
	}
	
	public int getRowcount() {
		XSSFSheet sheet = Workbook.getSheetAt(0);
		return sheet.getLastRowNum();	
				}
	
	public int getCellCount(int rownum) {
		
		XSSFSheet sheet = Workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(rownum);
		if (row == null)
			return 0;
		else
			return row.getLastCellNum();
		
	}
	
	public String readingDatafromExcel(int rownum,int colnum) {
		
		XSSFSheet sheet = Workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(rownum);
		if(row == null) return "";
		XSSFCell cell = row.getCell(colnum);
		if(cell== null) return "";
		return cell.toString();
		
	}
	public void closeWorkbook() throws IOException {
		Workbook.close();
	}
	
	

}
