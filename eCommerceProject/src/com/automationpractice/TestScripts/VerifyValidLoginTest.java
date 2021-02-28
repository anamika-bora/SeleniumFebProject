package com.automationpractice.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.Pages.Home;
import com.automationpractice.Pages.Login;
import com.automationpractice.Pages.MyAccount;

import utils.GenericMethod;

public class VerifyValidLoginTest extends Base {
	@Test
	public void verifyLogin() throws IOException {
		Home hm=new Home(driver);
		Login lg=new Login(driver);

		String data[][]=GenericMethod.getData("TestData.xlsx", "VerifyValidLoginTest");
		for(int i=1;i<data.length;i++){
			hm.signIn();
			lg.signIn(data[i][0], data[i][1]);
			MyAccount myAcc=new MyAccount(driver);
			boolean IsMAPresent=myAcc.myAccountPresent();
			Assert.assertTrue(IsMAPresent);
			myAcc.signOut();

		}

	}
}