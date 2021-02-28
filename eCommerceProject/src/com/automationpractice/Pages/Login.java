package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	@FindBy(id="email")
	private WebElement email;
	@FindBy(id="passwd")
	private WebElement passwd;
	@FindBy(id="SubmitLogin")
	private WebElement SubmitLogin;
	@FindBy(css="#center_column > div.alert.alert-danger")
	private WebElement erreMsgBox;

	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void signIn(String emailAdd,String pass){
		email.sendKeys(emailAdd);
		passwd.sendKeys(pass);
		SubmitLogin.click();
	}
	public String getErrMsg(){
		String errorMsg=erreMsgBox.getText();
		return errorMsg;
	}
}
