package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.orangehrm.driverfactory.WebDriverSession;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.ListenerUtils;
import com.orangehrm.utils.PropertiesFileUtils;

public class LoginTest extends WebDriverSession {
    /**
     * Login method executes once before executing all the test methods
     * belonging to a particular <test> tag in the test suite XML file.
     * @throws InterruptedException
     */
	
	//This retryAnalyzer will be applicable only for below test method
    //@Test(priority = 1, retryAnalyzer = MyRetryAnalyzer.class)
    
	@Test(priority = 1)
    public void loginToApplication() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        Reporter.log("Enter an User Name");
        ListenerUtils.extentTest.log(Status.PASS, "Enter an User Name");
        loginPage.enterUserName(PropertiesFileUtils.getValueForTheKey("appUserName"));
        Reporter.log("User Name entered successfully...!!!");
        ListenerUtils.extentTest.log(Status.PASS, "User Name entered successfully...!!!");
        Reporter.log("Enter the Password");
        ListenerUtils.extentTest.log(Status.PASS, "Enter the Password");
        loginPage.enterPassword(PropertiesFileUtils.getValueForTheKey("appPassword"));
        Reporter.log("Password entered successfully...!!!");
        ListenerUtils.extentTest.log(Status.PASS, "Password entered successfully...!!!");
        Reporter.log("Click on Login button");
        ListenerUtils.extentTest.log(Status.PASS, "Click on Login button");
        loginPage.clickLoginButton();
        Reporter.log("Login button clicked successfully...!!!");
        ListenerUtils.extentTest.log(Status.PASS, "Login button clicked successfully...!!!");
        Reporter.log("Verify Application logged In");
        ListenerUtils.extentTest.log(Status.PASS, "Verify Application logged In");
        Assert.assertEquals(homePage.getDashboardPageHeader(), "Dashboard", "Login is not successful...!!!");
        Reporter.log("Application logged In successfully...!!!");
        ListenerUtils.extentTest.log(Status.PASS,"Application logged In successfully...!!!");
    }

    /**
     * Logout method executes once after executing all the test methods
     * belonging to a particular <test> tag in the test suite XML file.
     * @throws InterruptedException
     */
    @AfterTest
    public void logoutFromApplication() {
        HomePage homePage = new HomePage(driver);
        Reporter.log("Click on Logout option");
        ListenerUtils.extentTest.log(Status.PASS, "Click on Logout option");
        homePage.clickLogoutLink();
        Reporter.log("Application Logged out successfully...!!!");
        ListenerUtils.extentTest.log(Status.PASS, "Application Logged out successfully...!!!");
    }
}