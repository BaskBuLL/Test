package top.baskbull.leet.链表;

import top.baskbull.leet.common.ListNode;

import java.util.PriorityQueue;

/**
 * @author liuzhuo
 * @date 2022/4/11 8:11 下午
 */
public class 链表排序 {

    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        while (head != null) {
            heap.offer(head);
            head = head.next;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (heap.size() > 0) {
            cur.next = heap.peek();
            heap.poll();
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }

    public ListNode sortList2(ListNode head) {
        //自顶向下排序
        //1. 找到链表的中点，以中点为分界，将链表拆分成两个子链表。寻找链表的中点可以使用快慢指针的做法，快指针每次移动 22 步，慢指针每次移动 11 步，当快指针到达链表末尾时，慢指针指向的链表节点即为链表的中点。
        //2. 对两个子链表分别排序。
        //3. 将两个排序后的子链表合并，得到完整的排序后的链表。
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}

