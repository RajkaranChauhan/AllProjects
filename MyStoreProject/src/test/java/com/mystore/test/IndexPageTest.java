package com.mystore.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass
{
	IndexPage index;
	//WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		
		launchApp();
	//	driver=getDriver();
	}
	
	@AfterMethod
	public void tearDown()
	{
		getDriver().quit();
	}
	
/*	@Test
	public void validateLogo() throws InterruptedException
	{
		getvalidateLogo(driver);
	}
	*/
	
	//public void getvalidateLogo(WebDriver driver) throws InterruptedException
	@Test
	public void getvalidateLogo() throws InterruptedException
	{
		 index=new IndexPage(getDriver());
		boolean result=index.validateLogo();
		Assert.assertTrue(result);
	}

}
