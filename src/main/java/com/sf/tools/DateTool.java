package com.sf.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 日期工具类
 * @author JSF
 */
public class DateTool {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_MONTH_FORMAT = "yyyy-MM";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_CHINESE = "yyyy年MM月dd日";
    public static final String DATE_MONTH_FORMAT_CHINESE = "yyyy年MM月";
    public static final String DATETIME_FORMAT_CHINESE = "yyyy年MM月dd日 HH时mm分ss秒";
    public static final String DATE_FORMAT_DIRECT_JOIN = "yyyyMMdd";
    public static final String DATE_MONTH_FORMAT_DIRECT_JOIN = "yyyyMM";
    public static final String DATETIME_FORMAT_DIRECT_JOIN = "yyyyMM";

    /**
     * <li> 根据指定的转换格式将日期转换为字符串</li>
     * @param date 日期
     * @param format 转换格式
     * @return String
     */
    public static String dateToString(Date date,String format){
        DateFormat sdf;
        if (StringTool.isBlank(format)) {
            sdf = new SimpleDateFormat(DATETIME_FORMAT);
        } else {
            sdf = new SimpleDateFormat(format);
        }
        if (date != null) {
            return sdf.format(date);
        }
        return null;
    }

    /**
     * <li> 将日期默认转换为日期+时间的形式 </li>
     * <li> 格式：yyyy-MM-dd HH:mm:ss</li>
     * @param date 日期
     * @return String
     */
    public static String dateToDateTimeString(Date date) {
        return dateToString(date,DATETIME_FORMAT);
    }

    /**
     * <li> 将日期默认转换为只有日期的形式 </li>
     * <li> 格式：yyyy-MM-dd</li>
     * @param date
     * @return String
     */
    public static String dataToDateString(Date date){
        return dateToString(date,DATE_FORMAT);
    }

    /**
     * <li> 将日期默认转换为只有年-月的形式 </li>
     * <li> 格式：yyyy-MM</li>
     * @param date
     * @return String
     */
    public static String dataToDateMonthString(Date date){
        return dateToString(date,DATE_MONTH_FORMAT);
    }

