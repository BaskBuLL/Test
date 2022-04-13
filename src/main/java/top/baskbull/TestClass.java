package top.baskbull;

import com.alibaba.fastjson.JSON;

import java.time.LocalDateTime;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * @author liuzhuo
 * @date 2021/12/11 8:37 下午
 */
public class TestClass {

    public static void main(String[] args) {
        String s = new String();
        Class aClass = s.getClass();
        System.out.println(aClass.getSimpleName());
        System.out.println(aClass.getName());
        System.out.println(aClass.getCanonicalName());

        Date date = new Date();
        Class dClass = date.getClass();
        System.out.println(dClass.getSimpleName());
        System.out.println(dClass.getName());
        System.out.println(dClass.getCanonicalName());

//        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);
        LocalDateTime localDateTime = LocalDateTime.now();
        Class c = localDateTime.getClass();
        System.out.println(Temporal.class.isAssignableFrom(c));
//        System.out.println(localDateTime);
//        localDateTime.format(formatter)
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String format = dateTimeFormatter.format(localDateTime);
        System.out.println(format);

        Temporal temporal = JapaneseDate.now();

        if (localDateTime instanceof Temporal) {
            System.out.println(localDateTime);
        }
        if (temporal instanceof Temporal) {
            System.out.println(temporal);
        }

        Boolean b = false;
        System.out.println(b.toString());

        Set<String> set = new HashSet<>();
        set.add("select * from student where id = 1");
        set.add("select * from student");
        set.add("delete from student where id = 1");
        System.out.println(set);
        System.out.println(JSON.toJSONString(set));

//        String format = formatter.format(localDateTime);
//        System.out.println("'" + format + "'");
//
//        LocalDate localDate = LocalDate.now();
//        System.out.println("'" + formatter.format(localDate) + "'");
//
//        System.out.println("'" + formatter.format(LocalDate.now()) + "'");
    }
}
