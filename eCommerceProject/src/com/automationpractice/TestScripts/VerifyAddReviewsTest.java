package com.automationpractice.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.Pages.AccountCreation;
import com.automationpractice.Pages.EmailAddConfirmation;
import com.automationpractice.Pages.Home;
import com.automationpractice.Pages.Login;
import com.automationpractice.Pages.MyAccount;
import com.automationpractice.Pages.ProductInformation;

import utils.GenericMethod;

public class VerifyAddReviewsTest extends Base {
	@Test
	public void VerifyAddReviewsTest() throws IOException{
		String data[][]=GenericMethod.getData("TestData.xlsx", "VerifyAddReviewsTest");
		Home hm=new Home(driver);
		for(int i=1;i<data.length;i++){
			ProductInformation prdInfo=new ProductInformation(driver);
			hm.signIn();
			Login lg=new Login(driver);
			lg.signIn(data[i][0], data[i][1]);
			MyAccount myAcc=new MyAccount(driver);
			myAcc.GoToHome();
			hm.selectItem();
			prdInfo.writeReview(data[i][2],data[i][3]);
			Assert.assertTrue(prdInfo.confMsgDisplayed());

		}
	}
}