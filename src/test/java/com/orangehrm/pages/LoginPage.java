package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.utils.PropertiesFileUtils;
import com.orangehrm.utils.WaitUtils;

public class LoginPage {
	
    //Declaration of the WebDriver instance
    WebDriver driver;

    //PageFactory and initElements to initialize all the Web Elements
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Declaration of all the Web Elements using @findBy Annotation
    @FindBy(name="username")
    private WebElement userNameInputBox;

    @FindBy(name="password")
    private WebElement passwordInputBox;

    @FindBy(xpath="//button[normalize-space()='Login']")
    private WebElement loginBtn;

    //Method to enter UserName
    public void enterUserName(String userName) {
        WaitUtils.waitForTheElementToBeVisible(driver, userNameInputBox, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        userNameInputBox.sendKeys(userName);
    }

    //Method to enter Password
    public void enterPassword(String password) {
        WaitUtils.waitForTheElementToBeVisible(driver, passwordInputBox, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
        passwordInputBox.sendKeys(password);
    }

    //Method to click Login button
    public void clickLoginButton() {
        WaitUtils.waitForTheElementToBeClickable(driver, loginBtn, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
        loginBtn.click();
    }
}