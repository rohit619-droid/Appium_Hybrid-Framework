package com.Appium.test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Appium.base.Base;
import com.Appium.objectRepository.ApiDemoHomePage;
import com.Appium.objectRepository.ApiDemoPreferencesPage;
import com.Appium.utils.TestData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ApiDemo extends Base {
	public  AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void killTask() throws IOException, InterruptedException {
		System.out.println("in");
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
	
	@Test(dataProvider = "input", dataProviderClass = TestData.class)
	public void apiDemo(String data) throws IOException, InterruptedException {

		service = startServer();
		driver = capabilities("apiDemoDebugApk");

		ApiDemoHomePage apiHome = new ApiDemoHomePage(driver);
		apiHome.getpref().click();
		ApiDemoPreferencesPage apiPref = new ApiDemoPreferencesPage(driver);
		apiPref.getPrefDep().click();
		apiPref.getCheck().click();
		apiPref.getSettings().click();
		apiPref.getTextField().sendKeys(data);
		apiPref.getButton().get(1).click();

		service.stop();
		

	}
	
	

}
