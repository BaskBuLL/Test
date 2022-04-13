package top.baskbull;

import org.pegdown.PegDownProcessor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liuzhuo
 * @date 2021/12/12 5:47 下午
 */
public class TestMarkDown {

    public static void main(String[] args) {
        String s = new String("| id | select\\_type | table | partitions | type | possible_keys | key | key\\_len | ref | rows | filtered | scalability | Extra |\n" +
                "|---|---|---|---|---|---|---|---|---|---|---|---|---|\n" +
                "| 1  | SIMPLE | *NULL* | NULL | NULL | NULL | NULL | NULL | NULL | 0 | 0.00% | ☠️ **O(n)** | NULL |");
        PegDownProcessor peg = new PegDownProcessor(Integer.MAX_VALUE);
        String s1 = peg.markdownToHtml(s);
//        System.out.println(s1);
//        System.out.println("--------------");
//        String process = Processor.process(s);
//        System.out.println(process);

        String w1 = "\\?";
        String w2 = "?";
//        System.out.println(w1);
//        System.out.println(w2);
//        System.out.println(w1.equals(w2));
//        System.out.println(w2.replaceFirst("\\?", "123"));

        final String regex = "issue\\/(\\d+)\\/comment";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher("https://jira.qima-inc.com/rest/api/2/issue/792023/comment/1624681");
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        System.out.println(localDate.toString());
        System.out.println("'" + localDateTime.toString() + "'");
        System.out.println(localTime.toString());

        Date date = new Date();
        System.out.println(date.toString());

//        if(matcher.find()){
//            System.out.println(matcher.group(1));
//        }else{
//            System.out.println("没有");
//        }
    }
}
