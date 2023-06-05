package com.orangehrm.pages;

import com.orangehrm.utils.PropertiesFileUtils;
import com.orangehrm.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    //Declaration of the WebDriver instance
    WebDriver driver;

    //PageFactory and initElements to initialize all the Web Elements
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Declaration of all the Web Elements using @findBy Annotation

    @FindBy(xpath = "(//a[contains(@href,'www.orangehrm.com')])[1]")
    private WebElement orangeHRMSidePanelHeaderLink;

    @FindBy(xpath = "//a[contains(@href, 'viewAdminModule')]")
    private WebElement adminMenuItem;

    @FindBy(xpath = "//h6[text()='Admin']")
    private WebElement adminPageHeader;

    @FindBy(xpath = "//a[contains(@href, 'viewPimModule')]")
    private WebElement pimMenuItem;

    @FindBy(xpath = "//h6[text()='PIM']")
    private WebElement pimPageHeader;

    @FindBy(xpath = "//a[contains(@href, 'viewLeaveModule')]")
    private WebElement leaveMenuItem;

    @FindBy(xpath = "//h6[text()='Leave']")
    private WebElement leavePageHeader;

    @FindBy(xpath = "//a[contains(@href, 'viewTimeModule')]")
    private WebElement timeMenuItem;

    @FindBy(xpath = "//h6[text()='Time']")
    private WebElement timePageHeader;

    @FindBy(xpath = "//a[contains(@href, 'viewRecruitmentModule')]")
    private WebElement recruitmentMenuItem;

    @FindBy(xpath = "//h6[text()='Recruitment']")
    private WebElement recruitmentPageHeader;

    @FindBy(xpath = "//a[contains(@href, 'viewMyDetails')]")
    private WebElement myInfoMenuItem;

    @FindBy(xpath = "//a[contains(@href, 'viewPerformanceModule')]")
    private WebElement performanceMenuItem;

    @FindBy(xpath = "//h6[text()='Performance']")
    private WebElement performancePageHeader;

    @FindBy(xpath = "//a[contains(@href, 'dashboard')]")
    private WebElement dashboardMenuItem;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardPageHeader;

    @FindBy(xpath = "//a[contains(@href, 'viewDirectory')]")
    private WebElement directoryMenuItem;

    @FindBy(xpath = "//h6[text()='Directory']")
    private WebElement directoryPageHeader;

    @FindBy(xpath = "//a[contains(@href, 'viewMaintenanceModule')]")
    private WebElement maintenanceMenuItem;

    @FindBy(xpath = "//h6[text()='Administrator Access']")
    private WebElement maintenancePageAdminAccessFormHeader;

    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    private WebElement maintenancePageAdministratorAccessConfirmBtn;

    @FindBy(xpath = "//h6[text()='Maintenance']")
    private WebElement maintenancePageHeader;

    @FindBy(xpath = "//a[contains(@href, 'viewBuzz')]")
    private WebElement buzzMenuItem;

    @FindBy(xpath = "//h6[text()='Buzz']")
    private WebElement buzzPageHeader;

    @FindBy(xpath="//p[@class='oxd-userdropdown-name']")
    private WebElement loggedInUserNameOption;

    @FindBy(xpath="//a[text()='Logout']")
    private WebElement logoutLink;

    //Click left side panel Orange HRM link
    public void clickOrangeHRMHeaderLink() {
        WaitUtils.waitForTheElementToBeClickable(driver, orangeHRMSidePanelHeaderLink, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        orangeHRMSidePanelHeaderLink.click();
    }

    //Click left side panel Admin menu item
    public void clickAdminMenu() {
        WaitUtils.waitForTheElementToBeClickable(driver, adminMenuItem, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        adminMenuItem.click();
    }

    //Get Admin page header value for verification
    public String getAdminPageHeader() {
        WaitUtils.waitForTheElementToBeVisible(driver, adminPageHeader, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        return adminPageHeader.getText();
    }

    //Click left side panel PIM menu item
    public void clickPIMMenu() {
        pimMenuItem.click();
    }

    //Get PIM page header value for verification
    public String getPIMPageHeader() {
        WaitUtils.waitForTheElementToBeVisible(driver, pimPageHeader, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        return pimPageHeader.getText();
    }

    //Click left side panel Leave menu item
    public void clickLeaveMenu() {
        leaveMenuItem.click();
    }

    //Get Leave page header value for verification
    public String getLeavePageHeader() {
        WaitUtils.waitForTheElementToBeVisible(driver, leavePageHeader, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        return leavePageHeader.getText();
    }

    //Click left side panel Time menu item
    public void clickTimeMenu() {
        timeMenuItem.click();
    }

    //Get Time page header value for verification
    public String getTimePageHeader() {
        WaitUtils.waitForTheElementToBeVisible(driver, timePageHeader, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        return timePageHeader.getText();
    }

    //Click left side panel Recruitment menu item
    public void clickRecruitmentMenu() {
        recruitmentMenuItem.click();
    }

    //Get Recruitment page header value for verification
    public String getRecruitmentPageHeader() {
        WaitUtils.waitForTheElementToBeVisible(driver, recruitmentPageHeader, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        return recruitmentPageHeader.getText();
    }

    //Click left side panel My Info menu item
    public void clickMyInfoMenu() {
        myInfoMenuItem.click();
    }

    //Get My Info page header value for verification
    public String getMyInfoPageHeader() {
        WaitUtils.waitForTheElementToBeVisible(driver, pimPageHeader, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        return pimPageHeader.getText();
    }

    //Click left side panel Performance menu item
    public void clickPerformanceMenu() {
        performanceMenuItem.click();
    }

    //Get Performance page header value for verification
    public String getPerformancePageHeader() {
        WaitUtils.waitForTheElementToBeVisible(driver, performancePageHeader, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        return performancePageHeader.getText();
    }

    //Click left side panel Dashboard menu item
    public void clickDashboardMenu() {
        dashboardMenuItem.click();
    }

    //Get Dashboard page header value for verification
    public String getDashboardPageHeader() {
        WaitUtils.waitForTheElementToBeVisible(driver, dashboardPageHeader, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        return dashboardPageHeader.getText();
    }

    //Click left side panel Directory menu item
    public void clickDirectoryMenu() {
        directoryMenuItem.click();
    }

    //Get Directory page header value for verification
    public String getDirectoryPageHeader() {
        WaitUtils.waitForTheElementToBeVisible(driver, directoryPageHeader, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        return directoryPageHeader.getText();
    }

    //Click left side panel Maintenance menu item
    public void clickMaintenanceMenu() {
        maintenanceMenuItem.click();
    }

    //Get Maintenance page Admin access form header value for verification
    public String getMaintenancePageAdminAccessFormHeader() {
        WaitUtils.waitForTheElementToBeVisible(driver, maintenancePageAdminAccessFormHeader, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        return maintenancePageAdminAccessFormHeader.getText();
    }

    //Click Confirm button
    public void clickConfirmButton() {
        maintenancePageAdministratorAccessConfirmBtn.click();
    }

    //Get Maintenance page header value for verification
    public String getMaintenancePageHeader() {
        WaitUtils.waitForTheElementToBeVisible(driver, maintenancePageHeader, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        return maintenancePageHeader.getText();
    }

    //Click left side panel Buzz menu item
    public void clickBuzzMenu() {
        buzzMenuItem.click();
    }

    //Get Buzz page header value for verification
    public String getBuzzPageHeader() {
        WaitUtils.waitForTheElementToBeVisible(driver, buzzPageHeader, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        return buzzPageHeader.getText();
    }

    //Click Logout link
    public void clickLogoutLink() {
        WaitUtils.waitForTheElementToBeClickable(driver, loggedInUserNameOption, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsLong"));
        loggedInUserNameOption.click();
        WaitUtils.waitForTheElementToBeClickable(driver, logoutLink, PropertiesFileUtils.getValueForTheKey("timeoutInSecondsShort"));
        logoutLink.click();
    }

}
