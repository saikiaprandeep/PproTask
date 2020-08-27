package com.ppro.web.pages;


import com.ppro.web.util.Actions;
import com.ppro.web.util.Element;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Common Page to keep elements common in most pages like Submit, OK , Cancel
 */
public class PageCommon {

    Logger log = LogManager.getLogger(getClass());
    private WebDriver driver;
    private WebElement webElement;

    Element element = new Element();
    Actions actions = new Actions();

    public PageCommon(WebDriver driver) {
        this.driver = driver;
    }

    public Actions linkWithTitleAttribute(String titleAttributeValue) throws Exception {
        String xpathValue = "//a[@title='" + titleAttributeValue.trim() + "']";
        webElement = element.getElement(driver, By.xpath(xpathValue), 7);
        actions.setDriverAndWebElement(driver, webElement);
        log.info("Element found");
        return actions;
    }

    public Actions btnProceedToCheckout() throws Exception {
        actions = linkWithTitleAttribute("Proceed to checkout");
        log.info("Element found");
        return actions;
    }

    public Actions VerifyAnyTextOnPage(String textToVerify) throws Exception {
        String xpath = "//*[text()='" + textToVerify.trim() + "']";
        webElement = element.getElement(driver, By.xpath(xpath), 5);
        actions.setDriverAndWebElement(driver, webElement);
        log.info("Element found");
        return actions;
    }

    public Actions btnAddToCart() throws Exception {
        webElement = element.getElement(driver, By.xpath("//span[text()='Add to cart']//parent::button"), 5);
        actions.setDriverAndWebElement(driver, webElement);
        log.info("Element found");
        return actions;
    }

    public Actions linkProductWithName(String productName) throws Exception {
        String xpath = "//a[@title='" + productName.trim() + "' and @class='product-name']";
        webElement = element.getElement(driver, By.xpath(xpath), 5);
        actions.setDriverAndWebElement(driver, webElement);
        log.info("Element found");
        return actions;
    }
}
