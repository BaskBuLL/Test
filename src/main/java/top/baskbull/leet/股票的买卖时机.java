package top.baskbull.leet;

/**
 * @author liuzhuo
 * @date 2022/4/11 10:21 下午
 */
public class 股票的买卖时机 {

    /**
     * 在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
     * 返回 你能获得的 最大 利润 。
     * <p>
     * 贪心的角度考虑我们每次选择贡献大于 0 的区间即能使得答案最大化
     * <p>
     * prices[i] - prices[l] = (prices[i] - prices[i-1]) + (prices[i-1] - prices[i-2]) + ...
     */
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            //有利可图
            if (prices[i + 1] > prices[i]) {
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     * <p>
     * 1. 未进行过任何操作；
     * 2. 只进行过一次买操作；
     * 3. 进行了一次买操作和一次卖操作，即完成了一笔交易；
     * 4. 在完成了一笔交易的前提下，进行了第二次买操作；
     * 5. 完成了全部两笔交易。
     * 第一个不考虑 四个状态
     *
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        //buy1即为以prices[0]的价格买入股票
        int buy1 = -prices[0];
        //sell1即为在同一天买入并且卖出
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }


}
