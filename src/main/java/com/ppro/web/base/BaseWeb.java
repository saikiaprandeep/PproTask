package com.ppro.web.base;


import com.ppro.commonUtil.ReadProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

/**
 * Base class for Web Testing
 */
public class BaseWeb {


    public BaseWeb() {
        driver = DriverFactory.getInstance().getDriver();
        log.info("New Driver is Initiated");
    }

    Logger log = LogManager.getLogger(this.getClass());
    public WebDriver driver;
    public Properties properties = ReadProperties.properties;


    @BeforeMethod
    public void setUp() {
        driver.manage().deleteAllCookies();
        log.info("Deleted Cookies");
        driver.get(properties.getProperty("web_url"));
        log.info("Fetched url from Properties file");
        driver.navigate().refresh();
        driver.manage().window().maximize();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
        log.info("Driver instance is closed");
        driver = null;
    }

}
