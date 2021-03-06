package com.gamaset.sonicbot.collector.infra.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import com.gamaset.sonicbot.collector.infra.exception.FormatDateException;

public class DateUtils {


	public static final String ZONE_CONFIG_SP = "America/Sao_Paulo";
	private static final String DEFAULT_PATTERN_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
	private static final String DEFAULT_PATTERN_DATE = "yyyy-MM-dd";
	
	public static String convertDateMatchInfoToDateString(String date) {
		StringBuilder ret = new StringBuilder();
		String[] dateParts = date.split(" ");
		
		ret.append(dateParts[2]);
		ret.append("-");
		ret.append(getMonth(dateParts[1]));
		ret.append("-");
		ret.append(dateParts[0]);
		
		return ret.toString();
	}

	public static long convertDateStringToTimestamp(String date) {
		return convertDateStringToDate(date).getTime()/1000;
	}

	public static String getDateStringTodayMinus1Day() {
		LocalDate now = LocalDate.now().minusDays(1);
		return DateTimeFormatter.ofPattern(DEFAULT_PATTERN_DATE).format(now);
	}
	
	/**
	 * Convert date pattern yyyy-MM-dd to Date object
	 * 
	 * @param dateString
	 * @return
	 */
	private static Date convertDateStringToDate(String dateString) {
		Calendar cal = null;
		
		try{
			String[] dateParts = dateString.split("-");
			cal = new GregorianCalendar(
				Integer.valueOf(dateParts[0]),
				Integer.valueOf(dateParts[1])-1, 
				Integer.valueOf(dateParts[2])
				);
		}catch(Exception e){
			throw new FormatDateException("date pattern should be [yyyy-MM-dd]");
		}
		
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

	public static String getNowDateTimeFormatted() {
		TimeZone.setDefault(TimeZone.getTimeZone(ZONE_CONFIG_SP));
		return new SimpleDateFormat(DEFAULT_PATTERN_DATE_TIME).format(new Date());
	}

	public static String getNowDateFormatted() {
		TimeZone.setDefault(TimeZone.getTimeZone(ZONE_CONFIG_SP));
		return new SimpleDateFormat(DEFAULT_PATTERN_DATE).format(new Date());
	}
	
	public static Date getNowDateTime() {
		Calendar c = Calendar.getInstance();
		c.setTimeZone(TimeZone.getTimeZone(ZONE_CONFIG_SP));
		return c.getTime();
	}
	
}
