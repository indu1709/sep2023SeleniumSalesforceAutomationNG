package com.tekarch.test;
//maven-- pom.xml--- dependancy
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteXLSXsheet {

	public static void readSingledatafromxlsxfile()throws IOException {
		//Properties pro=new Properties();
		FileInputStream fi=new FileInputStream(new File(System.getProperty("user.dir")+"/resources/sep2023.xlsx"));
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		
		XSSFSheet sheet= workbook.getSheet("Sheet3");
		XSSFRow row= sheet.getRow(0);
		XSSFCell cell= row.getCell(0);
		if(cell.getCellType()== CellType.NUMERIC)
			System.out.println(cell.getNumericCellValue());
		else if(cell.getCellType()== CellType.STRING)
			System.out.println(cell.getStringCellValue());
		fi.close();

	}
	
	public static void readAlldatafromxlsxfile()throws IOException {
		FileInputStream fi=new FileInputStream(new File(System.getProperty("user.dir")+"/resources/sep2023.xlsx"));// Object[][] //collections
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		
	/*	List<List<Integer>> ob=new ArrayList<>();
		List<Integer> a1=new ArrayList<>();
		a1.add(4);
		a1.add(5);
		a1.add(6);
		ob.add(a1);
		List<Integer> a2=new ArrayList<>();
		a2.add(7);
		a2.add(8);
		a2.add(9);
		ob.add(a2);*/
		//int totalsheet=workbook.getNumberOfSheets();
		//for(int k=0;k<totalsheet;k++) {
		XSSFSheet sheet= workbook.getSheet("sh1");
		int totalRows=sheet.getLastRowNum()+1;
		//int totalCol=sheet.getRow(0).getLastCellNum();
		for(int i=0;i<totalRows;i++) {
			int totalcell=sheet.getRow(i).getLastCellNum();
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<totalcell;j++) {
				XSSFCell cell= row.getCell(j);
				
				if(cell.getCellType()== CellType.NUMERIC)
					System.out.print(cell.getNumericCellValue()+ " ");
				else if(cell.getCellType()== CellType.STRING)
					System.out.print(cell.getStringCellValue()+" ");
			}
			System.out.println();
		}
		System.out.println("**********************");
	
		
		fi.close();
		
		

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
	
	public static void writeDataToXlsx() throws IOException {
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("divya");
		XSSFRow row= sheet.createRow(0);
		XSSFCell cell= row.createCell(0);
		
		cell.setCellValue("tekarch training");
		
		FileOutputStream fo=new FileOutputStream(new File("./src/test/resources/newxlsheet.xlsx"));
		workbook.write(fo);
		workbook.close();
		fo.close();
		System.out.println("completed writing");
	}
	
	public static void writeDataToOldXlsx() throws IOException {
		FileInputStream fi=new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/resources/sep2023.xlsx"));
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		XSSFSheet sheet= workbook.getSheet("sh2");
		sheet.getRow(0).getCell(0).setCellValue("tekarch");
		//XSSFRow row= sheet.createRow(0);
		//XSSFCell cell= row.createCell(0);
		
		//cell.setCellValue("tekarch training");
		
		FileOutputStream fo=new FileOutputStream(new File("./src/test/resources/sep2023.xlsx"));

		workbook.write(fo);
		workbook.close();
		fo.close();
		System.out.println("completed writing");
	}
	
	
	public static void main(String[] args) throws IOException  {
	
		readAlldatafromxlsxfileA();
		//writeDataToXlsx();
		//writeDataToOldXlsx();
	}

}
