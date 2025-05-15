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
     * This method will take the path of the JSONFile as input and will return a JSONObject/JSONArray.
     * The returned object will have to be type-casted at the location where the method is called.
     *
     * @param jsonFileName external JSONFile path
     * @param <T>          generics
     * @return JSONObject / JSONArray
     * @throws IOException external file path input exception
     * @author Shwetank Vashishtha
     */
    public <T> T getPOJOObjectFromJSONFile(String jsonFileName, Class<T> classType) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        T objectClass = (T) objectMapper.readValue(new File(jsonFileName), classType);
        return objectClass;
    }

    /**
     * This method will take the path of the JSONString as input and will return a JSONObject/JSONArray.
     * The returned object will have to be type-casted at the location where the method is called.
     *
     * @param jsonString JSONString
     * @param <T>        generics
     * @param classType  accepts class type
     * @return JSONObject / JSONArray
     * @throws IOException external file path input exception
     * @author Shwetank Vashishtha
     */
    public <T> T getPOJOObjectFromJSONString(String jsonString, Class<T> classType) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        T objectClass = (T) objectMapper.readValue(jsonString, classType);
        return objectClass;
    }

    /**
     * This method will take the JSONObject as input and will return a JSONString.
     * The returned object will have to be type-casted at the location where the method is called.
     *
     * @param jsonObject JSONObject / JSONArray
     * @return JSONString
     * @throws IOException external file path input exception
     * @author Shwetank Vashishtha
     */
    public String convertToJsonString(Object jsonObject) {
        String jsonString = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            jsonString = objectMapper.writeValueAsString(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}