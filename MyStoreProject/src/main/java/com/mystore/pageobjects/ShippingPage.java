package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionClass.ActionClass;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass
{
	ActionClass action =new ActionClass();
	public void Shipping()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="input#cgv")	WebElement termsCheckbox;
	@FindBy(css="button[name='processCarrier']")	WebElement proceedToCheckOut;
	
	
	public void clickTrems()
	{
		action.click(driver, termsCheckbox);
	}
	
	public PaymentPage proceedToCheckout()
	{
		action.click(driver, proceedToCheckOut);
		return new PaymentPage();
	}

}
