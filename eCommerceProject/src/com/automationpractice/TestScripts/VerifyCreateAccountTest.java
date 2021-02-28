package com.automationpractice.TestScripts;
import utils.GenericMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.Pages.AccountCreation;
import com.automationpractice.Pages.EmailAddConfirmation;
import com.automationpractice.Pages.Home;
import com.automationpractice.Pages.MyAccount;
import com.automationpractice.TestScripts.Base;


public class VerifyCreateAccountTest extends Base {
	@Test
	public void verifyCreateAccount() throws IOException{

		Home hm=new Home(driver);
		EmailAddConfirmation addConfm=new EmailAddConfirmation(driver);
		AccountCreation accCreation=new AccountCreation(driver);
		MyAccount myAcc=new MyAccount(driver);
		String data[][]=GenericMethod.getData("TestData.xlsx", "VerifyCreateAccountTest");
		for(int i=1;i<data.length;i++){
			hm.signIn();
			addConfm.createNewAccout(data[i][0]);
			try{
			
				String errMsg=addConfm.getErrMsg();
				String expErrMsg=data[1][12];

				if(errMsg.equals(expErrMsg)){
					driver.navigate().back();
				}
				
			}
			catch (Exception e) {
				accCreation.Register(data[i][2], data[i][3], data[i][1], data[i][0], data[i][4], data[i][5], data[i][6],
						data[i][7], data[i][8], data[i][9], data[i][10], data[i][11]);
				myAcc.signOut();
			}
			
			


		}



	}
}
