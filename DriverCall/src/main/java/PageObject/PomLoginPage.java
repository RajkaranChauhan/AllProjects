package PageObject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomLoginPage {

	
	WebDriver driver;
	
	
	public PomLoginPage (WebDriver driver)
	{
		this.driver= driver;
		System.out.println("driver");
	//	PageFactory.initElements(driver, this);
	}
	
/*	
	@FindBy(xpath="//a[@href=\"password/new/index.php\"]")
	WebElement emailAddress;
	
	public WebElement getEmailAddress()
	{System.out.println(driver+"456");
		System.out.println("email");
		return emailAddress;
	}
*/	

	
By emailAddress= By.xpath("//input[@id=\"user_email\"]");
//	By emailAddress = By.cssSelector("input[type=email]");
By password= By.xpath("//input[@id=\"user_password\"]");
By logIn= By.xpath("//input[@type=\"submit\"]");


	
	
	public WebElement getEmailAddress()
	{
		System.out.println("email");
		return driver.findElement(emailAddress);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getLogIn()
	{
		return driver.findElement(logIn);
	}
	
	
	
	
	
}
