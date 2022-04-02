package com.fluent.qa.core.utils;

import java.util.Properties;

public class PropertyUtil {
    private Properties prop = new Properties();
    public PropertyUtil() {
        try {
            prop.load(this.getClass().getResourceAsStream("/properties/driver.properties"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String getProperty(String key) {
       return prop.getProperty(key);
    }
}
