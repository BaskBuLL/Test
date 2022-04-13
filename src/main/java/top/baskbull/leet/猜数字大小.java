package top.baskbull.leet;

/**
 * @author liuzhuo
 * @date 2022/4/5 9:22 下午
 */
public class 猜数字大小 {

    public int getMoneyAmount(int n) {
        return dfs(1, n);
    }

    public int dfs(int start, int end) {
        if (start >= end) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            ans = Math.min(ans, Math.max(dfs(start, i - 1), dfs(i + 1, end)) + i);
        }

        return ans;
    }

    public int getMoneyAmount2(int n) {
        int[][] record = new int[n + 1][n + 1];
        return dfs2(1, n, record);
    }

    public int dfs2(int start, int end, int[][] record) {
        if (start >= end) {
            return 0;
        }

        if (record[start][end] != 0) {
            return record[start][end];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            ans = Math.min(ans, Math.max(dfs2(start, i - 1, record), dfs2(i + 1, end, record)) + i);
        }

        record[start][end] = ans;
        return ans;
    }

    public int getMoneyAmount3(int n) {
        int[][] f = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                f[i][j] = j + f[i][j - 1];
                for (int k = i; k < j; k++) {
                    f[i][j] = Math.min(f[i][j], k + Math.max(f[i][k - 1], f[k + 1][j]));
                }
            }
        }
        return f[1][n];
    }
}
