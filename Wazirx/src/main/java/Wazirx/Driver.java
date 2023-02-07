package Wazirx;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	
	WebDriver  driver;
	
	@SuppressWarnings("deprecation")
	public Driver()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Dev\\chromedriver_win32\\chromedriver.exe");
		  driver= new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}

}
