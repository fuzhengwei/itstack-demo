/*
 * @(#)DateUtils.java
 *
 * Copyright 2014 Copyright© 2004-2013 360buy京东商城  All rights reserved.
 */
package itstack.demo.common.utils;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期Util类
 * 
 * @author zhangdongfang
 */
public final class DateUtils {

	/**
	 * 24小时格式的完整日期
	 */
	public static final String COMPLETE_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 只有年份的日期
	 */
	public static final String ONLY_YEAR_DATE_PATTERN = "yyyy";
	/**
	 * 只有年月的日期
	 */
	public static final String YEAR_MONTH_PATTERN = "yyyy-MM";
	/**
	 * 只有年月日的日期
	 */
	public static final String YEAR_MONTH_DATE_PATTEN = "yyyyMMdd";

	/**
	 * 默认日期
	 */
	private static final String DEFAULT_DETE_PATTERN = "yyyy-MM-dd";

	/**
	 * 
	 */
	public static final String HOUR_MINTUS_SECOND_PATTERN = "HHmmss";

	private static final int WEEK_SATURDAY = 6;

	private static final int WEEK_SUNDAY = 0;

	/**
	 * private constructor
	 */
	private DateUtils() {

	}

	public static String getDefaultDatePattern() {
		return DEFAULT_DETE_PATTERN;
	}

	/**
	 * 返回预设Format的当前日期字符串
	 */
	public static String getToday() {
		Date today = new Date();
		return format(today);
	}

	/**
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getToday(String pattern) {
		Date today = new Date();
		return format(today, pattern);
	}

	/**
	 * 使用预设Format格式化Date成字符串
	 */
	public static String format(Date date) {
		if (date != null) {
			return format(date, getDefaultDatePattern());
		}
		return "";
	}

	/**
	 * 使用参数Format格式化Date成字符串
	 */
	public static String format(Date date, String pattern) {
		if (date != null) {
			return new SimpleDateFormat(pattern).format(date);
		}
		return "";
	}

	/**
	 * 使用预设格式将字符串转为Date
	 */
	public static Date parse(String strDate) throws ParseException {
		if (StringUtils.isBlank(strDate)) {
			return null;
		}
		return parse(strDate, getDefaultDatePattern());
	}

	/**
	 * 使用参数Format将字符串转为Date
	 */
	public static Date parse(String strDate, String pattern) throws ParseException {
		if (StringUtils.isBlank(strDate)) {
			return null;
		}
		return new SimpleDateFormat(pattern).parse(strDate);

	}

	/**
	 * 在日期上增加数个整月
	 */
	public static Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

	/**
	 * 在日期上增加数天
	 */
	public static Date addDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, n);
		return cal.getTime();
	}

	/**
	 * 在日期上增加数天
	 * 
	 * @throws java.text.ParseException
	 */
	public static String addDay(String date, int n) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(parse(date));
		cal.add(Calendar.DAY_OF_MONTH, n);
		return format(cal.getTime());
	}

	/**
	 * 判断某一天是否是周末
	 *
	 * @param today
	 * @return
	 * @throws java.text.ParseException
	 */
	public static boolean isWeekEnd(String today) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(parse(today));
		int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (week == WEEK_SATURDAY || week == WEEK_SUNDAY) {
			return true;
		}
		return false;
	}

	/**
	 * 获取日期差值之间的所有日期，以List返回
	 *
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws java.text.ParseException
	 */
	public static List<String> getDateDiffValues(final String startDate, final String endDate) throws ParseException {
		String newstartDate = format(parse(startDate));
		String newendDate = format(parse(endDate));
		List<String> result = new ArrayList<String>();
		if (newstartDate.equals(newendDate)) {
			result.add(newstartDate);
			return result;
		}

		result.add(newstartDate);
		while (!newstartDate.equals(newendDate)) {
			newstartDate = addDay(newstartDate, 1);
			result.add(newstartDate);
		}

		return result;
	}

	/**
	 * 
	 * 取二个时间的差多少天
	 * @param startTime
	 * @param endTime
	 * @return
	 * @author zhangdongfang
	 */
	public static int getDateDiff(final Date startTime, final Date endTime) {
		int times = Integer.valueOf((startTime.getTime() - endTime.getTime()) / (24 * 3600 * 1000) + "");
		return times;
	}
	
	/**
	 * 取得当前日期的最大时间
	 * @param 
	 * @return
	 * @author：fengcheng
	 * @since：2014年12月29日 下午6:20:05
	 */
	public static Date getDateMaxTime(Date date) {
		if (date == null) {
			return date;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
		
	}
}