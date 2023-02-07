package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionClass.ActionClass;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass
{
	ActionClass action =new ActionClass();
	public void AddressPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button[name='processAddress']")  WebElement proceedToCheckout;
	
	public ShippingPage proceedToCheckout()
	{
		action.click(driver, proceedToCheckout);
		return new ShippingPage();
	}

}
