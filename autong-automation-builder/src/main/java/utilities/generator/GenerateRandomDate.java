package utilities.generator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author shwetankvashishtha
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GenerateRandomDate {

    static DateFormat dateFormat;

    public static Date getTomorrowDate() {
        Calendar.getInstance().add(Calendar.DAY_OF_YEAR, 1);
        return Calendar.getInstance().getTime();
    }

    public static String getFormattedDate(Date date, String pattern) {
        dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }
}
