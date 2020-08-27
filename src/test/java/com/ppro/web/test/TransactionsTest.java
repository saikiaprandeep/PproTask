package com.ppro.web.test;


import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.ppro.web.base.BaseWeb;
import com.ppro.web.pages.PagePayment;
import com.ppro.web.util.RetryAnalyzer;
import com.ppro.web.util.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ExtentITestListenerClassAdapter.class})
public class TransactionsTest extends BaseWeb {

    PagePayment paypage = new PagePayment(driver);

    @Test(dataProvider = "testDataSuccesfulTransactions", dataProviderClass = TestDataProvider.class, retryAnalyzer = RetryAnalyzer.class, groups = {"a:Prandeep"},
            description = "Verify Transaction is successful with valid combination of Country and Currency")
    public void verifySuccessTransactionsWithValidCombinations(String currency, String country) throws Exception {

        paypage.txtAmount().enterValue("5000");
        paypage.selectCurrency().selectByValue(currency);
        paypage.selectCountry().selectByValue(country);
        paypage.btnPAY().click();

        Assert.assertEquals("Transaction Succeded", paypage.verifyPayment().getText());

    }

    @Test(dataProvider = "testDataFailedTransactions", dataProviderClass = TestDataProvider.class, retryAnalyzer = RetryAnalyzer.class, groups = {"a:Prandeep"},
            description = "Verify Transaction is failed with wrong combination of Country and Currency")
    public void verifyFailedTransactionsWithWrongCombinations(String currency, String country) throws Exception {

        paypage.txtAmount().enterValue("5000");
        paypage.selectCurrency().selectByValue(currency);
        paypage.selectCountry().selectByValue(country);
        paypage.btnPAY().click();

        Assert.assertEquals("Transaction Failed", paypage.verifyPayment().getText());
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, groups = {"a:Prandeep"}, description = "Verify Transaction is failed with zero Amount")
    public void verifyFailedTransactionsWithZeroAmount() throws Exception {


        paypage.txtAmount().enterValue("0");
        paypage.selectCurrency().selectByValue("EUR");
        paypage.selectCountry().selectByValue("DE");
        paypage.btnPAY().click();

        Assert.assertEquals("Transaction Failed", paypage.verifyPayment().getText());


    }


}
