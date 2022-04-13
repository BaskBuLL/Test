package top.baskbull.leet.common;

import lombok.Data;

/**
 * @author liuzhuo
 * @date 2022/4/1 11:11 上午
 */
@Data
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
