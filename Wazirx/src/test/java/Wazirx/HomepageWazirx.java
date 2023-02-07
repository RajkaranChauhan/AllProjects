package Wazirx;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import resources.ExcelOutput;

public class HomepageWazirx extends Driver {
	
/*	WebDriver driver;
	
	public HomepageWazirx()
	{
	Driver dr=new Driver();
	dr.getDriver();
	}
	
	*/
	String purchaseAmount;
	String numberOfTrans;
	int purchaseSize;
	int sellSize;
	String coinName;
	
	
	
	ExcelOutput excel=new ExcelOutput();
	
	@Test
	public void getHomePage() throws InterruptedException, IOException
	{
		driver.get("https://wazirx.com/exchange/BTC-INR");
		driver.manage().window().maximize();
		
		PageObjectHomepageWazirx obj=new PageObjectHomepageWazirx(driver);
		
		Thread.sleep(3000);
		
		obj.getLoginButton().click();
		Thread.sleep(3000);
		obj.getEmail().sendKeys("raj.gamebegins@gmail.com");
		obj.getPassword().sendKeys("N@ughty1#");
		Thread.sleep(1500);
		obj.getLogin().click();
		Thread.sleep(5000);
		
		obj.getFavo().click();
		obj.getCompleteOrdersTab().click();
		obj.getSameOrderToggle().click();	
		obj.getHideCancelledOrder().click();
		
		List<WebElement> favoCoins =obj.getListOfFavoCoins(); //webElements of favo coins
		List<Object> favoCoinsList =favoCoins.stream().map(s->s.getText()).sorted().collect(Collectors.toList()); //getting the name of favo coins in list	
	
		System.out.println("The coins available in favo tabs are listed below");
		favoCoinsList.forEach(s->System.out.println(s));
		
		///creating excel template
		excel.setExcelTemplate(favoCoinsList);
		
				
		favoCoins.forEach(s->{
							s.click();
			{  
				
					try {  
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
					coinName=obj.getSelectedCoinName().getText();
					coinName=coinName.replaceAll("[^a-zA-Z0-9]", "-"); 
				//System.out.println( obj.getSelectedCoinName().getText());// Selected coin from favo list is displayed here
					System.out.println(coinName);
					
				
					
				System.out.println("Write methods to collect all the data for each coin here");
// Getting the information of BUY and SELL Amount of coin per transaction	
		//BUY zone
				
				
				
	///running java scrip to scroll the window of the order execution			
				
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("document.querySelector('.sc-bUrLeq').scrollTop=5000");  
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e6) {
					// TODO Auto-generated catch block
					e6.printStackTrace();
				}
				js.executeScript("document.querySelector('.sc-bUrLeq').scrollTop=5000"); //sc-JoojE
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e5) {
					// TODO Auto-generated catch block
					e5.printStackTrace();
				}
				js.executeScript("document.querySelector('.sc-bUrLeq').scrollTop=5000"); 
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
				js.executeScript("document.querySelector('.sc-bUrLeq').scrollTop=5000");  
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				js.executeScript("document.querySelector('.sc-bUrLeq').scrollTop=5000"); //sc-JoojE
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				js.executeScript("document.querySelector('.sc-bUrLeq').scrollTop=5000"); 
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
				
				purchaseSize=obj.getAmountPurchaseOrder().size();
				System.out.println(	"***Amount of Purchase size is*** " + purchaseSize);	
			 
					 if (purchaseSize>0)
					 {
						 List<WebElement> amountPurchaseOrder = obj.getAmountPurchaseOrder(); //Amount
						 List<WebElement> pricePurchaseOrder = obj.getPricePurchaseOrder();//driver.findElements(By.cssSelector("div.dQnuZq span#open-order-price")); //price
						 List<WebElement> totalPurchaseInINR = obj.getTotalPurchaseInINR();//driver.findElements(By.cssSelector("div.dQnuZq div[class='sc-gsTEea sc-cvJIAo inxVVg ieTGnb'] span[class='sc-bdfBQB gkKhNv']")) ; //price
						 
					//	int insertAmountAtRow =0;
		
						 
						 List<String> amountPurchaseOrderList = amountPurchaseOrder.stream().map(amt->amt.getText()).collect(Collectors.toList());
						 List<String> pricePurchaseOrderrList = pricePurchaseOrder.stream().map(v->v.getText()).collect(Collectors.toList());
						 List<String> totalPurchaseInINRList = totalPurchaseInINR.stream().map(v->v.getText()).collect(Collectors.toList());
						// List<String> totalPurchaseInINRList = totalPurchaseInINR.stream().map(v->v.getText()).sorted().collect(Collectors.toList());
						 
//Writing amount of purchase in excel						 
						 amountPurchaseOrderList.forEach(v->System.out.println("Amount Of coin purchsed: "+v));
						 int insertAmountAtCell=0; 
						 try {
							 
							//Creating rows in excel for each tab based on the number of transaction 
							 System.out.println("---------------------------------row crated in excel for Purchase--------------------");	
							 excel.getRowCreator( coinName,amountPurchaseOrderList);
						
							 System.out.println("************########Amout excell call###########***********");
							 
							excel.SetDataInExcel(coinName,amountPurchaseOrderList,insertAmountAtCell);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 
//Writing Price of purchase in excel							 
						 pricePurchaseOrderrList.forEach(v->System.out.println("Price Of coin purchsed: "+v));
						 int insertPriceAtCell=1; 
						 try {
							 System.out.println("************########Price excell call###########***********");
							 
							excel.SetDataInExcel(coinName,pricePurchaseOrderrList,insertPriceAtCell);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 
//Writing Purchase in INR of purchase in excel						 
						 totalPurchaseInINRList.forEach(v->System.out.println("Total purchase in INR: "+v));
						 int insertINRAtCell=2;  
						 try {
							 System.out.println("************########INR excell call###########***********");
							excel.SetDataInExcel(coinName,totalPurchaseInINRList,insertINRAtCell);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 
///////////////////////////////was trying to run the loop to write data in excel but the out put was not as per the requirement						 
/*						 totalPurchaseInINRList.forEach
						 (INR->{
								 System.out.println(INR);
								 
								 int insertAmountAtCell=2;
								 try   {
									 
											excel.SetDataInExcel(coinName,insertAmountAtCell,INR);
											//	insertAmountAtRow=insertAmountAtRow+1;
										}
								 catch (IOException e) 
								 		{
											// TODO Auto-generated catch block
											e.printStackTrace();
								 		}
						 });
						 
					*/	 
					 }
					 else
					 {
						 System.out.println("No coin Purchased");
					 }
				
		//SELL zone	 
					 if (purchaseSize>0)
				 {
					
//						 sellSize=driver.findElements(By.cssSelector("div.fSpTxq")).size();
						 sellSize=obj.getAmountSellOrder().size();
						 System.out.println("***Amount of Sell size is*** "  + sellSize);	
							 if (sellSize>0)
							 {
								List<WebElement> amountSellOrder =obj.getAmountSellOrder();
//								List<WebElement> numberOfSellRequest =driver.findElements(By.cssSelector("div.fSpTxq")); 
								List<WebElement> priceSellOrder = obj.getPriceSellOrder();//driver.findElements(By.cssSelector("div.guZCFG span#open-order-price")); //price
								List<WebElement> totalSellInINR = obj.getTotalSellInINR();//driver.findElements(By.cssSelector("div.guZCFG div[class='sc-gsTEea sc-cvJIAo inxVVg ieTGnb'] span[class='sc-bdfBQB gkKhNv']")) ; //price
								
								
								List<String> amountSellOrderList = amountSellOrder.stream().map(v->v.getText()).collect(Collectors.toList());
								List<String> priceSellOrderList = priceSellOrder.stream().map(v->v.getText()).collect(Collectors.toList());
								List<String> totalSellInINRList = totalSellInINR.stream().map(v->v.getText()).collect(Collectors.toList());
								
								
//Writing amount of S in excel								
								amountSellOrderList.forEach(v->System.out.println("Amount Of coin Sell: "+v));

								 int insertAmountAtCell=3; 
								 try {
									 
									//Creating rows in excel for each tab based on the number of transaction 
									 //This is already done in purchase oreder 
									// System.out.println("---------------------------------row crated in excel for Purchase--------------------");	
									// excel.getRowCreator( coinName,amountPurchaseOrderList);
								
									 System.out.println("************########Amout excell call###########***********");
									excel.SetDataInExcel(coinName,amountSellOrderList,insertAmountAtCell);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								 
								 
								
								
								
								
								
								
//Writing Price of Sell in excel
								priceSellOrderList.forEach(v->System.out.println("Price Of coin Sell: "+v));
								 int insertPriceAtCell=4; 
								 try {
									 System.out.println("************########Price excell call###########***********");
									 
									excel.SetDataInExcel(coinName,priceSellOrderList,insertPriceAtCell);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								 								
								
								
								
								
//Writing Purchase in INR of purchase in excel								
								totalSellInINRList.forEach(v->System.out.println("Total Sell in INR: "+v));
								int insertINRAtCell=5;  
								 try {
									 System.out.println("************########INR excell call###########***********");
									excel.SetDataInExcel(coinName,totalSellInINRList,insertINRAtCell);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								 
								 
								
								
							 }
							 else
							 {
								 System.out.println("No coin to Sell");
							 }
				 }
				 else
				 {
					 System.out.println("No coin Purchased, so no coin to sell");
				 }
					
			//		 (coin)
			
			}
			   });
			
			
			

}
	
}
