package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailAddConfirmation {
	@FindBy(id="email_create")
	private WebElement email;
	@FindBy(id="SubmitCreate")
	private WebElement Submit;
	@FindBy(css="#create_account_error > ol > li")
	private WebElement errMsg;
	
	public EmailAddConfirmation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void createNewAccout(String emailAdd){
		email.sendKeys(emailAdd);		
		Submit.click();
	}
	public String getErrMsg(){
		String errorMsg=errMsg.getText();
		return errorMsg;
	}
	public boolean errMsgPresent(){
		boolean errMsgPresent=errMsg.isDisplayed();
		return errMsgPresent;
	}
	
}
