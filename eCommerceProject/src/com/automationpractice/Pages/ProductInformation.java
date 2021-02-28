package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductInformation {
	@FindBy(id="quantity_wanted")
	private WebElement quantity_wanted;
	@FindBy(css="#quantity_wanted_p > a.btn.btn-default.button-plus.product_quantity_up > span > i")
	private WebElement addQty;
	@FindBy(css="#quantity_wanted_p > a.btn.btn-default.button-minus.product_quantity_down > span > i")
	private WebElement lessQty;
	@FindBy(id="group_1")
	private WebElement size;
	@FindBy(css="#add_to_cart > button > span")
	private WebElement AddToCart;
	
	@FindBy(partialLinkText="Proceed to checkout")
	private WebElement checkout;
	
	@FindBy(id="new_comment_tab_btn")
	private WebElement newComment;
	@FindBy(css="#product > div.fancybox-overlay.fancybox-overlay-fixed > div")
	private WebElement popup;
	@FindBy(id="comment_title")
	private WebElement comment_title;
	@FindBy(id="content")
	private WebElement content;
	@FindBy(id="submitNewMessage")
	private WebElement submitNewMessage ;
	@FindBy(css="#product > div.fancybox-wrap.fancybox-desktop.fancybox-type-html.fancybox-opened")
	private WebElement confMsg ;
	@FindBy(css="#product > div.fancybox-wrap.fancybox-desktop.fancybox-type-html.fancybox-opened > div > div > div > p:nth-child(2)")
	private WebElement confMsgText ;
	@FindBy(xpath="//*[@class='btn btn-default btn-facebook']")
	private WebElement FBBttn;
	
	public ProductInformation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void writeReview(String comment,String cont){
		newComment.click();
		if(popup.isDisplayed())
		{
			comment_title.sendKeys(comment);
			content.sendKeys(cont);
			submitNewMessage.click();
		}
	}
	public boolean confMsgDisplayed(){
		boolean confMsgShown=confMsg.isDisplayed();
		return confMsgShown;
	}
	public void addQty()
	{
		addQty.click();
	}
	public void selectSize(String size1){
		Select drop1 = new Select(size);
	    drop1.selectByVisibleText(size1);	
	}
	public void addToCart(){
		AddToCart.click();
	}
	public void checkOut(){
		checkout.click();
	}
	public void shareOnFB(){
		FBBttn.click();
	}
}
