package com.orangehrm.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.PropertiesFileUtils;
import com.orangehrm.utils.ScrollUtils;
import com.orangehrm.utils.WaitUtils;

public class EmployeePage {

	//Declaration of the WebDriver, Actions and Robot instance
    WebDriver driver;
    Actions action;
    Robot robot;

    //PageFactory and initElements to initialize all the Web Elements
    public EmployeePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        action = new Actions(driver);
        try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
    }

    //Declaration of all the Web Elements using @findBy Annotation
    @FindBy(xpath="//button[normalize-space()='Add']")
    private WebElement addButton;
    
    @FindBy(name="firstName")
    private WebElement empFirstNameInputBox;
    
    @FindBy(name="middleName")
    private WebElement empMiddleNameInputBox;
    
    @FindBy(name="lastName")
    private WebElement empLastNameInputBox;
    
    @FindBy(xpath="//label[text()='Employee Id']//following::input[1]")
    private WebElement empIDInputBox;
    
    @FindBy(xpath="//span[text()='Employee Id already exists']")
    private WebElement empIDExistMessage;
    
    @FindBy(xpath="//img[@class='employee-image']")
    private WebElement empImageBox;
    
    @FindBy(xpath="//a[text()='Employee List']")
    private WebElement employeeListLink;
    
    @FindBy(xpath="(//div[@class='orangehrm-container']//following::div[@role='cell'])[2]//div")
    private WebElement searchedEmpID;
    
    @FindBy(xpath="(//div[@class='orangehrm-container']//following::div[@role='cell'])[3]//div")
    private WebElement searchedEmpFirstAndMiddleName;
    
    @FindBy(xpath="(//div[@class='orangehrm-container']//following::div[@role='cell'])[4]//div")
    private WebElement searchedEmpLastName;
    
    @FindBy(xpath="(//div[@class='orangehrm-container']//following::div[@role='cell'])[9]//button[1]")
    private WebElement searchedEmployeeDeleteButton;
    
    @FindBy(xpath="//button[normalize-space()='Yes, Delete']")
    private WebElement searchedRecordDeleteYesOptionButton;

    //Method to enter Employee First Name
    public void enterEmpFirstName(String empFirstName) {
    	WaitUtils.waitForTheElementToBeVisible(driver, empFirstNameInputBox, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
    	empFirstNameInputBox.sendKeys(empFirstName);
    }
    
    //Method to enter Employee Middle Name
    public void enterEmpMiddleName(String empMiddleName) {
    	WaitUtils.waitForTheElementToBeVisible(driver, empMiddleNameInputBox, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
    	empMiddleNameInputBox.sendKeys(empMiddleName);
    }
    
    //Method to enter Employee Last Name
    public void enterEmpLastName(String empLastName) {
    	WaitUtils.waitForTheElementToBeVisible(driver, empLastNameInputBox, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
    	empLastNameInputBox.sendKeys(empLastName);
    }
    
    //Method to enter Employee ID
    public void enterEmployeeID(String empID) {
        WaitUtils.waitForTheElementToBeVisible(driver, empIDInputBox, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        empIDInputBox.sendKeys(empID);
    }

    //method to double click on Element
    public void doubleClickOnEmpIDInputBox() {
        WaitUtils.waitForTheElementToBeVisible(driver, empIDInputBox, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
        action.doubleClick(empIDInputBox).build().perform();
        WaitUtils.waitGeneric(2000);
    }

    //Method to enter Employee ID
    public boolean isEmployeeIDExists() {
        try {
            WaitUtils.waitForTheElementToBeVisible(driver, empIDExistMessage, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Method to get Employee ID
    public String getEmployeeID() {
        WaitUtils.waitForTheElementToBeVisible(driver, searchedEmpID, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
        return searchedEmpID.getText();
    }
    
    //Method to upload profile picture using Robot class
    public void uploadImage(String imagePath) throws InterruptedException {
    	WaitUtils.waitForTheElementToBeClickable(driver, empImageBox, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
    	empImageBox.click();
    	WaitUtils.waitGeneric(5000);
    	StringSelection imageData = new StringSelection(imagePath);
    	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(imageData, null);
    	
    	robot.keyPress(KeyEvent.VK_CONTROL);
    	robot.keyPress(KeyEvent.VK_V);
    	robot.keyRelease(KeyEvent.VK_CONTROL);
    	robot.keyRelease(KeyEvent.VK_V);
    	
    	WaitUtils.waitGeneric(3000);
    	robot.keyPress(KeyEvent.VK_ENTER);
    	robot.keyRelease(KeyEvent.VK_ENTER);
        WaitUtils.waitGeneric(7000);
    }

    public void uploadImageDummy() {
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(PropertiesFileUtils.getValueForTheKey("imagePath"));
    }
    
    //Method to click Employee List link menu
    public void clickEmployeeListLinkMenu() {
    	WaitUtils.waitForTheElementToBeClickable(driver, employeeListLink, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
    	employeeListLink.click();
    }
    
    //Method to get searched Employee ID
    public String getSearchedEmpID() {
        WaitUtils.waitForTheElementToBeVisible(driver, searchedEmpID, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
        ScrollUtils.scrollToElement(driver, searchedEmpID);
        return searchedEmpID.getText();
    }
    
   //Method to get searched Employee First and Middle Name
    public String getSearchedEmpFirstAndMiddleName() {
        WaitUtils.waitForTheElementToBeVisible(driver, searchedEmpFirstAndMiddleName, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
        return searchedEmpFirstAndMiddleName.getText();
    }
    
  //Method to get searched Employee Last Name
    public String getSearchedEmpLastName() {
        WaitUtils.waitForTheElementToBeVisible(driver, searchedEmpLastName, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
        return searchedEmpLastName.getText();
    }  
    
    
   //Method to click searched employee Delete button
    public void clickDeleteButton() {
    	WaitUtils.waitForTheElementToBeClickable(driver, searchedEmployeeDeleteButton, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
    	searchedEmployeeDeleteButton.click();
    	WaitUtils.waitForTheElementToBeClickable(driver, searchedRecordDeleteYesOptionButton, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
    	searchedRecordDeleteYesOptionButton.click();
    }
}