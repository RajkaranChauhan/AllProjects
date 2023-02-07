package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionClass.ActionClass;
import com.mystore.base.BaseClass;

public class SummaryPage extends BaseClass  
{
	ActionClass action =new ActionClass();
	public void SummaryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cart_unit span span[class='price']")	WebElement unitPrice ;
	@FindBy(css="span[id='total_price']")	WebElement totalPrice ; 
	@FindBy(css="p[class='cart_navigation clearfix'] a[title='Proceed to checkout']")	WebElement btnProceedToCheckout ; 
	
	
	 public double unitPrice()
	 {
		 String unitPricevalue= action.getText(unitPrice);
		String unit= unitPricevalue.replaceAll("[^a-zA-Z0-9]", "");
		
		double finalunitPrice= Double.parseDouble(unit);
		return finalunitPrice/100; /// as in replaceAll function we have replaced all the special char so dot was also removed here in the unit price
	 }

	 public double totalPrice()
	 {
		 String totalvalue= action.getText(totalPrice);
		String total= totalvalue.replaceAll("[^a-zA-Z0-9]", "");
		
		double finaltotalPrice= Double.parseDouble(total);
		return finaltotalPrice/100; /// as in replaceAll function we have replaced all the special char so dot was also removed here in the unit price
	 }
	 
	 public LoginPage proceedToCheckout()
	 {
		 action.click(driver, btnProceedToCheckout);
		 return new LoginPage(driver);
	 }

}
