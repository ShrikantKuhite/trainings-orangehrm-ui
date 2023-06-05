package com.orangehrm.utils;

import com.orangehrm.driverfactory.WebDriverSession;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenshotUtils extends WebDriverSession {
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {
		WaitUtils.waitGeneric(3000);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		screenshotName = date.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		//FileHandler.copy(scrFile, new File(".\\Screenshots\\" + screenshotName));
		FileHandler.copy(scrFile, new File(".\\Reports\\" + screenshotName));
	}
}
