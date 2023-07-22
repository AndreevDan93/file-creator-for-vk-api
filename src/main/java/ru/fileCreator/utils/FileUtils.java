package ru.fileCreator.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtils {
    public static Properties loadProperties(String path) {
        Properties properties = null;
        try (FileInputStream fis = new FileInputStream(path)) {
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}
