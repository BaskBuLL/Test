package top.baskbull;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author liuzhuo
 * @date 2022/1/19 2:36 下午
 */
public class TestString {

    public static void main(String[] args) {
        //        String s = "sql.qpm_by_app{status!=\"success\",appReporter=\"%s\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>";
        String s = "sql.qpm_by_app{status!=\"success\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>";
//        String s = "sql.qpm_by_app{}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>";

//        Map<String, String> map = new HashMap<>();
//        map.put("appReporter", "dennis-chain");
//        map.put("method", "getSku");
//
//        StringBuilder stringBuilder = new StringBuilder();
//        map.entrySet().forEach(e -> {
//            String temp = e.getKey() +
//        });
        List<String> condition = new ArrayList<>();
        //这里需要注意"dennis-chain"
        condition.add("appReporter=\"dennis-chain\"");
        condition.add("method=\"getSku\"");
        condition.add("");
//        int index = s.indexOf('{');
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(s.substring(0, index + 1));
//
//        //这里不能直接在filter过后直接操作，因为没拿到清理过后的size
//        List<String> collect = list.stream().filter(StringUtils::isNotBlank).collect(Collectors.toList());
//        for (int i = 0; i < collect.size(); i++) {
//            stringBuilder.append(list.get(i));
//            if (i != collect.size() - 1) {
//                stringBuilder.append(',');
//            } else {
//                if (s.charAt(index + 1) != '}') {
//                    stringBuilder.append(',');
//                }
//            }
//        }
//        stringBuilder.append(s.substring(index + 1, s.length()));
//        System.out.println(stringBuilder);

        String rawQuery = "sql.qpm_by_app{status=\"success\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>";

//        List<String> conditionList = condition.stream().filter(StringUtils::isNotBlank).collect(Collectors.toList());
//        int index = rawQuery.indexOf('{');
//        StringBuilder rawQueryBuilder = new StringBuilder();
//        rawQueryBuilder.append(rawQuery.substring(0, index + 1));
//        for (int i = 0; i < conditionList.size(); i++) {
//            rawQueryBuilder.append(conditionList.get(i));
//            if (i != conditionList.size() - 1) {
//                rawQueryBuilder.append(',');
//            } else {
//                if (rawQuery.charAt(index + 1) != '}') {
//                    rawQueryBuilder.append(',');
//                }
//            }
//        }
//        rawQueryBuilder.append(rawQuery.substring(index + 1, rawQuery.length()));
//        System.out.println(rawQueryBuilder.toString());


        String defaultTagCondition = "appReporter=\"%s\"";

        int index = rawQuery.indexOf('{');
        StringBuilder rawQueryBuilder = new StringBuilder();
        rawQueryBuilder.append(rawQuery.substring(0, index + 1));

        rawQueryBuilder.append(String.format(defaultTagCondition, "dennis-chain"));
        if (rawQuery.charAt(index + 1) != '}') {
            rawQueryBuilder.append(',');
        }
        rawQueryBuilder.append(rawQuery.substring(index + 1, rawQuery.length()));
//        System.out.println(rawQueryBuilder.toString());

//        String pre = "1#开发指南/1#开发手册/2#有容器开发/ddd.md";
//        String pre = "1#开发指南/2#有容器开发/ddd.md";
        String pre = "1#开发指南/1#开发手册/2#有容器开发/1#te.md";
        String after = "1#开发指南/1#开发手册/1#有容器开发/1#test1.md";

        change(pre, after);
        String i = "1";
        System.out.println(DigestUtils.md2Hex(i.getBytes()));

        System.out.println(changeLevel(pre, after));
        Integer iw = 1;
        System.out.println(iw.equals(null));
    }

    public static void change(String pre, String after) {
        if (Objects.equals(pre, after)) {
            System.out.println("相等");
        }

        String[] preS = pre.split("/");
        String[] aftS = after.split("/");

        int length = Math.max(preS.length, aftS.length);
        int index = 0;
        for (; index < length; index++) {
            if (!Objects.equals(preS[index], aftS[index])) {
                break;
            }
        }
        System.out.println(index);
        StringBuilder preChange = new StringBuilder();
        StringBuilder afterChange = new StringBuilder();

        for (int i = index; i < preS.length; i++) {
            preChange.append(preS[i]);
            if (i != preS.length - 1) {
                preChange.append("/");
            }
        }

        for (int i = index; i < aftS.length; i++) {
            afterChange.append(aftS[i]);
            if (i != aftS.length - 1) {
                afterChange.append("/");
            }
        }

        System.out.println(preChange.toString());
        System.out.println(afterChange.toString());
    }

    public static Integer changeLevel(String pre, String after) {
        if (Objects.equals(pre, after)) {
            return 0;
        }

        String[] preS = pre.split("/");
        String[] aftS = after.split("/");

        int length = Math.max(preS.length, aftS.length);
        int index = 0;
        for (; index < length; index++) {
            if (!Objects.equals(preS[index], aftS[index])) {
                break;
            }
        }

        return index;
    }
}
