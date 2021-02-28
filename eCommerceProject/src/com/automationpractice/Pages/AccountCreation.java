package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreation {
	
	
	@FindBy(id="id_gender1")
	private WebElement gender1;
	@FindBy(id="id_gender2")
	private WebElement gender2;
	@FindBy(id="customer_firstname")
	private WebElement customer_firstname;
	@FindBy(id="customer_lastname")
	private WebElement customer_lastname;
	@FindBy(id="email")
	private WebElement email;	
	@FindBy(id="passwd")
	private WebElement passwd;
	@FindBy(id="days")
	private WebElement days;
	@FindBy(id="months")
	private WebElement months;
	@FindBy(id="years")
	private WebElement years;
	
	@FindBy(id="address1")
	private WebElement address1;
	@FindBy(id="city")
	private WebElement cityName;
	@FindBy(id="id_state")
	private WebElement id_state;
	@FindBy(id="postcode")
	private WebElement postcode;
	@FindBy(id="id_country")
	private WebElement id_country;
	@FindBy(id="phone_mobile")
	private WebElement phone_mobile;
	@FindBy(id="alias")
	private WebElement alias;
	@FindBy(id="submitAccount")
	private WebElement submitAccount;
	@FindBy(css="#center_column > div")
	private WebElement error;
	
	public AccountCreation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void Register(String firstName,String lastName,String gender, String emailAdd,String pass, String add,String city, String state,
			String zipcode, String country, String mobile, String refEmail){
		
		customer_firstname.sendKeys(firstName);
		customer_lastname.sendKeys(lastName);
		//email.sendKeys(emailAdd);
		passwd.sendKeys(pass);
		address1.sendKeys(add);
		cityName.sendKeys(city);
		Select drop = new Select(id_state);
	    drop.selectByVisibleText(state);		
		postcode.sendKeys(zipcode);
		Select drop1 = new Select(id_country);
	    drop1.selectByVisibleText(country);	
		//id_country.sendKeys(country);
		phone_mobile.sendKeys(mobile);
		alias.clear();
		alias.sendKeys(refEmail);
		submitAccount.click();
	}
	public boolean pagePresent(){
		boolean pagePresent=submitAccount.isDisplayed();
		return pagePresent;
	}
	public String getErrMsg(){
		String errorMsg=error.getText();
		return errorMsg;
	}
	
}
