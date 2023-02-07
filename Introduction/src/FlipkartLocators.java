import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;





public class FlipkartLocators {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		LaunchBrowser lb=new LaunchBrowser();
		
		lb.browserLaunch();
	/*	
		lb.driver.get("https://www.flipkart.com/");
		//lb.driver.manage().window().maximize();
		
		//lb.driver.findElement(By.className("_2IX_2- VJZDxU")).sendKeys("9595591894");
		lb.driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("9595591894");
		lb.driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("1");
	//	lb.driver.findElement(By.className("_2KpZ6l _2HKlqd _3AWRsL")).click(); /// login button
		//_2KpZ6l _2HKlqd _3AWRsL
		lb.driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")).click();
		
		//Thread.sleep(5000);
		
		String failure= lb.driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/span[3]/span")).getText();
	//	Thread.sleep(5000);
		
		System.out.println(failure);
		//lb.driver.close();
*/
	/*	lb.driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		Thread.sleep(2000);
		//Assert.assertTrue(1==1);
		System.out.println(lb.driver.findElement(By.xpath("//input[@id='checkBoxOption1'] ")).isSelected());
		 Assert.assertFalse(lb.driver.findElement(By.xpath("//input[@id='checkBoxOption1'] ")).isSelected());
		lb.driver.findElement(By.xpath("//input[@id='checkBoxOption1'] ")).click();
		
		System.out.println(lb.driver.findElement(By.xpath("//input[@id='checkBoxOption1'] ")).isSelected());
		 Assert.assertTrue(lb.driver.findElement(By.xpath("//input[@id='checkBoxOption1'] ")).isSelected());
		 
		lb.driver.findElement(By.xpath("//input[@id='checkBoxOption1'] ")).click();
		System.out.println(lb.driver.findElement(By.xpath("//input[@id='checkBoxOption1'] ")).isSelected());
		 Assert.assertFalse(lb.driver.findElement(By.xpath("//input[@id='checkBoxOption1'] ")).isSelected());
		
	System.out.println(	lb.driver.findElements(By.xpath("//input[@type='checkbox']")).size());
	Assert.assertEquals(lb.driver.findElements(By.xpath("//input[@type='checkbox']")).size(), 3);
	
	*/
		
		lb.driver.get("https://rahulshettyacademy.com/angularpractice/");
/*		Thread.sleep(2000);
		lb.driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Raj Karan Chauhan");
		lb.driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Raj@gmail.com");
		lb.driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
		lb.driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();
		
		
		WebElement StaticDropdown = lb.driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));
		Select dropdown=new Select(StaticDropdown);
		//select[@id='exampleFormControlSelect1']
		dropdown.selectByIndex(1);
		
		lb.driver.findElement(By.xpath("//input[@id='inlineRadio1']")).click();		
		lb.driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("01-01-2000");
		lb.driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		System.out.println(lb.driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
		
*/		
		System.out.println(lb.driver.findElement(By.cssSelector(".navbar-brand")).isDisplayed());
		WebElement element1=lb.driver.findElement(By.cssSelector(".navbar-brand"));
		WebDriver dirver=lb.driver;
		
		findElement(dirver,element1);
		
		
		lb.driver.close();
	
		}
		
		
		
		

		
	
		
		
	

public static void   findElement(WebDriver driver,WebElement element)
{
	boolean flag=false;
	
	try 
	{
		element.isDisplayed();
		//flag=true;
		System.out.println("1");
	}
	catch (Exception e)
	{
		flag=false;
		System.out.println("2");
	}
	finally
	{
		if (flag)
		{
			System.out.println(flag);
			System.out.println("Found element");
		}
		else
		{
			System.out.println("Unalbe to locate element");
		}
	}
	
	//return;

}


}
