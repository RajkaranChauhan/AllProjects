package com.mystore.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.actionClass.ActionClass;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass
{
	IndexPage index;
	LoginPage loginpage;
	HomePage homePage;
	
//	public WebDriver driver;
	//

	@BeforeMethod
	public void setup()
	{
		launchApp();
	//	driver=getDriver();
	}
	
	@AfterMethod
	public void tearDown()
	{
	//	getDriver().close();
	}
	
/*	@Test
	public  void loginTest()
	{
		System.out.println(getDriver()+"loginTest");
		getloginTest(getDriver());
		
	}
	*/
	
	
	//public void getloginTest(WebDriver driver)
	@Test
	public void getloginTest() throws InterruptedException
	{
		System.out.println(getDriver()+"getloginTest");
		index=new IndexPage(getDriver());
		
		
		loginpage=index.clickOnSignInButton();
	
		homePage=loginpage.login(prop.getProperty("userName"), prop.getProperty("password"));
		String currentURL=homePage.getCurrentURL();
		String expectedURL="http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(currentURL, expectedURL);
		
	}
	
}
