package top.baskbull.leet;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liuzhuo
 * @date 2022/4/8 4:14 下午
 */
public class 接雨水 {

    public int trap(int[] height) {
        //可以理解为单独每个位置 求最多可以接多少水 -> 求左右高度最大值，再到里面取较小的 再减去自己的高度 如果小于0取0
        if (height == null || height.length == 0) {
            return 0;
        }

        int water = 0;
        for (int i = 1; i < height.length - 1; i++) {
            Integer leftValue = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                leftValue = Math.max(height[j], leftValue);
            }
            Integer rightValue = Integer.MIN_VALUE;
            for (int j = i + 1; j < height.length; j++) {
                rightValue = Math.max(height[j], rightValue);
            }
            water += Math.max(Math.min(leftValue, rightValue) - height[i], 0);
        }

        return water;
    }

    public int trap2(int[] height) {
        //因为第一种方法时间复杂度较高 我们可以记忆化搜索一下
        if (height == null || height.length < 2) {
            return 0;
        }

        int water = 0;
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            water += Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);

        }

        return water;
    }

    public static int water3(int[] arr) {
        //对water的小优化
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int N = arr.length;
        int[] rightMaxs = new int[N];
        rightMaxs[N - 1] = arr[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            rightMaxs[i] = Math.max(rightMaxs[i + 1], arr[i]);
        }
        int water = 0;
        int leftMax = arr[0];
        for (int i = 1; i < N - 1; i++) {
            water += Math.max(Math.min(leftMax, rightMaxs[i + 1]) - arr[i], 0);
            leftMax = Math.max(leftMax, arr[i]);
        }
        return water;
    }

    public static int trap4(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int water = 0;

        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int l = 1;
        int r = height.length - 2;
        while (l <= r) {
            if (leftMax <= rightMax) {
                water += Math.max(leftMax - height[l], 0);
                leftMax = Math.max(leftMax, height[l++]);
            } else {
                water += Math.max(rightMax - height[r], 0);
                rightMax = Math.max(rightMax, height[r--]);
            }
        }

        return water;
    }

    //单调栈 每一个数左右比它小的最近的数的位置
    public int trap5(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        接雨水 j = new 接雨水();
        int[] n = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(j.trap2(n));
    }
}
