package com.orangehrm.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtils {

    //Creation of Extent Reports object
    public static ExtentReports extentReports = new ExtentReports();

    /**
     * Method which configures the Extent Report
     * @param fileName
     * @return
     */
    public static ExtentReports createInstance(String fileName) {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setReportName(fileName);

        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Quality Assurance Analyst", "Shrikant Kuhite");
        extentReports.setSystemInfo("Organization", "Shri InfoTech");

        return extentReports;
    }
}
