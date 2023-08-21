package com.autong.utilities.generator;

import java.util.Random;
import java.util.logging.Logger;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2022
 */
public class GenerateRandomString {

    private static final Logger logger = Logger.getLogger(GenerateRandomString.class.getName());

    public String generateRandomAlphaNumericString() {
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int length = 8;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }
        return sb.toString();
    }

    public String generateRandomString() {
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int length = 4;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }
        return sb.toString();
    }

    public static String generateRandomString(int min, int max) {
        final String CHAR_LIST = "abcd";

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            long number = GenerateRandomNumber.generateRandomNum(min, max);
            char ch = CHAR_LIST.charAt((int) number);
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    public static String generateAlphaNumericString(int count) {
        String ALPHA_NUMERIC_STRING = "abcd123";

        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}
