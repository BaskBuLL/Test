package top.baskbull.leet.common;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author liuzhuo
 * @date 2022/4/9 3:17 下午
 */
public class 测试数据 {

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static ListNode generateRandomLinkedList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        ListNode head = new ListNode((int) (Math.random() * (value + 1)));
        ListNode pre = head;
        while (size != 0) {
            ListNode cur = new ListNode((int) (Math.random() * (value + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }


    public static TreeNode generateRandomTree(int value, int N) {
        HashSet<Integer> hasValue = new HashSet<Integer>();
        return createTree(value, 1, N, hasValue);
    }

    public static TreeNode createTree(int value, int level, int N, HashSet<Integer> hasValue) {
        if (level > N) {
            return null;
        }
        int cur = 0;
        do {
            cur = (int) (Math.random() * value) + 1;
        } while (hasValue.contains(cur));
        hasValue.add(cur);
        TreeNode head = new TreeNode(cur);
        head.left = createTree(value, level + 1, N, hasValue);
        head.right = createTree(value, level + 1, N, hasValue);
        return head;
    }

    public static void main(String[] args) {
        int maxSize = 20;
        int maxValue = 100;
        int[] arr1 = generateRandomArray(maxSize, maxValue);
        System.out.println(Arrays.toString(arr1));

        int N = 5;
        int value = 1000;
        generateRandomTree(value, N);
    }
}
