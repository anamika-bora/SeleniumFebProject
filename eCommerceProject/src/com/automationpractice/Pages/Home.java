package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	@FindBy(partialLinkText="Sign in")
	private WebElement SignIn;
	@FindBy(css="#homefeatured > li:nth-child(2) > div > div.right-block > div.button-container > a.button.lnk_view.btn.btn-default > span")
	private WebElement More;

	
	
	@FindBy(css="#homefeatured > li:nth-child(2) > div > div.left-block > div > a.product_img_link > img")
	private WebElement item;
	Actions action;
	public Home(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}
	public void signIn(){
		SignIn.click();
	}
	public void selectItem()
	{
		action.moveToElement(item).build().perform();
		More.click();
	}
}
