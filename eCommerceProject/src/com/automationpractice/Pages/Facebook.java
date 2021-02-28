package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Facebook {
	
	@FindBy(name="__CANCEL__")
	private WebElement cancelBtn;
	@FindBy(id="facebook")
	private WebElement fbPage;
	public Facebook(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public boolean isFBPageOpen(){
		boolean fbStatus=fbPage.isDisplayed();
		return fbStatus;
	}
}
