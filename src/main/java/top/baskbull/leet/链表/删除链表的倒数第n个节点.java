package top.baskbull.leet.链表;

import top.baskbull.leet.common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liuzhuo
 * @date 2022/4/9 9:30 下午
 */
public class 删除链表的倒数第n个节点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //求长度 时间复杂度 O(L)
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 0; i < length - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        //求长度 时间复杂度 O(L) 空间复杂度 O(L)
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            //弹出的第n个就是要删除的节点
            stack.pop();
        }
        ListNode pre = stack.peek();
        pre.next = pre.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        //求长度 时间复杂度 O(L) 空间复杂度 O(1)
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}
