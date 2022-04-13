package top.baskbull.leet;

/**
 * @author liuzhuo
 * @date 2022/4/9 8:28 下午
 * 每个偶数大于相邻的元素，每个奇数大于相邻的元素
 */
public class 递减元素使数组呈锯齿状 {

    public int movesToMakeZigzag(int[] nums) {
        //相当于每个奇数小于相邻的元素 或者 每个偶数小于相邻的索引
        int left, right;
        int odd = 0;
        int even = 0;
        for (int i = 0; i < nums.length; i++) {
            left = i - 1;
            right = i + 1;
            int leftGap = 0;
            int rightGap = 0;
            if (left >= 0) {
                leftGap = Math.max(nums[i] - nums[left] + 1, 0);
            }
            if (right <= nums.length - 1) {
                rightGap = Math.max(nums[i] - nums[right] + 1, 0);
            }
            if (i % 2 == 0) {
                even += Math.max(leftGap, rightGap);
            } else {
                odd += Math.max(leftGap, rightGap);
            }
        }
        return Math.min(odd, even);
    }
}
