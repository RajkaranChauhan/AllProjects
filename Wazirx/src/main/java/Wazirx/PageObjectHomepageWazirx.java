package Wazirx;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectHomepageWazirx {
	
	WebDriver driver;  
	
	public PageObjectHomepageWazirx(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By loginButton= By.xpath("//button/span[text()='Login']");   //span[@class='sc-bdfBQB itBswf']      //span[@class=\"sc-gsTEea kPVhwL\"]    sc-dlfnuX hLZtIz   sc-gsTEea kPVhwL
	By email= By.xpath("//input[@type=\"email\"]");
	By password= By.xpath("//input[@type=\"password\"]");
	By login= By.xpath("//button[@type=\"submit\"]");
	By favo= By.xpath("//i[@class=\"mdi mdi-star\"]");
	By completeOrdersTab= By.xpath("//h6[@id=\"completed-orders\"]");
	By sameOrderToggle= By.xpath("//span[@id=\"btc-inr-order-toggle\"]");
	By hideCancelledOrder= By.xpath("//*[contains(text(),\"Hide Cancelled Orders\")]");
	By listOfFavoCoins= By.xpath("//span[@class=\"market-name-text\"]");
	By selectedCoinName= By.xpath("//h1[@id=\"selected-coin-market-chart-section\"]");

	
	By amountPurchaseOrder=By.cssSelector("div.ljOlGC span#open-order-amount span.underline");  ///sc-gsTEea sc-kmATbt hBDsMD dQnuZq  // sc-bdfBQB sc-iIEXtl bPoXNP ljOlGC
	By amountSellOrder=By.cssSelector("div.fSpTxq span#open-order-amount span.underline");   ///sc-gsTEea sc-kmATbt hBDsMD guZCFG   //sc-bdfBQB sc-iIEXtl bPoXNP fSpTxq
	
	By pricePurchaseOrder=By.cssSelector("div.ljOlGC span#open-order-price");
	By priceSellOrder=By.cssSelector("div.fSpTxq span#open-order-price");
	
	By totalPurchaseInINR=By.cssSelector("div.ljOlGC div[class='sc-bdfBQB sc-gsBqHK gfvmec dGHxkH'] span[class='sc-gsTEea ZGYHn']");  //sc-bdfBQB sc-aKXVD kFyjUl dYQZJd//span[class='sc-gsTEea ZGYHn']
	By totalSellInINR= By.cssSelector("div.fSpTxq div[class='sc-bdfBQB sc-gsBqHK gfvmec dGHxkH'] span[class='sc-gsTEea ZGYHn']");
	
	
	

	public WebElement getLoginButton()
	{
		return driver.findElement(loginButton);
	}
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	public WebElement getFavo()
	{
		return driver.findElement(favo);
	}
	public WebElement getCompleteOrdersTab()
	{
		return driver.findElement(completeOrdersTab);
	}
	public WebElement getSameOrderToggle()
	{
		return driver.findElement(sameOrderToggle);
	}
	public WebElement getHideCancelledOrder()
	{
		return driver.findElement(hideCancelledOrder);
	}
	public List<WebElement> getListOfFavoCoins()
	{
		return  driver.findElements(listOfFavoCoins); //here findelements are used as more then one order were present
	}
	public WebElement getSelectedCoinName()
	{
		return  driver.findElement(selectedCoinName);
	}
	public List<WebElement> getAmountPurchaseOrder()
	{
		return  driver.findElements(amountPurchaseOrder); //here findelements are used as more then one order were present
	}
	public List<WebElement> getAmountSellOrder()
	{
		return  driver.findElements(amountSellOrder); //here findelements are used as more then one order were present
	}
	public List<WebElement> getPricePurchaseOrder()
	{
		return  driver.findElements(pricePurchaseOrder); //here findelements are used as more then one order were present
	}
	public List<WebElement> getPriceSellOrder()
	{
		return  driver.findElements(priceSellOrder); //here findelements are used as more then one order were present
	}
	public List<WebElement> getTotalPurchaseInINR()
	{
		return  driver.findElements(totalPurchaseInINR); //here findelements are used as more then one order were present
	}
	public List<WebElement> getTotalSellInINR()
	{
		return  driver.findElements(totalSellInINR); //here findelements are used as more then one order were present
	}

}
