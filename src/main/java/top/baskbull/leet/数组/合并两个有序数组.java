package top.baskbull.leet.数组;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/3/27 4:11 下午
 */
public class 合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
