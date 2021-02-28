package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shipping {
	@FindBy (id="uniform-cgv")
	private WebElement check;
	@FindBy (name="processCarrier")
	private WebElement checkoutBtn;
	@FindBy (xpath="//*[@class='fancybox-error']")
	private WebElement err;//You must agree to the terms of service before continuing.
	@FindBy (xpath="//*[@class='fancybox-item fancybox-close']")
	private WebElement errClose;
	public Shipping(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void checkOut(){
		check.click();
		checkoutBtn.click();
	}
}
