package top.baskbull.leet;

/**
 * @author liuzhuo
 * @date 2022/4/9 3:00 下午
 */
public class 岛问题 {

    // 求每个点的岛屿面积，默认0
    int sum = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 从每个点开始遍历，若为1才考虑计算岛屿面积
                if (grid[i][j] == 1) {
                    // 计算这个点的上下左右个点是否是岛屿
                    getLands(grid, i, j);
                    // 最大面积保存到res
                    res = Math.max(sum, res);
                    // 遍历完某个点后，将sum初始化0
                    sum = 0;
                }
            }
        }
        return res;
    }

    public void getLands(int[][] grid, int i, int j) {
        // 边界条件，注意条件中的grid[i][j] != 1 我们只计算grid[i][j] == 1的岛屿面积
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        // 未防止重复遍历某个点，当这个点是1时，变为2，同时sum++；
        grid[i][j] = 2;
        sum++;
        // 递归调用求上下左右的点
        getLands(grid, i - 1, j);
        getLands(grid, i, j - 1);
        getLands(grid, i + 1, j);
        getLands(grid, i, j + 1);
    }

}
