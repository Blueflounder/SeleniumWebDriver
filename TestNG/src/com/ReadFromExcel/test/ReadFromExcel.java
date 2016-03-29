package com.ReadFromExcel.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	static File file;
	static InputStream is;

	static int rowCount;
	static int cellCount;

	public static void main(String args[]) throws InvalidFormatException, IOException {

		file = new File("D:\\SomePrivateLimited.xlsx");
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet("Designations");
		rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		
		for (int i = 0; i < workbook.getNumberOfSheets(); i++){
			
			System.out.println("Printing from sheet: "+workbook.getSheetName(i));
			sheet=workbook.getSheetAt(i);
			
				for (int j = 0; j <= rowCount; j++) {
	
					row = sheet.getRow(j);
					cellCount = row.getLastCellNum() - row.getFirstCellNum();
					System.out.println("\n" + "[Row No.]:" + row.getRowNum());
					
						for (int k = 0; k < cellCount; k++) {
					
							cell = row.getCell(k);
							switch (cell.getCellType()) {
							case XSSFCell.CELL_TYPE_STRING:
								//System.out.println(cell.getStringCellValue());
								System.out.print("[Cell No. " + k + " ] " + cell.getStringCellValue() + " ");
								break;
							case XSSFCell.CELL_TYPE_NUMERIC:
								System.out.print("[Cell No. " + k + " ] " + cell.getNumericCellValue() + " ");
								break;
							default:
								System.out.println("None of String / Numeric values detected");
							}
					}
						
				}System.out.println("\n");
			
			}
			workbook.close();

		}
}
