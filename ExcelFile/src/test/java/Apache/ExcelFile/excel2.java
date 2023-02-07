package Apache.ExcelFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel2 {

	public static void main(String[] args) throws IOException 
	{

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
				 System.out.println(workbook.getSheetName(i));
				
			}
		}
		System.out.println("****************************************************"+sheet.getLastRowNum());  //sheet.getFirstRowNum()
		    
	/*	    
		    for(int i=1;i<workbook.getNumberOfSheets();i++) {
		        Sheet sheet = workbook.getSheetAt(i);
		        for (int colnum=0;colnum<sheet.getLastRowNum();colnum++){
		            // Create a DataFormatter to format and get each cell's value as String
		            // System.out.print(sheet.getRow(j).getCell(1) + "\n");

		            // Closing the workbook
		            workbook.close();
		        }
*/
		    sheet= workbook.getSheetAt(0);
		    System.out.println(sheet.getSheetName());
		    Iterator<Row> rows = sheet.iterator(); //sheet is a collection of rows
		    
		  Row firstRow = rows.next();  // firstrow
		  Iterator<Cell> ce = firstRow.cellIterator();// row is a collection of cells
		  
		  String firstCell = ce.next().getStringCellValue();
		  System.out.println(firstCell);
		  Cell firstCell1 = ce.next();
		  while(ce.hasNext())
		  {
			  System.out.println(ce.next().getStringCellValue());
		  }
		  
		    
	}

}
