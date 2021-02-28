package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {
	@FindBy(partialLinkText="Proceed to checkout")
	private WebElement checkout;
	public Cart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void checkOut(){
		checkout.click();
	}
}
