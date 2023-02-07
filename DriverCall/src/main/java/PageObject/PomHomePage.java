package PageObject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class PomHomePage {
	
	WebDriver driver;
	
	public PomHomePage (WebDriver driver) throws IOException
	{
		//DataProperties dp=new DataProperties();
		//driver=dp.getDriver();
		this.driver=driver;
	
	}
	
	


	By Login= By.xpath("//a[@href=\"https://rahulshettyacademy.com/sign_in/\"]");
//	By Login= By.xpath("//a[@href=\"https://www.rahulshettyacademy.com\"]");
	By title= By.xpath("//div[@class=\"text-center\"]//h2");
	
	
	
	
	public WebElement getLoginButton()
	{
		return driver.findElement(Login);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	
	
	
	
	
}
