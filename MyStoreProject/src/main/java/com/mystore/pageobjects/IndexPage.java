package com.mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionClass.ActionClass;
import com.mystore.base.BaseClass;

public class IndexPage //extends BaseClass
{
	WebDriver driver;
	ActionClass action =new ActionClass();
	
	public  IndexPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		System.out.println(driver+"IndexPage");
	}	
	
	
	
//	By signInButton=By.className("login");
//	By logo=By.className("logo");
//	By searchBox=By.cssSelector("input.search_query");
//	By searchButton=By.name("submit_search");
	
	@FindBy(css="a[class='login']")
	WebElement signInButton;
	
	By  signInButton1= By.xpath("//a[@class='login']");
	
	@FindBy(css="img[class='logo img-responsive']")  
	WebElement logo;
	
	@FindBy(css="input.search_query")
	WebElement searchBox;
	
	@FindBy(name="submit_search")
	WebElement searchButton;
	
	
	
	
	
	public LoginPage clickOnSignInButton() throws InterruptedException
	{		
		System.out.println(driver+"clickOnSignInButton");
		Thread.sleep(2000);
		driver.findElement(signInButton1).click();
		System.out.println(driver+"clickOnSignInButton is clicked");
		return new LoginPage(driver);
	}
	
	public boolean validateLogo()
	{  
		return action.isDisplayed( logo);
	}
	
	public SearchResultPage SearchProduct(String text)
	{
		action.type(searchBox,text);
		action.click(driver, searchButton);
		return new SearchResultPage();	
	}
	
	
	
	
}
