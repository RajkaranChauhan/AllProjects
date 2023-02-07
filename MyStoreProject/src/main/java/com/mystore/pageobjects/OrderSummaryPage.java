package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionClass.ActionClass;
import com.mystore.base.BaseClass;

public class OrderSummaryPage extends BaseClass
{
	ActionClass action =new ActionClass();
	public void OrderSummaryPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="p#cart_navigation button[type='submit']")	WebElement orderConfirm;
	
	public OrderConfirmationPage orderConfirmBtn()
	{
		action.click(driver, orderConfirm);
		return new OrderConfirmationPage();
	}

}
