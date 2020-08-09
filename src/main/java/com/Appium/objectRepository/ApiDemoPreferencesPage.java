package com.Appium.objectRepository;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ApiDemoPreferencesPage {

	public ApiDemoPreferencesPage(AppiumDriver<?> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='3. Preference dependencies']")
	private WebElement prefDependencies;

	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement wifiCheckbox;

	@AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
	public WebElement wifiSettings;

	@AndroidFindBy(id = "android:id/edit")
	private WebElement wifiTextField;

	@AndroidFindBy(className = "android.widget.Button")
	private List<WebElement> submit;

	public WebElement getPrefDep() {
		System.out.println("Click on preference dependencies option in preferences");
		return prefDependencies;
	}

	public WebElement getCheck() {
		System.out.println("Click on wifi checkbox");
		return wifiCheckbox;
	}

	public WebElement getSettings() {
		System.out.println("Click on wifi settings");
		return wifiSettings;
	}
	
	public WebElement getTextField() {
		System.out.println("Enter text in this field..");
		return wifiTextField;
	}

	public List<WebElement> getButton() {
		System.out.println("Click on submit");
		return submit;
	}

}
