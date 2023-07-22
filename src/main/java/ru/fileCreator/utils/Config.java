package ru.fileCreator.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final String RELATIVE_PATH_TO_PROPERTIES = "config.properties";
    private static Properties properties;

    public static String get(String key) {
        if (properties == null) {

            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream(RELATIVE_PATH_TO_PROPERTIES);
            try {
                properties = new Properties();
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return properties.getProperty(key);
    }

}
