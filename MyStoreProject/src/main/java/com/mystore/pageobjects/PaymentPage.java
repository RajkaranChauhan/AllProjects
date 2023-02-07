package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionClass.ActionClass;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass
{
	ActionClass action =new ActionClass();
	public void PaymentPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".bankwire")	WebElement payByBankWire;
	@FindBy(css=".cheque")	WebElement payByCheque;
	
	
	public OrderSummaryPage clickOnPaymentMethod()
	{
		action.click(driver, payByBankWire);
		return new OrderSummaryPage();
	}
	
}
