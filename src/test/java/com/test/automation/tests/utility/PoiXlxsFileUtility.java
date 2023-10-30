package com.test.automation.tests.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiXlxsFileUtility {

	private static XSSFWorkbook workbook = null;

	public static Object readSingledatafromxlsxfile(File path, String sheetName, int rowNum, int cellNum) {

		Object data = null;
		try {
			workbook = new XSSFWorkbook(path);
			System.out.println(workbook.getSheetName(0));
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(rowNum);
			XSSFCell cell = row.getCell(cellNum);

			if (cell.getCellType() == CellType.NUMERIC)
				data = (Object) Double.valueOf(cell.getNumericCellValue());
			else if (cell.getCellType() == CellType.STRING)
				data = (Object) String.valueOf(cell.getStringCellValue());
		} catch (InvalidFormatException | IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return data;

	}

	public static Object[][] readAlldatafromxlsxfile(File path, String sheetName) throws IOException {

		FileInputStream fs = new FileInputStream(path);
		workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() + 1;
		int coloumnCount = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowCount][coloumnCount];

		Iterator<Row> rows = sheet.rowIterator();
		int i = 0;
		int j = 0;

		while (rows.hasNext()) {
			Iterator<Cell> cells = rows.next().cellIterator();
			j = 0;
			while (cells.hasNext()) {
				XSSFCell cell = (XSSFCell) cells.next();
				if (cell.getCellType() == CellType.NUMERIC)
					data[i][j] = cell.getNumericCellValue();
				else if (cell.getCellType() == CellType.STRING)
					data[i][j] = cell.getStringCellValue();
				j++;
			}
			i++;

		}

		return data;
	}
	
	public static void readAlldatafromxlsxfileA()throws IOException {
		FileInputStream fi=new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/resources/sep2023.xlsx"));
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		XSSFSheet sheet= workbook.getSheet("sh1");
		
		Iterator<Row> rowit=sheet.rowIterator();
		while(rowit.hasNext()) {
			Row row=rowit.next();
			Iterator<Cell> cellit= row.cellIterator();
			while(cellit.hasNext()) {
				Cell cell=cellit.next();
				if(cell.getCellType()== CellType.NUMERIC)
					System.out.print(cell.getNumericCellValue()+ " ");
				else if(cell.getCellType()== CellType.STRING)
					System.out.print(cell.getStringCellValue()+" ");
			
			}
		}
		
		fi.close();
		

	}

}
