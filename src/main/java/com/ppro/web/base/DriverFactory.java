package com.ppro.web.base;


import com.ppro.commonUtil.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Properties;


/**
 * Driver Factory class to select type of Browser
 */
public class DriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    Logger log = LogManager.getLogger(this.getClass());
    Properties properties = ReadProperties.properties;

    public static DriverFactory getInstance() {
        return new DriverFactory();
    }

    /**
     * getBrowser fetches browser type from maven options and property file.
     * Highest priority is given to maven options . if its null , it searches for property file
     * if property is also null or empty . it selects default as chrome browser
     */
    public WebDriver getDriver() {

        String browser = "chrome";

        browser = System.getProperty("browser") == null
                ? properties.getProperty("browser").isEmpty() ? browser : properties.getProperty("browser")
                : System.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            driver.set(new ChromeDriver());
            log.info("Chrome driver is initiated");
            return driver.get();
        }
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            driver.set(new FirefoxDriver());
            log.info("Firefox driver is initiated");
            return driver.get();
        }
        if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
            driver.set(new EdgeDriver());
            log.info("Edge driver is initiated");
            return driver.get();
        }
        if (browser.equalsIgnoreCase("headless")) {
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            driver.set(new ChromeDriver(options));
            log.info("Headless Chrome driver is initiated");
            return driver.get();
        }
        return driver.get();
    }
}

