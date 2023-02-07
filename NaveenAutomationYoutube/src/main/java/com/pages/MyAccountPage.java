package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	
	private WebDriver driver;
	
	public MyAccountPage(WebDriver driver)
	{
	this.driver=driver;	
	}
	
	private By accountSections=By.cssSelector("nav[class='woocommerce-MyAccount-navigation'] li");
	
	
	
	public String getMyAccountPageTitle()
	{
		return driver.getTitle();
	}
	
	public int getMyAccounrSectionCount()
	{
		return driver.findElements(accountSections).size();
	}
	
	public List<String> getAccountSectionsList()
	{
		List<String> MyAccountSectionContent=new ArrayList<>();
	List<WebElement>	MyAccountSectionContentList= driver.findElements(accountSections);
	
	for (WebElement e : MyAccountSectionContentList )
	{
		String text=e.getText();
		System.out.println(text);
		MyAccountSectionContent.add(text);
	}
	return MyAccountSectionContent;
	}
	
	
}
