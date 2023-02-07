package Apache.ExcelFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis= new FileInputStream("D://Dev//Selenium//Excel_Test.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		//get the values for name3
		int sheets=workbook.getNumberOfSheets();
		XSSFSheet sheet = null;
		for (int i=0; i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("abc"))
			{	
				 sheet = workbook.getSheetAt(i);
				
			}
		}
		
		
		int lastRow;
		int lastCell;
		ArrayList<String> data = new ArrayList<String> ();
		
		lastRow = sheet.getLastRowNum();//// here first column is not count, here the row count starts form 0
		
		System.out.println(lastRow);		
		System.out.println(sheet.getFirstRowNum());	
		System.out.println(sheet.getRow(sheet.getFirstRowNum()).getCell(1).getStringCellValue());
		
		for (int i=0; i<=lastRow;i++)
		{
			
		if(	sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("name4"))
		{
			
			lastCell=sheet.getRow(i).getLastCellNum();  //// here cell count starts for 1
			//System.out.println(lastCell);
			{
				for (int j=0; j<lastCell;j++)
				{
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
				
				data.add(sheet.getRow(i).getCell(j).getStringCellValue());
				
				
				}
				
			}
			
		}
	
		}
		for (int k=0;k<data.size();k++)
		{
			System.out.println(data.get(k));
		//	System.out.println(data.get(1));
		//	System.out.println(data.get(2));
		}
	
		
	/*	Iterator<Row> firstRow = sheet.iterator();//sheet is collection of number of rows
		while(firstRow.hasNext())
		{
			boolean CellIndex = firstRow.next().getCell(1).getStringCellValue().equalsIgnoreCase("Column");
		}
		*/	
		
		
	}

}
