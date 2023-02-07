package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionClass.ActionClass;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass
{
	ActionClass action =new ActionClass();
	public void HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css=".icon-heart")	WebElement myWishList ;
	@FindBy(css=".icon-list-ol")	WebElement orderHistory ;
	
	
	public boolean validateMyWishList()
	{
		return action.isDisplayed(myWishList);
	}
	public boolean validateOrderHistory()
	{
		return action.isDisplayed(orderHistory);
	}
	public String getCurrentURL()
	{
	 return driver.getCurrentUrl();
	}
	
	
	
	
}
