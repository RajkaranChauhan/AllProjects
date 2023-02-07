package com.mystore.actionClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.base.BaseClass;

public class ActionClass extends BaseClass 
{
	///Waits and pagexx load
	public static  void implicitlWait(WebDriver driver,int timeOut)
	{
		driver.manage().timeouts().implicitlyWait(timeOut,TimeUnit.SECONDS);
	}
	
	public static  void pageLoadTimeOut(WebDriver driver,int timeOut)
	{
		driver.manage().timeouts().pageLoadTimeout(timeOut,TimeUnit.SECONDS);
	}
	public void explicitWait(WebDriver driver, WebElement element, int timeOut ) 
	{
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void PageLoadTillElementVisiable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	
	///Actions class
	public  boolean findElement(WebElement element)
	{
		boolean flag=false;
		
		try 
		{
			element.isDisplayed();
			flag=true;
		}
		catch (Exception e)
		{
			flag=false;
		}
		finally
		{
			if (flag)
			{
				System.out.println("Found element");
			}
			else
			{
				System.out.println("Unalbe to locate element");
			}
		}
		
		return flag;
	}
	
	
	public  boolean isDisplayed(WebElement element)
	{
		boolean flag=false;
		flag=findElement(element);
		
		if(flag)
		{
			flag=element.isDisplayed();
			if(flag)
			{
				System.out.println("Element is Displayed");
			}
			else
			{
				System.out.println("Element is not displayed");
			}
		}
		else 
		{
			System.out.println("Element is not Present");
		}
		return flag;
		
	}
	
	
	public  void click(WebDriver driver,WebElement element)
	{
		System.out.println(driver+"click");
		Actions action=new Actions(driver);
		System.out.println(element+"click webelement");
		System.out.println(element.isDisplayed());
		action.moveToElement(element).click().build().perform();
	//	element.click();
	}
	
	public  void type(WebElement element,String text)
	{
		boolean flag=false;
		
		
		try
		{
			flag=element.isDisplayed();
			element.click();
			element.clear();
			element.sendKeys(text);
			flag=true;
		}
		catch (Exception e)
		{
			flag=false;
			System.out.println("text box is not Present to text ");
		}
		finally
		{
			if(flag)
			{
				System.out.println("Successfuly text entred in text box");
			}
			else
			{
				System.out.println("Failed to enter text in text box");
			}
		}
	}
	
	
	public  boolean selectByVisiableText(WebElement element, String visiabletext)
	{
		boolean flag=false;
		
		try
		{
			Select s=new Select(element);
			s.selectByVisibleText(visiabletext);
			flag=true;
			
		}
		catch (Exception e)
		{
			flag=false;
		}
		finally
		{
			if(flag)
			{
				System.out.println("Option is selected by visiable Text");
			}
			else
			{
				System.out.println("Option is NOT selected by visiable Text");
			}
		}
		return flag;
	}
	
	public  String getText(WebElement element)
	{
		boolean flag=false;
		String text=null;
		
		try
		{
			text=element.getText();
			flag=true;
		}
		catch (Exception e)
		{
			flag=false;
		}
		
		finally
		{
			if(flag)
			{
				System.out.println("Text of the WebElement is captured");
			}
			else
			{
				System.out.println("Text of the WebElement was NOT captured");
			}
			
		}
		return text;
	}
	
	public  void screenshots(WebDriver driver, String fileName) throws IOException
	{
		String currentDate=date();
		String path= System.getProperty("user.dir")+"\\Screenshots"+fileName+"_"+currentDate+".png";
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(path));
		try 
		{
			FileUtils.copyFile(source, new File(path));
		}
		catch (Exception e)
		{
			e.getMessage();
		}
	}
	
	public static String date()
	{
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		return date;
	}
	
		
	
	

}
