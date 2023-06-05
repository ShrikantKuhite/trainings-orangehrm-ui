package com.orangehrm.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {

	// private static final Logger LOG = LogManager.getLogger ("Retry.class");
	private static final int RETRY_LIMIT = 1;
	private int count = 0;

	@Override
	public boolean retry(ITestResult iTestResult) {
		if (count < RETRY_LIMIT) {
			count++;
			return true;
		}
		return false;
	}

}
