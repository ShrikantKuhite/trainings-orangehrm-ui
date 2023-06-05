package com.orangehrm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtils {

    //Path of configuration.properties file to access the Application URL and Credentials
    private static String propertiesFilePath = ".\\src\\test\\resources\\configuration.properties";

    /**
     * Method which access the values based on the key provided from the properties file
     * @return
     * @throws IOException
     */
    static FileInputStream fis = null;
    public static String getValueForTheKey(String key){
        File file = new File(propertiesFilePath);
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Properties properties = new Properties();
        try {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }
}
