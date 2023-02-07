package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionClass.ActionClass;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass
{
	ActionClass action =new ActionClass();
	public void SearchResultPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="//img[@title='Faded Short Sleeve T-shirts']")	WebElement productSearched ;
	
	public boolean productAvailiablityTest()
	{
		return action.isDisplayed(productSearched);
	}
	
	public AddToCartPage productSelected()
	{
		action.click(driver, productSearched);
		return new AddToCartPage();
	}
}
