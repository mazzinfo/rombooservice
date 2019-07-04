package org.mazz.rombooservice.utill;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateUtill {

	public static java.util.Date getDateTime(String fromDate, String fromTime) {
		String getDate = fromDate.substring(0, 10);
		String strTime = getDate + "T" + fromTime + ":00";
		
		System.out.println("strTime.."+strTime);
		LocalDateTime localDateTime = LocalDateTime.parse("" + strTime);

		Long localDate = Timestamp.valueOf(localDateTime).getTime();

		return new java.util.Date(localDate);
	}

}
