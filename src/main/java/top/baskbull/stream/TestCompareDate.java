package top.baskbull.stream;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuzhuo
 * @date 2022/3/21 2:20 下午
 */
public class TestCompareDate {

    public static void main(String[] args) {
        List<Date> date = new ArrayList<>();
        date.add(new Date(1998, Calendar.OCTOBER, 19));
        date.add(new Date());
        date.add(new Date(1997, 2, 11));

        System.out.println(date);

        List<Date> collect = date.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(collect);
    }
}
