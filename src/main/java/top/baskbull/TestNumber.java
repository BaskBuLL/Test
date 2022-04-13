package top.baskbull;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author liuzhuo
 * @date 2022/3/4 10:00 下午
 */
public class TestNumber {

    public static void main(String[] args) {
        Double d = Double.valueOf(1.444222);

        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMaximumFractionDigits(1);
        System.out.println(percentFormat.format(d));

        Double dd = Double.valueOf(1000000.0);
        NumberFormat integerInstance = NumberFormat.getIntegerInstance();
        System.out.println(integerInstance.format(dd));

        List<String> ss = Arrays.asList("每分钟三方接口请求平均RT变化:[4]", "每分钟三方接口请求单个地址数量:[3,025]");
        System.out.println("触发原因:" + String.join(",", ss));
        System.out.println("---");
        System.out.println("触发原因:" + String.join("\n", ss));

        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for (int i = 0; i < ss.size(); i++) {
            builder.append(i + 1).append(".").append(ss.get(i)).append("\n");
        }
        System.out.println("---");
        System.out.println("触发原因:" + builder.toString());

        Map<String, String> skynetDashBoardUrl = new HashMap<>();
        skynetDashBoardUrl.put("biz", "biz.com");
        skynetDashBoardUrl.put("www", "www.com");

        List<String> labels = Arrays.asList("xx", "xxx");
        System.out.println(labels.stream()
                .map(label -> skynetDashBoardUrl.get(label)).filter(Objects::nonNull).collect(Collectors.toList()));
        System.out.println(labels.stream()
                .map(label -> skynetDashBoardUrl.get(label)).collect(Collectors.toList()));
    }
}
