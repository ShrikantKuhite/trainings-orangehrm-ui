package com.orangehrm.driverfactory;
import com.orangehrm.utils.PropertiesFileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class WebDriverSession {

    //Declaration of WebDriver instance
    public static  WebDriver driver;
    /**
     * This method create an WebDriver session with multiple browser
     * based on the choice and provide it wherever the class gets extended.
     */
    @BeforeSuite
    public void setUp() {
        if (PropertiesFileUtils.getValueForTheKey("appBrowser").equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (PropertiesFileUtils.getValueForTheKey("appBrowser").equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (PropertiesFileUtils.getValueForTheKey("appBrowser").equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            Reporter.log("No Specific browser to launch...!!!");
        }

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.get(PropertiesFileUtils.getValueForTheKey("appURL"));
        Reporter.log("Application Launched successfully...!!!");
    }

    /**
     * This method closes all the browser instances and end the WebDriver session.
     */
    @AfterSuite
    public void tearDown() {
        driver.quit();
        Reporter.log("Application browser closed successfully...!!!");
    }
}
