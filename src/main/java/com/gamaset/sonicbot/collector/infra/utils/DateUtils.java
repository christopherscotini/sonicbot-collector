package com.gamaset.sonicbot.collector.infra.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class DateUtils {

	public static String convertDateInfoMatchStringToDateStringYYYY_MM_DD(String date) {
		StringBuilder ret = new StringBuilder();
		String[] dateParts = date.split(" ");
		
		ret.append(dateParts[2]);
		ret.append("-");
		ret.append(getMonth(dateParts[1]));
		ret.append("-");
		ret.append(dateParts[0]);
		
		return ret.toString();
	}

	/**
	 * Convert date pattern YYYY-MM-DD to Date object
	 * 
	 * @param date
	 * @return
	 */
	public static Date convertDateStringToDate(String date) {
		String[] dateParts = date.split("-");
		Calendar cal = new GregorianCalendar(
				Integer.valueOf(dateParts[0]),
				Integer.valueOf(dateParts[1])-1, 
				Integer.valueOf(dateParts[2])
				);
		return cal.getTime();
	}
	
	private static String getMonth(String key) {
		Map<String, String> months = new HashMap<String, String>();

		months.put("Janeiro", "01");
		months.put("Fevereiro", "02");
		months.put("Março", "03");
		months.put("Abril", "04");
		months.put("Maio", "05");
		months.put("Junho", "06");
		months.put("Julho", "07");
		months.put("Agosto", "08");
		months.put("Setembro", "09");
		months.put("Outubro", "10");
		months.put("Novembro", "11");
		months.put("Dezembro", "12");

		return months.get(key);
	}

}
