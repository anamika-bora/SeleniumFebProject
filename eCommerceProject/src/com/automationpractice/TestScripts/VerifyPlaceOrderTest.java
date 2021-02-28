package com.automationpractice.TestScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.automationpractice.Pages.AddressConfirmation;
import com.automationpractice.Pages.Cart;
import com.automationpractice.Pages.Home;
import com.automationpractice.Pages.Login;
import com.automationpractice.Pages.Payment;
import com.automationpractice.Pages.ProductInformation;
import com.automationpractice.Pages.Shipping;

import junit.framework.Assert;
import utils.GenericMethod;

public class VerifyPlaceOrderTest extends Base{
	@Test
	public void VerifyPlaceOrderTest() throws IOException{

		Home hm=new Home(driver);
		Login lg=new Login(driver);
		ProductInformation prdInf=new ProductInformation(driver);
		Cart cart=new Cart(driver);
		AddressConfirmation addConf=new AddressConfirmation(driver);
		Shipping sh=new Shipping(driver);
		Payment py=new Payment(driver);
		String data[][]=GenericMethod.getData("TestData.xlsx", "VerifyPlaceOrderTest");
		for(int i=1;i<data.length;i++){
			hm.selectItem();
			prdInf.addQty();
			prdInf.selectSize(data[i][13]);
			prdInf.addToCart();
			prdInf.checkOut();
			cart.checkOut();
			lg.signIn(data[i][0], data[i][4]);
			addConf.checkOut();
			sh.checkOut();
			py.payByBankWire();
			py.confOrder();
			String conMsg=py.getConMsg();
			String expConMsg=data[i][14];
			Assert.assertEquals(expConMsg, conMsg);
		}

	}

}
