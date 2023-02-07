package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.mystore.actionClass.ActionClass;

public class BaseClass 
{

	
	public static Properties prop;
	public WebDriver driver;
	
	@BeforeTest
	public void getConfigProperties() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\Configuration\\Config.properties";
	
		FileInputStream fis=new FileInputStream(path);
		
		 prop=new Properties();
		prop.load(fis);
		
	}
	
	public void launchApp()
	{
		String browseName=prop.getProperty("browser") ;
		if (browseName.equals("chrome"))
			{
			System.out.println("Browser selected is Chrome");
			String driverPath= System.getProperty("user.dir")+"\\Webdriver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",driverPath);
			driver=new ChromeDriver();
			}
		else if(browseName.equals("firefox"))
			{
			System.out.println("Browser selected is Firefox");
			}
		else if(browseName.equals("ie"))
			{
			System.out.println("Browser selected is ie");
			}
		driver.manage().window().maximize();
		ActionClass.implicitlWait( driver,10);
		ActionClass.pageLoadTimeOut(driver,30);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}
	

}
