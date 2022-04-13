package top.baskbull.leet.数组;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author liuzhuo
 * @date 2022/3/27 4:28 下午
 */
public class 数组中的第K个最大元素 {

//    public static int findKthLargest(int[] nums, int k) {
//
//        Arrays.sort(nums);
//        return nums[nums.length- k];
//    }

    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 k 个元素的最小堆，PriorityQueue 底层是动态数组，为了防止数组扩容产生消耗，可以先指定数组的长度
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        // Java 里没有 heapify ，因此我们逐个将前 k 个元素添加到 minHeap 里
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < len; i++) {
            // 看一眼，不拿出，因为有可能没有必要替换
            Integer topElement = minHeap.peek();
            // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
            if (nums[i] > topElement) {
                // Java 没有 replace()，所以得先 poll() 出来，然后再放回去
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] n = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(n, 2));
    }
}
