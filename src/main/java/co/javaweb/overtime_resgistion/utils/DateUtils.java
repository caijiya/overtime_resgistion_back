package co.javaweb.overtime_resgistion.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	
	private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
	
	public static String now() {
		return LocalDateTime.now().format(DEFAULT_DATETIME_FORMATTER);
	}
}
