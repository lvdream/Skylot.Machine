package com.fangda.skylot.mathine.utils;

import com.fangda.skylot.mathine.utils.constant.Constant;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static void main(String[] args) {
//		System.out.println(DateUtils.truncate(new Date(), Calendar.DATE));
//		try {
//			StringBuilder exceptionBuilder = new StringBuilder();
//			exceptionBuilder.append(STR_EXCEPTION_BUSINESS_CODE);
//			exceptionBuilder.append("management.login.parameter.error");
//			throw new SkyLotException(exceptionBuilder.toString());
//		} catch (SkyLotException e) {
//			if (StringUtils.contains(e.getMessage(), STR_EXCEPTION_BUSINESS_CODE)) {
//				System.out.println(32323);
//			}
//		}
		// System.out.println(DateUtil.dateToStrLong(DateUtil.strToDateLong("1996-02-25
		// 15:32:23")));
//		 long time = DateUtil.dateDiff("1996-02-25 15:32:23", "1996-02-25 16:52:43", "yyyy-MM-dd HH:mm:ss", "s");
//		 System.out.println(time);
		// System.out.println(DateUtil.isInDate(DateUtil.getNowDate(), "1996-02-25 15:32:23", "1996-02-25 15:52:23"));
//		System.out.println(getTimeByMinute(-3));
	}

	/**
	 * 获取现在时间
	 * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
	 */
	public static String getNowDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(Constant.DATE_FORMAT_STANDARD);
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
	 * @param strDate
	 * @return
	 */
	public static Date strToDateLong(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(Constant.DATE_FORMAT_STANDARD);
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
	 * @param dateDate
	 * @return
	 */
	public static String dateToStrLong(java.util.Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(Constant.DATE_FORMAT_STANDARD);
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * @author damon <br>
	 * @time Nov 18, 2016 2:02:29 PM <br>
	 * @param startTime
	 * @param endTime
	 * @param format(时间格式)
	 * @param str
	 * @return
	 */
	public static long dateDiff(String startTime, String endTime, String format, String str) {
		// 按照传入的格式生成一个simpledateformate对象
		SimpleDateFormat sd = new SimpleDateFormat(format);
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		long nm = 1000 * 60;// 一分钟的毫秒数
		long ns = 1000;// 一秒钟的毫秒数
		long diff;
		long day = 0;
		long hour = 0;
		long min = 0;
		long sec = 0;
		// 获得两个时间的毫秒时间差异
		try {
			diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
			day = diff / nd;// 计算差多少天
			hour = diff % nd / nh + day * 24;// 计算差多少小时
			min = diff % nd % nh / nm + hour * 60;// 计算差多少分钟
			sec = diff % nd % nh % nm / ns + min * 60;// 计算差多少秒
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (str.equalsIgnoreCase("h")) {
			return hour;
		} else if (str.equalsIgnoreCase("m")){
			return min;
		}else {
			return sec;
		}
	}

	/**
	 * 判断时间是否在时间段内
	 * 
	 * @param strDate
	 *            当前时间 yyyy-MM-dd HH:mm:ss
	 * @param strDateBegin
	 *            开始时间 00:00:00
	 * @param strDateEnd
	 *            结束时间 00:05:00
	 * @return
	 */
	public static boolean isInDate(String strDate, String strDateBegin, String strDateEnd) {
		// 截取当前时间时分秒
		int strDateY = Integer.parseInt(strDate.substring(0, 4));
		int strDateM = Integer.parseInt(strDate.substring(5, 7));
		int strDated = Integer.parseInt(strDate.substring(8, 10));
		// 截取开始时间时分秒
		int strDateBeginY = Integer.parseInt(strDateBegin.substring(0, 4));
		int strDateBeginM = Integer.parseInt(strDateBegin.substring(5, 7));
		int strDateBegind = Integer.parseInt(strDateBegin.substring(8, 10));
		// 截取结束时间时分秒
		int strDateEndY = Integer.parseInt(strDateEnd.substring(0, 4));
		int strDateEndM = Integer.parseInt(strDateEnd.substring(5, 7));
		int strDateEndd = Integer.parseInt(strDateEnd.substring(8, 10));
		if (strDateY >= strDateBeginY && strDateY <= strDateEndY) {
			if (strDateY > strDateBeginY && strDateY < strDateEndY) {
				return true;
			} else if (strDateY == strDateBeginY && strDateM >= strDateBeginM && strDateM <= strDateEndM) {
				return true;
			} else if (strDateY == strDateBeginY && strDateM == strDateBeginM && strDated >= strDateBegind
					&& strDated <= strDateEndd) {
				return true;
			} else if (strDateY >= strDateBeginY && strDateY == strDateEndY && strDateM <= strDateEndM) {
				return true;
			} else if (strDateY >= strDateBeginY && strDateY == strDateEndY && strDateM == strDateEndM
					&& strDated <= strDateEndd) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * 获取当前时间前或后N分钟的时间(yyyy-MM-dd HH:mm:ss)（minute为负数则为前，正数则为后）
	 * @param minute
	 * @return
	 */
	public static String getTimeByMinute(int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, minute);
		return new SimpleDateFormat(Constant.DATE_FORMAT_STANDARD).format(calendar.getTime());
	}
}
