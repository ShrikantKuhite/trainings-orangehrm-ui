package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.orangehrm.driverfactory.WebDriverSession;
import com.orangehrm.pages.EmployeePage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.UserManagementPage;
import com.orangehrm.utils.JsonFileUtils;
import com.orangehrm.utils.ListenerUtils;
import com.orangehrm.utils.PropertiesFileUtils;

public class EmployeeTest extends WebDriverSession {

	public static String employeeID;
	
	// Method to add employee
	@Test(priority = 1, enabled = true)
	public void addEmployee() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		UserManagementPage userManagePage = new UserManagementPage(driver);
		EmployeePage empPage = new EmployeePage(driver);
		
		Reporter.log("Click on PIM menu");
		ListenerUtils.extentTest.log(Status.PASS,"Click on PIM menu");
		homePage.clickPIMMenu();
		Reporter.log("PIM menu clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"PIM menu clicked successfully...!!!");
		
		Reporter.log("Click on Add button");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Add button");
		userManagePage.clickAddButton();
		Reporter.log("Add button clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Add button clicked successfully...!!!");
		
		Reporter.log("Enter an Employee First, Middle and Last Name");
		ListenerUtils.extentTest.log(Status.PASS,"Enter an Employee First, Middle and Last Name");
		empPage.enterEmpFirstName(JsonFileUtils.getAppTestDataFromJsonFileByKey("empFirstName"));
		empPage.enterEmpMiddleName(JsonFileUtils.getAppTestDataFromJsonFileByKey("empMiddleName"));
		empPage.enterEmpLastName(JsonFileUtils.getAppTestDataFromJsonFileByKey("empLastName"));
		Reporter.log("Employee First, Middle and Last Name entered successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Employee First, Middle and Last Name entered successfully...!!!");

		if(empPage.isEmployeeIDExists()) {
			Reporter.log("Employee ID already exists, Please enter it manually");
			Reporter.log("Enter an Employee ID");
			empPage.doubleClickOnEmpIDInputBox();
			empPage.enterEmployeeID(JsonFileUtils.getAppTestDataFromJsonFileByKey("empID"));
			Reporter.log("Employee ID entered successfully...!!!");
		} else {
			Reporter.log("Employee ID does not exists, We can use system generated...!!!");
		}

		Reporter.log("Upload Employee picture");
		ListenerUtils.extentTest.log(Status.PASS,"Upload Employee picture");
		empPage.uploadImage(PropertiesFileUtils.getValueForTheKey("imagePath"));
		//empPage.uploadImageDummy();
		Reporter.log("Employee picture uploaded successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Employee picture uploaded successfully...!!!");
		
		Reporter.log("Click on Save button");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Save button");
		userManagePage.clickSaveButton();
		Reporter.log("Save button clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Save button clicked successfully...!!!");
	}

	// Method to search an employee and verify
	@Test(priority = 2, enabled = true)
	public void searchEmployeeAndVerify() throws InterruptedException {
		EmployeePage empPage = new EmployeePage(driver);
		UserManagementPage userManagePage = new UserManagementPage(driver);
		
		Reporter.log("Click an Employee List link menu");
		ListenerUtils.extentTest.log(Status.PASS,"Click an Employee List link menu");
		empPage.clickEmployeeListLinkMenu();
		Reporter.log("Employee List link menu clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Employee List link menu clicked successfully...!!!");
		
		Reporter.log("Enter an Employee Name");
		ListenerUtils.extentTest.log(Status.PASS,"Enter an Employee Name");
		userManagePage.enterEmployeeName(JsonFileUtils.getAppTestDataFromJsonFileByKey("empFirstName"));
		Reporter.log("Employee Name entered successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Employee Name entered successfully...!!!");
		
		Reporter.log("Click on Search button");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Search button");
		userManagePage.clickSearchButton();
		Reporter.log("Search button clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Search button clicked successfully...!!!");
		
		Reporter.log("Verify the Searched Record");
		ListenerUtils.extentTest.log(Status.PASS,"Verify the Searched Record");
		Assert.assertTrue(userManagePage.searchedRecordFound(), "No Record Found...!!!");
		Reporter.log("Searched Record is Found...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Searched Record is Found...!!!");
		
		Reporter.log("Capture auto generated Employee ID");
		ListenerUtils.extentTest.log(Status.PASS,"Capture auto generated Employee ID");
		employeeID = empPage.getSearchedEmpID();
		Reporter.log("Employee ID captured successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Employee ID captured successfully...!!!");
		
		Reporter.log("Verify Employee First and Middle Name");
		ListenerUtils.extentTest.log(Status.PASS,"Verify Employee First and Middle Name");
		String empFirstAndMiddleName = JsonFileUtils.getAppTestDataFromJsonFileByKey("empFirstName")+" "+JsonFileUtils.getAppTestDataFromJsonFileByKey("empMiddleName");
		Assert.assertEquals(empPage.getSearchedEmpFirstAndMiddleName(), empFirstAndMiddleName, "Employee First and Middle Name does not matched...!!!");
		Reporter.log("Employee First and Middle Name verified successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Employee First and Middle Name verified successfully...!!!");
		
		Reporter.log("Verify Employee Last Name");
		ListenerUtils.extentTest.log(Status.PASS,"Verify Employee Last Name");
		Assert.assertEquals(empPage.getSearchedEmpLastName(), JsonFileUtils.getAppTestDataFromJsonFileByKey("empLastName"), "Employee Last Name does not matched...!!!");
		Reporter.log("Employee Last Name verified successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Employee Last Name verified successfully...!!!");
	}
}
