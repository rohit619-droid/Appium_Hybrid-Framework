package com.Appium.utils;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name = "input")
	public Object[][] getData() {

		Object[][] obj = new Object[][] {

				{ "Hello" }, { "~!@#$%^&" } };

		return obj;

	}
}
