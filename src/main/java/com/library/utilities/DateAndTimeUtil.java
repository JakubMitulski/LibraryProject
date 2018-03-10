/**
 * DateAndTimeUtil.java
 * Purpose: getting current system date and time.
 *
 * @version 1.0 23/02/2018
 * @author Jakub Mitulski
 */
package com.library.utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DateAndTimeUtil {
    public static String currDateAndTime() {
        return (LocalDate.now() + ", " + LocalTime.now().truncatedTo(ChronoUnit.SECONDS));
    }
}
