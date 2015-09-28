package com.appiumTestData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestReadExcel {
	public static void main(String[] args) {
		try {
			
			FileInputStream fileInputStream = new FileInputStream("TestDataDetails.xlsx");

			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet worksheet = workbook.getSheetAt(0);
			XSSFRow row1 = worksheet.getRow(0);
			XSSFCell cellA1 = row1.getCell((short) 0);
			String a1Val = cellA1.getStringCellValue();
			XSSFCell cellB1 = row1.getCell((short) 1);
			String b1Val = cellB1.getStringCellValue();

			System.out.println("A1: " + a1Val);
			System.out.println("B1: " + b1Val);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}