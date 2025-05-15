package com.autong.utilities.generator;

import java.util.logging.Logger;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2022
 */
public class GenerateRandomNumber {

    private static final Logger logger = Logger.getLogger(GenerateRandomNumber.class.getName());

    public static int generateRandomNum(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}
