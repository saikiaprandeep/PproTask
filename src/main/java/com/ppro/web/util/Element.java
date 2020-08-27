package com.ppro.web.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


/**
 * Class used to implement Wait for an Element , till it is not found beyond certain time
 */
public class Element {

    Logger log = LogManager.getLogger(getClass());
    WebElement element;
    List<WebElement> elements;

    /**
     * Method implement to search for element for a certain time.
     * params timeout in seconds ( max waiting time ) if not found will throw an error
     * Returns WebElement
     */
    public WebElement getElement(WebDriver driver, By locator, int timeout) throws Exception {
        for (int i = 0; i <= timeout; i++) {
            try {
                element = driver.findElement(locator);
                log.info("Found element with : " + locator);
                return element;
            } catch (Exception e) {
                log.info(i + ". Trying to find element with " + locator);
            }
            Thread.sleep(2000);
        }
        StackTraceElement stackTrace = new Throwable().getStackTrace()[1];
        log.error("Cannot find element with : " + locator);
        log.error("Cannot find element : " + stackTrace.getClassName() + "." + stackTrace.getMethodName());
        throw new Exception("Unable to find Element");
    }

    /**
     * Method implement to search for all elements for a certain time.
     * params timeout in seconds ( max waiting time ) if not found will throw an error
     * Returns List of WebElements
     */
    public List<WebElement> getElements(WebDriver driver, By locator, int timeout) throws Exception {
        for (int i = 0; i <= timeout; i++) {
            try {
                if (driver.findElements(locator).size() == 0) throw new Exception();
                elements = driver.findElements(locator);
                log.info("Found total " + elements.size() + " elements with : " + locator);
                return elements;
            } catch (Exception e) {
                log.info(i + ". Trying to find all elements with " + locator);
            }
            Thread.sleep(2000);
        }
        StackTraceElement stackTrace = new Throwable().getStackTrace()[1];
        log.error("Cannot find all elements with : " + locator);
        log.error("Cannot find all elements : " + stackTrace.getClassName() + "." + stackTrace.getMethodName());
        throw new Exception("Unable to find all Elements");
    }
}
