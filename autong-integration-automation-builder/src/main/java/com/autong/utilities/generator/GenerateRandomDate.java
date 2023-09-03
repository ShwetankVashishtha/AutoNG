package com.autong.utilities.generator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2022
 */
public final class GenerateRandomDate {

    static DateFormat dateFormat;
    private static final Logger logger = Logger.getLogger(GenerateRandomDate.class.getName());

    public static Date getTomorrowDate() {
        Calendar.getInstance().add(Calendar.DAY_OF_YEAR, 1);
        return Calendar.getInstance().getTime();
    }

    public static String getFormattedDate(String pattern) {
        dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.toString();
    }
}
