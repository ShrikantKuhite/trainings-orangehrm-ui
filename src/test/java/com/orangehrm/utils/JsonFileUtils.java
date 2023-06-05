package com.orangehrm.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonFileUtils {

    //File path for the AppTestData.json file
    private static String testDataFilePath = ".\\src\\test\\resources\\AppTestData.json";

    /**
     * This method read all the data from JSON file and returns
     * the values based on the key provided from where ever it gets called
     * @param key
     * @return
     */
	public static String getAppTestDataFromJsonFileByKey(String key) {

        //Objects declarations
        FileReader reader;
        JSONParser jsonParser;
        Object object;
        JSONObject jsonObject;

        try {
            //Read a JSON file
            reader = new FileReader(testDataFilePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            //Parse the file into object and then cast it into JSON Object
        	jsonParser = new JSONParser();
            object = jsonParser.parse(reader);
            jsonObject = (JSONObject) object;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return (String) jsonObject.get(key);
    }
}
