package Automation.Reporting;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report1 {
	
	ExtentReports extend;
	
	@BeforeTest
	public void config()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		
		reporter.config().setReportName("AutomationReport");
		reporter.config().setDocumentTitle("Test");
		
		 extend=new ExtentReports();
		extend.attachReporter(reporter);
		extend.setSystemInfo("Tester", "Raj");
		
	}
	
	
	
	
	
	
	@Test
	public void browserLaunch()
	{
		extend.createTest("InitialDemoTest");
		
		System.setProperty("webdriver.chrome.driver", "D:\\Dev\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		
		extend.flush();
		
	}

}
