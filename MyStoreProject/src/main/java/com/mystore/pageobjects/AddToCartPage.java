package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionClass.ActionClass;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass
{
	ActionClass action =new ActionClass();
	public void AddToCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input#quantity_wanted")	WebElement  quantityBox;
	@FindBy(css="select#group_1")	WebElement  sizeDropdown;
	@FindBy(css="a#color_13")	WebElement  color;
	@FindBy(css="//span[text()='Add to cart']")	WebElement  addToCart;
	@FindBy(css=".icon-ok")	WebElement  productAddedToCart;
	@FindBy(css="a[class='btn btn-default button button-medium']")	WebElement  btnPproceedToCheckout;
	
	
	public void selectquantity(String quantity)
	{
		action.type(quantityBox, quantity);
	}
	public void selectSize(String size)
	{
		action.selectByVisiableText(sizeDropdown, size);
	}
	public void selectcolor()
	{
		action.click(driver, color);;
	}
	public void addToCartButton()
	{
		action.click(driver, addToCart);;
	}
	public boolean validateProductAddedToCart()
	{
		return action.isDisplayed(productAddedToCart);
	}
	public SummaryPage proceedToCheckout()
	{
		action.click(driver, btnPproceedToCheckout);
		return new SummaryPage();
	}
	
	
}
