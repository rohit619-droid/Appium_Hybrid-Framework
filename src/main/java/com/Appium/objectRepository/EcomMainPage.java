package com.Appium.objectRepository;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EcomMainPage {

	public EcomMainPage(AppiumDriver<?> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement text;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
	private WebElement radioButton;

	@AndroidFindBy(className = "android.widget.Button")
	private WebElement letShop;


	public WebElement getEnter() {
		System.out.println("Enter info..");
		return text;
	}

	public WebElement getRadioButton() {
		System.out.println("select any option");
		return radioButton;
	}

	public WebElement getShop() {
		System.out.println("click on lets shop button");
		return letShop;
	}
	
}
