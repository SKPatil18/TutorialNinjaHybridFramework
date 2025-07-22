package com.tutorialninja.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;


public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIME = 10;
	
	public static String generateEmail() {
		Date date = new Date();
		String dateStr = date.toString(); // Convert Date to String
		System.out.println(dateStr); // Print original date string
		return dateStr.replace(" ", "").replace(":", "");

	}
	
	public static Object[][] getTextDataFromExcel(String sheetName) {
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialninja\\testdata\\data.xlsx");
		
		XSSFWorkbook workBook = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			workBook = new XSSFWorkbook(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workBook.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();
		int col = sheet.getRow(0).getLastCellNum();
		Object data[][] = new Object[rows][col];
		
		for(int i=0; i<rows; i++) {
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j=0; j<col; j++) {
				XSSFCell cell = row.getCell(j);
				
				CellType cellType = cell.getCellType();
				
				switch(cellType) {
				case STRING : 
					data[i][j] = cell.getStringCellValue();
					break;
					
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}
			}
		}
		return data;
	}	
	
	public static String captureScreenshot(WebDriver driver, String testName) {
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\ScreenShots\\"+testName+".png";
		try {
			Files.copy(screenshot, new File(dest));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest;
		
	}
	

}