    /**
     * <li> 根据指定的转换格式将日期字符串转换为日期格式</li>
     * @param source 日期字符串
     * @param format 转换格式
     * @return Date
     */
    public static Date stringToDate(String source,String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            throw new IllegalArgumentException("SimpleDateFormat字符串格式有误");
        }
    }

    /**
     * <li> 将日期字符串以年-月-日格式转换为日期 </li>
     * <li> 格式：yyyy-MM-dd</li>
     * @param source 日期字符串
     * @return Date
     */
    public static Date stringToDate(String source) {
       return stringToDate(source,DATE_FORMAT);
    }

    /**
     * <li> 将日期字符串以年+月的格式转换为日期 </li>
     * <li> 格式：yyyy-MM</li>
     * @param source 日期字符串
     * @return Date
     */
    public static Date stringToDateMonth(String source){
        return stringToDate(source,DATE_MONTH_FORMAT);
    }

    /**
     * <li> 将日期字符串以日期+时间的格式转换为日期 </li>
     * <li> 格式：yyyy-MM-dd HH:mm:ss</li>
     * @param source 日期字符串
     * @return Date
     */
    public static Date stringToDateTime(String source) {
        return stringToDate(source,DATETIME_FORMAT);
    }


    /**
     * <li> 设置一个时间</li>
     * @param year 年
     * @param month 月
     * @param date 日
     * @return Date
     */
    public static Date setDate(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, date);
        return calendar.getTime();
    }

    /**
     * <li> 现在到今天凌晨还剩多少秒</li>
     * @return long
     */
    public static long nowToMidNight() {
        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalDate today = LocalDate.now();
        LocalDateTime todayMidnight = LocalDateTime.of(today, midnight);
        LocalDateTime tomorrowMidnight = todayMidnight.plusDays(1);
        return TimeUnit.NANOSECONDS.toSeconds(Duration.between(LocalDateTime.now(), tomorrowMidnight).toNanos());
    }

    /**
     * <li> 现在到今天凌晨还剩多少分钟</li>
     * @return Long
     */
    public static Long getMinutes() {
        LocalDateTime midnight = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        return ChronoUnit.MINUTES.between(LocalDateTime.now(), midnight);
    }

    /**
     * <li> 获取两个日期直接的月数</li>
     * @param d1 日期1
     * @param d2 日期2
     * @return int
     */
    public static int getMonthDiff(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        // 获取年的差值 
        int yearInterval = year1 - year2;
        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if (month1 < month2 || month1 == month2 && day1 < day2) {
            yearInterval--;
        }
        // 获取月数差值
        int monthInterval = (month1 + 12) - month2;
        if (day1 < day2) {
            monthInterval--;
        }
        monthInterval %= 12;
        int monthsDiff = Math.abs(yearInterval * 12 + monthInterval);
        return monthsDiff;
    }

    /**
     * <li> 获取两个日期之间的天数</li>
     * @param d1 日期1
     * @param d2 日期2
     * @return int
     */
    public static int getDayDiff(Date d1,Date d2){
        if(d1 == null || d2 == null){
            throw new IllegalArgumentException("日期为空");
        }
        int diff  = Integer.parseInt(((d1.getTime() - d2.getTime())/(60*60*24*1000)) + "");
        return diff;
    }

    /**
     * <li> 获取一个日期中的日的数字</li>
     * @param date 日期
     * @return int
     */
    public static int getDay(Date date){
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        return c1.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * <li> 获取一个日期中月份的数字</li>
     * @param date 日期
     * @return int
     */
    public static int getMonth(Date date){
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        return c1.get(Calendar.MONTH) + 1;
    }

    /**
     * <li> 获取一个日期中年份的数字</li>
     * @param date 日期
     * @return int
     */
    public static int getYear(Date date){
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        return c1.get(Calendar.YEAR);
    }

    /**
     * <li> 对一个日期增加天数</li>
     * @param date 日期
     * @param day 天数
     * @return Date
     */
    public static Date addDay(Date date, int day){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.DAY_OF_MONTH, day);
        Date dt1 = rightNow.getTime();
        return dt1;
    }

    /**
     * <li> 对一个日期增加分钟</li>
     * @param date 日期
     * @param minute 分钟
     * @return Date
     */
    public static Date addMinute(Date date,int minute){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MINUTE, minute);
        Date dt1 = rightNow.getTime();
        return dt1;
    }

    /**
     * <li> 获取当前日期是星期几</li>
     * @param date 日期
     * @return int
     */
    public static int getDayOfWeek(Date date){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        return rightNow.get(Calendar.DAY_OF_WEEK) -1;
    }

    /**
     * <li> 对一个日期增加月数</li>
     * @param date 日期
     * @param month 月数
     * @return Date
     */
    public static Date addMonth(Date date,int month) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, month);
        Date dt1 = rightNow.getTime();
        return dt1;
    }

    /**
     * <li> 直接设置当前日期的日的数字</li>
     * @param date 日期
     * @param day 日
     * @return Date
     */
    public static Date setDay(Date date,int day){
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        c1.set(c1.get(Calendar.YEAR),c1.get(Calendar.MONTH),day);
        return c1.getTime();
    }

    /**
     * <li> 直接设置当前日期的月数</li>
     * @param date 日期
     * @param month 月数
     * @return Date
     */
    public static Date setMonth(Date date,int month){
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        c1.set(c1.get(Calendar.YEAR),month-1,c1.get(Calendar.DAY_OF_MONTH));
        return c1.getTime();
    }

    /**
     * <li> 直接设置当前日期的月数和日数</li>
     * @param date 日期
     * @param month 月数
     * @param day 日数
     * @return Date
     */
    public static Date setMonthAndDay(Date date,int month,int day){
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        c1.set(c1.get(Calendar.YEAR),month-1,day);
        return c1.getTime();
    }

    /**
     * <li> 计算日期{@code startDate}与{@code endDate}的间隔天数</li>
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return 间隔天数
     */
    public static long numberOfDaysBetweenDates(LocalDate startDate, LocalDate endDate){
        return startDate.until(endDate, ChronoUnit.DAYS);
    }


}
