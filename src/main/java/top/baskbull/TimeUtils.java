package top.baskbull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhangkang
 * @since 2020/8/17
 **/
public class TimeUtils {

    /**
     * 获取默认时间格式: yyyy-MM-dd HH:mm:ss
     */
    private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = TimeFormat.LONG_DATE_PATTERN_LINE.formatter;

    /**
     * 获取当前时间
     */
    public static String getCurrentDatetime() {
        return DEFAULT_DATETIME_FORMATTER.format(LocalDateTime.now());
    }

    /**
     * 获取当前年月日时
     */
    public static String getCurrentYMDH() {
        return TimeFormat.SHORT_DATE_PATTERN_YMDH.formatter.format(LocalDateTime.now());
    }

    /**
     * 获取当前年月日时分
     */
    public static String getCurrentYMDHM() {
        return TimeFormat.YYYY_MMDD_HHMM.formatter.format(LocalDateTime.now());
    }


    /**
     * 获取当前年月日时分秒毫秒
     */
    public static String getCurrentyMdHmsS() {
        return TimeFormat.LONG_DATE_PATTERN_WITH_MILSEC_NONE_ALL.formatter.format(LocalDateTime.now());
    }

    public static String getDateMdHms(Date date) {
        return date2String(date);
    }


    /**
     * 获取当前时间
     *
     * @param format 时间格式
     */
    public static String getCurrentDatetime(TimeFormat format) {
        return format.formatter.format(LocalDateTime.now());
    }

    public static Long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static Long getCurrentTimeSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    public static Long getDelayTimeSeconds(int seconds) {
        return System.currentTimeMillis() / 1000 + seconds;
    }

    public static Long getDelayTimeMilliSeconds(long milliSeconds) {
        return System.currentTimeMillis() + milliSeconds;
    }

    /**
     * 时间戳转日期
     *
     * @param timestamp 10位时间戳
     * @param pattern
     */
    public static String timestamp2Date(long timestamp, String pattern) {
        final SimpleDateFormat timeFormat = new SimpleDateFormat(pattern);
        return timeFormat.format(new Date(timestamp * 1000));
    }

    /**
     * 日期转10位时间戳
     *
     * @param date
     */
    public static Long date2Timestamp(Date date) {
        if (date == null) {
            return null;
        }
        return date.getTime() / 1000;
    }

    /**
     * 日期转13位时间戳
     *
     * @param date
     */
    public static Long date2Timestamp13(Date date) {
        if (date == null) {
            return null;
        }
        return date.getTime();
    }

    public static String date2String(Date date) {
        return new SimpleDateFormat(TimeFormat.LONG_DATE_PATTERN_LINE.pattern).format(date);
    }

    public static String date2String(Date date, TimeFormat timeFormat) {
        return new SimpleDateFormat(timeFormat.pattern).format(date);
    }

    /**
     * 时间戳转日期
     *
     * @param timestamp 时间戳（S）
     * @return 日期
     */
    public static Date timestamp2Date(Long timestamp) {
        if (timestamp == null || timestamp == 0) {
            return null;
        }

        if (timestamp.toString().length() == 10) {
            timestamp = timestamp * 1000;
        }

        return new Date(timestamp);
    }

    /**
     * 获取当前Date格式日期
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * Date转换为时间戳(毫秒)
     *
     * @param date 时间
     * @return long
     */
    public static long dateToEpochMicroSecond(Date date) {
        return date.toInstant().getEpochSecond() * 1000L;
    }

    /**
     * 获取初始时间
     */
    public static Date getInitialDateTime() {
        return new Date(0);
    }

    /**
     * object 转 date
     */
    public static Date getDate(String s) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date date = null;
        try {
            date = dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return date;
    }

    public static Calendar operateMonth(Date date, int target) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, target);
        return calendar;
    }

    public static int getMonth(Calendar calendar) {
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static int getYear(Calendar calendar) {
        return calendar.get(Calendar.YEAR);
    }


    /**
     * 时间格式
     */
    public enum TimeFormat {

        /**
         * 短时间格式
         */
        SHORT_DATE_PATTERN_YMDH("yyyyMMddHH"),

        /**
         * 长时间格式
         */
        LONG_DATE_PATTERN_LINE("yyyy-MM-dd HH:mm:ss"),

        /**
         * yyyyMMddHHmm
         */
        YYYY_MMDD_HHMM("yyyyMMddHHmm"),

        /**
         * 长时间格式 带毫秒
         */
        LONG_DATE_PATTERN_WITH_MILSEC_NONE_ALL("yyyyMMddHHmmssSSS"),

        /**
         * 年月
         */
        YYYY_MM("yyyy-MM")
        ;


        private transient DateTimeFormatter formatter;

        private final String pattern;

        TimeFormat(String pattern) {
            this.pattern = pattern;
            formatter = DateTimeFormatter.ofPattern(pattern);
        }

        @Override
        public String toString() {
            return pattern;
        }
    }

}

