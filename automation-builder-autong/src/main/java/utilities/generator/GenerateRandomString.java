package utilities.generator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author shwetankvashishtha
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GenerateRandomString {

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
