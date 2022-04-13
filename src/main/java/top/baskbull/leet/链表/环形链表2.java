package top.baskbull.leet.链表;

import top.baskbull.leet.common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhuo
 * @date 2022/4/1 11:50 上午
 */
public class 环形链表2 {

    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            if (map.containsKey(cur)) {
                return cur;
            } else {
                map.put(cur, index);
                index++;
                cur = cur.next;
            }
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        /**
         * 链表环外为a，slow指针进入环走了b与fast相遇，此时fast指针已经走了n圈
         *
         *                -----
         *       a        丨  丨b
         * ---------------丨  丨
         *                丨  丨
         *                -----
         *                  c
         *
         * a + n(b+c) + b = a + (n+1)b + nc
         * =2(a + b)
         * a = c + (n-1)(b+c) 从相遇点到入环点的距离加上 n−1 圈的环长，恰好等于从链表头部到入环点的距离。
         * 因此，当发现slow 与 fast 相遇时，我们再额外使用一个指针 ptr。起始，它指向链表头部；
         * 随后，它和slow 每次向后移动一个位置。最终，它们会在入环点相遇。
         */
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
