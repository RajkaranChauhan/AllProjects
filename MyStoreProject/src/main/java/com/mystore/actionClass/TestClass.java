package com.mystore.actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestClass 
{
	public WebDriver driver;
	ActionClass action =new ActionClass();
	
	@Test
	public void getTest() throws InterruptedException
	{
		String driverPath= System.getProperty("user.dir")+"\\Webdriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",driverPath);
		driver=new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		
		
		driver.manage().window().maximize();
		action.implicitlWait( driver,10);
		action.pageLoadTimeOut(driver,30);
		driver.get("http://automationpractice.com/index.php");
		

		
		System.out.println(driver.findElement(By.cssSelector("img[class='logo img-responsive']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//a[@class='login']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//a[@class='login']")).isEnabled());
	Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(null))
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='login']")));	
	//	WebElement element = driver.findElement(By.xpath("//a[@class='login']"));
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='login']")));
		driver.findElement(By.xpath("//a[@class='login']")).click();
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.page-heading")));
	//	element.click();
		System.out.println("button clicked");
		Thread.sleep(5000);
	}

}
