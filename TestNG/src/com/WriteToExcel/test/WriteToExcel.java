package com.WriteToExcel.test;

import java.io.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToExcel {

	public static void CreateExcel() throws IOException {
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		XSSFRow row;
		XSSFCell cell;
		File file;
		FileOutputStream fos;

		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Test");
		row = sheet.createRow(0);
		cell = row.createCell(0);

		cell.setCellValue("Testing");

		file = new File("D:\\CreatedExcel.xlsx");
		fos = new FileOutputStream(file);

		workbook.write(fos);
		fos.close();
		workbook.close();

		System.out.println("New excel created successfully");
	}

	public static void UpdateExistingExcel() throws IOException, InvalidFormatException {
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		XSSFRow row;
		XSSFCell cell;
		File file;
		FileInputStream fis;
		FileOutputStream fos;

		file = new File("D:\\CreatedExcel.xlsx");
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		row = sheet.getRow(0);
		cell = row.getCell(0);
				
		cell.setCellValue("Selenium WebDriver");
		
		row = sheet.createRow(1);
		cell = row.createCell(0);
		
		cell.setCellValue("TestNG");
				
		fos = new FileOutputStream(file);

		workbook.write(fos);
		fos.close();
		workbook.close();

		System.out.println("Excel updated successfully");

	}

	public static void main(String args[]) throws IOException, InvalidFormatException {

		//CreateExcel();
		UpdateExistingExcel();
	}

}
