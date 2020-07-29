package com.Noam.CouponsSystem_part2.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

	public static java.sql.Date convertUtilDateToSQL(java.util.Date date) {
		return new java.sql.Date(date.getYear() - 1900, date.getMonth() - 1, date.getDate() + 1);
	}

	public static java.util.Date calcDate(int DD, int MM, int YYYY) {

		ZoneId defaultZoneId = ZoneId.systemDefault();

		// creating the instance of LocalDate using the day, month, year info
		LocalDate localDate = LocalDate.of(YYYY, MM, DD);

		// local date + atStartOfDay() + default time zone + toInstant() = Date
		return Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
	}

}
