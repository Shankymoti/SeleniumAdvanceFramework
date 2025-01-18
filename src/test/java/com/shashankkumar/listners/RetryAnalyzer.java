package com.shashankkumar.listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetry = 3;

    @Override
    public boolean retry(ITestResult iTestResult){
        if(retryCount < maxRetry){
            retryCount++;
            return true;
        }
           return false;
    }
}
