package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	private WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	private By userName= By.xpath("//input[@id='username']");
	private By password = By.id("password");
	private By loginButton= By.xpath("//input[@name='login']");
	private By lostYourPassword = By.xpath("//a[@href='https://11practice.automationtesting.in/my-account/lost-password/']");
	
	
	public String loginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean lostYourPasswordLinkExists()
	{
		return driver.findElement(lostYourPassword).isDisplayed();
	}
	
	public void enterUserName(String username)
	{
		driver.findElement(userName).sendKeys(username);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLoginButton()
	{
		driver.findElement(loginButton).click();
	}
	
	public MyAccountPage doLogin(String username, String pwd)
	{
		driver.findElement(userName).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		
		// ********************IMPORTANT STEP*********************
		return new MyAccountPage(driver);
	}
	
	
}
