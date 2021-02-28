package com.automationpractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmation {
	@FindBy(css="#center_column > form > div")
	private WebElement OrderConfText;
	
	@FindBy(css="#cart_navigation > button")
	private WebElement OrderConfBtn;
}
