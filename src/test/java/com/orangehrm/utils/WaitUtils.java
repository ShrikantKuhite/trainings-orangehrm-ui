package com.orangehrm.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

	//Wait till the Element to be Visible
    public static void waitForTheElementToBeVisible(WebDriver driver, WebElement element, String timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeoutInSeconds)));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Wait till the Element to be Clickable
    public static void waitForTheElementToBeClickable(WebDriver driver, WebElement element, String timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeoutInSeconds)));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    //Hard Wait
    public static void waitGeneric(int timeInMilliSeconds) {
    	try {
			Thread.sleep(timeInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
