package utilities.generator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author shwetankvashishtha
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GenerateRandomNumber {

    public static int generateRandomNum(int min, int max) {

        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}
