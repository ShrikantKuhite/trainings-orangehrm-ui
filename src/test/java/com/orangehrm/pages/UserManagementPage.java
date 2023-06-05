package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.PropertiesFileUtils;
import com.orangehrm.utils.ScrollUtils;
import com.orangehrm.utils.WaitUtils;

public class UserManagementPage {

	//Declaration of the WebDriver instance
    WebDriver driver;
    Actions action;

    //PageFactory and initElements to initialize all the Web Elements
    public UserManagementPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        action = new Actions(driver);
    }

    //Declaration of all the Web Elements using @findBy Annotation
    @FindBy(xpath="//button[normalize-space()='Add']")
    private WebElement addButton;

    @FindBy(xpath="//h6[text()='Edit User']")
    private WebElement editUserHeader;

    @FindBy(xpath="//label[normalize-space()='User Role']//following::div[4]")
    private WebElement userRoleDropdown;

    @FindBy(xpath="//label[normalize-space()='Status']//following::div[4]")
    private WebElement statusDropdown;

    @FindBy(xpath="//div[@role='listbox']//div//span")
    private List<WebElement> commonDropdownListOptions;

    @FindBy(xpath="//label[text()='Employee Name']//following::input[1]")
    private WebElement employeeNameInputBox;
    
    @FindBy(xpath="//label[normalize-space()='Username']//following::input[1]")
    private WebElement userNameInputBox;
    
    @FindBy(xpath="//label[normalize-space()='Password']//following::input[1]")
    private WebElement passwordInputBox;
    
    @FindBy(xpath="//label[normalize-space()='Confirm Password']//following::input[1]")
    private WebElement confirmPasswordInputBox;
    
    @FindBy(xpath="//button[normalize-space()='Save']")
    private WebElement saveButton;
    
    @FindBy(xpath="//button[normalize-space()='Search']")
    private WebElement searchButton;
    
    @FindBy(xpath="//button[normalize-space()='Reset']")
    private WebElement resetButton;
    
    @FindBy(xpath="//span[text()='(1) Record Found']")
    private WebElement recordFoundLabel;
    
    @FindBy(xpath="//span[text()='No Records Found']")
    private WebElement noRecordFoundLabel;
    
    @FindBy(xpath="(//div[@class='orangehrm-container']//following::div[@role='cell'])[2]//div")
    private WebElement searchedUsername;

    @FindBy(xpath="(//div[@class='orangehrm-container']//following::div[@role='cell'])[3]//div")
    private WebElement searchedUserRole;
    
    @FindBy(xpath="(//div[@class='orangehrm-container']//following::div[@role='cell'])[4]//div")
    private WebElement searchedEmployeeName;
    
    @FindBy(xpath="(//div[@class='orangehrm-container']//following::div[@role='cell'])[5]//div")
    private WebElement searchedStatus;
    
    @FindBy(xpath="(//div[@class='orangehrm-container']//following::div[@role='cell'])[6]//div//button[1]")
    private WebElement searchedUserDeleteButton;
    
    @FindBy(xpath="//button[normalize-space()='Yes, Delete']")
    private WebElement searchedRecordDeleteYesOptionButton;
    
    @FindBy(xpath="(//div[@class='orangehrm-container']//following::div[@role='cell'])[6]//div//button[2]")
    private WebElement searchedRecordEditButton;
    
    //Method to click Add button
    public void clickAddButton() {
    	WaitUtils.waitForTheElementToBeClickable(driver, addButton, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
    	addButton.click();
    }

    //Method to check Edit user page displayed with header
    public boolean isEditUserPageDisplayed() {
        WaitUtils.waitForTheElementToBeClickable(driver, editUserHeader, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        return editUserHeader.isDisplayed();
    }
//    //Method to select User Role
//    public void selectUserRole(String userRole) throws InterruptedException {
//        WaitUtils.waitForTheElementToBeClickable(driver, userRoleDropdown, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
//        WaitUtils.waitGeneric(5000);
//        action.click(userRoleDropdown).build().perform();
//        WaitUtils.waitGeneric(2000);
//        if (userRole.equals("Admin")) {
//            action.sendKeys(Keys.ARROW_DOWN).perform();
//            WaitUtils.waitGeneric(1000);
//            action.sendKeys(Keys.ENTER).perform();
//        } else {
//            action.sendKeys(Keys.ARROW_DOWN).perform();
//            WaitUtils.waitGeneric(1000);
//            action.sendKeys(Keys.ARROW_DOWN).perform();
//            WaitUtils.waitGeneric(1000);
//            action.sendKeys(Keys.ENTER).perform();
//        }
//    }

    //Method to select User Role
    public void selectUserRole(String userRole) throws InterruptedException {
        WaitUtils.waitForTheElementToBeClickable(driver, userRoleDropdown, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        userRoleDropdown.click();
        WaitUtils.waitGeneric(2000);
        for (WebElement userRoleOption : commonDropdownListOptions) {
            if (userRoleOption.getText().equalsIgnoreCase(userRole)) {
                userRoleOption.click();
                break;
            } else {
                System.out.println("No Specific Role for Selection...!!!");
            }
        }
    }
    
//    //Method to select Status
//    public void selectStatus(String status) throws InterruptedException {
//    	WaitUtils.waitForTheElementToBeClickable(driver, statusDropdown, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
//    	action.click(statusDropdown).build().perform();
//    	WaitUtils.waitGeneric(2000);
//    	if(status.equals("Enabled")) {
//    		action.sendKeys(Keys.ARROW_DOWN).perform();
//    		WaitUtils.waitGeneric(1000);
//            action.sendKeys(Keys.ENTER).perform();
//    	} else {
//    		action.sendKeys(Keys.ARROW_DOWN).perform();
//    		WaitUtils.waitGeneric(1000);
//    		action.sendKeys(Keys.ARROW_DOWN).perform();
//    		WaitUtils.waitGeneric(1000);
//            action.sendKeys(Keys.ENTER).perform();
//    	}
//    }

    //Method to select Status
    public void selectStatus(String status) throws InterruptedException {
        WaitUtils.waitForTheElementToBeClickable(driver, statusDropdown, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
        statusDropdown.click();
        WaitUtils.waitGeneric(2000);
        for (WebElement statusOption : commonDropdownListOptions) {
            if (statusOption.getText().equalsIgnoreCase(status)) {
                statusOption.click();
                break;
            } else {
                System.out.println("No Specific Status for Selection...!!!");
            }
        }
    }
    //Method to enter Employee Name
    public void enterEmployeeName(String employeeName) throws InterruptedException {
        WaitUtils.waitForTheElementToBeVisible(driver, employeeNameInputBox, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
        employeeNameInputBox.sendKeys(employeeName);
        WaitUtils.waitGeneric(3000);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        WaitUtils.waitGeneric(1000);
        action.sendKeys(Keys.ENTER).perform();
    }
    
    //Method to enter UserName
    public void enterUserName(String userName) {
        WaitUtils.waitForTheElementToBeVisible(driver, userNameInputBox, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        //userNameInputBox.clear();
        userNameInputBox.sendKeys(userName);
    }
    
    //Method to double click on particular TextBox to select it so that we can clear it by enter another value
    public void doubleClickToSelectElementValue() {
    	WaitUtils.waitForTheElementToBeVisible(driver, userNameInputBox, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
    	action.doubleClick(userNameInputBox).build().perform();
    }
    
    //Method to enter Password
    public void enterPassword(String password) {
        WaitUtils.waitForTheElementToBeVisible(driver, passwordInputBox, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
        passwordInputBox.sendKeys(password);
    }
    
    //Method to enter Password again
    public void enterConfirmPassword(String confirmPassword) {
        WaitUtils.waitForTheElementToBeVisible(driver, confirmPasswordInputBox, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
        confirmPasswordInputBox.sendKeys(confirmPassword);
    }
    
    //Method to click Save button
    public void clickSaveButton() {
    	WaitUtils.waitForTheElementToBeClickable(driver, saveButton, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
    	saveButton.click();
    }
    
  //Method to click Reset button
    public void clickResetButton() {
    	WaitUtils.waitForTheElementToBeClickable(driver, resetButton, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
    	resetButton.click();
    }
    
    //Method to click Search button
    public void clickSearchButton() {
    	WaitUtils.waitForTheElementToBeClickable(driver, searchButton, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
    	searchButton.click();
    }
    
    //Method to check the record is found
    public boolean searchedRecordFound() {
    	WaitUtils.waitForTheElementToBeVisible(driver, recordFoundLabel, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
    	return recordFoundLabel.isDisplayed();
    }
    
  //Method to check the no record is found
    public boolean noSearchedRecordFound() {
    	WaitUtils.waitForTheElementToBeVisible(driver, noRecordFoundLabel, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
    	return noRecordFoundLabel.isDisplayed();
    }
    
   //Method to get User Name
    public String getSearchedUserName() {
        WaitUtils.waitForTheElementToBeVisible(driver, searchedUsername, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        ScrollUtils.scrollToElement(driver, searchedUsername);
        return searchedUsername.getText();
    }
    
    //Method to get User Role
    public String getSearchedUserRole() {
        WaitUtils.waitForTheElementToBeVisible(driver, searchedUserRole, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
        return searchedUserRole.getText();
    }
    
    //Method to get Employee Name
    public String getSearchedEmployeeName() {
        WaitUtils.waitForTheElementToBeVisible(driver, searchedEmployeeName, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
        return searchedEmployeeName.getText();
    }
    
    //Method to get Status
    public String getSearchedStatus() {
        WaitUtils.waitForTheElementToBeVisible(driver, searchedStatus, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
        return searchedStatus.getText();
    }
    
   //Method to click searched record Edit button
    public void clickEditButton() {
    	WaitUtils.waitForTheElementToBeClickable(driver, searchedRecordEditButton, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
    	searchedRecordEditButton.click();
    }
    
   //Method to click searched record Delete button
    public void clickDeleteButton() {
    	WaitUtils.waitForTheElementToBeClickable(driver, searchedUserDeleteButton, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
    	searchedUserDeleteButton.click();
    	WaitUtils.waitForTheElementToBeClickable(driver, searchedRecordDeleteYesOptionButton, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
    	searchedRecordDeleteYesOptionButton.click();
    	
    }
}