package Resource;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;







public class DriverDefine {
	
	String browser;
	public WebDriver driver;
	
	
	/*public DriverDefine(String browser) 
	{
	this.browser=browser;

	}
	*/


	public String getBrowser() throws IOException
	{
		System.out.println("i'm  dd getbrowser");
		Dataprop dp=new Dataprop();
		 browser=dp.getBrowser();
		return browser;
	}
	
	

	public    WebDriver getDriver() throws IOException
	{System.out.println("i'm  setdriver");
		browser=getBrowser();
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Dev\\chromedriver_win32\\chromedriver.exe");
			 driver= new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			//syntext for firefox driver
		}
		else if(browser.equals("ie"))
		{
			//syntext for ie driver
		}
	//	driver.get("http://www.qaclickacademy.com/");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println(driver +"123");
		
		return driver;
		
	//	Homepage hp=new Homepage(driver);
		
			
	}

/*	@AfterClass
	public void driverClose()
	{
		driver.close();
	}
*/
	
	  
}
