package top.baskbull.leet;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/3/27 2:42 下午
 */
public class 两数之和 {

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int to = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (to == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] ints = {2, 7, 11, 15};
        int target = 9;
        int[] ints1 = twoSum(ints, target);
        System.out.println(Arrays.toString(ints1));
    }
}
