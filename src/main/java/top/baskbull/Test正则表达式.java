package top.baskbull;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liuzhuo
 * @date 2022/1/6 2:41 下午
 */
public class Test正则表达式 {

    private static final Pattern RELEASE_VERSION_PATTERN = Pattern.compile("^\\d+\\.\\d+\\.\\d+\\.");
    public static final Pattern TITLE_PATTERN = Pattern.compile("(\\d{1,3})\\#([\\s\\S]*)");


    public static void main(String[] args) {
//        String releaseVersion = "3.42.4";
//        Matcher matcher = RELEASE_VERSION_PATTERN.matcher(releaseVersion);
//        if (!matcher.find()) {
//            if (Pattern.matches("^\\d+\\.\\d+\\.\\d+$", releaseVersion)) {
//                System.out.println(releaseVersion);
//            }
//        }
//        String prefix = matcher.group();
//        System.out.println("???");
//        System.out.println(prefix.substring(0, prefix.length() - 1));

        String fileName = "4#文档2-4.md";
        List<String> sequenceAndName = titleMatch(fileName);
        if (!sequenceAndName.isEmpty()) {
            fileName = sequenceAndName.get(0);
        }
    }

    public static List<String> titleMatch(String title) {
        Matcher matcher = TITLE_PATTERN.matcher(title);
        if (matcher.matches()) {
            return Lists.newArrayList(matcher.group(1), matcher.group(2));
        } else {
            return Collections.emptyList();
        }
    }
}
