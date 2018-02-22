package com.library.utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DateAndTimeUtil {
    public static String currDateAndTime() {
        return (LocalDate.now() + ", " + LocalTime.now().truncatedTo(ChronoUnit.SECONDS));
    }
}
