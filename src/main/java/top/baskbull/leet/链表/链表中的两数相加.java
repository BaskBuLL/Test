package top.baskbull.leet.链表;

import top.baskbull.leet.common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liuzhuo
 * @date 2022/4/9 11:39 下午
 */
public class 链表中的两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> deque1 = new LinkedList<>();
        Deque<ListNode> deque2 = new LinkedList<>();
        while (l1 != null) {
            deque1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            deque2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode res = null;
        while (!deque1.isEmpty() || !deque2.isEmpty() || carry != 0) {
            int a = deque1.isEmpty() ? 0 : deque1.pop().val;
            int b = deque2.isEmpty() ? 0 : deque2.pop().val;
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode listNode = new ListNode(cur);
            listNode.next = res;
            res = listNode;
        }
        return res;
    }

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            //是否有进位
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}
