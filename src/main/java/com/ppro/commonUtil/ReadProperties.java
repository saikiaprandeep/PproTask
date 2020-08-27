package com.ppro.commonUtil;

import com.ppro.web.base.BaseWeb;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * Class to read property file
 */
public class ReadProperties {

    public static Properties properties = getInstance().readProperty();
    Logger log = LogManager.getLogger(this.getClass());


    private static ReadProperties getInstance() {
        return new ReadProperties();
    }


    /**
     * Method to read property file
     * it fetches env from maven options like dev or qa.
     * if maven options is null , it selects dev as default
     */
    private Properties readProperty() {

        properties = new Properties();
        String env = "dev";

        try {
            env = System.getProperty("env") == null ? env : System.getProperty("env");

            log.info("====================================" + env.toUpperCase() + " ENV  =========================================");

            if (env.equalsIgnoreCase("dev")) {
                properties.load(BaseWeb.class.getResourceAsStream("/dev.config.properties"));
                log.info("Loading property from DEV config file");
                return properties;
            }
            if (env.equalsIgnoreCase("qa")) {
                properties.load(BaseWeb.class.getResourceAsStream("/qa.config.properties"));
                log.info("Loading property from QA config file");
                return properties;
            }
        } catch (IOException e) {
            log.error("Properties file is not found in current location");
        }

        return null;

    }

}
