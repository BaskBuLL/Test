package top.baskbull.leet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author liuzhuo
 * @date 2022/3/30 9:11 下午
 */
public class 打印括号内内容 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Stack<Integer> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                result.add(s.substring(stack.pop(), i));
            }
        }

        System.out.println(result);
    }
}
