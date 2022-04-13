package top.baskbull.leet;

/**
 * @author liuzhuo
 * @date 2022/4/11 7:49 下午
 */
public class 选钱币 {

    public static int ways(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process(arr, 0, aim);
    }

    /**
     * 可以自由使用arr[index...]所有的面值，每一种任意可以使用，组成rest多少种方法
     * 先举出具体的例子
     * [10,]  rest = 1000  0)0张10元 f(1,1000) 1)1张10元 f(1,990) 2)2张10元 f(1,980) ......
     */
    public static int process(int[] arr, int index, int rest) {
        if (index == arr.length) {
            //没有货币可以选择了
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        //因为这一步 所以rest必不可能小于0 所以去掉basecase
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            ways += process(arr, index + 1, rest - (zhang * arr[index]));
        }
        return ways;
    }

    public static int ways2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        //index = 3 rest=900 map key "3_900" int
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(arr, 0, aim, dp);
    }

    public static int process2(int[] arr, int index, int rest, int[][] dp) {
        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }

        //rest >= 0
        if (index == arr.length) {
            dp[index][rest] = rest == 0 ? 1 : 0;
            //没有货币可以选择了
            return dp[index][rest];
        }
        int ways = 0;
        //因为这一步 所以rest必不可能小于0 所以去掉basecase
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            ways += process2(arr, index + 1, rest - (zhang * arr[index]), dp);
        }
        dp[index][rest] = ways;
        return ways;
    }

    public static int dpWay(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int n = arr.length;
        int[][] dp = new int[n + 1][aim + 1];
        //根据暴力递归 第n行第0列上是1 其他都是0
        dp[n][0] = 1;

        for (int index = n - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                //dp[index][rest] = ?
                int ways = 0;
                //因为这一步 所以rest必不可能小于0 所以去掉basecase
                for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
                    ways += dp[index + 1][rest - (zhang * arr[index])];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][aim];
    }
}
