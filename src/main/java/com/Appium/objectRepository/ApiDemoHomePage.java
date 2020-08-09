package com.Appium.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ApiDemoHomePage {

	public ApiDemoHomePage(AppiumDriver<?> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']")
	private WebElement preferences;

	public WebElement getpref() {
		System.out.println("Click on preference option in API demo");
		return preferences;
	}

}
