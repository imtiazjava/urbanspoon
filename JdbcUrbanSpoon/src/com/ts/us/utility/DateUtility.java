package com.ts.us.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ts.us.exception.UrbanSpoonException;

public class DateUtility {

	private static final String DATE_PATTERN = "yyyy-MM-dd";

	public static Date convertStringToDate(String dateString) throws UrbanSpoonException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
		try {
			return simpleDateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new UrbanSpoonException(e.toString());
		}

	}

}
