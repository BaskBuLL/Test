package top.baskbull.leet.链表;

import top.baskbull.leet.common.ListNode;

import java.util.HashSet;

/**
 * @author liuzhuo
 * @date 2022/4/5 6:59 下午
 */
public class 删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode deleteDupNode1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(head.val);
        ListNode prev = head, cur = head.next; // prev 指向当前构造的链表的最后节点
        while (cur != null) {
            if (hashSet.contains(cur.val)) {
                // 当前节点要删除
                prev.next = cur.next;
            } else {
                hashSet.add(cur.val);
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }


}
