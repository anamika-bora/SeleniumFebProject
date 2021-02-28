package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressConfirmation {
	@FindBy (name="processAddress")
	private WebElement checkoutBtn;
	public AddressConfirmation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void checkOut(){
		checkoutBtn.click();
	}
}
