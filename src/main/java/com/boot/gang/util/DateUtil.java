package com.boot.gang.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;



public class DateUtil {
	
	
	
	
	public static String getDateFormat(Date date,String format){
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * 将某种类型的时间格式的字符串转换为Date类型
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date getDateFromStr(String dateStr,String format){
		if(StringUtil.isNullOrEmpty(dateStr))
			return null;
		try {
			Date date = new SimpleDateFormat(format).parse(dateStr);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args){
		Date d = new Date();
		////System.out.println(d.getYear());
	}

	public static Date createDate(int getType, int year, int month, int day,int a,int b,int c) {
		if (getType == 1) {
			if (month > 0)
				month--;
			if (year > 1900)
				year = year - 1900;
		}
		return new Date(year, month, day,a,b,c);
	}
	
	public static Date getDateSubDay(Date date,int day){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
		return calendar.getTime();
	}
	
	public static String getFormate(Date date) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static String getFormateDay(Date date) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    public static Date changeToDay(Date date) throws ParseException {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
      return  simpleDateFormat.parse(format);
    }

    public static String getFormateBy(Date date, String formate) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formate);
        return simpleDateFormat.format(date);
    }

    public static Date parse(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
            System.out.println("转化时间错误："+e);
        }

        return new Date();
    }

    public static Date parse(String date,String format) throws ParseException {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(date);
    }

    /**
     * 为原日期添加指定的月份并返回添加后的日期，如果天数为负数则在原日期的基础上减去指定的天数
     * @param source
     * @param month
     * @return
     */
    public static Date addMonth(Date source, int month){
        try{
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            format.parse(format.format(source));
            Calendar calendar = format.getCalendar();
            calendar.add(Calendar.MONTH, month);
            return calendar.getTime();
        } catch (Exception e){
            throw new RuntimeException("add days is error.");
        }
    }

    /**
     * 为原日期添加指定的月份并返回添加后的日期，如果天数为负数则在原日期的基础上减去指定的天数
     * @param source
     * @param hour
     * @return
     */
    public static Date addHour(Date source, int hour){
        try{
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(source);
            calendar.add(Calendar.HOUR_OF_DAY, hour);
            return calendar.getTime();
        } catch (Exception e){
            throw new RuntimeException("add hour is error.");
        }
    }

    /**
     * 添加一分钟
     * @param source
     * @param minute
     * @return
     */
    public static Date addMinute(Date source, int minute){
        try{
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(source);
            calendar.add(Calendar.MINUTE, minute);
            return calendar.getTime();
        } catch (Exception e){
            throw new RuntimeException("add hour is error.");
        }
    }

    public static Date addDay(Date source, int day){
        try{
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(source);
            calendar.add(Calendar.DAY_OF_MONTH, day);
            return calendar.getTime();
        } catch (Exception e){
            throw new RuntimeException("add day is error.");
        }
    }

    public static Date addYears(Date yearsStartDate, int i) {
        try{
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(yearsStartDate);
            calendar.add(Calendar.YEAR, i);
            return calendar.getTime();
        } catch (Exception e){
            throw new RuntimeException("add day is error.");
        }
    }

   
    public static Date getDate(String dateStr,String dateFormatStr){
		Date date = null;
		try{
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormatStr);
		date =sdf.parse(dateStr);
		}catch(Exception ex){
		}
		return date;
	}

	public static String getYesterday(){
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,-24);
        String yesterdayDate=dateFormat.format(calendar.getTime());
        return yesterdayDate;
    }



}
