package tech.practice;

import java.time.*;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;

public class DateTimeUtils {
	 public static String getDayOfWeek(String date) {
	        LocalDate localDate = LocalDate.parse(date);
	        return localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	    }

	    public static String getCurrentTime(String timeZone) {
	        ZoneId zoneId = ZoneId.of(timeZone);
	        LocalDateTime localDateTime = LocalDateTime.now(zoneId);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	        return localDateTime.format(formatter);
	    }

	    public static String[] getDateTimeComponents(String dateTime) {
	        return dateTime.split("[\\s:]");
	    }
}
