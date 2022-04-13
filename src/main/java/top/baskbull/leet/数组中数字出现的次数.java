package top.baskbull.leet;

/**
 * @author liuzhuo
 * @date 2022/4/5 5:16 下午
 */
public class 数组中数字出现的次数 {

    public int[] singleNumbers(int[] nums) {
        //提取出最右侧的1    n & ((~n) + 1)
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
