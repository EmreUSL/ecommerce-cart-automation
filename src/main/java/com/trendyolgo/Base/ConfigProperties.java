package com.trendyolgo.Base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

    private static final Properties prop = new Properties();

    static {

        try {
            InputStream inputStream = ConfigProperties.class.getClassLoader()
                    .getResourceAsStream("config.properties");

            if (inputStream != null) {
                prop.load(inputStream);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}