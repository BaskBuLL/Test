package top.baskbull.leet;

/**
 * @author liuzhuo
 * @date 2022/4/9 9:02 下午
 */
public class 不同路径 {

    public int uniquePaths(int m, int n) {
        //从0,0走到m,n
        int[][] cache = new int[m][n];
        return walk(cache, 0, 0, m, n);
    }

    public int walk(int[][] record, int curX, int curY, int m, int n) {
        if (curX >= m) {
            return 0;
        }
        if (curY >= n) {
            return 0;
        }
        if (curX == m - 1 && curY == n - 1) {
            return 1;
        }

        if (record[curX][curY] != 0) {
            return record[curX][curY];
        }
        int sum = walk(record, curX + 1, curY, m, n) + walk(record, curX, curY + 1, m, n);
        record[curX][curY] = sum;
        return sum;
    }

    public int uniquePaths3(int m, int n) {
        //f(0,0) = 1 求 f(m-1,n-1)
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {

        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }


}
