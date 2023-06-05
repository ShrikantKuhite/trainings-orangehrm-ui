package com.orangehrm.tests;

import com.aventstack.extentreports.Status;
import com.orangehrm.utils.ListenerUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.orangehrm.driverfactory.WebDriverSession;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.PropertiesFileUtils;

public class HomePageNavigationTest extends WebDriverSession {
	/*
	 * //Method to verify new Application URL
	 * 
	 * @Test(priority = 1, enabled = false) public void verifyAppNewURLNavigation()
	 * { HomePage homePage = new HomePage(driver);
	 * Reporter.log("Click Orange HRM header link");
	 * homePage.clickOrangeHRMHeaderLink();
	 * Reporter.log("Orange HRM header link clicked successfully...!!!");
	 * Reporter.log("Verify New Application URL");
	 * Assert.assertEquals(driver.getCurrentUrl(), "https://www.orangehrm.com/",
	 * "URL does not matched...!!!");
	 * Reporter.log("New Application URL verified successfully...!!!");
	 * driver.navigate().back(); }
	 */
	
	//Method to verify Admin page navigation
	@Test(priority = 1, enabled = true)
	public void verifyAdminPageNavigation() {
		HomePage homePage = new HomePage(driver);
		Reporter.log("Click on Admin Menu");
		ListenerUtils.extentTest.log(Status.PASS, "Click on Admin Menu");
		homePage.clickAdminMenu();
		Reporter.log("Admin menu clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS, "Admin menu clicked successfully...!!!");
		Reporter.log("Verify navigation to Admin page");
		ListenerUtils.extentTest.log(Status.PASS, "Verify navigation to Admin page");
		Assert.assertEquals(homePage.getAdminPageHeader(), "Admin", "Admin page navigation is not Successful...!!!");
		Reporter.log("Admin page navigation is successful...!!!");
		ListenerUtils.extentTest.log(Status.PASS, "Admin page navigation is successful...!!!");
	}
	
	//Method to verify PIM page navigation
	@Test(priority = 2, enabled = true)
	public void verifyPIMPageNavigation() {
		HomePage homePage = new HomePage(driver);
		Reporter.log("Click on PIM menu");
		ListenerUtils.extentTest.log(Status.PASS, "Click on PIM menu");
		homePage.clickPIMMenu();
		Reporter.log("PIM menu clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS, "PIM menu clicked successfully...!!!");
		Reporter.log("Verify navigation to PIM page");
		ListenerUtils.extentTest.log(Status.PASS,"Verify navigation to PIM page");
		Assert.assertEquals(homePage.getPIMPageHeader(), "PIM", "PIM page navigation is not Successful...!!!");
		Reporter.log("PIM page navigation is successful...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"PIM page navigation is successful...!!!");
	}
	
	//Method to verify Leave page navigation
	@Test(priority = 3, enabled = true)
	public void verifyLeavePageNavigation() {
		HomePage homePage = new HomePage(driver);
		Reporter.log("Click on Leave menu");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Leave menu");
		homePage.clickLeaveMenu();
		Reporter.log("Leave menu clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Leave menu clicked successfully...!!!");
		Reporter.log("Verify navigation to Leave page");
		ListenerUtils.extentTest.log(Status.PASS,"Verify navigation to Leave page");
		Assert.assertEquals(homePage.getLeavePageHeader(), "Leave", "Leave page navigation is not Successful...!!!");
		Reporter.log("Leave page navigation is successful...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Leave page navigation is successful...!!!");
	}
	
	//Method to verify Time page navigation
	@Test(priority = 4, enabled = true)
	public void verifyTimePageNavigation() {
		HomePage homePage = new HomePage(driver);
		Reporter.log("Click on Time menu");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Time menu");
		homePage.clickTimeMenu();
		Reporter.log("Time menu clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Time menu clicked successfully...!!!");
		Reporter.log("Verify navigation to Time page");
		ListenerUtils.extentTest.log(Status.PASS,"Verify navigation to Time page");
		Assert.assertEquals(homePage.getTimePageHeader(), "Time", "Time page navigation is not Successful...!!!");
		Reporter.log("Time page navigation is successful...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Time page navigation is successful...!!!");
	}
	
	//Method to verify Recruitment page navigation
	@Test(priority = 5, enabled = true)
	public void verifyRecruitmentPageNavigation() {
		HomePage homePage = new HomePage(driver);
		Reporter.log("Click on Recruitment menu");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Recruitment menu");
		homePage.clickRecruitmentMenu();
		Reporter.log("Recruitment menu clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Recruitment menu clicked successfully...!!!");
		Reporter.log("Verify navigation to Recruitment page");
		ListenerUtils.extentTest.log(Status.PASS,"Verify navigation to Recruitment page");
		Assert.assertEquals(homePage.getRecruitmentPageHeader(), "Recruitment", "Recruitment page navigation is not Successful...!!!");
		Reporter.log("Recruitment page navigation is successful...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Recruitment page navigation is successful...!!!");
	}
	
	//Method to verify My Info page navigation
	@Test(priority = 6, enabled = true)
	public void verifyMyInfoPageNavigation() {
		HomePage homePage = new HomePage(driver);
		Reporter.log("Click on My Info menu");
		ListenerUtils.extentTest.log(Status.PASS, "Click on My Info menu");
		homePage.clickMyInfoMenu();
		Reporter.log("My Info menu clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"My Info menu clicked successfully...!!!");
		Reporter.log("Verify navigation to My Info page");
		ListenerUtils.extentTest.log(Status.PASS,"Verify navigation to My Info page");
		Assert.assertEquals(homePage.getMyInfoPageHeader(), "PIM", "My Info page navigation is not Successful...!!!");
		Reporter.log("My Info page navigation is successful...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"My Info page navigation is successful...!!!");
	}
	
	//Method to verify Peformance page navigation
	@Test(priority = 7, enabled = true)
	public void verifyPerformancePageNavigation() {
		HomePage homePage = new HomePage(driver);
		Reporter.log("Click on Performance menu");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Performance menu");
		homePage.clickPerformanceMenu();
		Reporter.log("Performance menu clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Performance menu clicked successfully...!!!");
		Reporter.log("Verify navigation to Performance page");
		ListenerUtils.extentTest.log(Status.PASS,"Verify navigation to Performance page");
		Assert.assertEquals(homePage.getPerformancePageHeader(), "Performance", "Performance page navigation is not Successful...!!!");
		Reporter.log("Performance page navigation is successful...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Performance page navigation is successful...!!!");
	}
	
	//Method to verify Dashboard page navigation
	@Test(priority = 8, enabled = true)
	public void verifyDashboardPageNavigation() {
		HomePage homePage = new HomePage(driver);
		Reporter.log("Click on Dashboard menu");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Dashboard menu");
		homePage.clickDashboardMenu();
		Reporter.log("Dashboard menu clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Dashboard menu clicked successfully...!!!");
		Reporter.log("Verify navigation to Dashboard page");
		ListenerUtils.extentTest.log(Status.PASS,"Verify navigation to Dashboard page");
		Assert.assertEquals(homePage.getDashboardPageHeader(), "Dashboard", "Dashboard page navigation is not Successful...!!!");
		Reporter.log("Dashboard page navigation is successful...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Dashboard page navigation is successful...!!!");
	}
	
	//Method to verify Directory page navigation
	@Test(priority = 9, enabled = true)
	public void verifyDirectoryPageNavigation() {
		HomePage homePage = new HomePage(driver);
		Reporter.log("Click on Directory Menu");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Directory Menu");
		homePage.clickDirectoryMenu();
		Reporter.log("Directory menu clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Directory menu clicked successfully...!!!");
		Reporter.log("Verify navigation to Directory page");
		ListenerUtils.extentTest.log(Status.PASS,"Verify navigation to Directory page");
		Assert.assertEquals(homePage.getDirectoryPageHeader(), "Directory", "Directory page navigation is not Successful...!!!");
		Reporter.log("Directory page navigation is successful...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Directory page navigation is successful...!!!");
	}
	
	//Method to verify Maintenance page navigation
	@Test(priority = 10, enabled = true)
	public void verifyMaintenancePageNavigation() {
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		Reporter.log("Click on Maintenance menu");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Maintenance menu");
		homePage.clickMaintenanceMenu();
		Reporter.log("Maintenance menu clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Maintenance menu clicked successfully...!!!");
		Reporter.log("Verify navigation to Administrator Access form page");
		ListenerUtils.extentTest.log(Status.PASS,"Verify navigation to Administrator Access form page");
		Assert.assertEquals(homePage.getMaintenancePageAdminAccessFormHeader(), "Administrator Access", "Administrator Access form navigation is not Successful...!!!");
		Reporter.log("Administrator Access form page navigation is successful...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Administrator Access form page navigation is successful...!!!");
		Reporter.log("Enter the password");
		ListenerUtils.extentTest.log(Status.PASS,"Enter the password");
		loginPage.enterPassword(PropertiesFileUtils.getValueForTheKey("appPassword"));
		Reporter.log("Password entered successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Password entered successfully...!!!");
		Reporter.log("Click on Confirm button");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Confirm button");
		homePage.clickConfirmButton();
		Reporter.log("Confirm button clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Confirm button clicked successfully...!!!");
		Reporter.log("Verify navigation to Maintenance page");
		ListenerUtils.extentTest.log(Status.PASS,"Verify navigation to Maintenance page");
		Assert.assertEquals(homePage.getMaintenancePageHeader(), "Maintenance", "Maintenance page navigation is not Successful...!!!");
		Reporter.log("Maintenance page navigation is successful...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Maintenance page navigation is successful...!!!");
	}
	
	//Method to verify Buzz page navigation
	@Test(priority = 11, enabled = true)
	public void verifyBuzzPageNavigation() {
		HomePage homePage = new HomePage(driver);
		Reporter.log("Click on Buzz menu");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Buzz menu");
		homePage.clickBuzzMenu();
		Reporter.log("Buzz menu clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Buzz menu clicked successfully...!!!");
		Reporter.log("Verify navigation to Buzz page");
		ListenerUtils.extentTest.log(Status.PASS,"Verify navigation to Buzz page");
		Assert.assertEquals(homePage.getBuzzPageHeader(), "Buzz", "Buzz page navigation is not Successful...!!!");
		Reporter.log("Buzz page navigation is successful...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Buzz page navigation is successful...!!!");
	}
}