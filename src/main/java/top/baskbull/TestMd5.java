package top.baskbull;

import com.alibaba.fastjson.JSON;
import com.youzan.platform.util.security.MD5;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liuzhuo
 * @date 2021/11/29 4:59 下午
 */
public class TestMd5 {

    public static void main(String[] args) {
        String content = "应用程序: shishishsiccc\n" +
                "sql: select * from student where id = ?\n" +
                "开发环境: DEV\n" +
                "建议1:\n" +
                "  概览: 不建议使用 SELECT * 类型查询\n" +
                "  规则: 当表结构变更时，使用 * 通配符选择所有列将导致查询的含义和行为会发生更改，可能导致查询返回更多的数据。\n" +
                "\n" +
                "建议2:\n" +
                "  概览: MySQL execute failed: \n" +
                "  规则: \n";
        System.out.println(MD5.digest(content));
        System.out.println(String.format(ROWKEY_FORMAT, MD5.digest(content).substring(0, 8)));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("SQL分析报告" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("(yyyy-MM-dd HH:mm:ss)")));
        System.out.println("DEV".toLowerCase(Locale.ROOT));

        Map<String, Integer> labelMap = new HashMap<>(8);
        System.out.println(JSON.toJSONString(labelMap));
        System.out.println(labelMap);

        System.out.println(true && false);

        System.out.println("1#tset.add".matches("\\d+#"));
        System.out.println("----------------");
        Matcher m = ppp.matcher("1#tswdawdw#adaet.md");
        if (m.matches()){
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }
    }

    public static Pattern ppp = Pattern.compile("(\\d{1,3})\\#([\\s\\S]*)");
    private static final String ROWKEY_FORMAT = "%s_saar";

}
