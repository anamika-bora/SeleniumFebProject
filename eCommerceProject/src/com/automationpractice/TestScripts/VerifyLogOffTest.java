package com.automationpractice.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.Pages.Home;
import com.automationpractice.Pages.Login;
import com.automationpractice.Pages.MyAccount;
import utils.GenericMethod;

public class VerifyLogOffTest extends Base {
	@Test
	public void verifyLogOff () throws IOException {
		MyAccount myAcc=new MyAccount(driver);
		Home hm=new Home(driver);
		Login lg=new Login(driver);
		String data[][]=GenericMethod.getData("TestData.xlsx", "VerifyValidLoginTest");
		hm.signIn();
		lg.signIn(data[1][0], data[1][1]);
		if(myAcc.myAccountPresent()){
			myAcc.signOut();
		}

	}
}
