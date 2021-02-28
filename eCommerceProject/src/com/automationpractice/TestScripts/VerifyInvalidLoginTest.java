package com.automationpractice.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.Pages.Home;
import com.automationpractice.Pages.Login;
import com.automationpractice.Pages.MyAccount;

import utils.GenericMethod;

public class VerifyInvalidLoginTest extends Base {
	@Test
	public void verifyLogin() throws IOException {
		Home hm=new Home(driver);

		MyAccount myAcc=new MyAccount(driver);
		String data[][]=GenericMethod.getData("TestData.xlsx", "VerifyInvalidLoginTest");
		for(int i=1;i<data.length;i++){
			hm.signIn();
			Login lg=new Login(driver);
			lg.signIn(data[i][0], data[i][1]);
			String errMsg=lg.getErrMsg();
			String expErrMsg=data[i][2];
			Assert.assertEquals(errMsg, expErrMsg);

			//myAcc.signOut();

		}
	}
}