package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelOutput {
	
	String path=System.getProperty("user.dir")+"\\ExcelPath\\Wazirx.xlsx";
	File file;
	FileOutputStream fos;
	FileInputStream fis;
	XSSFWorkbook setWorkbook;
	XSSFWorkbook Workbook;
	XSSFSheet sheet;
	
//	@Test
	public void setExcelData() throws IOException
	{
		XSSFWorkbook workbook1=new XSSFWorkbook();
		XSSFSheet sheet= workbook1.createSheet("Test1");
	
		XSSFCellStyle Yellow=workbook1.createCellStyle();
		
		Yellow.setFillBackgroundColor(IndexedColors.ORANGE.getIndex());
		Yellow.setFillPattern(FillPatternType.FINE_DOTS);
		
		
		XSSFCellStyle Green=workbook1.createCellStyle();
		Green.setFillBackgroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		Green.setFillPattern(FillPatternType.FINE_DOTS);
		
		sheet.createRow(0);
		
		sheet.getRow(0).createCell(0).setCellValue("Raj");
		sheet.getRow(0).getCell(0).setCellStyle(Yellow);
	
		
		sheet.getRow(0).createCell(1).setCellValue("Karan");
		sheet.getRow(0).getCell(1).setCellStyle(Green);
	
	//	String path=System.getProperty("user.dir")+"\\ExcelPath\\Wazirx.xlsx";
		File file=new File(path);
		FileOutputStream fos=new FileOutputStream(file);
		workbook1.write(fos);
		
		workbook1.close();
		
	}
	
//	@Test//(priority = 1)
	public void CreateExcelOutput() throws IOException
	{
		// path=System.getProperty("user.dir")+"\\ExcelPath\\Wazirx.xlsx";
		 file=new File(path);
		 fos=new FileOutputStream(file);
	
	}
	
	public void setExcelInput() throws IOException
	{
	//String	path2=System.getProperty("user.dir")+"\\ExcelPath\\Wazirx.xlsx";
		 fos=new FileOutputStream(path);
	}
	public void getExcelInput() throws IOException
	{
	//String	 path1=System.getProperty("user.dir")+"\\ExcelPath\\Wazirx.xlsx";
		 fis=new FileInputStream(path);
	}
	
	public void setExcelTemplate(List<Object> favoCoinsList) throws IOException
	{
		CreateExcelOutput();
		setWorkbook=new XSSFWorkbook();
		
		XSSFCellStyle Yellow=setWorkbook.createCellStyle();
		Yellow.setFillBackgroundColor(IndexedColors.YELLOW1.getIndex());
		Yellow.setFillPattern(FillPatternType.FINE_DOTS);
		
		XSSFCellStyle Green=setWorkbook.createCellStyle();
		Green.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		Green.setFillPattern(FillPatternType.FINE_DOTS);
		
		XSSFCellStyle Red=setWorkbook.createCellStyle();
		Red.setFillBackgroundColor(IndexedColors.ORANGE.getIndex());
		Red.setFillPattern(FillPatternType.FINE_DOTS);
		
		favoCoinsList .forEach(coin->{
			
			System.out.println("excel tab name"+coin);
			
			String coinName=(String) coin;
			coinName=coinName.replaceAll("[^a-zA-Z0-9]", "-"); 
			System.out.println("excel tab name to string: "+coinName);
			
			
			
			 sheet=setWorkbook.createSheet(coinName);
			sheet.createRow(0);
			sheet.getRow(0).createCell(0).setCellValue("Amount Purchase");
			sheet.getRow(0).getCell(0).setCellStyle(Yellow);
			sheet.getRow(0).createCell(1).setCellValue("Purchase Price");
			sheet.getRow(0).getCell(1).setCellStyle(Yellow);
			sheet.getRow(0).createCell(2).setCellValue("Total Purchase in INR");
			sheet.getRow(0).getCell(2).setCellStyle(Green);
			sheet.getRow(0).createCell(3).setCellValue("Amount Sell");
			sheet.getRow(0).getCell(3).setCellStyle(Yellow);
			sheet.getRow(0).createCell(4).setCellValue("Sell Price");
			sheet.getRow(0).getCell(4).setCellStyle(Yellow);
			sheet.getRow(0).createCell(5).setCellValue("Total Sell in INR");
			sheet.getRow(0).getCell(5).setCellStyle(Red);
			
		
			
		});
		setWorkbook.write(fos);
		setWorkbook.close();
		
	}

	
		
	public void getRowCreator(String coinName,List<String> valuePurchaseOrderList) throws IOException
	{
		int  insertAmountAtRow=0;
		
		getExcelInput();
    	Workbook=new XSSFWorkbook(fis);
		 
		int totalSheets = Workbook.getNumberOfSheets();
		System.out.println("Total sheets available in sheet:"+totalSheets);
		for (int i=0;i<totalSheets;i++)
		{ 
			sheet=Workbook.getSheetAt(i);
			if(coinName.equalsIgnoreCase(sheet.getSheetName()))
			{
				System.out.println(sheet.getSheetName());
			
			
		
			for (int j=0;j<valuePurchaseOrderList.size();j++)
			    	{
			    		
			    		 insertAmountAtRow=insertAmountAtRow+1;
			    		 sheet.createRow(insertAmountAtRow);
			    		 setExcelInput();
							Workbook.write(fos);
							
			    	}
			break;
			}
			else 
			{
				System.out.println("**********The coin and the tab name did not matched***********");
			}
	
		}
		Workbook.close();
	   	
	}

	
@Test
public void SetDataInExcel(String coinName,List<String> valuePurchaseOrderList,   int insertAtCell) throws IOException
//	public void SetDataInExcel(String coinName,int insertAmountAtCell ,String value) throws IOException
	{
	System.out.println("excel data write coinName: "+ coinName);
	   // int insertAmountAtCell=0;
    	int  insertAmountAtRow=0;
    	String value;
    	
    //	for (int value=0;value<amountPurchaseOrderList.size();value++)
    //	{
    //		System.out.println("#########values to be written in excel#########"+amountPurchaseOrderList.get(value));   
    //	}
    
    	
 
    	getExcelInput();
    	Workbook=new XSSFWorkbook(fis);
		 
		int totalSheets = Workbook.getNumberOfSheets();
		System.out.println("Total sheets available in sheet:"+totalSheets);
		for (int i=0;i<totalSheets;i++)
		{ 
			sheet=Workbook.getSheetAt(i);
			if(coinName.equalsIgnoreCase(sheet.getSheetName()))
			{
				
				System.out.println(sheet.getSheetName());
				
				
			//	System.out.println("****************************************************"+sheet.getLastRowNum());  //sheet.getFirstRowNum()  
			//	 insertAmountAtRow= sheet.getLastRowNum();
				
				
				for (int valueCount=0;valueCount<valuePurchaseOrderList.size();valueCount++)
		    	{
		    		System.out.println("#########values to be written in excel#########"+valuePurchaseOrderList.get(valueCount)); 
		    		
		    		value=valuePurchaseOrderList.get(valueCount);
		    		
		    		 insertAmountAtRow=insertAmountAtRow+1;
		    	//	 sheet.createRow(insertAmountAtRow);
		    		 sheet.getRow(insertAmountAtRow).createCell(insertAtCell).setCellValue(value);
		    		 
		    		 System.out.println("-----------------------------------"+insertAmountAtRow);
		    		 System.out.println("------------------------------------"+insertAtCell);
		    		 
		    		 setExcelInput();
						Workbook.write(fos);
						
		    	}
		    	
			//	Workbook.close();
		    	break;
		    
		
				}
				else 
				{
					System.out.println("**********The coin and the tab name did not matched***********");
				}
		//	Workbook.close();
		   	
			}
//			setExcelInput();
//			Workbook.write(fos);
//			Workbook.close();
   	
	
/*	
int insertAmountAtRow;
//	String coinName= "ADA-INR";
//	int insertAmountAtCell=125;
//	int value=1;
		System.out.println("excel data write coinName"+ coinName);
		//System.out.println("excel data write insertAmountAtRow"+insertAmountAtRow);
		System.out.println("excel data write insertAmountAtCell"+insertAmountAtCell);
	System.out.println("excel data writeamount"+value);
	


		getExcelInput();
		
		
		Workbook=new XSSFWorkbook(fis);
		 
		 
		int totalSheets1 = Workbook.getNumberOfSheets();
		System.out.println("Total sheets available in sheet:"+totalSheets1);
		for (int i=0;i<totalSheets1;i++)
		{ 
		
			sheet=Workbook.getSheetAt(i);
			if(coinName.equalsIgnoreCase(sheet.getSheetName()))
			{
				
				System.out.println(sheet.getSheetName());
				
			System.out.println("****************************************************"+sheet.getLastRowNum());  //sheet.getFirstRowNum()  
			 insertAmountAtRow= sheet.getLastRowNum();
			 insertAmountAtRow=insertAmountAtRow+1;
				
				sheet.createRow(insertAmountAtRow);
				sheet.getRow(insertAmountAtRow).createCell(insertAmountAtCell).setCellValue(value);
				
			}
			else 
			{
				System.out.println("**********The coin and the tab name did not matched***********");
			}
		}
		setExcelInput();
		Workbook.write(fos);
		Workbook.close();
	*/
		Workbook.close();
	   	
	}


}


