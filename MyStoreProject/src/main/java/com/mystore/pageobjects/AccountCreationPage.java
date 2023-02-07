package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionClass.ActionClass;
import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass
{
	ActionClass action =new ActionClass();
	public void AccountCreationPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".page-heading")  WebElement createAnAccount;
	
	public boolean ValidatecreateAccountPage()
	{
		return action.isDisplayed(createAnAccount);
	}
}
