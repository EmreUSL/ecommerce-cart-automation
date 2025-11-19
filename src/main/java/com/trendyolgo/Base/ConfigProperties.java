package com.trendyolgo.Base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

    private static final Properties prop = new Properties();

    static {
        try {
            InputStream in = ConfigProperties.class.getClassLoader().getResourceAsStream("config.properties");

            if (in != null) {
                prop.load(in);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}