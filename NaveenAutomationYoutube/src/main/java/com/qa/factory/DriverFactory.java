package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;


public class DriverFactory 
{
	//public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<>();
	
	public WebDriver init_driver(String browser)
	{System.out.println("2");
		System.out.println("The browser is =" + browser);
		if(browser.equals("chrome"))
		{
			//System.out.println("it is inside chrome browser method");
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
			System.out.println("3");
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
			
		}
		else 
		{
			System.out.println("Please pass the correct browser value: " +browser);
		}
		System.out.println("4");
		getDriver().manage().deleteAllCookies();
		System.out.println("5");
		getDriver().manage().window().maximize();
		System.out.println("6");
		return getDriver();
	}
 
	//Sync word is use as in multiple thread every thing runs in sync
	public synchronized static WebDriver getDriver()
	{System.out.println("1");
		return tlDriver.get();
		
	}
	
}
