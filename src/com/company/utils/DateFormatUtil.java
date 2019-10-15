package com.company.utils;

import java.text.DateFormat;
import java.util.Date;

public class DateFormatUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.MEDIUM);
		Date date = new Date();
		System.out.println(dateFormat.format(date));
	}

}
