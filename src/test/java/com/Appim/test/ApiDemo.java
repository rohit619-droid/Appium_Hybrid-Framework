package com.Appim.test;

import java.io.IOException;

import org.testng.annotations.Test;
import com.Appium.base.Base;
import com.Appium.objectRepository.ApiDemoHomePage;
import com.Appium.objectRepository.ApiDemoPreferencesPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ApiDemo extends Base {

	@Test
	public void apiDemo() throws IOException {

		service = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("apiDemoDebugApk");

		ApiDemoHomePage apiHome = new ApiDemoHomePage(driver);
		apiHome.getpref().click();
		ApiDemoPreferencesPage apiPref = new ApiDemoPreferencesPage(driver);
		apiPref.getPrefDep().click();
		apiPref.getCheck().click();
		apiPref.getSettings().click();
		apiPref.getTextField().sendKeys("hello");
		apiPref.getButton().get(1).click();

		service.stop();

	}

}
