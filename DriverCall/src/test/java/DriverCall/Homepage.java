package DriverCall;
import java.io.IOException;


import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import PageObject.PomHomePage;
import Resource.Dataprop;
import Resource.DriverDefine;


public class Homepage extends DriverDefine {//extends DataProperties{
	WebDriver driver ;
	Dataprop dp;
//	Homepage hp=new Homepage();
//	public static Logger log=LogManager.getLogger(Base.class.getName());
//	public static Logger log = LogManager.getLogger(Base.class.getName());
	
//	public Homepage() throws IOException
//	{
	//	System.out.println("i'm Homepage ");
		//System.out.println("i'm homepage const ");
//		 dp=new Dataprop();
//	driver=dp.getDriver();
	//log.info("homepage constractor ");
//	}
	
/*
	public WebDriver getDriver() throws IOException
	{	System.out.println("i'm  homepage getdriver");
		return driver;
	
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
	 public void homepage() throws IOException
	 {
		getHomePage(driver);
	 }
	
	public void getHomePage(WebDriver driver) throws IOException
	{
	//	driver=getDriver();
		
	//	System.out.println("i'm  gethomepage");
		dp=new Dataprop();
	//	driver=dp.getDriver();
		
		driver.manage().window().maximize();
	//	log.info("maximize window");
		 driver.get(dp.getURL());
	//	 log.info("getting url of home page");
		
	PomHomePage php=new PomHomePage(driver);
//	Loginpage lp=new Loginpage(driver);
	
	php.getLoginButton().click();
//	 driver = dp.getDriver();

	
	}
	
	@AfterMethod
	public void browserClose()
	{
		System.out.println("closing driver from homepage by using @Aftertest");
		driver.close();
	}
	
	
	
	

}
