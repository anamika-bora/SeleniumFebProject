package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment {
	@FindBy(partialLinkText="Pay by bank wire ")
	private WebElement PayByBankWire;
	@FindBy(partialLinkText="Pay by check")
	private WebElement PayByCheck;
	@FindBy(css="#cart_navigation > button")
	private WebElement confOrderBtn;
	@FindBy(css="#center_column > div > p")
	private WebElement confOrderMsg;//Your order on My Store is complete.
	public Payment(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void payByBankWire(){
		PayByBankWire.click();
	}
	public void payByCheck(){
		PayByCheck.click();
	}
	public void confOrder(){
		confOrderBtn.click();
	}
	public String getConMsg(){
		String confMsg=confOrderMsg.getText();
		return confMsg;
	}
}
