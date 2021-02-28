package com.automationpractice.TestScripts;

import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.Pages.AccountCreation;
import com.automationpractice.Pages.Facebook;
import com.automationpractice.Pages.Home;
import com.automationpractice.Pages.Login;
import com.automationpractice.Pages.MyAccount;
import com.automationpractice.Pages.ProductInformation;


import utils.GenericMethod;

public class ShareProductTest extends Base{
	@Test
	public void shareProduct() throws IOException{
		Home hm=new Home(driver);
		Login lg=new Login(driver);
		MyAccount myAcc=new MyAccount(driver);

		String data[][]=GenericMethod.getData("TestData.xlsx", "ShareProductTest");
		for(int i=1;i<data.length;i++){
			hm.signIn();
			lg.signIn(data[i][0],data[i][4]);
			myAcc.GoToHome();
			hm.selectItem();
			ProductInformation prdInfo=new ProductInformation(driver);
			prdInfo.shareOnFB();
			Set<String> wndHandles = driver.getWindowHandles();
			   Object[] converToArray = wndHandles.toArray();
			  driver.switchTo().window(converToArray[1].toString());
			   
			Facebook fb=new Facebook(driver);
			boolean fbPageOpen=fb.isFBPageOpen();
			GenericMethod.takeScreenShot("D:\\project\\ScreenShot", driver, "ShareP");
			Assert.assertTrue(fbPageOpen);
			driver.close();
			 driver.switchTo().window(converToArray[0].toString());
		}
	}
}
