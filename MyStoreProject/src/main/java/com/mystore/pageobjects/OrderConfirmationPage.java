package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionClass.ActionClass;
import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass
{
	ActionClass action =new ActionClass();
	public void OrderConfirmation()
	{
		PageFactory.initElements(driver,this);
	}

	@FindBy(css="//strong[text()='Your order on My Store is complete.']")	WebElement orderConfirmMsg;
	
	public String orderConfirmMessage()
	{
		String confirmationmsg=action.getText(orderConfirmMsg);
		return confirmationmsg;
	}
}
