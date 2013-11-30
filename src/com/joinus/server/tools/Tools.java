package com.joinus.server.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 常用工具方法<br>
 * @author henrybit
 * @version 1.0
 * @since 2013-4-6
 */
public class Tools {
	/**当天0点时间点*/
	private final static Calendar currentDayCalendar = Calendar.getInstance();
	
	static {
		currentDayCalendar.set(Calendar.HOUR_OF_DAY, 0);
		currentDayCalendar.set(Calendar.SECOND, 0);
		currentDayCalendar.set(Calendar.MINUTE, 0);
		currentDayCalendar.set(Calendar.MILLISECOND, 0);
	}
	
	/**
	 * 生成一个不重复的唯一序列ID<br>
	 * TODO
	 * @return uid-返回一个唯一uid
	 */
	public static String createNewUid() {
		return "";
	}
	
	/**
	 * 获取指定日期格式的字符串<br>
	 * @param date 时间
	 * @param dateFormat 日期格式
	 * @return String-时间的字符格式
	 */
	public static String getDateFormat(Date date, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(date);
	}
	
	/**
	 * 获取指定字符串的日期对象<br>
	 * @param date 时间（字符串格式）
	 * @param dateFormat 日期格式
	 * @return Date-时间
	 */
	public static Date getDateFormate(String date, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取当天0点的时间<br>
	 * @return Date
	 */
	public static Date getCurrentDay() {
		return currentDayCalendar.getTime();
	}
	
	/**
	 * 返回分割后的字符串数组（该方法确保不会返回空指针）<br>
	 * @param s 待分隔字符串
	 * @param delimiter 分隔符
	 * @return String[]
	 */
	public static Set<String> split(String s, String delimiter){
		Set<String> set = new HashSet<String>();
		if(s == null)
			return set;
		int delimiterLength;
		int stringLength = s.length();
		if (delimiter == null || (delimiterLength = delimiter.length()) == 0){
			return set;
		}
		int count =0;
		int start =0;
		int end;
		
		while((end = s.indexOf(delimiter, start)) != -1){
			set.add((s.substring(start, end)));
			count++;
			start = end + delimiterLength;
		}
		end = stringLength;
		set.add(s.substring(start, end));

		return set;
	}
}
