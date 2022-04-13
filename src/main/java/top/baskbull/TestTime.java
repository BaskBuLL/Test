package top.baskbull;

import com.alibaba.fastjson.JSON;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author liuzhuo
 * @date 2021/12/21 1:47 下午
 */
public class TestTime {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(System.currentTimeMillis()/1000);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()));

        List<String> list = new ArrayList<>();
        //.*?!(.*?\.png).*?!
//        final String regex = ".*?!(.*?\\.png).*?!";
        String regex = ".*?!(.*?\\.(png|jpg|jpeg)).*?!";
        final Pattern pattern = Pattern.compile(regex);
//        final Matcher matcher = pattern.matcher("测试 !门头照1.jpeg!");
        Matcher matcher = pattern.matcher("最后测试下两个jpg !test.jpg|thumbnail!!ttteswwt.png|thumbnail!");
//        System.out.println(matcher.find());
//        System.out.println(matcher.group(0));
        while (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                list.add(matcher.group(i));
            }
        }
        System.out.println(list);
        list = list.stream().filter(s ->
                !("png".equals(s) || "jpg".equals(s) || "jpeg".equals(s))
        ).collect(Collectors.toList());
        System.out.println(list);
        byte[] s = new byte[3];
        s[0] = 1;
        s[1] = 1;
        System.out.println(JSON.toJSONString(s));
//        String src = "src=\".*?\"";
//        Pattern compile = Pattern.compile(src);
//        Matcher matcher1 = compile.matcher("<img src=\"test.jpg\" width=\"60px\" height=\"80px\"/>");
//        System.out.println(matcher1.find());
//        System.out.println(matcher1.group(0));
//        while (matcher1.find()) {
//            for (int i = 0; i <= matcher1.groupCount(); i++) {
//                list.add(matcher1.group(i));
//            }
//        }
//
//        System.out.println(list);

//        String jiraNo = null;
//        System.out.println(null != jiraNo);
//        System.out.println(null != jiraNo && StringUtils.isNoneBlank(jiraNo));
//        System.out.println(StringUtils.isNoneBlank(jiraNo));
//        System.out.println(StringUtils.isNotBlank(jiraNo));
    }
}
