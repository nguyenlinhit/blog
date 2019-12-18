package vn.totoro.common.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author linhnguyen
 * @version 1.0
 * @classname DateUtils
 * @description Time tool
 * @date 13/12/2019
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"
    };

    /**
     * Get current date
     *
     * @return String current date
     */
    public static Date geNowtDate(){
        return new Date();
    }

    /**
     * Get time now with custom format time
     *
     * @param format type
     * @return String
     */
    public static String dateTimeNow(final String format){
        return parseDateToStr(format, new Date());
    }

    /**
     * Parse time to string time
     *
     * @param format type
     * @param date convert
     * @return String
     */
    private static String parseDateToStr(final String format,final Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * Get time with format yyyy-MM-DD
     *
     * @return String
     */
    public static String getDate(){
        return dateTimeNow(YYYY_MM_DD);
    }

    /**
     * Get time with format yyyy-MM-DD HH:mm:ss
     *
     * @return String
     */
    public static String getTime(){
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    /**
     * Format time to yyyy-MM-dd
     *
     * @param date convert
     * @return String
     */
    public static String dateTime(final Date date){
        return parseDateToStr(YYYY_MM_DD, date);
    }

    /**
     * Format string time to custom string time
     *
     * @param format type
     * @param ts parse
     * @return Date
     */
    public static Date dateTime(final String format, final String ts){
        try {
            return new SimpleDateFormat(format).parse(ts);
        } catch (ParseException e){
            throw new RuntimeException(e);
        }
    }
    /**
     * Date path i.e. year/month/day e.g. 2019/12/14
     *
     * @return String
     */
    public static String datePath(){
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/DD");
    }

    /**
     * Date time i.e. yearMonthday e.g. 2019/12/14
     *
     * @return String
     */
    public static String dateTime(){
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
    }

    /**
     * Date string to date format
     *
     * @param str object
     * @return Date
     */
    public static Date parseDate(Object str){
        if (str == null){
            return null;
        }

        try{
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e){
            return null;
        }
    }

    /**
     * Get server startup time
     *
     * @return Date
     */
    public static Date getServerStartDate(){
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * Calculate two time differences
     *
     * @param endDate date
     * @param nowDate date
     * @return String
     */
    public static String getDatePoor(Date endDate, Date nowDate){
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        /*Get millisecond time difference between two times*/
        long diff = endDate.getTime() - nowDate.getTime();
        /*Calculate how many days are poor*/
        long day = diff / nd;
        /*Calculate the hours*/
        long hour = diff % nd / nh;
        /*Calculate the minutes*/
        long minute = diff % nd % nh / nm;

        return day + " d" + hour + " h" + minute + " m";
    }

    /**
     * Get list date of past date
     *
     * @param intervals gap
     * @return List<String>
     */
    public static List<String> getPastDaysList(int intervals){
        List<String> pastDayList = new ArrayList<>();
        for (int i = intervals - 1; i >= 0; i--){
            pastDayList.add(getPastDate(i));
        }
        
        return pastDayList;
    }

    /**
     *
     * Get the date of past date
     *
     * @param past time
     * @return String
     */
    private static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date toDay = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD);
        return simpleDateFormat.format(toDay);
    }

    /**
     * Judging by the incoming time is just now, wait a few seconds ago
     *
     * @param paramTime time to judge
     * @return String
     */
    public static String showTime(Date paramTime){
        String result = "";
        if (paramTime == null){
            return result;
        }
        /*Timestamp of current time*/
        long nowTimeLong = System.currentTimeMillis();
        /*Timestamp of income time*/
        long paramTimeLong = paramTime.getTime();

        long resultLong = Math.abs(nowTimeLong = paramTimeLong);

        if (resultLong < 60000){
            long seconds = resultLong / 1000;
            if (seconds < 5){
                result = "just recently";
            } else {
                result = seconds + "seconds ago";
            }
        } else if (resultLong >= 60000 && resultLong < 3600000){
            long seconds = resultLong / 60000;
            result = seconds + "minutes ago";
        } else if (resultLong >= 3600000 && resultLong < 86400000){
            long seconds = resultLong / 3600000;
            result = seconds + "hours ago";
        } else if (resultLong >= 86400000 && resultLong < 1702967296){
            long seconds = resultLong / 86400000;
            result = seconds + "days ago";
        } else {
            result = new SimpleDateFormat(YYYY_MM_DD).format(paramTime);
        }

        return result;
    }
}
