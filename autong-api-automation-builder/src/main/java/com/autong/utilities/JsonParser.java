package com.autong.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2023
 */
public class JsonParser {

    private static final Logger logger = Logger.getLogger(JsonParser.class.getName());

    /**
     * This method will take the path of the json file as input and will return a JSONObject/JSONArray.
     * The returned object will have to be type-casted at the location where the method is called.
     *
     * @param jsonFileName external JSON file path
     * @param <T>          generics
     * @return JSON object / JSON array
     * @throws IOException external file path input exception
     * @author Akhil Khandelwal
     */
    public <T> T getPOJOObjectFromJSONFile(String jsonFileName, Class<T> classType) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        T objectClass = (T) objectMapper.readValue(new File(jsonFileName), classType);
        return objectClass;
    }

    /**
     * This method will take the path of the json file as input and will return a JSONObject/JSONArray.
     * The returned object will have to be type-casted at the location where the method is called.
     *
     * @param jsonString JSON string
     * @param <T>        generics
     * @param classType  accepts class type
     * @return JSON object / JSON array
     * @throws IOException external file path input exception
     * @author Akhil Khandelwal
     */
    public <T> T getPOJOObjectFromJSONString(String jsonString, Class<T> classType) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        T objectClass = (T) objectMapper.readValue(jsonString, classType);
        return objectClass;
    }
}