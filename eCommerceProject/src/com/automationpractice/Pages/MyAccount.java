package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	@FindBy(partialLinkText="Sign out")
	private WebElement SignOut;
	@FindBy(css="#center_column > ul > li > a")
	private WebElement Home;
	
	public MyAccount(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public boolean myAccountPresent(){
		boolean myAccountPresent=SignOut.isDisplayed();
		return myAccountPresent;
	}
	public void signOut(){
		SignOut.click();
	}
	public void GoToHome()
	{
		Home.click();
	}
}
