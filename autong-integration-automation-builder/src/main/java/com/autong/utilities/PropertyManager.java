package com.autong.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2022
 */
public class PropertyManager {

    private static final Logger logger = Logger.getLogger(PropertyManager.class.getName());
    public Properties getResourceBundle;

    public PropertyManager() {
        try {
            File pageSrc = new File("./src/test/resources/page.properties");
            FileInputStream pageFIS = new FileInputStream(pageSrc);
            getResourceBundle = new Properties();

            File baseSrc = new File("./src/test/resources/base.properties");
            FileInputStream baseFIS = new FileInputStream(baseSrc);
            getResourceBundle = new Properties();

            File executionSrc = new File("./src/test/resources/execution.properties");
            FileInputStream executionFIS = new FileInputStream(executionSrc);
            getResourceBundle = new Properties();

            getResourceBundle.load(pageFIS);
            getResourceBundle.load(baseFIS);
            getResourceBundle.load(executionFIS);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Print all key value pairs
     */

    public void printKeyValue() {
        Enumeration KeyValues = getResourceBundle.keys();
        while (KeyValues.hasMoreElements()) {
            String key = (String) KeyValues.nextElement();
            String value = getResourceBundle.getProperty(key);
            System.out.println(key + ":- " + value);
        }
    }
}
