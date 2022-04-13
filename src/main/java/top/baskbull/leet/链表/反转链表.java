package top.baskbull.leet.链表;

import top.baskbull.leet.common.ListNode;

/**
 * @author liuzhuo
 * @date 2022/3/27 3:16 下午
 */
public class 反转链表 {

    public ListNode reverseList(ListNode head) {
        //迭代
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        //递归
        /**
         * n1 -> ... -> nk-1 -> nk -> nk+1 -> ... -> nm ->
         * n1 -> ... -> nk-1 -> nk <- nk+1 <- ... <- nm
         * nk.next.next = nk
         */
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
