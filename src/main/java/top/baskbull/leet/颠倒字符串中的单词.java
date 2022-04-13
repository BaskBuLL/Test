package top.baskbull.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhuo
 * @date 2022/4/5 11:33 下午
 */
public class 颠倒字符串中的单词 {

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        List<String> word = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ') {
                if (stringBuilder.length() > 0) {
                    word.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
            } else {
                stringBuilder.append(c);
            }
        }

        if (stringBuilder.length() > 0) {
            word.add(stringBuilder.toString());
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (int i = word.size() - 1; i >= 0; i--) {
            resultBuilder.append(word.get(i));
            if(i != 0){
                resultBuilder.append(' ');
            }
        }

        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
}
