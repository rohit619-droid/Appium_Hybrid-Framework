package com.Appium.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class Utilities {
   
	public static AppiumDriver<?> driver;

	public Utilities(AppiumDriver<?> driver) {
		Utilities.driver = driver;
	}

	public double getAmount(String value) {
		value = value.substring(1);
		double a = Double.parseDouble(value);
		return a;
	}

	public void getScroll(String text) {
		System.out.println("Scrolled to the desired text..");
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""
						+ text + "\").instance(0))"));
	}

	public WebElement getCountry(String text) {
		return driver.findElement(By.xpath("//*[@text='" + text + "']"));
	}

	public static void getScreenshot(String s) throws IOException {
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "\\src\\main\\java\\Screenshots" + s + ".png"));
	}


}
