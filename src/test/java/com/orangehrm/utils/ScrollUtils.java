package com.orangehrm.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollUtils {

	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WaitUtils.waitGeneric(3000);
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
}
