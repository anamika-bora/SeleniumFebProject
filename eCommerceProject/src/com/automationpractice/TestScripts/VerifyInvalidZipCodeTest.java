package com.automationpractice.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.Pages.AccountCreation;
import com.automationpractice.Pages.EmailAddConfirmation;
import com.automationpractice.Pages.Home;
import com.automationpractice.Pages.MyAccount;

import utils.GenericMethod;

public class VerifyInvalidZipCodeTest extends Base{
	@Test
	public void verifyCountryCodeZipCode() throws IOException{

		Home hm=new Home(driver);
		EmailAddConfirmation addConfm=new EmailAddConfirmation(driver);
		AccountCreation accCreation=new AccountCreation(driver);
		MyAccount myAcc=new MyAccount(driver);
		String data[][]=GenericMethod.getData("TestData.xlsx", "VerifyCountryFieldBlankTest");
		for(int i=1;i<data.length;i++){
			hm.signIn();
			addConfm.createNewAccout(data[i][0]);
			accCreation.Register(data[i][2], data[i][3], data[i][1], data[i][0], data[i][4], data[i][5], data[i][6],
					data[i][7], data[i][8], data[i][9], data[i][10], data[i][11]);
			String errMsg=accCreation.getErrMsg();
			String expErrMsg=data[i][12];
			Assert.assertEquals(errMsg, expErrMsg);

		

		}
	}
}