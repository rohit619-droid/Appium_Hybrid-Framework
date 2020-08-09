package com.Appim.test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Appium.base.Base;
import com.Appium.objectRepository.EcomCheckoutPage;
import com.Appium.objectRepository.EcomMainPage;
import com.Appium.objectRepository.EcomProductsPage;
import com.Appium.utils.Utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EcommerceApp extends Base {

	@Test
	public void ecommerce() throws IOException, InterruptedException {

		AndroidDriver<AndroidElement> driver = capabilities("generalStoreApk");

		Utilities utils = new Utilities(driver);
		utils.getScroll("Argentina");
		utils.getCountry("Argentina").click();
		EcomMainPage eHome = new EcomMainPage(driver);
		eHome.getEnter().sendKeys("hello");
		driver.hideKeyboard();
		eHome.getRadioButton().click();
		eHome.getShop().click();

		EcomProductsPage ePro = new EcomProductsPage(driver);
		ePro.getProducts().get(0).click();
		ePro.getProducts().get(0).click();
		ePro.getCart().click();
		Thread.sleep(2000);

		EcomCheckoutPage eCheck = new EcomCheckoutPage(driver);
		int count = eCheck.getProductPrice().size();
		double sum = 0;
		for (int i = 0; i < count; i++) {
			String price1 = eCheck.getProductPrice().get(i).getText();
			double amount = utils.getAmount(price1);
			sum = sum + amount;
		}

		String finalAmount = "$" + " " + sum;

		String amountFinal = eCheck.getTotalAmount().getText();
		System.out.println(amountFinal);

		Assert.assertEquals(finalAmount, amountFinal);

		System.out.println("Excecution Completed");
	}

}
