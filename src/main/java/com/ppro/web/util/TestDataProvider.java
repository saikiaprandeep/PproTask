package com.ppro.web.util;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.Iterator;

/**
 * Class to pass Test data to test methods
 */
public class TestDataProvider {

    ReadTestData readTestData = new ReadTestData();

    @DataProvider(name = "testDataSuccesfulTransactions")
    public Iterator<Object[]> testData0() throws IOException {
        return readTestData.parseCsvData(getClass().getResourceAsStream("/testData/testDataSuccessTransactions.csv"));
    }


    @DataProvider(name = "testDataFailedTransactions")
    public Iterator<Object[]> testData1() throws IOException {
        return readTestData.parseCsvData(getClass().getResourceAsStream("/testData/testDataFailedTransactions.csv"));
    }
}
