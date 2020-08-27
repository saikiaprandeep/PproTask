package com.ppro.web.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Selenium Actions are present here like select , rightclick, mouseclick etc
 */
public class Actions {

    private WebElement element;
    private WebDriver driver;
    Logger log = LogManager.getLogger(getClass());

    public void setDriverAndWebElement(WebDriver driver, WebElement element) {
        this.element = element;
        this.driver = driver;
    }

    public void click() throws Exception {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
            log.info(element + " is succesfully clicked");
        } catch (Exception e) {
            log.error("Cannot click " + element);
            e.printStackTrace();
            throw new Exception("Cannot click " + element);
        }
    }

    public void enterValue(String value) throws Exception {
        try {
            element.clear();
            element.sendKeys(value);
            log.info("Entered value: " + value + " on " + element);
        } catch (Exception e) {
            log.error("Cannot enter: " + value + " on " + element);
            throw new Exception();
        }
    }

    public void selectByIndex(int index) throws Exception {
        try {
            Select select = new Select(element);
            select.selectByIndex(index);
            log.info("Selected " + element + " with " + index);
        } catch (Exception e) {
            log.error("Cannot select: " + element + " with " + index);
            throw new Exception("Cannot select: " + element + " with " + index);
        }
    }

    public void selectByValue(String value) throws Exception {
        try {
            Select select = new Select(element);
            select.selectByValue(value);
            log.info("Selected " + element + " with " + value);
        } catch (Exception e) {
            log.error("Cannot select: " + element + " with " + value);
            throw new Exception("Cannot select: " + element + " with " + value);
        }
    }

    public String getText() throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20, 2000);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            String text = element.getText();
            log.info(element + " found with gettext String: " + text);
            return text;
        } catch (Exception e) {
            log.error(element + " not found with gettext String");
            throw new Exception(element + " not found with gettext String");
        }
    }

    public boolean isDisplayed() {
        if (element.isDisplayed()) log.info(element + " is displayed");
        else log.info(element + " is not displayed");
        return element.isDisplayed();
    }

    public void rightClick() throws Exception {

        try {
            org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
            actions.moveToElement(element).contextClick().build().perform();
            log.info(element + " is succesfully rightClicked");
        } catch (Exception e) {
            log.error("Cannot rightClicked " + element);
            throw new Exception("Cannot RightClicked " + element);
        }
    }
}
