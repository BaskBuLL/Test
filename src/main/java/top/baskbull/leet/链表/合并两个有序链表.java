package top.baskbull.leet.链表;

import top.baskbull.leet.common.ListNode;

/**
 * @author liuzhuo
 * @date 2022/4/1 11:11 上午
 */
public class 合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // O(n+m)
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode pre = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }

        pre.next = list1 == null ? list2 : list1;

        return head.next;
    }
}
