package com.Appium.utils;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name = "input")
	public static Object[][] getData() {

		Object[][] obj = new Object[][] {

				{ "Hello" }, { "~!@#$%^&" } };

		return obj;

	}
}
