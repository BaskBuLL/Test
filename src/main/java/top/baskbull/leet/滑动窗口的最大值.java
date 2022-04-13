package top.baskbull.leet;

import java.util.LinkedList;

/**
 * @author liuzhuo
 * @date 2022/4/9 12:39 下午
 * 固定大小为k的窗口 依次划过nums，返回最大值
 */
public class 滑动窗口的最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        //当然可以遍历 不过代价比较大
        //做出一个结构 随着窗口更新可以不断更新
        //双端队列：如果此时形成的窗口状况不想让r往右动了，而让l往右动，谁会依次成为最大值的优先级。 比你晚过期还比你大 均摊下来O(1)
        if (nums == null || nums.length < 1 || nums.length < k) {
            return new int[]{};
        }
        //双端队列: 放的是下标,过期靠的是下标 从头开始一定是从大到小的
        LinkedList<Integer> qmax = new LinkedList<>();

        //结果长度 7个数 3为窗口 一次5个数
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        //L...R
        //    i     i进入窗口,i就是r
        for (int r = 0; r < nums.length; r++) {
            //r位置代表的值可以放在比他大的数后 或者 放进空队列
            while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[r]) {
                qmax.pollLast();
            }
            qmax.addLast(r);

            //如果窗口没有形成k的长度，不弹出数字 来到r位置 r-k就是过期下标 比如来到4位置 3为窗口 1要过期
            if (qmax.peekFirst() == r - k) {
                qmax.pollFirst();
            }

            //比如3为窗口 需要到了2位置才收集答案  [0,1,2]
            if (r >= k - 1) {
                res[index] = nums[qmax.peekFirst()];
                index++;
            }
        }
        return res;

    }

    //给定一个整型数组arr,和一个整数num 某个arr中的子数组sub，
    //如果想达标，必须满足：sub中最大值-sub中最小值<=num 返回arr中达标的子数组的数量
    //子数组必须连续
    public int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //一直到max - min 不达标为止
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int L = 0;
        int R = 0;
        // [L..R) -> [0,0) 窗口内无数  R是第一个不达标的位置  左闭右开
        // [0,1] -> [0~0]
        int res = 0;
        //L是开头位置，尝试每一个开头 0开头的求完了就到1开头
        while (L < arr.length) {
            //如果此时窗口开头是L，下面while工作：R向右扩到违规为止
            //R是达标位置的再下一个
            while (R < arr.length) {
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[R]) {
                    qmin.pollLast();
                }
                qmin.addLast(R);

                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                    qmax.pollLast();
                }
                qmax.addLast(R);

                //达到了不达标为止
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                R++;
            }
            //内部必达标 范围达标了 范围缩小必达标
            res += R - L;
            if (qmin.peekFirst() == L) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == L) {
                qmax.pollFirst();
            }

            L++;
        }

        return res;
    }

}
