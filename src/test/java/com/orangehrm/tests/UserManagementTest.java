package com.orangehrm.tests;

import com.aventstack.extentreports.Status;
import com.orangehrm.utils.ListenerUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.orangehrm.driverfactory.WebDriverSession;
import com.orangehrm.pages.EmployeePage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.UserManagementPage;
import com.orangehrm.utils.JsonFileUtils;

public class UserManagementTest extends WebDriverSession {

	// Method to add a user
	@Test(priority = 1, enabled = true)
	public void addUser() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		UserManagementPage userManagePage = new UserManagementPage(driver);

		Reporter.log("Click on Admin Menu");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Admin Menu");
		homePage.clickAdminMenu();
		Reporter.log("Admin Menu clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Admin Menu clicked successfully...!!!");

		Reporter.log("Click on Add button");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Add button");
		userManagePage.clickAddButton();
		Reporter.log("Add button clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Add button clicked successfully...!!!");

		Reporter.log("Select an User Role");
		ListenerUtils.extentTest.log(Status.PASS,"Select an User Role");
		userManagePage.selectUserRole(JsonFileUtils.getAppTestDataFromJsonFileByKey("userRole"));
		Reporter.log("User Role selected successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"User Role selected successfully...!!!");

		Reporter.log("Enter an Employee Name");
		ListenerUtils.extentTest.log(Status.PASS,"Enter an Employee Name");
		userManagePage.enterEmployeeName(JsonFileUtils.getAppTestDataFromJsonFileByKey("empFirstName"));
		Reporter.log("Employee Name entered successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Employee Name entered successfully...!!!");

		Reporter.log("Select the Status");
		ListenerUtils.extentTest.log(Status.PASS,"Select the Status");
		userManagePage.selectStatus(JsonFileUtils.getAppTestDataFromJsonFileByKey("status"));
		Reporter.log("Status selected successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Status selected successfully...!!!");

		Reporter.log("Enter an User Name");
		ListenerUtils.extentTest.log(Status.PASS,"Enter an User Name");
		userManagePage.enterUserName(JsonFileUtils.getAppTestDataFromJsonFileByKey("userName"));
		Reporter.log("User Name entered successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"User Name entered successfully...!!!");

		Reporter.log("Enter the Password");
		ListenerUtils.extentTest.log(Status.PASS,"Enter the Password");
		userManagePage.enterPassword(JsonFileUtils.getAppTestDataFromJsonFileByKey("password"));
		Reporter.log("Password entered successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Password entered successfully...!!!");

		Reporter.log("Enter the Confirm Password");
		ListenerUtils.extentTest.log(Status.PASS,"Enter the Confirm Password");
		userManagePage.enterConfirmPassword(JsonFileUtils.getAppTestDataFromJsonFileByKey("password"));
		Reporter.log("Confirm Password entered successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Confirm Password entered successfully...!!!");

		Reporter.log("Click on Save button");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Save button");
		userManagePage.clickSaveButton();
		Reporter.log("Save button clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Save button clicked successfully...!!!");
	}

	// Method to search user and verify
	@Test(priority = 2, enabled = true)
	public static void searchUserAndVerify() {
		UserManagementPage userManagePage = new UserManagementPage(driver);

		Reporter.log("Click on Reset button");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Reset button");
		userManagePage.clickResetButton();
		Reporter.log("Reset button clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Reset button clicked successfully...!!!");

		Reporter.log("Enter an User Name");
		ListenerUtils.extentTest.log(Status.PASS,"Enter an User Name");
		userManagePage.enterUserName(JsonFileUtils.getAppTestDataFromJsonFileByKey("userName"));
		Reporter.log("User Name entered successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"User Name entered successfully...!!!");

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

		Reporter.log("Verify an User Name");
		ListenerUtils.extentTest.log(Status.PASS,"Verify an User Name");
		Assert.assertEquals(userManagePage.getSearchedUserName(),
				JsonFileUtils.getAppTestDataFromJsonFileByKey("userName"), "User Name does not matched...!!!");
		Reporter.log("User Name verified successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"User Name verified successfully...!!!");

		Reporter.log("Verify an User Role");
		ListenerUtils.extentTest.log(Status.PASS,"Verify an User Role");
		Assert.assertEquals(userManagePage.getSearchedUserRole(),
				JsonFileUtils.getAppTestDataFromJsonFileByKey("userRole"), "User Role does not matched...!!!");
		Reporter.log("User Role verified successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"User Role verified successfully...!!!");

		Reporter.log("Verify an Employee Name");
		ListenerUtils.extentTest.log(Status.PASS,"Verify an Employee Name");
		Assert.assertEquals(userManagePage.getSearchedEmployeeName(),
				JsonFileUtils.getAppTestDataFromJsonFileByKey("empName"), "Employee Name does not matched...!!!");
		Reporter.log("Employee Name verified successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Employee Name verified successfully...!!!");

		Reporter.log("Verify the Status");
		ListenerUtils.extentTest.log(Status.PASS,"Verify the Status");
		Assert.assertEquals(userManagePage.getSearchedStatus(), JsonFileUtils.getAppTestDataFromJsonFileByKey("status"),
				"Status does not matched...!!!");
		Reporter.log("Status verified successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Status verified successfully...!!!");
	}

	// Method to update user details and verify
	@Test(priority = 3, enabled = true)
	public void updateUserAndVerify() throws InterruptedException {
		UserManagementPage userManagePage = new UserManagementPage(driver);

		Reporter.log("Click on Edit button");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Edit button");
		userManagePage.clickEditButton();
		Reporter.log("Edit button clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Edit button clicked successfully...!!!");

		Reporter.log("Verify the Edit User page");
		ListenerUtils.extentTest.log(Status.PASS,"Verify the Edit User page");
		Assert.assertTrue(userManagePage.isEditUserPageDisplayed(), "Edit user page does not displayed");
		Reporter.log("Edit User page verified successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Edit User page verified successfully...!!!");

		Reporter.log("Select new User Role");
		ListenerUtils.extentTest.log(Status.PASS,"Select new User Role");
		userManagePage.selectUserRole(JsonFileUtils.getAppTestDataFromJsonFileByKey("updatedUserRole"));
		Reporter.log("New User Role selected successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"New User Role selected successfully...!!!");

		Reporter.log("Select new Status");
		ListenerUtils.extentTest.log(Status.PASS,"Select new Status");
		userManagePage.selectStatus(JsonFileUtils.getAppTestDataFromJsonFileByKey("updatedStatus"));
		Reporter.log("New Status selected successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"New Status selected successfully...!!!");

		Reporter.log("Enter new User Name");
		ListenerUtils.extentTest.log(Status.PASS,"Enter new User Name");
		userManagePage.doubleClickToSelectElementValue();
		userManagePage.enterUserName(JsonFileUtils.getAppTestDataFromJsonFileByKey("updatedUserName"));
		Reporter.log("New User Name entered successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"New User Name entered successfully...!!!");

		Reporter.log("Click on Save button");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Save button");
		userManagePage.clickSaveButton();
		Reporter.log("Save button clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Save button clicked successfully...!!!");

		Reporter.log("Click on Reset button");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Reset button");
		userManagePage.clickResetButton();
		Reporter.log("Reset button clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Reset button clicked successfully...!!!");

		Reporter.log("Enter an User Name");
		ListenerUtils.extentTest.log(Status.PASS,"Enter an User Name");
		userManagePage.enterUserName(JsonFileUtils.getAppTestDataFromJsonFileByKey("updatedUserName"));
		Reporter.log("User Name entered successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"User Name entered successfully...!!!");

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

		Reporter.log("Verify an updated User Name");
		ListenerUtils.extentTest.log(Status.PASS,"Verify an updated User Name");
		Assert.assertEquals(userManagePage.getSearchedUserName(),
				JsonFileUtils.getAppTestDataFromJsonFileByKey("updatedUserName"), "User Name does not matched...!!!");
		Reporter.log("User Name updated successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"User Name updated successfully...!!!");

		Reporter.log("Verify an updated User Role");
		ListenerUtils.extentTest.log(Status.PASS,"Verify an updated User Role");
		Assert.assertEquals(userManagePage.getSearchedUserRole(),
				JsonFileUtils.getAppTestDataFromJsonFileByKey("updatedUserRole"), "User Role does not matched...!!!");
		Reporter.log("User Role updated successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"User Role updated successfully...!!!");

		Reporter.log("Verify an Employee Name");
		ListenerUtils.extentTest.log(Status.PASS,"Verify an Employee Name");
		Assert.assertEquals(userManagePage.getSearchedEmployeeName(),
				JsonFileUtils.getAppTestDataFromJsonFileByKey("empName"), "Employee Name does not matched...!!!");
		Reporter.log("Employee Name verified successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Employee Name verified successfully...!!!");

		Reporter.log("Verify updated Status");
		ListenerUtils.extentTest.log(Status.PASS,"Verify updated Status");
		Assert.assertEquals(userManagePage.getSearchedStatus(),
				JsonFileUtils.getAppTestDataFromJsonFileByKey("updatedStatus"), "Status does not matched...!!!");
		Reporter.log("Status updated successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Status updated successfully...!!!");
	}

	// Method to delete an user and verify successful deletion
	@Test(priority = 4, enabled = true)
	public void deleteUserAndVerify() {
		UserManagementPage userManagePage = new UserManagementPage(driver);

		Reporter.log("Click on Delete button");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Delete button");
		userManagePage.clickDeleteButton();
		Reporter.log("Delete button clicked successfully....!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Delete button clicked successfully....!!!");

		Reporter.log("Click on Reset button");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Reset button");
		userManagePage.clickResetButton();
		Reporter.log("Reset button clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Reset button clicked successfully...!!!");

		Reporter.log("Enter an User Name");
		ListenerUtils.extentTest.log(Status.PASS,"Enter an User Name");
		userManagePage.enterUserName(JsonFileUtils.getAppTestDataFromJsonFileByKey("updatedUserName"));
		Reporter.log("User Name entered successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"User Name entered successfully...!!!");

		Reporter.log("Click on Search button");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Search button");
		userManagePage.clickSearchButton();
		Reporter.log("Search button clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Search button clicked successfully...!!!");

		Reporter.log("Verify the Searched Record");
		ListenerUtils.extentTest.log(Status.PASS,"Verify the Searched Record");
		Assert.assertTrue(userManagePage.noSearchedRecordFound(), "Searched record is Found...!!!");
		Reporter.log("Searched Record does not Found, so User deleted successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Searched Record does not Found, so User deleted successfully...!!!");
	}

	// Method to delete an employee and verify successful deletion
	@Test(priority = 5, enabled = true)
	public void deleteEmployeeAndVerify() {
		HomePage homePage = new HomePage(driver);
		EmployeePage empPage = new EmployeePage(driver);
		UserManagementPage userManagePage = new UserManagementPage(driver);

		Reporter.log("Click PIM Menu");
		ListenerUtils.extentTest.log(Status.PASS,"Click PIM Menu");
		homePage.clickPIMMenu();
		Reporter.log("PIM Menu clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"PIM Menu clicked successfully...!!!");

		Reporter.log("Enter Employee ID : "+EmployeeTest.employeeID);
		ListenerUtils.extentTest.log(Status.PASS,"Enter Employee ID");
		empPage.enterEmployeeID(EmployeeTest.employeeID);
		Reporter.log("Employee ID entered successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Employee ID entered successfully...!!!");

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

		Reporter.log("Verify an Employee ID");
		ListenerUtils.extentTest.log(Status.PASS,"Verify an Employee ID");
		Assert.assertEquals(empPage.getEmployeeID(), EmployeeTest.employeeID, "Employee ID does not matched...!!!");
		Reporter.log("Employee ID verified successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Employee ID verified successfully...!!!");

		Reporter.log("Click on Delete button");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Delete button");
		empPage.clickDeleteButton();
		Reporter.log("Delete button clicked successfully....!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Delete button clicked successfully....!!!");
		
		Reporter.log("Click on Reset button");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Reset button");
		userManagePage.clickResetButton();
		Reporter.log("Reset button clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Reset button clicked successfully...!!!");
		
		Reporter.log("Enter an Employee ID : "+EmployeeTest.employeeID);
		ListenerUtils.extentTest.log(Status.PASS,"Enter an Employee ID");
		empPage.enterEmployeeID(EmployeeTest.employeeID);
		Reporter.log("Employee ID entered successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Employee ID entered successfully...!!!");

		Reporter.log("Click on Search button");
		ListenerUtils.extentTest.log(Status.PASS,"Click on Search button");
		userManagePage.clickSearchButton();
		Reporter.log("Search button clicked successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Search button clicked successfully...!!!");
		
		Reporter.log("Verify the Searched Record");
		ListenerUtils.extentTest.log(Status.PASS,"Verify the Searched Record");
		Assert.assertTrue(userManagePage.noSearchedRecordFound(), "Searched record is Found...!!!");
		Reporter.log("Searched Record does not Found, so User deleted successfully...!!!");
		ListenerUtils.extentTest.log(Status.PASS,"Searched Record does not Found, so User deleted successfully...!!!");
	}
}
