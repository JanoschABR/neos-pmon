package dev.janoschr.pmon;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import java.time.format.DateTimeFormatterBuilder;

public class Utils {

    protected static PeriodFormatter periodFormatter = new PeriodFormatterBuilder()
            .appendWeeks()
            .appendSuffix(" weeks, ")
            .appendDays()
            .appendSuffix(" days, ")
            .appendHours()
            .appendSuffix(":")
            .appendMinutes()
            .appendSuffix(":")
            .appendSeconds()
            .toFormatter();

    protected static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("YYYY-MM-DD HH:mm:ss");

    public static String stringifyPeriod (Period period) {
        return periodFormatter.print(period);
    }

    public static String stringifyDuration (Duration duration) {
        return stringifyPeriod(duration.toPeriod());
    }

    public static String stringifyDateTime (DateTime dateTime) {
        return dateTimeFormatter.print(dateTime);
    }

}
