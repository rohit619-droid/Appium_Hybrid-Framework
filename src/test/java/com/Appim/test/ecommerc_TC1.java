package com.Appim.test;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.Appium.base.base;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerc_TC1 extends base {

	public static double getAmount(String value) {
		value = value.substring(1);
		double a = Double.parseDouble(value);
		return a;
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		AndroidDriver<AndroidElement> driver = capabilities("generalStoreApk");
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""
						+ "Argentina" + "\").instance(0))"));

		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("hello");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(By.className("android.widget.Button")).click();

		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);

		//
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		double sum = 0;
		for (int i = 0; i < count; i++) {
			String price1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i)
					.getText();
			double amount = getAmount(price1);
			sum = sum + amount;
		}

		String finalAmount = "$" + " " + sum;

		String amountFinal = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		System.out.println(amountFinal);

		Assert.assertEquals(finalAmount, amountFinal);

	}

}
