package com.autong.utilities.generator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2022
 */
public class GenerateRandomNumber {

    public static int generateRandomNum(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}
