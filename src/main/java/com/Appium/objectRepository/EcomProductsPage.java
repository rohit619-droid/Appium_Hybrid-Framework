package com.Appium.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EcomProductsPage {


	public EcomProductsPage(AppiumDriver<AndroidElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//*[@text='ADD TO CART']")
	private List<WebElement> addProduct;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement addToCart;


	public List<WebElement> getProducts() {
		System.out.println("Click on the country from dropdown");
		return addProduct;
	}

	public WebElement getCart() {
		System.out.println("Click on cart on top right corner page");
		return addToCart;
	}



}
