package com.ppro.web.pages;


import com.ppro.web.util.Actions;
import com.ppro.web.util.Element;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Elements of Homepage are present here
 */
public class PagePayment {

    Logger log = LogManager.getLogger(getClass());
    private WebDriver driver;
    private WebElement webElement;

    public PagePayment(WebDriver driver) {
        this.driver = driver;
    }

    Element element = new Element();
    Actions actions = new Actions();

    public Actions txtAmount() throws Exception {
        webElement = element.getElement(driver, By.id("amount"), 5);
        actions.setDriverAndWebElement(driver, webElement);
        log.info("Element found");
        return actions;
    }

    public Actions selectCurrency() throws Exception {
        webElement = element.getElement(driver, By.id("currency"), 5);
        actions.setDriverAndWebElement(driver, webElement);
        log.info("Element found");
        return actions;
    }

    public Actions selectCountry() throws Exception {
        webElement = element.getElement(driver, By.id("country"), 5);
        actions.setDriverAndWebElement(driver, webElement);
        log.info("Element found");
        return actions;
    }

    public Actions btnPAY() throws Exception {
        webElement = element.getElement(driver, By.xpath("//form[@class='login-form']//button"), 5);
        actions.setDriverAndWebElement(driver, webElement);
        log.info("Element found");
        return actions;
    }

    public Actions verifyPayment() throws Exception {
        webElement = element.getElement(driver, By.id("pay"), 5);
        actions.setDriverAndWebElement(driver, webElement);
        log.info("Element found");
        return actions;
    }
}
