package DriverCall;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import PageObject.PomLoginPage;
import Resource.Dataprop;
import Resource.DriverDefine;


public class Loginpage extends DriverDefine { //extends Homepage {
	
	WebDriver driver ;
//	public static Logger log = LogManager.getLogger(Base.class.getName());
//	Dataprop dp;
/*	
//	@Test(dataProvider="getLoginDetails")
	
	public Loginpage() throws IOException {
		 dp=new DataProperties();
		driver=dp.getDriver(); /// when passing driver through here then xpath is not recogonied why? 
		//Ans: it was because it was creating two driver one thought the class const and other through obj call of class Homepage hp=new Homepage(); and the system gets confused between the driver and resutls in xpatth error
		
	}
*/
	@BeforeMethod
	public void setDriver() throws IOException
	{
//		System.out.println("0213");
//		System.out.println(prop.getProperty("URL"));
//		driver.get(prop.getProperty("URL"));
		driver=getDriver();	
		}
	
	@Test
	public void callingLoginPage() throws InterruptedException//(String name, String Password, String sequence) throws InterruptedException, IOException
, IOException
	{
		System.out.println("i'm  calling loginpage");
		Homepage hp=new Homepage();
//		driver=hp.getDriver();
//		log.info("setting driver for loginpage");
//		dp=new Dataprop();
//		driver=dp.getDriver();
//		hp.setDriver();
		hp.getHomePage(driver);
		PomLoginPage plp=new PomLoginPage(driver);
		
		//PomLoginPage plp =new PomLoginPage(driver);
	Thread.sleep(2000);
		plp.getEmailAddress().sendKeys("raj"); //raj
//	log.info("sending username ");
		Thread.sleep(2000);
		
		plp.getPassword().sendKeys("123");
//		log.info("sending password ");
	Thread.sleep(2000);
		System.out.println("sequence");  //first
		plp.getLogIn().click();
		Thread.sleep(2000);
	}
/*	
	@DataProvider
	public Object[][] getLoginDetails()
	{
		Object[][] data= new Object[1][3];  // Object[3][3]
		data[0][0]= "raj";
		data[0][1]= "123";
		data[0][2]= "first";
	
		data[1][0]= "karan";
		data[1][1]= "567";
		data[1][2]= "second";
		
		data[2][0]= "chauhan";
		data[2][1]= "999";
		data[2][2]= "third";
	
	//	return data;
		
	}
	*/
	@AfterMethod
	public void browserClose()
	{
		driver.close();
	}
	
	
	
}
