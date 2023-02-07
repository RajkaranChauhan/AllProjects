package WazirScroll;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;



public class HomepageWazirx extends Driver {
	

	String purchaseAmount;
	String numberOfTrans;
	int purchaseSize;
	int sellSize;
	String coinName;
	
	
	
	
	
	@Test
	public void getHomePage() throws InterruptedException, IOException
	{
		driver.get("https://wazirx.com/exchange/BTC-INR");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("document.querySelector('.sc-JoojE').scrollTop=5000");
		
		
	/*	obj.getLoginButton().click();
		Thread.sleep(3000);
		obj.getEmail().sendKeys("raj.gamebegins@gmail.com");
		obj.getPassword().sendKeys("N@ughty1#");
		Thread.sleep(1500);
		obj.getLogin().click();
		Thread.sleep(5000);
		
		obj.getFavo().click();
		obj.getCompleteOrdersTab().click();
		obj.getSameOrderToggle().click();	
		obj.getHideCancelledOrder().click();
		
		List<WebElement> favoCoins =obj.getListOfFavoCoins(); //webElements of favo coins
		List<Object> favoCoinsList =favoCoins.stream().map(s->s.getText()).sorted().collect(Collectors.toList()); //getting the name of favo coins in list	
	
		System.out.println("The coins available in favo tabs are listed below");
		favoCoinsList.forEach(s->System.out.println(s));
		*/
	
				
	
			
			
			


	
}
}
