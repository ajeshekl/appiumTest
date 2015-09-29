package com.appiumTestData;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestReadExcel {
	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream("TestDataFile.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row;

			row = sheet.getRow(1);
					
			System.out.println("ROWS>>>>>>>"+row.getCell(0));
			System.out.println("ROWS>>>>>>>"+row.getCell(1));
			
		} catch(Exception ioe) {
			ioe.printStackTrace();
		}
	}
}