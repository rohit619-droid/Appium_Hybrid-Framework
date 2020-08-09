package com.Appium.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EcomCheckoutPage {



	public EcomCheckoutPage(AppiumDriver<?> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPrice;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalPrice;


	public List<WebElement> getProductPrice() {
		System.out.println("Click on the country from dropdown");
		return productPrice;
	}

	public WebElement getTotalAmount() {
		System.out.println("Click on cart on top right corner page");
		return totalPrice;
	}




}
