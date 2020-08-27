package com.ppro.web.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Class used to implement Retry Test case if failed.
 * Retry count can be configured
 */
public class RetryAnalyzer implements IRetryAnalyzer {

    int counter = 0;
    int retryLimit = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (counter < retryLimit) {
            counter++;
            return true;
        }
        return false;
    }
}